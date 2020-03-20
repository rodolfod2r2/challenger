package br.com.conductor.challenge.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Slf4j
public class TcpSocketClientThread extends Thread {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public void startConnection() {
        String response;
        log.info("Connectado");

        try {
            socket = new Socket("127.0.0.1", 1111);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            response = sendMessage("|001|10032012|002|50186|003|Raul Seixas|004|Rio de Janeiro|005|0000015000|006|SRF001|");

            log.info(response);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public String sendMessage(String message) {
        String response = "";
        try {
            dataOutputStream.write(message.getBytes());
            dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] buffer = new byte[4096];
            int length = dataInputStream.read(buffer);

            if (length > -1) {
                response = new String(buffer, 0, length, StandardCharsets.UTF_8);
            }
        } catch (IOException error) {
            error.printStackTrace();
            response = "error";
        }
        return response;
    }

    public void stopConnection() {
        try {
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        startConnection();
    }
}
