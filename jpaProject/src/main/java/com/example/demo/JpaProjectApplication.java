package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.dataClass.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class JpaProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaProjectApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
//		User user = new User();
//		user.setName("Mahaz");
//		user.setCity("RWP");
//		user.setStatus("I am a Python Programmer");
//		User user1 = userRepository.save(user);
//		System.out.println(user1);

        //Create user object
        User user1 = new User();
        user1.setName("User");
        user1.setCity("ISB");
        user1.setStatus("Python Programmer");


        User user2 = new User();
        user2.setName("User 02");
        user2.setCity("ISB 02");
        user2.setStatus("Python Programmer 02");
//Saving single user
//        User resultUser = userRepository.save(user2);
//        System.out.println("Result User:" + resultUser);

        //Saving multiple users

//        List<User>  users = List.of(user2,user1);
//        Iterable<User> result = userRepository.saveAll(users);
//
//        for (User user : result) {
//            System.out.println(user);
//        }


        //Now updating the data
//        Optional<User> optional = userRepository.findById(3);
//        User myUser  = optional.get();
//        myUser.setName("UserUpdated");
//        userRepository.save(myUser);
//        System.out.println(myUser);

        //Getting all the data from dataBase
        Iterable<User> itr = userRepository.findAll();
//        Iterator<User> iterator = itr.iterator();
//        while(iterator.hasNext()) {
//            User user = iterator.next();
//            System.out.println(user);
//        }

//        itr.forEach(new Consumer<User>() {
//            @Override
//            public void accept(User user) {
//                System.out.println(user);
//            }
//        });

//        itr.forEach(user -> System.out.println(user));

        //For deleting the user element using id

//        userRepository.deleteB yId(502);

        //For deleting all the users

//        Iterable<User> allUsers = userRepository.findAll();
//        allUsers.forEach(user -> System.out.println(user));
//        userRepository.deleteAll(allUsers);


//        List<User> userByDB = userRepository.findByName("User");
//        userByDB.forEach(user -> System.out.println(user));

//        List<User> users = userRepository.findByNameAndCity("User","ISB");
//        List<User> users = userRepository.findByNameStartingWith("I");
//        List<User> users = userRepository.getAllUser();
//        users.forEach(user -> System.out.println(user));

//        List<User> users = userRepository.getUserByName("User");
//        users.forEach(user -> System.out.println(user));

//        List<User> users = userRepository.getUserByNameAndCity("User","ISB");
//        users.forEach(user -> System.out.println(user));

        List<User> users = userRepository.getUsers();
        users.forEach(user -> System.out.println(user));
    }

}
