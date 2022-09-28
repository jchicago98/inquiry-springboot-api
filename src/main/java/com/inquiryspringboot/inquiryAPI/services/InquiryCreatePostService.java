package com.inquiryspringboot.inquiryAPI.services;

import com.inquiryspringboot.inquiryAPI.entities.CreatePost;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryCreatePostRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InquiryCreatePostService {

    private InquiryCreatePostRepository inquiryCreatePostRepository;

    public InquiryCreatePostService(InquiryCreatePostRepository inquiryCreatePostRepository){this.inquiryCreatePostRepository = inquiryCreatePostRepository;}

    public List<CreatePost> getAllPosts(){ return this.inquiryCreatePostRepository.findAll(); }

    public CreatePost findPostById(Integer id){
        return this.inquiryCreatePostRepository.findById(id).orElse(null);
    }

    public CreatePost savePost(CreatePost post){ return this.inquiryCreatePostRepository.save(post);}

    public CreatePost updatePost(CreatePost post){ return this.inquiryCreatePostRepository.save(post); }

}
