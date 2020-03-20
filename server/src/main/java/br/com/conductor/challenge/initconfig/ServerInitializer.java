package br.com.conductor.challenge.initconfig;

import br.com.conductor.challenge.config.ServerSocketProperties;
import br.com.conductor.challenge.socket.TcpSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServerInitializer implements ApplicationRunner {

    final
    ServerSocketProperties serverSocketProperties;

    @Autowired
    public ServerInitializer(ServerSocketProperties serverSocketProperties) {
        this.serverSocketProperties = serverSocketProperties;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        new TcpSocketServer(serverSocketProperties).init();
    }

}
