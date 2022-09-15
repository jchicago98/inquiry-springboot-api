package com.inquiryspringboot.inquiryAPI.repositories;

import com.inquiryspringboot.inquiryAPI.entities.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
}
