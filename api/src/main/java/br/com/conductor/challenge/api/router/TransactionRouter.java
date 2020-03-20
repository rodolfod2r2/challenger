package br.com.conductor.challenge.api.router;

import br.com.conductor.challenge.api.handler.TransactionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TransactionRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TransactionHandler transactionHandler){
        return RouterFunctions
                .route(GET("/api/transaction").and(accept(MediaType.APPLICATION_JSON)), transactionHandler::findAll)
                .andRoute(GET("/api/transaction/{id}").and(accept(MediaType.APPLICATION_JSON)), transactionHandler::findById)
                .andRoute(POST("/api/transaction").and(accept(MediaType.APPLICATION_JSON)), transactionHandler::save);

    }
}
