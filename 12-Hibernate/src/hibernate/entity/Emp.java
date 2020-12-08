package hibernate.entity;

/**
 * @author LXW
 * @creat2020-11-23-上午 10:50
 */
public class Emp {
    private Integer id;
    private String empName;
    private Dept dept;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
