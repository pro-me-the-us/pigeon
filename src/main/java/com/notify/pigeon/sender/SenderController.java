package com.notify.pigeon.sender;

import com.notify.pigeon.notification.EmailService;
import com.notify.pigeon.sender.dtos.CreateSenderDTO;
import com.notify.pigeon.sender.dtos.SenderResponseDTO;
import com.notify.pigeon.user.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sender")
public class SenderController {
    private final SenderServices senderServices;
    private final EmailService emailService;

    public SenderController(SenderServices senderServices, EmailService emailService) {
        this.senderServices = senderServices;
        this.emailService = emailService;
    }

    @PostMapping("/signup")
    ResponseEntity<SenderResponseDTO> signupSender(@RequestBody CreateSenderDTO request){
        var newSender = senderServices.createSender(request);
        var response = new SenderResponseDTO();
        response.setId(newSender.getId());
        response.setOrganization_name(newSender.getOrganization_name());
        response.setContact(newSender.getContact());
        response.setEmail(newSender.getEmail());
        sendEmail();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
        //TODO: Verify email using regex, add password using hash(JWT,OAuth)
    }

    void sendEmail(){
        JavaMailSender mailSender = emailService.getJavaMailSender();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shubhashish.shukla23b@iiitg.ac.in");
        message.setTo("shubh005ashish@gmail.com");
        message.setSubject("Hello This is a Test mail");
        message.setText("THis is a text mail : ) ");
        mailSender.send(message);
    }
}
