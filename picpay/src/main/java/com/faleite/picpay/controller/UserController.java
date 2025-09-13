package com.faleite.picpay.controller;

import com.faleite.picpay.dto.MerchantDTO;
import com.faleite.picpay.model.Merchant;
import com.faleite.picpay.service.UserService;
import com.faleite.picpay.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> creatUser(@RequestBody User user){
        User userCreated = userService.createUser(user);
        return ResponseEntity.ok(userCreated);
    }

    @PostMapping("create-merchant")
    public ResponseEntity<Merchant> createMerchant(@RequestBody MerchantDTO merchantDTO){
        Merchant merchantCreated = userService.createMerchant(merchantDTO);
        return ResponseEntity.ok(merchantCreated);
    }
}
