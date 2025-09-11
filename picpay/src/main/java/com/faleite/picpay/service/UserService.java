package com.faleite.picpay.service;

import com.faleite.picpay.dto.MerchantDTO;
import com.faleite.picpay.model.Merchant;
import com.faleite.picpay.model.User;
import com.faleite.picpay.repository.MerchantRepository;
import com.faleite.picpay.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Transactional // Se der algum problema ele refaz a transação
    public User createUser(final User user){
        user.setCreateAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Transactional
    public Merchant createMerchant(final MerchantDTO merchantDTO){

        User user = new User();
        user.setFullname(merchantDTO.getFullname());
        user.setCpf(merchantDTO.getCpf());
        user.setEmail(merchantDTO.getEmail());
        user.setPassword(merchantDTO.getPassword());
        user.setBalance(BigDecimal.ZERO);
        user.setCreateAt(LocalDateTime.now());
        user = userRepository.save(user);

        Merchant merchant = new Merchant();
        merchant.setUser(user);
        merchant.setCnpj(merchantDTO.getCnpj());
        return merchantRepository.save(merchant);
    }
}
