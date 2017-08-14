package com.galaxysoft.aquaplannernetng;

import com.galaxysoft.aquaplannernetng.model.RelayState;
import com.galaxysoft.aquaplannernetng.model.Status;
import com.galaxysoft.aquaplannernetng.net.requests.status.StatusParser;

import junit.framework.Assert;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StatusParserTest {

    private StatusParser statusParser;
    private List<Status> result;

    @Before
    public void setup() {
        statusParser = new StatusParser();
        byte[] input = new byte[]{-99, 24, -99, 1, 3, 1, 1, 1, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 21, 55, 14, 8, 17};
        result = statusParser.parse(input);
    }

    @Test
    public void testNotNull() {
        Assert.assertNotNull(result);
    }

    @Test
    public void testExactlyOne() {
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testTemp1() {
        Status s = result.get(0);
        Assert.assertEquals(24, s.getTemp1());
    }

    @Test
    public void testDate() {
        Status s = result.get(0);
        Assert.assertEquals(LocalDateTime.parse("2017-08-14 21:55"), s.getDateTime());
    }

    @Test
    public void testRelay7() {
        Status s = result.get(0);
        Assert.assertEquals(RelayState.FORCED_ON, s.getRelay7());
    }

    @Test
    public void testRelay8() {
        Status s = result.get(0);
        Assert.assertEquals(RelayState.OFF, s.getRelay8());
    }

    @Test
    public void testRelay1() {
        Status s = result.get(0);
        Assert.assertEquals(RelayState.ON, s.getRelay1());
    }

    @Test
    public void testRelay2() {
        Status s = result.get(0);
        Assert.assertEquals(RelayState.FORCED_OFF, s.getRelay2());
    }
}
