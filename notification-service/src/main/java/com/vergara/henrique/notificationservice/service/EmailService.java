package com.vergara.henrique.notificationservice.service;


import com.vergara.henrique.notificationservice.model.dto.WelcomeEmailRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
  public void sendUserWelcomeEmail(WelcomeEmailRequestDTO email);
}