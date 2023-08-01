package demoblazet.utils.misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class SessionData {
    private static final Logger logger = LoggerFactory.getLogger(SessionData.class);
    private static final ThreadLocal<ConcurrentHashMap<Object, Object>> testSessionVariable = new ThreadLocal<>();

    public static ConcurrentHashMap<Object, Object> getCurrentSession() {
        if (testSessionVariable.get() == null) {
            testSessionVariable.set(new ConcurrentHashMap<>());
        }
        return testSessionVariable.get();
    }

    public static <T> T sessionVariableCalled(Object key) {
        logger.debug("Session variable called: key: " + key + " value: " + (T) getCurrentSession().get(key));
        return (T) getCurrentSession().get(key);
    }

    public static SessionVariableSetter setSessionVariable(Object key) {
        return new SessionVariableSetter(key);
    }

    public static class SessionVariableSetter {
        final Object key;

        public SessionVariableSetter(Object key) {
            this.key = key;
        }

        public <T> void to(T value) {
            if (value != null) {
                logger.debug("Set session variable key: " + key + " value: " + value);
                SessionData.getCurrentSession().put(key, value);
            } else {
                SessionData.getCurrentSession().remove(key);
            }
        }
    }
}