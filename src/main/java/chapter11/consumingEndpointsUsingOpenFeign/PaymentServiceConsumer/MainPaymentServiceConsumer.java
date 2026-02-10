package chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MainPaymentServiceConsumer {
    public static void main(String[] args) {
        SpringApplication.run(MainPaymentServiceConsumer.class, args);
    }
}
