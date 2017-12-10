package com.david.edshirorolesystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.david.edshirorolesystem.po.UserLogin;
import com.david.edshirorolesystem.po.UserloginExample;

public interface UserLoginMapper {
	int countByExample(UserloginExample example);

	int deleteByExample(UserloginExample example);

	int deleteByPrimaryKey(Integer userid);

	int insert(UserLogin record);

	int insertSelective(UserLogin record);

	List<UserLogin> selectByExample(UserloginExample example);

	UserLogin selectByPrimaryKey(Integer userid);

	int updateByExampleSelective(@Param("record") UserLogin record, @Param("example") UserloginExample example);

	int updateByExample(@Param("record") UserLogin record, @Param("example") UserloginExample example);

	int updateByPrimaryKeySelective(UserLogin record);

	int updateByPrimaryKey(UserLogin record);
}
