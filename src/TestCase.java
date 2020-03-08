import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jinyoung
 * @date 09/03/2020
 */
public class TestCase implements Test{
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void run(TestResult testResult) {
        testResult.testStarted();

        setUp();

        try {
            Method method = getClass().getMethod(this.name);
            method.invoke(this);
        } catch (Exception e) {
            testResult.testFailed();
        }

        tearDown();
    }

    public void tearDown() {

    }

    public void setUp() {

    }
}
