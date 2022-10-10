package com.inquiryspringboot.inquiryAPI.entities;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class CreatePost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer post_id;
    @OneToOne
    InquiryUser sender;
    String subjectLine;
    Boolean academicsCheckBox;
    Boolean newsCheckBox;
    Boolean careerCheckBox;
    String postText;
    Double postPrice;
    Boolean cartActive;
    Boolean reportPostStatus;

    public CreatePost (){}

    public CreatePost(Integer post_id, InquiryUser sender, String subjectLine, Boolean academicsCheckBox, Boolean newsCheckBox, Boolean careerCheckBox, String postText, Double postPrice, Boolean cartActive, Boolean reportPostStatus) {
        this.post_id = post_id;
        this.sender = sender;
        this.subjectLine = subjectLine;
        this.academicsCheckBox = academicsCheckBox;
        this.newsCheckBox = newsCheckBox;
        this.careerCheckBox = careerCheckBox;
        this.postText = postText;
        this.postPrice = postPrice;
        this.cartActive = cartActive;
        this.reportPostStatus = reportPostStatus;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public InquiryUser getSender() {
        return sender;
    }

    public void setSender(InquiryUser sender) {
        this.sender = sender;
    }

    public String getSubjectLine() {
        return subjectLine;
    }

    public void setSubjectLine(String subjectLine) {
        this.subjectLine = subjectLine;
    }

    public Boolean getAcademicsCheckBox() {
        return academicsCheckBox;
    }

    public void setAcademicsCheckBox(Boolean academicsCheckBox) {
        this.academicsCheckBox = academicsCheckBox;
    }

    public Boolean getNewsCheckBox() {
        return newsCheckBox;
    }

    public void setNewsCheckBox(Boolean newsCheckBox) {
        this.newsCheckBox = newsCheckBox;
    }

    public Boolean getCareerCheckBox() {
        return careerCheckBox;
    }

    public void setCareerCheckBox(Boolean careerCheckBox) {
        this.careerCheckBox = careerCheckBox;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public CreatePost withPostId(Integer post_id){
        this.post_id = post_id;
        return this;
    }

    public CreatePost withSubjectLine(String subjectLine){
        this.subjectLine = subjectLine;
        return this;
    }

    public CreatePost withAcademicsCheckBox(Boolean academicsCheckBox){
        this.academicsCheckBox = academicsCheckBox;
        return this;
    }

    public CreatePost withNewsCheckBox(Boolean newsCheckBox){
        this.newsCheckBox = newsCheckBox;
        return this;
    }

    public CreatePost withCareerCheckbox(Boolean careerCheckBox){
        this.careerCheckBox = careerCheckBox;
        return this;
    }

    public CreatePost withPostText(String postText){
        this.postText = postText;
        return this;
    }

    public Double getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(Double postPrice) {
        this.postPrice = postPrice;
    }

    public Boolean getCartActive() {
        return cartActive;
    }

    public void setCartActive(Boolean cartActive) {
        this.cartActive = cartActive;
    }

    public Boolean getReportPostStatus() {
        return reportPostStatus;
    }

    public void setReportPostStatus(Boolean reportPostStatus) {
        this.reportPostStatus = reportPostStatus;
    }
}
