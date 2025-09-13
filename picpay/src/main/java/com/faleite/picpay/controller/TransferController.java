package com.faleite.picpay.controller;

import com.faleite.picpay.dto.TransferDTO;
import com.faleite.picpay.model.Transfer;
import com.faleite.picpay.service.ExternalAuthorizationService;
import com.faleite.picpay.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private ExternalAuthorizationService externalAuthorizationService;

    @PostMapping("/create")
    public ResponseEntity<Transfer> postMethodName(@RequestBody TransferDTO transferDTO){
        Transfer transferCreated = transferService.transfer(transferDTO.getPayer(), transferDTO.getPayee(), transferDTO.getValueTransfer());
        return ResponseEntity.ok(transferCreated);
    }

    @GetMapping("/test-authorization")
    public Boolean testAuthorization(){
        return externalAuthorizationService.isAuthorized();
    }

}
