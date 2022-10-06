package com.inquiryspringboot.inquiryAPI.serviceTests;

import com.inquiryspringboot.inquiryAPI.entities.InquiryUser;
import com.inquiryspringboot.inquiryAPI.entities.Message;
import com.inquiryspringboot.inquiryAPI.services.InquiryMessageService;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryMessageRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class InquiryMessageServiceTests {

    @Mock
    InquiryMessageRepository inquiryMessageRepository;

    @InjectMocks
    InquiryMessageService inquiryMessageService;

    List<Message> message = Arrays.asList(
            new Message()
            .withSender(new InquiryUser().withFirstName("Jorge"))
            .withReceiver(new InquiryUser().withFirstName("Zack"))
            .withMessageText("This is a test"),

            new Message()
            .withSender(new InquiryUser().withFirstName("Claudia"))
            .withReceiver(new InquiryUser().withFirstName("Brenda"))
            .withMessageText("This is a test #2")
    );

    @Test
    public void saveMessage_callsRepoSave(){
        Message message = new Message()
                .withSender(new InquiryUser().withFirstName("Jorge"))
                .withReceiver(new InquiryUser().withFirstName("Zack"))
                .withMessageText("This is a test");

        inquiryMessageService.saveMessage(message);
        verify(inquiryMessageRepository,times(1)).save(message);
    }

    @Test
    public void getAllMessages_ifExists(){
        when(inquiryMessageRepository.findAll()).thenReturn(message);
        List<Message> allMessages = inquiryMessageService.getAllMessages();

        assertEquals(2, allMessages.size());
    }

}
