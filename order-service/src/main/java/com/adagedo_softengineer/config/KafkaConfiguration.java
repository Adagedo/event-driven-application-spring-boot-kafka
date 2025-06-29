package adagedo_softengineer.config;
import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class KafkaConfiguration {

    // grap the topic name from the application.yml config file
    @Value("${spring.kafka.topic.name}")
    private String topic_name;

    // bean for kafka topic 

    public NewTopic topic(){
        return TopicBuilder.name(name).build();
    }
}