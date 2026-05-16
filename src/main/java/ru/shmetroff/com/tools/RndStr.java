package ru.shmetroff.com.tools;

import java.util.Random;

/**
 * Helper class for creating random Strings
 * @author Alex Alejandro Shmetroff
 * @date 15.05.2026
 */
public class RndStr {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CHARS_LEN = CHARS.length();
    private static final Random RND = new Random();
    private static final int LEN = 10;
    private static final int CNT = 100_000;

    /**
     * Only for test
     */
    public static void main(String[] args) {
        System.out.println("gen(10)   = " + gen(LEN));
        System.out.println("gens(10)  = " + gens(LEN));
        System.out.println("genps(10) = " + gens(LEN));

        StopWatch stopWatch = new StopWatch();

        stopWatch.start("gen  ");
        for (int i = 0; i < CNT; i++) {
            final String s = gen(LEN);
        }
        stopWatch.stop();

        stopWatch.start("gens ");
        for (int i = 0; i < CNT; i++) {
            final String s = gens(LEN);
        }
        stopWatch.stop();

        stopWatch.start("gensp");
        for (int i = 0; i < CNT; i++) {
            final String s = gensp(LEN);
        }
        stopWatch.stop();

        stopWatch.start("gensp");
        for (int i = 0; i < CNT; i++) {
            final String s = gensp(LEN);
        }
        stopWatch.stop();

        stopWatch.start("gens ");
        for (int i = 0; i < CNT; i++) {
            final String s = gens(LEN);
        }
        stopWatch.stop();

        stopWatch.start("gen  ");
        for (int i = 0; i < CNT; i++) {
            final String s = gen(LEN);
        }
        stopWatch.stop();
    }

    /**
     * Returns random String with specified legnth
     * @param length
     *        Length of needed random String
     * @return Needed random String
     */
    public static String gen(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = RND.nextInt(CHARS_LEN);
            sb.append(CHARS.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Like above but uses Streams
     * @param length
     *        Length of needed random String
     * @return Needed random String
     */
    public static String gens(int length) {
//        return RND.ints(48, 123) // Range from '0' to 'z'
        return RND.ints('0', 'z') // Range from '0' to 'z'
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)) // Alphanumeric only
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * Like above but uses Parallel Streams
     * @param length
     *        Length of needed random String
     * @return Needed random String
     */
    public static String gensp(int length) {
        return RND.ints('0', 'z') // Range from '0' to 'z'
                .parallel()
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)) // Alphanumeric only
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
