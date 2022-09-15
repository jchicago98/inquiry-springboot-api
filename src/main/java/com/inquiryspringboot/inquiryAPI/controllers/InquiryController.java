package com.inquiryspringboot.inquiryAPI.controllers;

import com.inquiryspringboot.inquiryAPI.entities.Inquiry;
import com.inquiryspringboot.inquiryAPI.services.InquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("developers")
public class InquiryController {

    private InquiryService developerService;

    public InquiryController(InquiryService developerService){
        this.developerService = developerService;
    }

    @GetMapping("all")
    public List<Inquiry> getAllActiveDevelopers(){
        return this.developerService.getAllActiveDevelopers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Inquiry> getDeveloperById(@PathVariable Integer id){
        Inquiry developer = this.developerService.findDeveloperById(id);
        HttpStatus status;
        ResponseEntity response;

        if(developer != null){
            status = HttpStatus.OK;
            response = new ResponseEntity(developer,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Developer not found",status);
        }

        return response;
    }

    @PostMapping("save")
    public Inquiry postDeveloper(@RequestBody Inquiry developer){
        return this.developerService.saveDeveloper(developer);
    }

    @PutMapping("update")
    public ResponseEntity<Inquiry> putDeveloper(@RequestBody Inquiry developer){
        Inquiry foundDeveloper = this.developerService.findDeveloperById(developer.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundDeveloper != null){
            status = HttpStatus.OK;
            this.developerService.updateDeveloper(developer);
            response = new ResponseEntity(developer,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Developer not found",status);
        }

        return response;
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteDeveloper(@RequestBody Inquiry developer){
        Inquiry foundDeveloper = this.developerService.findDeveloperById(developer.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundDeveloper != null){
            this.developerService.deleteDeveloper(developer);
            status = HttpStatus.OK;
            response = new ResponseEntity("Developer successfully deleted",status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Developer not found",status);
        }

        return response;
    }


}
