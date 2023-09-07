package com.example.learn.learner.batch;

import com.example.learn.learner.entity.Users;
import com.example.learn.learner.repository.UserRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBWriter implements ItemWriter<Users> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    public DBWriter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(Chunk<? extends Users> users) {
        System.out.println("DBWriter: userRepository.count()" + userRepository.count());
        if (userRepository.count() == 1000) {
            return;
        }

        System.out.println("Data saved for users: " + users);
        userRepository.saveAll(users);
    }
}
