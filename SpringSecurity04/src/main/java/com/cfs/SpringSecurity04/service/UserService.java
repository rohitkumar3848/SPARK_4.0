package com.cfs.SpringSecurity04.service;

import com.cfs.SpringSecurity04.dto.UserRequest;
import com.cfs.SpringSecurity04.entity.AppUser;
import com.cfs.SpringSecurity04.entity.Role;
import com.cfs.SpringSecurity04.repo.RoleRepository;
import com.cfs.SpringSecurity04.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUsers(List<UserRequest> requests) {

        for (UserRequest request : requests) {

            AppUser appUser = new AppUser();
            appUser.setUsername(request.getUsername());
            appUser.setPassword(passwordEncoder.encode(request.getPassword()));
            appUser.setEnabled(true);

            Set<Role> roles = new HashSet<>();

            for (String roleName : request.getRoles()) {

                Role role = roleRepository.findByName(roleName)
                        .orElseGet(() -> {
                            Role newRole = new Role();
                            newRole.setName(roleName);
                            return roleRepository.save(newRole);
                        });

                roles.add(role);
            }

            appUser.setRoles(roles);
            userRepository.save(appUser);
        }
    }
}
