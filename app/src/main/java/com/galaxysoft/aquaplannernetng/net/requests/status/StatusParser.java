package com.galaxysoft.aquaplannernetng.net.requests.status;

import com.galaxysoft.aquaplannernetng.model.RelayState;
import com.galaxysoft.aquaplannernetng.model.Status;
import com.galaxysoft.aquaplannernetng.net.requests.base.BaseParser;

import org.jetbrains.annotations.NotNull;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class StatusParser implements BaseParser<Status> {
    @NotNull
    @Override


    public List<Status> parse(@NotNull byte[] data) {

        String line = new String(data, Charset.forName("UTF-8"));
        String[] input = line.substring(1, line.length() - 1).split(",");
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }

        RelayState[] t = new RelayState[8];
        for (int i = 3; i <= 10; i++) {
            RelayState state;
            int r = Integer.valueOf(input[i]);
            if (r == 0) {
                state = RelayState.FORCED_OFF;
            } else if (r == 3) {
                state = RelayState.FORCED_ON;
            } else if (r == 2) {
                state = RelayState.ON;
            } else {
                state = RelayState.OFF;
            }

            t[10 - i] = state;
        }
        int[] led = new int[6];
        for (int i = 12; i <= 17; i++) {
            int r = Integer.valueOf(input[i]);
            if (r >= 0 && r <= 100) {
                led[17 - i] = r;
            } else {
                led[17 - i] = -1;
            }
        }
        //if(data[1]>-99; data[1])

        Status resultat;
        resultat = new Status(0f, 0f, 0f, null, led[0], led[1], led[2], led[3], led[4], led[5],
                t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], true);
        List<Status> list = new ArrayList<Status>();
        list.add(resultat);
        return list;
    }
}
