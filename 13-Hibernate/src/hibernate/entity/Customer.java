package hibernate.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LXW
 * @creat2020-11-19-下午 12:56
 */
@Entity
@Table(name = "t_customer")
public class Customer {
    //客户
    //客户id
    @Id
    @Column(name = "cid")
    private Integer cid;
    //客户名称
    @Column(name = "custName")
    private String custName;
    //客户级别
    @Column(name = "custLevel")
    private String custLevel;
    //客户来源
    @Column(name = "custSource")
    private String custSource;
    //客户电话
    @Column(name = "custPhone")
    private String custPhone;
    //客户手机
    @Column(name = "custMobile")
    private String custMobile;


    //在客户实体类里面表示多个联系人，一个客户有多个联系人
    //hibernate要求使用集合表示多个数据，使用set集合
    @OneToMany(targetEntity = LinkMan.class)
    @JoinColumn(name = "clid",referencedColumnName = "cid")
//    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();

    public Set<LinkMan> getSetLinkMan() {
        return setLinkMan;
    }

    public void setSetLinkMan(Set<LinkMan> setLinkMan) {
        this.setLinkMan = setLinkMan;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile)  {
        this.custMobile = custMobile;
    }
}
