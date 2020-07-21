package Junit4AndTest4;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrgServiceImplTest {

    @Test
    public void regOrg() {
        OrgServiceImpl orgService=new OrgServiceImpl();
        //用mock模拟一个UserDao的实现类
        OrgDao orgDao = EasyMock.createMock(OrgDao.class);
        orgService.setOrgDao(orgDao);
        //待测试的一个实体类
        Org org = new Org("曹操公司", "许昌", "魏国");
        //当orgDao调用queryOrgByName方法，并且传入参数为"曹操公司"时，则返回org对象，该模拟对象orgDao可使用次数为10
        //传入期望值,实际结果为Org对象或null
        EasyMock.expect(orgDao.queryOrgByName("曹操公司")).andReturn(org).times(10);
        EasyMock.expect(orgDao.queryOrgByName("刘备公司")).andReturn(null).times(10);

        //让我们模拟的特性生效
        EasyMock.replay(orgDao);

        boolean boo1 = orgService.regOrg("曹操公司", "许昌", "魏国");
        Assert.assertFalse(boo1);

        boolean boo2 = orgService.regOrg("刘备公司", "成都", "蜀汉");
        Assert.assertTrue(boo2);

    }
}