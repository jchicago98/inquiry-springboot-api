package com.inquiryspringboot.inquiryAPI.services;

import com.inquiryspringboot.inquiryAPI.entities.Inquiry;
import com.inquiryspringboot.inquiryAPI.repositories.InquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InquiryService {
    private InquiryRepository developerRepository;

    public InquiryService(InquiryRepository developerRepository){
        this.developerRepository = developerRepository;
    }


    public List<Inquiry> getAllDevelopers() {
        return this.developerRepository.findAll();
    }

    public  List<Inquiry> getAllActiveDevelopers(){
        return this.developerRepository.findAll()
                .stream()
                .filter(d->d.isActive()).collect(Collectors.toList());
    }

    public Inquiry findDeveloperById(Integer id) {
        return this.developerRepository.findById(id).orElse(null);
    }

    public Inquiry saveDeveloper(Inquiry developer){
        return this.developerRepository.save(developer);
    }

    public Inquiry updateDeveloper(Inquiry developer) {
        return this.developerRepository.save(developer);
    }

    public void deleteDeveloper(Inquiry developer) {
        developer.setActive(false);
        this.developerRepository.save(developer);
    }
}
