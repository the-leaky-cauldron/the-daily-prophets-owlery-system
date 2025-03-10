package org.theleakycauldron.prophetsowlerysystem.kafkalisteners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.theleakycauldron.prophetsowlerysystem.dtos.SignUpEmailDto;
import org.theleakycauldron.prophetsowlerysystem.services.OwleryEmailService;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */

@Service
public class OwlerySignUpListener {

    private final static String SIGNUP_EMAIL_SUBJECT = "Signup confirmation";
    private final OwleryEmailService emailService;

    public OwlerySignUpListener(
        OwleryEmailService emailService
    ) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "user-signup-email", id = "owlery-signup")
    public void listen(ConsumerRecord<String, SignUpEmailDto> dto){
        sendEmail(dto.value());
    }

    private void sendEmail(SignUpEmailDto dto){

        String body = "Hey " + dto.getName() + " Thanks for signing up for DiagonAlley. Your account has been activated!";
        emailService.sendEmail(dto.getEmail(), SIGNUP_EMAIL_SUBJECT, body);

    }
}
