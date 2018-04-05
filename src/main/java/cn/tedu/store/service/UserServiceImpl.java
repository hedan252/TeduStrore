package cn.tedu.store.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	public void register(User user) {
		if (findUserByUsername(user.getUsername()) != null) {
			return;
		}
		if (checkPhoneExists(user.getPhone())) {
			return;
		}
		if (checkEmailExists(user.getEmail())) {
			return;
		}
		userMapper.createUser(user);
	}

	public void register(
			String username, 
			String password, 
			String phone, 
			String email) {
		User user = new User();
		Date now = new Date();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		
		user.setDisabled(0);
		user.setCreatedTime(now);
		user.setCreatedUser("System");
		user.setModifiedTime(now);
		user.setModifiedUser("System");
		
		register(user);
	}
	
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	public boolean checkPhoneExists(String phone) {
		if (userMapper
				.getRecordCountByPhone(phone) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkEmailExists(String email) {
		return userMapper
				.getRecordCountByEmail(email) > 0;
	}

	public User login(String username, 
			String password) {
		User u = findUserByUsername(username);
		if (u == null) {
			return null;
		} else {
			if (u.getPassword().equals(password)) {
				return u;
			} else {
				return null;
			}
		}
	}

	public void updateUserInfo(
			Integer id, String username, 
			String phone, String email) {
		// 根据id在数据库中查询用户信息
		User user = userMapper.findUserById(id);
		// 如果用户提交的用户名为空
		// 则替换为当前数据库中的用户名
		if (username == null || "".equals(username)) {
			username = user.getUsername();
		}
		// 如果用户提交的手机号为空
		// 则替换为当前数据库中的手机号
		if (phone == null || "".equals(phone)) {
			phone = user.getPhone();
		}
		// 如果用户提交的邮箱为空
		// 则替换为当前数据库中的邮箱
		if (email == null || "".equals(email)) {
			email = user.getEmail();
		}
		// 通过持久层处理
		userMapper.updateUserInfo(id, username, phone, email);
	}

	public int updatePassword(Integer uid, 
			String oldPassword, 
			String newPassword) {
		// 初始化：参数、返回值
		int state = -1;
		
		// 处理业务
		// 根据uid获取用户信息
		User user = userMapper.findUserById(uid);
		// 判断用户输入的旧密码是否正确
		if (user.getPassword().equals(oldPassword)) {
			// 密码正确，允许修改
			userMapper.updatePassword(uid, newPassword);
			// 给正确的返回值
			state = 1;
		}
		
		// 返回
		return state;
	}

}
