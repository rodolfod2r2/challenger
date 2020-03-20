package br.com.conductor.challenge.initconfig;

import br.com.conductor.challenge.socket.TcpSocketClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientInitializer implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        new TcpSocketClient().init();
    }

}
