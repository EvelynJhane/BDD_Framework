package Helpers;

import org.testng.Assert;

public class Check {

    // Method to perform Assert Equals
    public static void checkEquals(String v1, String v2, String msg) {
        Assert.assertEquals(v1, v2, msg);
    }

    // Method to perform Assert Equals
    public static void checkEquals(int v1, int v2, String msg) {
        Assert.assertEquals(v1, v2, msg);
    }

    // Method to perform Assert True
    public static void checkTrue(boolean b1, String msg) {
        Assert.assertTrue(b1, msg);
    }

    // Method to perform Assert False
    public static void checkFalse(boolean b1, String msg) {
        Assert.assertFalse(b1, msg);
    }

}

