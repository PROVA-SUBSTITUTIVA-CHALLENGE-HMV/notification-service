package com.vergara.henrique.notificationservice.rabbitmq.consumer;

import com.vergara.henrique.notificationservice.model.dto.WelcomeEmailRequestDTO;
import com.vergara.henrique.notificationservice.service.impl.EmailServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class WelcomeNotificationConsumer {

  @Autowired
  private EmailServiceImpl emailService;

  @RabbitListener(queues = "${rabbitmq.queues.notification-welcome-email}")
  public void consumer(WelcomeEmailRequestDTO emailRequest) {
    log.info("### Mensagem consumida {} da fila", emailRequest);
    emailService.sendUserWelcomeEmail(emailRequest);
  }
}