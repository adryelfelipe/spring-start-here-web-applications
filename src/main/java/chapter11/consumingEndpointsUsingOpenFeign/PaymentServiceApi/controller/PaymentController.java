package chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceApi.controller;

import chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceApi.models.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {

    // Attributes
    private static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    // Methods
    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
        logger.info("Received request with ID {} || Payment Amount: {}", requestId, payment.getAmount());
        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("requestId", requestId)
                .body(payment);
    }
}
