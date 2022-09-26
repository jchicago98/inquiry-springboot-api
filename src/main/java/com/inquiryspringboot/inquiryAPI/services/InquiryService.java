package com.inquiryspringboot.inquiryAPI.services;

import com.inquiryspringboot.inquiryAPI.entities.Inquiry;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InquiryService {
    private InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository){
        this.inquiryRepository = inquiryRepository;
    }


    public List<Inquiry> getAllUsers() {
        return this.inquiryRepository.findAll();
    }

    public  List<Inquiry> getAllActiveUsers(){
        return this.inquiryRepository.findAll()
                .stream()
                .filter(d->d.isActive()).collect(Collectors.toList());
    }

    public Inquiry findUserById(Integer id) {
        return this.inquiryRepository.findById(id).orElse(null);
    }

    public Inquiry saveUser(Inquiry user){ return this.inquiryRepository.save(user);}

    public Inquiry updateUser(Inquiry user) {
        return this.inquiryRepository.save(user);
    }

    public void deleteUser(Inquiry user) {
        user.setActive(false);
        this.inquiryRepository.save(user);
    }
}
