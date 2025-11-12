package com.kevin.ameda.Camunda.camunda;

import com.kevin.ameda.Camunda.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

/**
 * Author: kev.Ameda
 */
@Service
@Slf4j
public class CamundaMailDelegate implements JavaDelegate {

    private final EmailService emailService;

    public CamundaMailDelegate(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("clientEmail");
        String subject = "Notification from Camunda!";
        String text ="Kevin is a Java Support Engineer with extensive knowledge in Camunda";
        emailService.sendEmail(email,subject,text);
    }
}
