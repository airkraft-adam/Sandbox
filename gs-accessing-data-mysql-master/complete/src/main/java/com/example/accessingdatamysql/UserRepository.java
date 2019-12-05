package com.example.accessingdatamysql;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {
    //   @Query("SELECT u FROM User u WHERE u.name = :name")
//User znajdzPoImieniu(@Param("name") String name);

    List<User> findByName(String name);
    User findByEmail(String email);
    List<User> findByNameOrderById(String name);
}