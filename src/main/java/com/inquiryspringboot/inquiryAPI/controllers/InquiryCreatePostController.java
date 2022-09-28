package com.inquiryspringboot.inquiryAPI.controllers;

import com.inquiryspringboot.inquiryAPI.services.InquiryCreatePostService;
import com.inquiryspringboot.inquiryAPI.entities.CreatePost;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("create-post")
public class InquiryCreatePostController {

    private InquiryCreatePostService inquiryCreatePostService;

    public InquiryCreatePostController(InquiryCreatePostService inquiryCreatePostService){this.inquiryCreatePostService = inquiryCreatePostService;}

    @GetMapping("all")
    public List<CreatePost> getAllPosts(){
        return this.inquiryCreatePostService.getAllPosts();
    }

    @PostMapping("save")
    public CreatePost createPost(@RequestBody CreatePost post){
        return this.inquiryCreatePostService.savePost(post);
    }

    @PutMapping("update")
    public ResponseEntity<CreatePost> putPost(@RequestBody CreatePost post){
        CreatePost foundPost = this.inquiryCreatePostService.findPostById(post.getPost_id());
        HttpStatus status;
        ResponseEntity response;

        if(foundPost != null){
            status = HttpStatus.OK;
            this.inquiryCreatePostService.updatePost(post);
            response = new ResponseEntity(post,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Post not found",status);
        }

        return response;
    }
}
