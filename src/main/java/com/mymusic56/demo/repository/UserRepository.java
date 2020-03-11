package com.mymusic56.demo.repository;

import com.mymusic56.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
