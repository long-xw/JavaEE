package cn.itcast.dao;

import cn.itcast.entity.Customer;

import java.util.List;

public interface CustomerDao {

	List<Customer> findAll();

}
