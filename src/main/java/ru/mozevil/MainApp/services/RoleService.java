package ru.mozevil.MainApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mozevil.MainApp.entities.Role;
import ru.mozevil.MainApp.repositories.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role save(Role role) {
       return roleRepository.save(role);
    }

    @Transactional
    public Role update(Role role) {
        Role roleEntity = getById(role.getId());
        roleEntity.setName(role.getName());
        return roleEntity;
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public Role getById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role findByName(String name) {
        return roleRepository.findOneByName(name);
    }
}
