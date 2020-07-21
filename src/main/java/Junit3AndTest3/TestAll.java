package Junit3AndTest3;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *单元测试套件,运行测试用例
 */
public class TestAll extends TestCase {

    public static TestSuite suite(){
        TestSuite testSuite=new TestSuite();
        testSuite.addTestSuite(TestOrderDao.class);
        return testSuite;
    }
}
