package com.example.learn.learner.config;

import com.example.learn.learner.batch.DBWriter;
import com.example.learn.learner.batch.Processor;
import com.example.learn.learner.entity.Users;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableAutoConfiguration
public class MongoDBConfig {

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Processor processor;

    @Autowired
    private DBWriter writer;

    @Bean
    public Step step(JobRepository jobRepository) {
        return new StepBuilder("MongoDB-Loader", jobRepository)
                .<Users, Users>chunk(200, transactionManager)
                .reader(reader())
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public FlatFileItemReader<Users> reader() {
        return new FlatFileItemReaderBuilder<Users>()
                .name("MongoDB-Reader")
//                .resource(new FileSystemResource("src/main/resources/data/Data.csv"))
                .delimited()
                .names("id",
                        "first_name",
                        "last_name",
                        "email",
                        "gender",
                        "avatar",
                        "domain",
                        "available")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>())
                .targetType(Users.class)
                .linesToSkip(1)
                .strict(false)
                .build();
    }

//    @Bean
//    public MongoItemWriter<Users> writer() {
//        MongoItemWriter<Users> writer = new MongoItemWriter<>();
//        writer.setTemplate(mongoTemplate);
//        writer.setCollection("Users");
//        return writer;
//    }
}
