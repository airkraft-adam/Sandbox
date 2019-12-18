package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {
    //   @Query("SELECT u FROM User u WHERE u.name = :name")
//User znajdzPoImieniu(@Param("name") String name);

    List<User> findByName(String name);
    User findByEmail(String email);
    List<User> findByNameOrderById(String name);
    List<User>findAll();
}