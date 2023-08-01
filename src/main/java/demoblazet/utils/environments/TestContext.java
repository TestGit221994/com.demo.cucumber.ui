package demoblazet.utils.environments;

public abstract class TestContext {
    public static String TEST_ENV;
    private static ThreadLocal<TestContext> testContext = new ThreadLocal<TestContext>();

    static {
        setTestEnvironment();
    }

    public TestContext() {
        testContext.set(this);
    }

    private static void setTestEnvironment() {
        String arg = System.getProperty("test.environment");
        if (arg == null) {
            TEST_ENV = Environment.STAGING;
            return;
        }
        if (arg.equalsIgnoreCase(Environment.QA)) {
            TEST_ENV = Environment.QA;
            return;
        }
        if (arg.equalsIgnoreCase(Environment.STAGING)) {
            TEST_ENV = Environment.STAGING;
            return;
        }
        throw new IllegalStateException("com.lori.com.hylapbl.test environment cannot be set. no such environment recognized: " + arg);
    }

    public static String getTestEnvironment() {
        return TEST_ENV;
    }
}