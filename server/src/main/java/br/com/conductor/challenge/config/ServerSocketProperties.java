package br.com.conductor.challenge.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ServerSocketProperties {

    @Value("${info.server.address}")
    private String infoServerAddress;

    @Value("${info.server.port}")
    private int infoServerPort;

    @Value("${info.server.backlog}")
    private int infoServerBackLog;

}
