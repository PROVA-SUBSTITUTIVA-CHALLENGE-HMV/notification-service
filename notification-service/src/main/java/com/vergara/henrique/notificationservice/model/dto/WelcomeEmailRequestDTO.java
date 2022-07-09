package com.vergara.henrique.notificationservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WelcomeEmailRequestDTO {

  private String userEmail;
  private String userName;
}