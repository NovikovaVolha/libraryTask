package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findUsersByNameContainingIgnoreCase(String name);

    List<User> findUsersBySurnameContainingIgnoreCase(String surname);

    List<User> findUsersByNameOrSurnameContainingIgnoreCase(String name, String surname);

    List<User> findUserByPassport(String passport);

    List<User> findUsersByPhoneNumberContaining(String phoneNumber);

    List<User> findUsersByRolesIn(List<Role> roles);

    User findByUsername(String userName);

}
