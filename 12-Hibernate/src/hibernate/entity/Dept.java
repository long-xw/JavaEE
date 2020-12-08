package hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LXW
 * @creat2020-11-23-上午 10:51
 */
public class Dept {
    private Integer id;
    private String deptName;
    private Set<Emp> setEmp =  new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Emp> getSetEmp() {
        return setEmp;
    }

    public void setSetEmp(Set<Emp> setEmp) {
        this.setEmp = setEmp;
    }
}
