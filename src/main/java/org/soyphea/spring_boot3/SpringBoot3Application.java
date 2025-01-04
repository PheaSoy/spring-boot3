package org.soyphea.spring_boot3;

import jdk.jshell.Snippet;
import org.soyphea.spring_boot3.domain.entity.Channel;
import org.soyphea.spring_boot3.domain.entity.Txn;
import org.soyphea.spring_boot3.domain.entity.TxnStatus;
import org.soyphea.spring_boot3.repository.TxnRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringBoot3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TxnRepository txnRepository){
		return args -> {
			// Create a new instance of Transaction
			Txn transaction = new Txn();
			// Set values for the fields
			transaction.setId("1");  // Set the unique ID for the transaction
			transaction.setStatus(TxnStatus.FAILED);  // Set the transaction status (SUCCESS or FAILED)
			transaction.setAmount(10.0);  // Set the amount for the transaction
			transaction.setCreatedAt(new Date());
			transaction.setChannel(Channel.MOBILE);
			txnRepository.save(transaction);
		};
	}
}
