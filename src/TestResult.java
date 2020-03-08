/**
 * @author jinyoung
 * @date 09/03/2020
 */
public class TestResult {
    private int testCount = 0;
    private int testFailedCount = 0;

    public void testStarted() {
        this.testCount++;
    }

    public void testFailed() {
        this.testFailedCount++;
    }

    public String getSummary() {
        return this.testCount + " run, " + this.testFailedCount + " failed";
    }
}
