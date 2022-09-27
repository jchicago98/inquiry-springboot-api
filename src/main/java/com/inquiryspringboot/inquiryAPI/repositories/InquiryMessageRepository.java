package com.inquiryspringboot.inquiryAPI.repositories;

import com.inquiryspringboot.inquiryAPI.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryMessageRepository extends JpaRepository<Message, Integer> {
}
