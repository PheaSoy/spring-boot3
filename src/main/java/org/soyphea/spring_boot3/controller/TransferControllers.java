package org.soyphea.spring_boot3.controller;

import org.soyphea.spring_boot3.service.BankTransferService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
public class TransferControllers {


    private final BankTransferService bankTransferService;

    public TransferControllers(BankTransferService bankTransferService) {
        this.bankTransferService = bankTransferService;
    }

    @PostMapping("/{bank}/{ok}")
    public String transferToBank(@PathVariable String bank, @PathVariable String ok,@RequestBody String transferDetails) {
        return bankTransferService.transfer(bank,ok, transferDetails);
    }
}
