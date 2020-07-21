package Junit4AndTest4;

/**
 * 测试用的实体类
 */
public class Org {
    private String orgName,orgLoaction,orgType;

    public Org(String orgName, String orgLoaction, String orgType) {
        this.orgName = orgName;
        this.orgLoaction = orgLoaction;
        this.orgType = orgType;
    }

    public Org() {
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgLoaction() {
        return orgLoaction;
    }

    public void setOrgLoaction(String orgLoaction) {
        this.orgLoaction = orgLoaction;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    @Override
    public String toString() {
        return "Org{" +
                "orgName='" + orgName + '\'' +
                ", orgLoaction='" + orgLoaction + '\'' +
                ", orgType='" + orgType + '\'' +
                '}';
    }
}

