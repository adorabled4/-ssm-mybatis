package pers.dhx_.pojo;

/**
 * @author Dhx_
 * @className Emp
 * @description TODO
 * @date 2022/7/22 11:56
 */
public class Emp {
    private  Integer empId;
    private String empName;
    private Integer age;
    private String gender;
    private Integer deptId;
    Emp(){}

    public Emp(String empName, int age, String gender, int deptId) {
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.deptId=deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", deptId=" + deptId +
                '}';
    }

    public Emp(String empName, Integer age, String gender ) {
        this.empName = empName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
