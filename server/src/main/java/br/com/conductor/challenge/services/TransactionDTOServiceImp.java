package br.com.conductor.challenge.services;

import br.com.conductor.challenge.dto.TransactionDTO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


import static java.util.Arrays.*;

@Slf4j
public class TransactionDTOServiceImp implements TransactionDTOService {

    private static final String URI_API = "http://localhost:8080/api/transaction";


    @Override
    public TransactionDTO save(TransactionDTO transactionDTO) {
        TransactionDTO responseEntityBody = null;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(asList(MediaType.APPLICATION_JSON));
        

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(transactionDTO);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, httpHeaders);

        ResponseEntity<TransactionDTO> responseEntity = restTemplate.exchange(URI_API,HttpMethod.POST, requestEntity, TransactionDTO.class);

        if(responseEntity.getStatusCode() == HttpStatus.OK){
            responseEntityBody = responseEntity.getBody();
            log.info("Transaction Save");
        } 

        return responseEntityBody;
    }

}
