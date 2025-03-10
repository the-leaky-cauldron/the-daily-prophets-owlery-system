package org.theleakycauldron.prophetsowlerysystem.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.theleakycauldron.prophetsowlerysystem.dtos.SignUpEmailDto;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Configuration
public class OwlerySystemConfiguration {

    @Bean
    public NewTopics signupTopic(){
        NewTopics newTopics = new NewTopics(
            new NewTopic("user-signup-email", 1, (short) 1),
            new NewTopic("order-status-changed", 1, (short) 1),
            new NewTopic("diagon-alley-product-create", 1, (short) 1),
            new NewTopic("diagon-alley-product-update", 1, (short) 1)
        );

        return newTopics;

    }

//    @Bean
//    public StringJsonMessageConverter messageConverter(){
//        return new StringJsonMessageConverter();
//    }

    // @Bean
    // public JsonDeserializer<SignUpEmailDto> jsonDeserializer(){
    //     return new JsonDeserializer<>(SignUpEmailDto.class);
    // }
}
