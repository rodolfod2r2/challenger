package br.com.conductor.challenge.socket;

import br.com.conductor.challenge.dto.TransactionDTO;
import br.com.conductor.challenge.services.TransactionDTOServiceImp;
import br.com.conductor.challenge.utils.ISOdeserialize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

@Slf4j
public class TcpSocketServerThread extends Thread {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;


    public TcpSocketServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = "";

            byte[] buffer = new byte[4096];
            int length = dataInputStream.read(buffer);

            if (length > -1) {
                message = new String(buffer, 0, length, StandardCharsets.UTF_8);

                TreeMap<String, String> dataMb = ISOdeserialize.deserialize(message);

                TransactionDTO transaction = new TransactionDTO();
                transaction.setId(dataMb.get("001"));
                transaction.setData(dataMb.get("002"));
                transaction.setName(dataMb.get("003"));
                transaction.setState(dataMb.get("004"));
                transaction.setBravely(dataMb.get("005"));
                transaction.setLow(dataMb.get("006"));
                new TransactionDTOServiceImp().save(transaction);

                log.info(message);
            }

            log.info("retorno");
            dataOutputStream.write(buffer);

            socket.close();
            log.info("cliente desconectado");
        } catch (IOException error) {
            log.error("error");
            error.printStackTrace();
        }
    }
}
