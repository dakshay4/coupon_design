package com.dakshay.model;

import javax.persistence.*;

/**
 * Created by Dakshay on 10/16/2018.
 */
@Entity
@Table(name="sms_provider")
public class SmsProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="url")
    private String url;
    @Column(name="provider_name")
    private String providerName;
    @Column(name="auth_key")
    private String authKey;
    @Column(name = "sender_id")
    private String senderId;
    @Column(name = "channel")
    private String channel;
    @Column(name = "route")
    private String route;
    @Column(name = "status")
    private String status;

    public SmsProvider() {
    }

    public SmsProvider(String url, String providerName, String authKey, String senderId, String channel, String route, String status) {
        this.url = url;
        this.providerName = providerName;
        this.authKey = authKey;
        this.senderId = senderId;
        this.channel = channel;
        this.route = route;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
