package org.soyphea.spring_boot3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class BankTransferService {

    private Logger log = Logger.getLogger(BankTransferService.class.getName());

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    public String transfer(String bank, String ok, String transferDetails) {
        // Create CircuitBreaker instance using the dynamic name for each bank service
        CircuitBreaker circuitBreaker = circuitBreakerFactory

                .create(bank + "-service");
        // Call the method and handle fallback
        return circuitBreaker.run(() -> makeHttpCall(bank, ok, transferDetails),
                throwable -> fallback(bank, transferDetails, throwable));  // Fallback logic
    }

    private String makeHttpCall(String bank, String ok, String transferDetails) {
        log.info("Calling external service: " + bank);

        // Simulate failure if "ok" is not "ok"
        if (!"ok".equals(ok)) {
            // Simulate failure by throwing an exception
            throw new RuntimeException(bank + " service is down!");
        }

        // Simulate successful transfer
        return "Transfer to " + bank + " succeeded: " + transferDetails;
    }

    private String fallback(String bank, String transferDetails, Throwable throwable) {
        // Return fallback message when circuit breaker is open
        log.warning("Fallback triggered for " + bank + " due to: " + throwable.getMessage());
        return "Fallback: " + bank + " service is unavailable for transfer: " + transferDetails + ". Reason: " + throwable.getMessage();
    }
}
