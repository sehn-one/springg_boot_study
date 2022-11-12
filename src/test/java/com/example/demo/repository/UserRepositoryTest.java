package com.example.demo.repository;


import com.example.demo.Demo1ApplicationTests;
import com.example.demo.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends Demo1ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user (%s, %s , %d ) value (account, email, age);
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    @Test
    @Transactional
    public void read(){

        // select * from user where id = ?
        Optional<User> user = userRepository.findByAccountAndEmail("TestUser03","TestUser03@gmail.com");

        user.ifPresent(selectUser ->{
                System.out.println(selectUser);

//            selectUser.getOrderDetailList().stream().forEach(detail ->{
//                Item item = detail.getItem();
//                System.out.println(item);
//            });

        });
    }

    @Test
    @Transactional
    public void update(){

        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent());    // false


        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        Assertions.assertFalse(deleteUser.isPresent()); // false
    }
}
