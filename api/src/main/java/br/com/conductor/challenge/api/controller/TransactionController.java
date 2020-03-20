package br.com.conductor.challenge.api.controller;

import br.com.conductor.challenge.api.document.Transaction;
import br.com.conductor.challenge.api.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transaction")
    public Flux<Transaction> getTransactionList() {
        return transactionService.findAll();
    }

    @GetMapping("/transaction/{id}")
    public Mono<Transaction> getTransactionId(@PathVariable String id) {
        return transactionService.findById(id);
    }

    @PostMapping(value = "/transaction", produces = "application/json")
    public Mono<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }
}
