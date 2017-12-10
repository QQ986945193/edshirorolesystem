package com.david.edshirorolesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.edshirorolesystem.mapper.UserLoginMapper;
import com.david.edshirorolesystem.po.UserLogin;
import com.david.edshirorolesystem.po.UserloginExample;
import com.david.edshirorolesystem.service.UserLoginService;

/**
 * 用户登录的service
 * 
 * @author ：david
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @github: https://github.com/QQ986945193
 */
@Service(value = "userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginMapper userLoginMapper;

	/***
	 * 根据用户名查找用户
	 */
	@Override
	public UserLogin findByName(String username) {
		UserloginExample userloginExample = new UserloginExample();
		UserloginExample.Criteria criteria = userloginExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<UserLogin> list = userLoginMapper.selectByExample(userloginExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
