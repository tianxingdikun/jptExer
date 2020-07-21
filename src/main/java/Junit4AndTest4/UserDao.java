package Junit4AndTest4;

/**
 * 测试单元
 */
public class UserDao {
    private static int moneyNum=100;
    public int queryMoney(){
        System.out.println(10/0);//模拟出现异常
        return moneyNum;
    }

    public void addMoney(int num){
        moneyNum+=num;
    }

    public void dropMoney(int num){
        moneyNum-=num;
    }
}
