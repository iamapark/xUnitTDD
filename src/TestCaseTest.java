import annotation.Test;

/**
 * @author jinyoung
 * @date 09/03/2020
 */
public class TestCaseTest extends TestCase {

    public TestCaseTest(String name) {
        super(name);
    }

    public static TestSuite suite() {
        return new TestSuite(TestCaseTest.class);
    }

    @Test
    public void methodTemplate() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult testResult = new TestResult();
        wasRun.run(testResult);
        Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
    }

    @Test
    public void testResult() {
        WasRun wasRun = new WasRun("testMethod");
        TestResult testResult = new TestResult();
        wasRun.run(testResult);
        Assert.assertEquals("1 run, 0 failed", testResult.getSummary());
    }

    @Test
    public void testFailedResultFormatting() {
        final TestResult testResult = new TestResult();
        testResult.testStarted();
        testResult.testFailed();
        Assert.assertEquals("1 run, 1 failed", testResult.getSummary());
    }

    @Test
    public void testFailedResult() {
        WasRun wasRun = new WasRun("testBrokenMethod");
        TestResult testResult = new TestResult();
        wasRun.run(testResult);
        Assert.assertEquals("1 run, 1 failed", testResult.getSummary());
    }

    @Test
    public void testSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        final TestResult testResult = new TestResult();
        suite.run(testResult);
        Assert.assertEquals("2 run, 1 failed", testResult.getSummary());
    }
}
