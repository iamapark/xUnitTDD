import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jinyoung
 * @date 09/03/2020
 */
public class TestSuite implements Test {

    List<Test> tests = new ArrayList<>();

    public TestSuite() {}

    public TestSuite(Class<? extends TestCase> testCaseClass) {
        Arrays.stream(testCaseClass.getMethods())
            /*.filter(m -> m.getName().startsWith("test"))*/
            .filter(m -> m.getAnnotation(annotation.Test.class) != null)
            .forEach(m -> {
                try {
                    add(testCaseClass.getConstructor(String.class).newInstance(m.getName()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
    }

    public void add(Test testCase) {
        tests.add(testCase);
    }

    public void run(TestResult result) {
        tests.forEach(testCase -> {
            testCase.run(result);
        });
    }
}
