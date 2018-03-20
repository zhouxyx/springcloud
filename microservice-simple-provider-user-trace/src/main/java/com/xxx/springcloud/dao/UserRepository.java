package com.xxx.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.springcloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
