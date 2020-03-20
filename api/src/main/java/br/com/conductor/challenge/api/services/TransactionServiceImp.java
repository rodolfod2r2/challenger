package br.com.conductor.challenge.api.services;

import br.com.conductor.challenge.api.document.Transaction;
import br.com.conductor.challenge.api.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Mono<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Mono<Transaction> save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
