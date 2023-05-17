package com.academy.libray_task.model.repository;

import com.academy.libray_task.model.entity.User;
import com.academy.libray_task.model.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findUsersByNameContainingIgnoreCase(String name);

    List<User> findUsersBySurnameContainingIgnoreCase(String surname);

    List<User> findUsersByNameAndSurnameContainingIgnoreCase(String name, String surname);

    User findUserByPassport(String passport);

    User findUserByPhoneNumber(String phoneNumber);

    List<User> findUsersByRole(Role role);

}
