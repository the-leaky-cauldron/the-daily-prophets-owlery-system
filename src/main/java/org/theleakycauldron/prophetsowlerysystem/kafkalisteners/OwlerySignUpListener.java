package org.theleakycauldron.prophetsowlerysystem.kafkalisteners;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.theleakycauldron.prophetsowlerysystem.dtos.SignUpEmailDto;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Service
public class OwlerySignUpListener {


    @KafkaListener(topics = "user-signup-email", id = "owlery")
    public void listen(ConsumerRecord<String, SignUpEmailDto> dto){
        System.out.println(dto.value());
    }

    public void sendEmail(SignUpEmailDto dto){
        // TODO: Add logic and config for this method
    }
}
