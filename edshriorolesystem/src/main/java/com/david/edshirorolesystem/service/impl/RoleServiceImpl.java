package com.david.edshirorolesystem.service.impl;

import com.david.edshirorolesystem.mapper.RoleMapper;
import com.david.edshirorolesystem.po.Role;
import com.david.edshirorolesystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色权限
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据id查找用户角色
     */
    @Override
    public Role findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
