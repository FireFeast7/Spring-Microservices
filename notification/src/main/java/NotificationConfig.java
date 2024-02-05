import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String notificationExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notifcation}")
    private String notificationRoutingKey;

    @Bean
    public TopicExchange internalTopicChange(){
        return new TopicExchange(notificationExchange);
    }

    @Bean
    public Queue notificationQueue(){
        return new Queue(notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding(){
        return BindingBuilder.bind(notificationQueue()).to(internalTopicChange()).with(notificationRoutingKey);
    }
}
