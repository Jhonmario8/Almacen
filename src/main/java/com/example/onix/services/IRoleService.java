package com.example.onix.services;

import com.example.onix.models.entities.Role;
import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    void saveRole(Role role);
    Role getRoleById(Integer id);
    void deleteRoleById(Integer id);
}
