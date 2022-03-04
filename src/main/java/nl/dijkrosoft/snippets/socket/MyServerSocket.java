package nl.dijkrosoft.snippets.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServerSocket {


    /**
     * param1 : listen port
     * param2 : port to forward to
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Geef listenPort nr op als eerste param");
            return;
        }

        int listenPort = Integer.parseInt(args[0]);
//        int forwardPort = Integer.parseInt(args[1]);
        ServerSocket ss = new ServerSocket(listenPort);


        while (true) {
            System.out.println("Waiting for connections...");
            Socket socket = ss.accept();

            socket.setSoTimeout(200);

            System.out.println("Socket got connection. " + new Date());


            InputStream remoteInputStream = socket.getInputStream();
            OutputStream remoteOutputStream = socket.getOutputStream();

            Socket dbSocket = new Socket("localhost", 5432);
            dbSocket.setSoTimeout(200);

            InputStream dbInputStream = dbSocket.getInputStream();
            OutputStream dbOutputStream = dbSocket.getOutputStream();

            Thread readRemoteThread = new Thread(new ReadRemoteThread(remoteInputStream, dbOutputStream));
            readRemoteThread.start();

            Thread readDbThread = new Thread(new ReadDbThread(dbInputStream, remoteOutputStream));
            readDbThread.start();


            System.out.println("Done");
        }
    }
}
