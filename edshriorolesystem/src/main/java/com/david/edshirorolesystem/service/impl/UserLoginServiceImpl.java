package com.david.edshirorolesystem.service.impl;

import java.util.List;

import com.david.edshirorolesystem.mapper.UserloginMapper;
import com.david.edshirorolesystem.po.Userlogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.edshirorolesystem.po.UserloginExample;
import com.david.edshirorolesystem.service.UserLoginService;

/**
 * 用户登录的service
 * 
 * @author ：david
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @github: https://github.com/QQ986945193
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserloginMapper userLoginMapper;

	/***
	 * 根据用户名查找用户
	 */
	@Override
	public Userlogin findByName(String username) {
		UserloginExample userloginExample = new UserloginExample();
		UserloginExample.Criteria criteria = userloginExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<Userlogin> list = userLoginMapper.selectByExample(userloginExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
