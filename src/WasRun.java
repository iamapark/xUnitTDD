/**
 * @author jinyoung
 * @date 09/03/2020
 */
public class WasRun extends TestCase {

    public String log;

    public WasRun(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        this.log = "setUp";
    }

    @Override
    public void tearDown() {
        this.log += " tearDown";
    }

    public void testMethod() {
        this.log += " testMethod";
    }

    public void testBrokenMethod() {
        throw new AssertionError();
    }

}
