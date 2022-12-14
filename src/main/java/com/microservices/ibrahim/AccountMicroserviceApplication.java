package com.microservices.ibrahim;

import com.microservices.ibrahim.entities.BankAccount;
import com.microservices.ibrahim.enums.AccountType;
import com.microservices.ibrahim.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@SpringBootApplication
public class AccountMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountMicroserviceApplication.class, args);
    }
//    @Bean //pour la créature de l'objet au démarrage
//    CommandLineRunner start(BankAccountRepository bankAccountRepository)
//    {
//        return args -> {
//            for (int i = 0; i < 10; i++) {
//                BankAccount bankAccount= BankAccount.builder()
//                        .id(UUID.randomUUID().toString())
//                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
//                        .balance(1000+Math.random()*90000)
//                        .createdAt(new Date())
//                        .currency("MAD")
//                        .build();
//                bankAccountRepository.save(bankAccount);
//            }
//        };
//    }
}
