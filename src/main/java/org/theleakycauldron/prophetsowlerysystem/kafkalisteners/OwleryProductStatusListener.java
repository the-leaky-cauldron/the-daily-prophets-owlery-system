package org.theleakycauldron.prophetsowlerysystem.kafkalisteners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.theleakycauldron.prophetsowlerysystem.dtos.ProductKafkaRequestDto;
import org.theleakycauldron.prophetsowlerysystem.services.OwleryEmailService;


@Component
public class OwleryProductStatusListener {
    
    private static final String PRODUCT_STATUS_EMAIL_SUBJECT = "Your product status has been changed!";
    private final OwleryEmailService owleryEmailService;

    public OwleryProductStatusListener(
        OwleryEmailService owleryEmailService
    ) {
        this.owleryEmailService = owleryEmailService;
    }

    @KafkaListener(topics = "diagon-alley-product-create", id="product-status-listener")
    public void listen(ConsumerRecord<String, ProductKafkaRequestDto> dto){

        ProductKafkaRequestDto product = dto.value();
        String body = "Hey!" + "Your product(" + product.getProductId() +") has been created. Please check the inventory";

        sendProductStatusEmail(product.getUserId(), PRODUCT_STATUS_EMAIL_SUBJECT, body);
    }

    @KafkaListener(topics = "diagon-alley-product-update", id="product-status-listener")
    public void listenUpdate(ConsumerRecord<String, ProductKafkaRequestDto> dto){

        ProductKafkaRequestDto product = dto.value();
        String body = "Hey!" + "Your product(" + product.getProductId() +") has been updated. Please check the inventory";

        sendProductStatusEmail(product.getUserId(), PRODUCT_STATUS_EMAIL_SUBJECT, body);

    }

    private void sendProductStatusEmail(String userId, String subject, String body) {

        owleryEmailService.sendEmail(userId, PRODUCT_STATUS_EMAIL_SUBJECT, body);
        
    }
}
