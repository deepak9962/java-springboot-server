package com.example.learn.learner.batch;

import com.example.learn.learner.entity.Users;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Users, Users> {

    @Override
    public Users process(Users item) {
        return item;
    }
}
