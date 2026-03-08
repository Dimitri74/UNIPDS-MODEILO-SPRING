package br.com.unipds.spring.helloworld.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("v2")
public class MessageServiceImplV2 implements IMessageService{

    @Override
    public String sayCustomMessage(String original) {
        // TODO Auto-generated method stub
        return original.replaceAll(" ", "-");
    }
}
