package com.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/property")
public class ValuePropertyController {

  private final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("HH:mm:ss.SSS dd/MM/yyyy");
  private static final String MSG_TO_FORMAT =
      "v1.0 / [%s] Value obtained from application.yml file is -> %s";

  @Value("${configuration.property.value:default value}")
  private String springProperty;

  @GetMapping
  public String getPropertyFromConfiguration() {
    String currentDateTime = LocalDateTime.now().format(DATE_TIME_FORMATTER);
    String message = String.format(MSG_TO_FORMAT, currentDateTime, springProperty);
    log.info("getPropertyFromConfiguration method called: {}", message);

    log.info(getComplexBusinessLogicToBeAdded());
    log.info(getComplexBusinessLogic2ToBeAdded());
    return message;
  }

  private String getComplexBusinessLogicToBeAdded() {
    return "Added from project a!";
  }
  
  private String getComplexBusinessLogic2ToBeAdded() {
    return "Added getComplexBusinessLogic2ToBeAdded logic here!";
  }
}
