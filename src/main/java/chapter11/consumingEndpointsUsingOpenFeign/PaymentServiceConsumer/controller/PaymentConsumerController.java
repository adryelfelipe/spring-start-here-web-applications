package chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceConsumer.controller;

import chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceApi.models.Payment;
import chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceConsumer.proxy.PaymentsProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentConsumerController {
    // Attribute
    private PaymentsProxy paymentsProxy;

    // Constructor
    public PaymentConsumerController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    // Methods
    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment paymentReceived) {
        String requestId = UUID.randomUUID().toString();
        Payment paymentReturned = paymentsProxy.anyMethod(requestId, paymentReceived);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paymentReturned);
    }
}
