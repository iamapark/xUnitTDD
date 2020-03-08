/**
 * @author jinyoung
 * @date 09/03/2020
 */
public class XUnitTest {

    public static void main(String[] args) {
        TestResult result = new TestResult();
        final TestSuite suite = TestCaseTest.suite();
        suite.run(result);
        System.out.println(result.getSummary());
    }
}
