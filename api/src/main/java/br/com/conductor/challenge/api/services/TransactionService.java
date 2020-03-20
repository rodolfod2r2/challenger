package br.com.conductor.challenge.api.services;

import br.com.conductor.challenge.api.document.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Flux<Transaction> findAll();

    Mono<Transaction> findById(String id);

    Mono<Transaction> save(Transaction transaction);
}
