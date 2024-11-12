package org.theleakycauldron.prophetsowlerysystem.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.theleakycauldron.prophetsowlerysystem.dtos.SignUpEmailDto;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Configuration
public class OwlerySystemConfiguration {

    @Bean
    public NewTopic signupTopic(){
        return new NewTopic("user-signup-email", 1, (short) 1);
    }

//    @Bean
//    public StringJsonMessageConverter messageConverter(){
//        return new StringJsonMessageConverter();
//    }

    @Bean
    public JsonDeserializer<SignUpEmailDto> jsonDeserializer(){
        return new JsonDeserializer<>(SignUpEmailDto.class);
    }
}
