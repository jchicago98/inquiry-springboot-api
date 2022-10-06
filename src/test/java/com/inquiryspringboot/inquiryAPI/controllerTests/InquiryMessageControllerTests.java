package com.inquiryspringboot.inquiryAPI.controllerTests;

import com.inquiryspringboot.inquiryAPI.entities.InquiryUser;
import com.inquiryspringboot.inquiryAPI.entities.Message;
import com.inquiryspringboot.inquiryAPI.controllers.InquiryMessageController;
import com.inquiryspringboot.inquiryAPI.services.InquiryMessageService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InquiryMessageController.class)
public class InquiryMessageControllerTests {

    @MockBean
    private InquiryMessageService inquiryMessageService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    Message message = new Message()
            .withMessageId(1)
            .withMessageText("This is a test");

    @Test
    @WithMockUser("user@gmail.com")
    public void getMessageById_returnMessage_ifExists() throws Exception{
        when(inquiryMessageService.findMessageById(1)).thenReturn(message);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/messages/1")
        ).andExpect(status().isOk());

        verify(inquiryMessageService).getAllMessages();

    }

}
