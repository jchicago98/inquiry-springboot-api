package com.inquiryspringboot.inquiryAPI.controllers;

import com.inquiryspringboot.inquiryAPI.entities.Inquiry;
import com.inquiryspringboot.inquiryAPI.services.InquiryMessageService;
import com.inquiryspringboot.inquiryAPI.services.InquiryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.inquiryspringboot.inquiryAPI.entities.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("messages")
public class InquiryMessageController {

    private InquiryMessageService inquiryMessageService;

    public InquiryMessageController(InquiryMessageService inquiryMessageService){ this.inquiryMessageService = inquiryMessageService; }

    @GetMapping("all")
    public List<Messages> getAllActiveUsers(){
        return this.inquiryMessageService.getAllMessages();
    }

    @GetMapping("{id}")
    public ResponseEntity<Messages> getUserById(@PathVariable Integer id){
        Messages user = this.inquiryMessageService.findUserById(id);
        HttpStatus status;
        ResponseEntity response;

        if(user != null){
            status = HttpStatus.OK;
            response = new ResponseEntity(user,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("User not found",status);
        }

        return response;
    }

    @PostMapping("save")
    public Messages postMessage(@RequestBody Messages user){
        return this.inquiryMessageService.saveMessage(user);
    }

    @PutMapping("update")
    public ResponseEntity<Messages> putUser(@RequestBody Messages user){
        Messages foundUser = this.inquiryMessageService.findUserById(user.getUser_id());
        HttpStatus status;
        ResponseEntity response;

        if(foundUser != null){
            status = HttpStatus.OK;
            this.inquiryMessageService.updateMessage(user);
            response = new ResponseEntity(user,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("User not found",status);
        }

        return response;
    }

}
