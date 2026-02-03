package chapter11.PaymentServiceConsumer.proxy;

import chapter11.PaymentServiceApi.models.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments", url = "${payment.url}")
public interface PaymentsProxy {

    @PostMapping("/payment")
    public Payment anyMethod(@RequestHeader String requestId, @RequestBody Payment payment);
}
