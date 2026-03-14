package br.com.unipds.reactiveapi.repository;


import java.util.Optional;

import br.com.unipds.reactiveapi.model.DocFiscal;
import org.springframework.data.repository.ListCrudRepository;


public interface DocFiscalRepo extends ListCrudRepository<DocFiscal, Integer>{
    public Optional<DocFiscal> findByProtocolo(String protocolo);
}
