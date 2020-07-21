package Junit3AndTest3;

import junit.framework.TestCase;

import java.util.List;

/**
 * Junit3,创建单元测试用例
 * 注:Junit4用注解完成
 */
public class TestOrderDao extends TestCase {
    private OrderDao orderDao;
    private static int num=0;

    @Override
    public void setUp() throws Exception {
        System.out.println((++num)+"--------========================");
//       setUp:在每个测试方法前都会执行，做通用初始化
//        super.setUp();
        orderDao=new OrderDao();
        System.out.println("test1.TestOrderDao.setUp");
    }

    @Override
    public void tearDown() throws Exception {
//        super.tearDown();
        System.out.println("test1.TestOrderDao.tearDown");
    }

    public void testQueryMoney(){
        System.out.println("test1.TestOrderDao.testQueryMoney");
        int queryMoney = orderDao.queryMoney();
        System.out.println("queryMoney = " + queryMoney);
        //传入一个期望值,再传入一个真实值,看两者是否相等
        assertEquals(100,queryMoney);
    }

    public void testAddMoney(){
        System.out.println("test1.TestOrderDao.testAddMoney");
        orderDao.addMoney(100);
        int queryMoney = orderDao.queryMoney();
        System.out.println("queryMoney = " + queryMoney);
        assertEquals(200,queryMoney);
    }

    public void testDropMoney(){
        System.out.println("TestOrderDao.testDropMoney");
        orderDao.dropMoney(35);
        int queryMoney = orderDao.queryMoney();
        System.out.println("queryMoney = " + queryMoney);
        assertEquals(165,queryMoney);
    }

    public void testQueryOrderCount(){
        System.out.println("TestOrderDao.testQueryOrderCount");
        int orderCount = orderDao.queryOrderCount("张三");
        System.out.println("orderCount = " + orderCount);
        assertEquals(3,orderCount);
    }

    public void testQueryOrders(){
        System.out.println("TestOrderDao.testQueryOrders");
        List<Order> orderList = orderDao.queryOrders("张三");
        System.out.println("orderList = " + orderList);
        assertEquals(orderList,orderList);
    }
}
