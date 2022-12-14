package com.microservices.ibrahim.web;

import com.microservices.ibrahim.dto.BankAccountRequestDTO;
import com.microservices.ibrahim.dto.BankAccountResponseDTO;
import com.microservices.ibrahim.entities.BankAccount;
import com.microservices.ibrahim.service.IAccountService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountRestController {

    private IAccountService service;

    public AccountRestController(IAccountService service) {
        this.service = service;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return service.bankAccounts();
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccount getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @PostMapping("addAccount")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO requestDTO) {
        return service.addAccount(requestDTO);
    }

    @PutMapping("/updateAccount/{id}")
    public BankAccountResponseDTO updateAccount(@PathVariable("id") String id, @RequestBody BankAccountRequestDTO requestDTO) {
        return service.updateAccount(id, requestDTO);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public void deletAccount(@PathVariable("id") String id) {
        service.deletAccount(id);
    }
}
