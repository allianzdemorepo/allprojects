package com.amazonaws.lambda.hello2;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class Hello2Test {

    private static String input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = "Dinesh";
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("handleRequest");

        return ctx;
    }

    @Test
    public void testHello2() {
        Hello2 handler = new Hello2();
        Context ctx = createContext();

        String output = handler.handleRequest(input, ctx);

        // TODO: validate output here if needed.
        Assert.assertTrue(output.contains("Dinesh"));
    }
}
