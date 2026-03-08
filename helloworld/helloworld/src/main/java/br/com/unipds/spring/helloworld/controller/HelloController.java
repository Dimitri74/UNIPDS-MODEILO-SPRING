package br.com.unipds.spring.helloworld.controller;


import br.com.unipds.spring.helloworld.service.IMessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final IMessageService serviceV1;
    private final IMessageService serviceV2;

    public HelloController(
            @Qualifier("v1") IMessageService serviceV1,
            @Qualifier("v2") IMessageService serviceV2) {
        this.serviceV1 = serviceV1;
        this.serviceV2 = serviceV2;
    }

    @GetMapping("/hello/v1")
    public String sayHelloV1(@RequestParam(defaultValue = "Hello World") String message) {
        return serviceV1.sayCustomMessage(message);
    }

    @GetMapping("/hello/v2")
    public String sayHelloV2(@RequestParam(defaultValue = "Hello World") String message) {
        return serviceV2.sayCustomMessage(message);
    }
}