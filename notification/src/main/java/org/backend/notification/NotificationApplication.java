package org.backend.notification;

import org.backend.amqp.producer.MessageProducer;
import org.backend.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "org.backend.amqp",
                "org.backend.notification",
        }
)
@EnableDiscoveryClient
@EnableFeignClients
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            MessageProducer producer,
//            NotificationConfig notificationConfig
//    ){
//        return args -> {
//            producer.publish(new Person("Ameya",20),
//                    notificationConfig.getNotificationExchange(),
//                    notificationConfig.getNotificationRoutingKey()
//            );
//        };
//    }
//    record Person(String name,int age){}
}
