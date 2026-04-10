package com.notify.pigeon.sender;

import com.notify.pigeon.sender.dtos.CreateSenderDTO;
import org.springframework.stereotype.Service;

@Service
public class SenderServices {

    private final SenderRepository senderRepository;


    public SenderServices(SenderRepository senderRepository) {
        this.senderRepository = senderRepository;
    }

    SenderEntity createSender(CreateSenderDTO request){
        var newsender = SenderEntity.builder()
                .organization_name(request.getOrganization_name())
                .password(request.getPassword())
                .contact(request.getContact())
                .email(request.getEmail())
                .build();
        senderRepository.save(newsender);
        return newsender;
    }
}
