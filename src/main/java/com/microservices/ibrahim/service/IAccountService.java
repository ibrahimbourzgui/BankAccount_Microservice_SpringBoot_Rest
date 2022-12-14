package com.microservices.ibrahim.service;

import com.microservices.ibrahim.dto.BankAccountRequestDTO;
import com.microservices.ibrahim.dto.BankAccountResponseDTO;
import com.microservices.ibrahim.entities.BankAccount;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IAccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO requestDTO);

    public BankAccount getById(String id);

    public List<BankAccount> bankAccounts();

    public void deletAccount(String id);
}
