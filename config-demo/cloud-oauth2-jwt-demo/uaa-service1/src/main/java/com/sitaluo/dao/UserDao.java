package com.sitaluo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sitaluo.entity.User;


public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
