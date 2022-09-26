package com.inquiryspringboot.inquiryAPI.services;


import com.inquiryspringboot.inquiryAPI.entities.Messages;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryMessageRepository;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InquiryMessageService {

    private InquiryMessageRepository inquiryMessageRepository;

    public InquiryMessageService(InquiryMessageRepository inquiryMessageRepository){ this.inquiryMessageRepository = inquiryMessageRepository; }

    public List<Messages> getAllMessages() { return this.inquiryMessageRepository.findAll(); }

    public Messages findUserById(Integer id) {
        return this.inquiryMessageRepository.findById(id).orElse(null);
    }

    public Messages saveMessage(Messages user){ return this.inquiryMessageRepository.save(user);}

    public Messages updateMessage(Messages user) {
        return this.inquiryMessageRepository.save(user);
    }

}
