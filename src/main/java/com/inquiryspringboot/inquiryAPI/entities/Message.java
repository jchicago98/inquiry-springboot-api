package com.inquiryspringboot.inquiryAPI.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer message_id;
    @OneToOne
    InquiryUser sender;
    @OneToOne
    InquiryUser receiver;
    String messageText;
    Date sentDateTime;

    public Message (){}

    public Message(Integer message_id, InquiryUser sender, InquiryUser receiver, String messageText, Date sentDateTime) {
        this.message_id = message_id;
        this.sender = sender;
        this.receiver = receiver;
        this.messageText = messageText;
        this.sentDateTime = sentDateTime;
    }

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public InquiryUser getSender() {
        return sender;
    }

    public void setSender(InquiryUser sender) {
        this.sender = sender;
    }

    public InquiryUser getReceiver() {
        return receiver;
    }

    public void setReceiver(InquiryUser receiver) {
        this.receiver = receiver;
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

    public Message withMessageId(Integer message_id){
        this.message_id = message_id;
        return this;
    }

    public Message withSender(InquiryUser sender){
        this.sender = sender;
        return this;
    }

    public Message withReceiver(InquiryUser receiver){
        this.receiver = receiver;
        return this;
    }

    public Message withMessageText(String messageText){
        this.messageText = messageText;
        return this;
    }


}
