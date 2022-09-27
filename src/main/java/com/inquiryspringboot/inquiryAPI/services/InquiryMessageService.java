package com.inquiryspringboot.inquiryAPI.services;


import com.inquiryspringboot.inquiryAPI.entities.Message;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryMessageRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryMessageService {

    private InquiryMessageRepository inquiryMessageRepository;

    public InquiryMessageService(InquiryMessageRepository inquiryMessageRepository){ this.inquiryMessageRepository = inquiryMessageRepository; }

    public List<Message> getAllMessages() { return this.inquiryMessageRepository.findAll(); }

    public Message findMessageById(Integer id) {
        return this.inquiryMessageRepository.findById(id).orElse(null);
    }

    public Message saveMessage(Message message){ return this.inquiryMessageRepository.save(message);}

    public Message updateMessage(Message message) {
        return this.inquiryMessageRepository.save(message);
    }

}
