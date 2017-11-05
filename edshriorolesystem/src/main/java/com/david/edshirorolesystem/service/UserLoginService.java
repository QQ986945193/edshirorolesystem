package com.david.edshirorolesystem.service;

import com.david.edshirorolesystem.po.UserLogin;

public interface UserLoginService {

	public UserLogin findByName(String username);

}
