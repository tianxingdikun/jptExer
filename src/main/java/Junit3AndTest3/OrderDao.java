package Junit3AndTest3;

import java.util.*;

/**
 * 测试单元,操作订单的类
 */
public class OrderDao {
    private static int moneyNum=100;
    private static Map<String, List<Order>> allOrders=new HashMap<>();
    private static int id=1;
    static {
        List<Order> orders=new ArrayList<>();
        orders.add(new Order(id++,new Date()));
        orders.add(new Order(id++,new Date()));
        orders.add(new Order(id++,new Date()));
        allOrders.put("张三",orders);//属于张三的订单
    }
    public int queryOrderCount(String username){
        //用户所下订单的数量
        return allOrders.get(username).size();
    }
    public List<Order> queryOrders(String username){
        //用户下过的订单
        return allOrders.get(username);
    }
    public int queryMoney(){
        return moneyNum;
    }
    public void addMoney(int num){
        moneyNum=moneyNum+num;
    }
    public void dropMoney(int num){
        moneyNum=moneyNum-num;
    }
}
