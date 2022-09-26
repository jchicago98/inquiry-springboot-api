package com.inquiryspringboot.inquiryAPI.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer message_id;
    Integer user_id;
    String senderEmail;
    String receiverEmail;
    String fromLastName;
    String fromFirstName;
    String toLastName;
    String toFirstName;
    String messageText;
    Date sentDateTime;

    public Messages (){}

    public Messages(Integer message_id, Integer user_id, String fromLastName, String fromFirstName, String toLastName, String toFirstName, String messageText, Date sentDateTime) {
        this.message_id = message_id;
        this.user_id = user_id;
        this.fromLastName = fromLastName;
        this.fromFirstName = fromFirstName;
        this.toLastName = toLastName;
        this.toFirstName = toFirstName;
        this.messageText = messageText;
        this.sentDateTime = sentDateTime;
    }

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFromLastName() {
        return fromLastName;
    }

    public void setFromLastName(String fromLastName) {
        this.fromLastName = fromLastName;
    }

    public String getFromFirstName() {
        return fromFirstName;
    }

    public void setFromFirstName(String fromFirstName) {
        this.fromFirstName = fromFirstName;
    }

    public String getToLastName() {
        return toLastName;
    }

    public void setToLastName(String toLastName) {
        this.toLastName = toLastName;
    }

    public String getToFirstName() {
        return toFirstName;
    }

    public void setToFirstName(String toFirstName) {
        this.toFirstName = toFirstName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getSentDateTime() {
        return sentDateTime;
    }

    public void setSentDateTime(Date sentDateTime) {
        this.sentDateTime = sentDateTime;
    }
}
