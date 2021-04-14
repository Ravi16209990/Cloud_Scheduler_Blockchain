package server;

import utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Constants.PORT);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());

        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Client: "+str);

        PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
        printWriter.println("Hello");
        printWriter.flush();

    }
}