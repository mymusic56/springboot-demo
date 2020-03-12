package com.mymusic56.demo.repository;

import com.mymusic56.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    @Transactional
    <S extends User> S save(S s);
}
