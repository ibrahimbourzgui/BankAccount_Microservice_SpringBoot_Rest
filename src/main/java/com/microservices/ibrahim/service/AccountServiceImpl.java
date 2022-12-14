package com.microservices.ibrahim.service;

import com.microservices.ibrahim.dto.BankAccountResponseDTO;
import com.microservices.ibrahim.entities.BankAccount;
import com.microservices.ibrahim.dto.BankAccountRequestDTO;
import com.microservices.ibrahim.mappers.AccountMapper;
import com.microservices.ibrahim.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper mapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper mapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.mapper = mapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO requestDTO) {

        BankAccount bankAccount = mapper.fromRequestDTO(requestDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO responseDTO = mapper.fromBankAccount(savedBankAccount);
        return responseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO requestDTO) {
        BankAccount bankAccount1 = getById(id);
        if (requestDTO != null) bankAccount1 = mapper.fromRequestDTO(requestDTO);
        BankAccountResponseDTO responseDTO = mapper.fromBankAccount(bankAccount1);

        return responseDTO;
    }

    @Override
    public BankAccount getById(String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Bank account not found %s", id)));
    }

    @Override
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public void deletAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
