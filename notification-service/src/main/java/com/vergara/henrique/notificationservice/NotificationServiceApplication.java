package com.vergara.henrique.notificationservice;

import com.vergara.henrique.notificationservice.config.RabbitMQMessageProducer;
import com.vergara.henrique.notificationservice.model.dto.WelcomeEmailRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationServiceApplication implements CommandLineRunner {

	@Autowired
	private RabbitMQMessageProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("### Enviando mensagem para fila");
		WelcomeEmailRequestDTO request = WelcomeEmailRequestDTO.builder()
				.userEmail("henrique.vergara.hv@gmail.com")
				.userName("Henrique Vergara")
				.build();

		producer.publish(request, "internal.exchange", "internal.notification.routing-key");
	}
}
