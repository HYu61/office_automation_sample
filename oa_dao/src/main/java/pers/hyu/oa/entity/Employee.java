package pers.hyu.oa.entity;

/**
 * The entity class of employee
 */
public class Employee {
    private String sn;
    private String password;
    private String name;
    private String caSin;
    private Integer deptId;
    private String position;

    private Department dept;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaSin() {
        return caSin;
    }

    public void setCaSin(String caSin) {
        this.caSin = caSin;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
