package com.inquiryspringboot.inquiryAPI.services;

import com.inquiryspringboot.inquiryAPI.entities.InquiryUser;
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


    public List<InquiryUser> getAllUsers() {
        return this.inquiryRepository.findAll();
    }

    public  List<InquiryUser> getAllActiveUsers(){
        return this.inquiryRepository.findAll()
                .stream()
                .filter(d->d.isActive()).collect(Collectors.toList());
    }

    public InquiryUser findUserById(Integer id) {
        return this.inquiryRepository.findById(id).orElse(null);
    }

    public InquiryUser saveUser(InquiryUser user){ return this.inquiryRepository.save(user);}

    public InquiryUser updateUser(InquiryUser user) {
        return this.inquiryRepository.save(user);
    }

    public void deleteUser(InquiryUser user) {
        user.setActive(false);
        this.inquiryRepository.save(user);
    }
}
