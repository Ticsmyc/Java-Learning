package com.lc.service;

import java.util.List;

import com.lc.pojo.User;

public interface UserService {
	
	/**
	 * 校验用户登录
	 * @param uname 用户名	
	 * @param pwd	密码
	 * @return 返回查询到的用户信息
	 */
	User checkUserLoginService(String uname, String pwd); 
	
	/**
	 * 修改用户密码
	 */
	int userChangePwdService(String newPwd,int uid);

	/**
	 * 获取所有的用户信息
	 * @return
	 */
	List<User> userShowService();

	
	/**
	 * 用户注册
	 * @param u
	 * @return
	 */
	int userRegService(User u);

}
