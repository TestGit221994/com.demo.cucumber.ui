package demoblazet.utils.listoners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class ParallelListener implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        int thread = System.getProperty("thread.count") == null ? 1 : Integer.parseInt(System.getProperty("thread.count"));
        XmlSuite xmlSuite = suites.get(0);
        xmlSuite.setParallel(XmlSuite.ParallelMode.TESTS);
        xmlSuite.setThreadCount(thread);
        for (int i = 1; i <= thread; i++) {
            XmlTest test = new XmlTest(xmlSuite);
            test.setName("Device " + i);
            List<XmlClass> classes = new ArrayList<XmlClass>();
            classes.add(new XmlClass("org.parallel.runner.CommonRunner"));
            test.setXmlClasses(classes);
        }
    }
}
