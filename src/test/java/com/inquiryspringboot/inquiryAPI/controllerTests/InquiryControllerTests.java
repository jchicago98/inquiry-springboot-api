package com.inquiryspringboot.inquiryAPI.controllerTests;

import com.inquiryspringboot.inquiryAPI.controllers.InquiryController;
import com.inquiryspringboot.inquiryAPI.services.InquiryService;
import com.inquiryspringboot.inquiryAPI.entities.InquiryUser;

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

@WebMvcTest(InquiryController.class)
public class InquiryControllerTests {

    @MockBean
    private InquiryService inquiryService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    InquiryUser user = new InquiryUser().withId(1).withFirstName("Jorge")
            .withLastName("Morin").withYearBorn(new Date(07-10-1998));

    @Test
    @WithMockUser("user@gmail.com")
    public void getById_returnUser_ifExists() throws Exception{
        when(inquiryService.findUserById(1)).thenReturn(user);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/inquiry-users/1")
        ).andExpect(status().isOk());

        verify(inquiryService).findUserById(1);
    }

}
