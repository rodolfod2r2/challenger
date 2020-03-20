package br.com.conductor.challenge.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@Slf4j
public class TcpSocketClient {

    @Bean
    public void init() throws IOException {
        new TcpSocketClientThread().start();
    }
}
