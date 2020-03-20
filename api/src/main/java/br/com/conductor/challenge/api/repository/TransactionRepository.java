package br.com.conductor.challenge.api.repository;

import br.com.conductor.challenge.api.document.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
