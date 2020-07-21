package Junit4AndTest4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao userDao;
    @Before
    public void init(){
        userDao=new UserDao();
        System.out.println("TestUserDao.init");
    }
    @After
    public void tearDown(){
        System.out.println("TestUserDao.tearDown");
    }


    @Test
    public void queryMoney() {
        System.out.println("TestUserDao.testQueryMoney "+userDao.hashCode());
        int money = userDao.queryMoney();
        Assert.assertEquals(100,money);
    }

    @Test
    public void addMoney() {
        System.out.println("TestUserDao.testAddMoney "+userDao.hashCode());
        userDao.addMoney(300);
        int money = userDao.queryMoney();
        Assert.assertEquals(400,money);
    }

    @Test
    public void dropMoney() {
    }
}