package com.inquiryspringboot.inquiryAPI.controllers;

import com.inquiryspringboot.inquiryAPI.services.InquiryMessageService;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.inquiryspringboot.inquiryAPI.entities.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("messages")
public class InquiryMessageController {

    private InquiryMessageService inquiryMessageService;

    public InquiryMessageController(InquiryMessageService inquiryMessageService){ this.inquiryMessageService = inquiryMessageService; }

    @GetMapping("all")
    public List<Message> getAllMessages(){
        return this.inquiryMessageService.getAllMessages();
    }

    @GetMapping("{id}")
    public List<Message> getMessagesByInquiryUserId(@PathVariable Integer id) {
        List<Message> messages = this.inquiryMessageService.getAllMessages()
                .stream().filter(message -> message.getReceiver().getId() == id || message.getSender().getId() == id).collect(Collectors.toList());
        HttpStatus status;
        ResponseEntity response;
        return messages;
    }

    @PostMapping("save")
    public Message postMessage(@RequestBody Message message){
        return this.inquiryMessageService.saveMessage(message);
    }

    @PutMapping("update")
    public ResponseEntity<Message> putMessage(@RequestBody Message message){
        Message foundMessage = this.inquiryMessageService.findMessageById(message.getMessage_id());
        HttpStatus status;
        ResponseEntity response;

        if(foundMessage != null){
            status = HttpStatus.OK;
            this.inquiryMessageService.updateMessage(message);
            response = new ResponseEntity(message,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("User not found",status);
        }

        return response;
    }

}
