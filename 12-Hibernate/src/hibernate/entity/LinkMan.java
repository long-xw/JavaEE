package hibernate.entity;

import javax.persistence.*;

/**
 * @author LXW
 * @creat2020-11-19-下午 12:56
 */
@Entity
@Table(name = "t_linkman")
public class LinkMan {
    @Id
    @Column(name = "lkm_id")
    private Integer lkm_id;//联系人编号（主键）
    @Column(name = "lkm_name")
    private String lkm_name;//联系人姓名
    @Column(name = "lkm_gender")
    private String lkm_gender;//联系人性别
    @Column(name = "lkm_phone")
    private String lkm_phone;//联系人办公电话

    //再联系人实体类里面表示所属客户，一个联系人只能属于一个客户
    @JoinColumn(name = "clid",referencedColumnName = "cid")
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getLkm_id() {
        return lkm_id;
    }

    public void setLkm_id(Integer lkm_id) {
        this.lkm_id = lkm_id;
    }

    public String getLkm_name() {
        return lkm_name;
    }

    public void setLkm_name(String lkm_name) {
        this.lkm_name = lkm_name;
    }

    public String getLkm_gender() {
        return lkm_gender;
    }

    public void setLkm_gender(String lkm_gender) {
        this.lkm_gender = lkm_gender;
    }

    public String getLkm_phone() {
        return lkm_phone;
    }

    public void setLkm_phone(String lkm_phone) {
        this.lkm_phone = lkm_phone;
    }
}
