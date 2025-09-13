package com.faleite.picpay.service;

import com.faleite.picpay.model.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public boolean notify(User user, String message){
        return true;
    }
}
