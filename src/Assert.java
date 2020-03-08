/**
 * @author jinyoung
 * @date 09/03/2020
 */
public class Assert {

    public static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected <" + expected + "> but was <" + actual + ">");
        }
    }
}
