package pers.dhx_.pojo;

import java.util.List;

/**
 * @author Dhx_
 * @className Dept
 * @description TODO
 * @date 2022/7/22 12:59
 */
public class Dept {
    private Integer deptId;
    private String deptName;
    private List<Emp> emps;

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }

    Dept()
    {}
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Dept(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
