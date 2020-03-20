package br.com.conductor.challenge.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ClientSocketProperties {

    @Value("${info.client.address}")
    private String infoClientAddress;

    @Value("${info.client.port}")
    private int infoClientPort;

    @Value("${info.client.backlog}")
    private int infoClientBackLog;

}
