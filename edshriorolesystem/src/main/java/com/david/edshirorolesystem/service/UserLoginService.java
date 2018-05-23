package com.david.edshirorolesystem.service;

import com.david.edshirorolesystem.po.Userlogin;

public interface UserLoginService {

	public Userlogin findByName(String username);

}
