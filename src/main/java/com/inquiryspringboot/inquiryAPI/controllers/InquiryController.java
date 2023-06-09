package com.inquiryspringboot.inquiryAPI.controllers;

import com.inquiryspringboot.inquiryAPI.entities.InquiryUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.inquiryspringboot.inquiryAPI.services.InquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("inquiry-users")
public class InquiryController {

    private InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService){
        this.inquiryService = inquiryService;
    }

    @GetMapping("all")
    public List<InquiryUser> getAllActiveUsers(){
        return this.inquiryService.getAllActiveUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<InquiryUser> getUserById(@PathVariable Integer id){
        InquiryUser user = this.inquiryService.findUserById(id);
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
    public InquiryUser postUser(@RequestBody InquiryUser user){
        return this.inquiryService.saveUser(user);
    }

    @PutMapping("update")
    public ResponseEntity<InquiryUser> putUser(@RequestBody InquiryUser user){
        InquiryUser foundUser = this.inquiryService.findUserById(user.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundUser != null){
            status = HttpStatus.OK;
            this.inquiryService.updateUser(user);
            response = new ResponseEntity(user,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("User not found",status);
        }

        return response;
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestBody InquiryUser user){
        InquiryUser foundUser = this.inquiryService.findUserById(user.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundUser != null){
            this.inquiryService.deleteUser(user);
            status = HttpStatus.OK;
            response = new ResponseEntity("User successfully deleted",status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("User not found",status);
        }

        return response;
    }


}
