package com.example.onix.models.services;

import com.example.onix.models.entities.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List<Role> getAllRoles();
    void saveRole(Role role);
    Role getRoleById(Integer id);
    void deleteRoleById(Integer id);
}
