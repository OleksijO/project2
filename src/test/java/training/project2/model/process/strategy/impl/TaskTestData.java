package training.project2.model.process.strategy.impl;

/**
 * Created by oleksij.onysymchuk@gmail on 05.12.2016.
 */
public class TaskTestData {
    public static final String TEST_1 ="\t zzzAzzz, zzzAzz zzzAz, A zA Azzz, zAz ";
    public static final String TEST_2 = "" +
            "\t- There is a beautiful evening!\n" +
            "\t - Is not it?\n" +
            "\tclass Anonymous{}\n" +
            "\t - Yes, I think so as you...\n";

    public static final String TEST_1_CONTROL = "\t zzzAzzz, zzzAzz zzzAz, Azzz zAz zA, A\n";
    public static final String TEST_2_CONTROL = "" +
            "\t- think not Yes There evening!\n" +
            "\t- is Is it?\n" +
            "\tclass Anonymous{}\n" +
            "\t- so, as beautiful you a I.\n";
}
