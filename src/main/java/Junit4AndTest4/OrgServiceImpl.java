package Junit4AndTest4;
/**
 * OrgService的实现类
 */
public class OrgServiceImpl implements OrgService {
    private OrgDao orgDao;

    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }

    @Override
    public boolean regOrg(String orgName, String orgLoaction, String orgType) {
        Org org = orgDao.queryOrgByName(orgName);
        if (org == null) {
            System.out.println(orgName+"不存在,可以执行插入动作。");
        } else {
            System.out.println(orgName+"已存在,不能再插入");
            return false;
        }
        return true;
    }
}