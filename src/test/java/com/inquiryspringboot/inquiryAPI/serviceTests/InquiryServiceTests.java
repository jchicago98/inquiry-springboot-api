package com.inquiryspringboot.inquiryAPI.serviceTests;

import com.inquiryspringboot.inquiryAPI.entities.InquiryUser;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryRepository;
import com.inquiryspringboot.inquiryAPI.services.InquiryService;

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
public class InquiryServiceTests {

    @Mock
    InquiryRepository inquiryRepository;

    @InjectMocks
    InquiryService inquiryService;

    List<InquiryUser> user = Arrays.asList(
            new InquiryUser()
            .withFirstName("Jorge")
            .withLastName("Morin")
            .withYearBorn(new Date(07-10-1998)),

            new InquiryUser()
            .withFirstName("Paul")
            .withLastName("Konerko")
            .withYearBorn(new Date(01-11-1970)),

            new InquiryUser()
            .withFirstName("Maritza")
            .withLastName("Diaz")
            .withYearBorn(new Date(12-25-1998))
    );

    @Test
    public void saveUser_callsRepoSave(){
        InquiryUser user = new InquiryUser()
                .withFirstName("Lawrence")
                .withLastName("Bass")
                .withYearBorn(new Date(03-24-1945));

        inquiryService.saveUser(user);
        verify(inquiryRepository,times(1)).save(user);
    }

    @Test
    public void getAllActiveUsers_returnsOnlyActive(){
        when(inquiryRepository.findAll()).thenReturn(user);
        List<InquiryUser> activeUsers = inquiryService.getAllActiveUsers();

        assertEquals(3,activeUsers.size());
        activeUsers.forEach(user -> assertTrue(user.isActive()));
    }

}
