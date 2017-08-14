package com.galaxysoft.aquaplannernetng;

import com.galaxysoft.aquaplannernetng.model.Task;
import com.galaxysoft.aquaplannernetng.net.requests.tasklist.TaskListParser;
import com.galaxysoft.aquaplannernetng.net.requests.tasklist.TaskListRequest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import kotlin.sequences.Sequence;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TaskListParserTest {

    private TaskListParser parser;

    @Before
    public void before() {
        parser = new TaskListParser();
    }

    @Test
    public void testListCount() {
        byte[] input = new byte[15];
        List<Task> tasks = parser.parse(input);
        int size = tasks.size();
        Assert.assertEquals("Has 1 task", 1, size);
    }

    @Test
    public void testListCount3() {
        byte[] input = new byte[45];
        List<Task> tasks = parser.parse(input);
        int size = tasks.size();
        Assert.assertEquals("Has 3 task", 3, size);
    }
}