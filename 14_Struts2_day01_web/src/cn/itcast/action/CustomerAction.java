package cn.itcast.action;

import cn.itcast.entity.Customer;
import cn.itcast.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CustomerAction extends ActionSupport {

	//客户列表
	public String list() {
		//调用service
		CustomerService service = new CustomerService();
		List<Customer> list = service.findAll();
		
		//放到域对象里面（明天讲到）
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		
		return "list";
	}
}
