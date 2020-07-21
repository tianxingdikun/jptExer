package Junit3AndTest3;

import java.util.Date;

/**
 * 单元测试用的实体类
 */
public class Order {
    private int orderId;//订单order的id
    private Date orderTime;//下订单时间

    public Order(int orderId, Date orderTime) {
        this.orderId = orderId;
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderTime=" + orderTime +
                '}';
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}


