package br.com.conductor.challenge.socket;

import br.com.conductor.challenge.config.ServerSocketProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


@Slf4j
public class TcpSocketServer {

    final
    ServerSocketProperties serverSocketProperties;

    @Autowired
    public TcpSocketServer(ServerSocketProperties serverSocketProperties) throws IOException {

        this.serverSocketProperties = serverSocketProperties;

        log.info("inicializando o Socket");

        try {
            ServerSocket serverSocket = new ServerSocket(serverSocketProperties.getInfoServerPort());
            log.info("Socket inicializado");
            log.info("Socket inicializado {}", serverSocketProperties.getInfoServerAddress());
            log.info("Socket inicializado {}", serverSocketProperties.getInfoServerPort());
            while (true) {
                Socket socket = serverSocket.accept();
                log.info("Novo Cliente Conectado");
                new TcpSocketServerThread(socket).start();
            }

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    @Bean
    public void init() throws IOException {
        new TcpSocketServer(serverSocketProperties);
    }
}
