package com.example.accessingdatamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootApplication
public class AccessingDataMysqlApplication {
//    private static EntityManagerFactory entityManagerFactory;
//    private static EntityManager entityManager;

    public static void main(String[] args) {

        SpringApplication.run(AccessingDataMysqlApplication.class, args);

//        entityManagerFactory = Persistence.createEntityManagerFactory("db_example");
//        entityManager = entityManagerFactory.createEntityManager();
//        TypedQuery<User> query = entityManager.createQuery("select e from User e WHERE e.getName = 'Jula'", User.class);
//        List<User> resultList = query.getResultList();
//        for (User user:resultList) {
//            System.out.println(user.getName() +" "+ user.getEmail());
//        }
//        entityManager.close();
//        entityManagerFactory.close();
    }
}
