package com.dakshay.model;


import javax.persistence.*;

/**
 * Created by Dakshay on 10/19/2018.
 */
@Entity
@Table(name="sms_template")
public class SmsTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "message")
    private String message;

    public SmsTemplate() {
    }

    public SmsTemplate(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
