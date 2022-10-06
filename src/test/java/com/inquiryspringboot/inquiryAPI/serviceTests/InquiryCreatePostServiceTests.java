package com.inquiryspringboot.inquiryAPI.serviceTests;

import com.inquiryspringboot.inquiryAPI.entities.CreatePost;
import com.inquiryspringboot.inquiryAPI.entities.Message;
import com.inquiryspringboot.inquiryAPI.services.InquiryCreatePostService;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryCreatePostRepository;

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
public class InquiryCreatePostServiceTests {

    @Mock
    InquiryCreatePostRepository inquiryCreatePostRepository;

    @InjectMocks
    InquiryCreatePostService inquiryCreatePostService;

    List<CreatePost> posts = Arrays.asList(
            new CreatePost()
            .withSubjectLine("I work at Cognizant!")
            .withAcademicsCheckBox(true)
            .withNewsCheckBox(true)
            .withCareerCheckbox(true)
            .withPostText("I do software development at Cognizant!"),

            new CreatePost()
            .withSubjectLine("This is another piece of subject text")
            .withAcademicsCheckBox(true)
            .withNewsCheckBox(false)
            .withCareerCheckbox(true)
            .withPostText("I like apples!")
    );

    @Test
    public void savePost_callsRepoSave(){
        CreatePost posts = new CreatePost()
                .withSubjectLine("Test")
                .withAcademicsCheckBox(false)
                .withNewsCheckBox(true)
                .withCareerCheckbox(false)
                .withPostText("This is post text");

        inquiryCreatePostService.savePost(posts);
        verify(inquiryCreatePostRepository,times(1)).save(posts);
    }

    @Test
    public void getAllPosts_ifExists(){
        when(inquiryCreatePostRepository.findAll()).thenReturn(posts);
        List<CreatePost> allPostsCreated = inquiryCreatePostService.getAllPosts();

        assertEquals(2, allPostsCreated.size());
    }
}
