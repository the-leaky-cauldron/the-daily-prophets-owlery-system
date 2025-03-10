package org.theleakycauldron.prophetsowlerysystem.kafkalisteners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.theleakycauldron.prophetsowlerysystem.dtos.OrderStatusDto;
import org.theleakycauldron.prophetsowlerysystem.services.OwleryEmailService;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Service
public class OwleryOrderStatusListener {

    private static final String ORDER_STATUS_EMAIL_SUBJECT = "Your order status has been changed!";
    private final OwleryEmailService emailService;

    public OwleryOrderStatusListener(
        OwleryEmailService emailService
    ) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "order-status-changed", id = "order-status-listener")
    public void listen(ConsumerRecord<String, OrderStatusDto> dto){
        sendOrderStatusEmail(dto.value());
    }

    private void sendOrderStatusEmail(OrderStatusDto dto) {

        String body = "Hey!" + "Your order(" + dto.getOrderId() +") status has been changed. Current status is:" + dto.getOrderStatus();

        emailService.sendEmail(dto.getUserId(), ORDER_STATUS_EMAIL_SUBJECT, body);
        
    }

}
