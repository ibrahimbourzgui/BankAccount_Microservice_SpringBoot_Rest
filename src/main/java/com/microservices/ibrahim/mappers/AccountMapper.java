package com.microservices.ibrahim.mappers;

import com.microservices.ibrahim.dto.BankAccountRequestDTO;
import com.microservices.ibrahim.dto.BankAccountResponseDTO;
import com.microservices.ibrahim.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO responseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, responseDTO);
        return responseDTO;
    }

    public BankAccount fromRequestDTO(BankAccountRequestDTO requestDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(requestDTO, bankAccount);
        return bankAccount;
    }
}
