package com.inquiryspringboot.inquiryAPI.repositories;

import com.inquiryspringboot.inquiryAPI.entities.CreatePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryCreatePostRepository extends JpaRepository<CreatePost,Integer>{
}
