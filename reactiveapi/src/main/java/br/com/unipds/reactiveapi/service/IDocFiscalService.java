package br.com.unipds.reactiveapi.service;


import br.com.unipds.reactiveapi.model.DocFiscal;

public interface IDocFiscalService {

    public void realizarAutorizacaoAPIExterna(Long idCliente, Integer idServico, String protocolo);
    public DocFiscal consultarPorProtocolo(String protocolo);
}