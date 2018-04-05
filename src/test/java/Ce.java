import java.util.Date;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.UserService;


public class Ce {
	AbstractApplicationContext ctx;
	@Test
	public void dao() {
		ctx=new ClassPathXmlApplicationContext("spring-dao.xml");
		BasicDataSource bds=ctx.getBean("dataSourc",BasicDataSource.class);
		System.out.println(bds.getDriverClassName()+","+bds.getUrl()+","+bds.getInitialSize());
		System.out.println(bds.getUsername()+","+bds.getPassword()+","+bds.getMaxActive());
	}
	@Test
	public void dao2() {
		ctx=new ClassPathXmlApplicationContext("spring-dao.xml");
		User u=new User();
		u.setUsername("zs");u.setPassword("123");u.setPhone("159");u.setEmail("2@qq.com");
		UserMapper userMapper=ctx.getBean("userMapper",UserMapper.class);
		userMapper.createUser(u);
		ctx.close();
	}
	@Test
	public void dao3() {
		ctx=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper=ctx.getBean("userMapper",UserMapper.class);
		User u=userMapper.findUserByUsername("zs");
		System.out.println(u.toString());
	}
	@Test
	public void testFindUserService() {
		ctx=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserService userService=ctx.getBean("userService",UserService.class);
		User u2=userService.findUserByUsername("zs");
		User u3=userService.findUserByUsername("admin");
		System.out.println(u2);
		System.out.println(u3);
		ctx.close();
	}
	@Test
	public void testCreate() {
		ctx=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserService userService=ctx.getBean("userService",UserService.class);
		User user=new User(null,"admin","321","158","a@qq.com",0,null,null,null,null);
		userService.register(user);
		
	}
	@Test
	public void ccccc() {
		ctx=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userService=ctx.getBean("userMapper",UserMapper.class);
		//System.out.println(userService.getRecordCountByphone("15915915915"));
	}
	@Test
	public void uidselect() {
		ctx=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		AddressService ice=ctx.getBean("addressService",AddressService.class);
		 List<Address> list=ice.getAddressList(3);
		 for(Address add:list) {
			 System.out.println(add);
		 }
	}
	
	@Autowired
	private AddressMapper ice;
	@Test
	public void uidselect2() {
		//ctx=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		//AddressMapper ice=ctx.getBean("addressMapper",AddressMapper.class);
		 List<Address> list=ice.getAddressList(1);
		 for(Address add:list) {
			 System.out.println(add.getRecvCity());
		 }
	}
}
