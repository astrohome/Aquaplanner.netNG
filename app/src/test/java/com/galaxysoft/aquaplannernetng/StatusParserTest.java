package com.galaxysoft.aquaplannernetng;

import com.galaxysoft.aquaplannernetng.model.RelayState;
import com.galaxysoft.aquaplannernetng.model.Status;
import com.galaxysoft.aquaplannernetng.net.requests.status.StatusParser;

import junit.framework.Assert;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class StatusParserTest {

    private StatusParser statusParser;
    private List<Status> result;
    private List<Status> result2;

    @Before
    public void setup() throws UnsupportedEncodingException {
        statusParser = new StatusParser();

        //                 ph    t1      t2 relay8 -----------    |  Fan led6 -------    |  Monday Hour  Minute  Day Month Year
        byte[] input = "[-99.9, 26.6, -99.9, 1, 3, 1, 1, 1, 1, 0, 2,   0, 99, 120, 0, 0, 0, 15, 1,     21,   55,     14, 8,    17]".getBytes("UTF-8");
        result = statusParser.parse(input);

        input = "[-99.9, 24.5, -99.9, 1, 0, 1, 1, 1, 1, 1, 2,   0, 9, 0, 0, 50, 1, 0, 1,     21,   55,     14, 8,    17]".getBytes("UTF-8");
        result2 = statusParser.parse(input);
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
    public void testLed5() {
        Status s = result.get(0);
        Assert.assertEquals(-1, s.getLed5());
        s = result2.get(0);
        Assert.assertEquals(0, s.getLed5());
    }

    @Test
    public void testLed3() {
        Status s = result.get(0);
        Assert.assertEquals(0, s.getLed3());
        s = result2.get(0);
        Assert.assertEquals(50, s.getLed3());
    }

    @Test
    public void testLed6() {
        Status s = result.get(0);
        Assert.assertEquals(99, s.getLed6());
        s = result2.get(0);
        Assert.assertEquals(9, s.getLed6());
    }


    @Test
    public void testDate() {
        Status s = result.get(0);
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        Assert.assertEquals(LocalDateTime.parse("2017-08-14 21:55", dtf), s.getDateTime());
    }

    @Test
    public void testRelay7() {
        Status s = result.get(0);
        Assert.assertEquals(RelayState.FORCED_ON, s.getRelay7());
        Status s2 = result2.get(0);
        Assert.assertEquals(RelayState.FORCED_OFF, s2.getRelay7());
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
        Status s2 = result2.get(0);
        Assert.assertEquals(RelayState.OFF, s2.getRelay2());
    }
}
