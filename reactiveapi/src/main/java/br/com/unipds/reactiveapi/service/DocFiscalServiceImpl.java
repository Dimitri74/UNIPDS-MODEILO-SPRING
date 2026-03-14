package br.com.unipds.reactiveapi.service;



import br.com.unipds.reactiveapi.model.DocFiscal;
import br.com.unipds.reactiveapi.repository.DocFiscalRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class DocFiscalServiceImpl implements IDocFiscalService{

    private DocFiscalRepo repo;
    private WebClient webClient;

    @Value("${api.external.url}")
    private String baseUrl;

    public DocFiscalServiceImpl(DocFiscalRepo repo , WebClient webClient) {
        super();
        this.repo = repo;
        this.webClient = webClient;
    }

    @Override
    public void realizarAutorizacaoAPIExterna(Long idCliente, Integer idServico, String protocolo) {
        // TODO Auto-generated method stub
        System.out.println("DEBUG = IDCLIENTE="+idCliente);
        System.out.println("DEBUG = IDSERVICO="+idServico);
        webClient.get()
                .uri(baseUrl + "/api/v1/autorizacao/"+idCliente+"?servico="+idServico)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext((resposta)->{
                    System.out.println("DEBUG - Solicitacao atendida pela API Externa");
                    DocFiscal doc = new DocFiscal();
                    doc.setProtocolo(protocolo);
                    doc.setDocumento(resposta);
                    repo.save(doc);
                })
                .doOnError(erro -> {
                    System.out.println("ERRO - "+erro);
                })
                .subscribe();
    }

    @Override
    public DocFiscal consultarPorProtocolo(String protocolo) {
        // TODO Auto-generated method stub
        return repo.findByProtocolo(protocolo).orElse(null);
    }

}