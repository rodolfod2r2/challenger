package br.com.conductor.challenge.api.handler;

import br.com.conductor.challenge.api.document.Transaction;
import br.com.conductor.challenge.api.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class TransactionHandler {

    @Autowired
    TransactionService transactionService;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(transactionService.findAll(), Transaction.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(transactionService.findById(id), Transaction.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        final Mono<Transaction> transactionMono = request.bodyToMono(Transaction.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(transactionMono.flatMap(transactionService::save), Transaction.class));
    }
}
