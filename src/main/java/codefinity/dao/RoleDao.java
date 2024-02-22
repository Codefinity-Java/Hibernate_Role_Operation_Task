package codefinity.dao;

import codefinity.model.Role;

import java.util.List;

public interface RoleDao {
    Role add(Role role);

    Role getById(int id);

    List<Role> getAll();

    Role updateRole(int id, Role newRole);
}
