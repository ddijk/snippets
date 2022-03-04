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

            byte[] buf = new byte[1024 * 1024];

            InputStream remoteInputStream = socket.getInputStream();
            OutputStream remoteOutputStream = socket.getOutputStream();

            Socket dbSocket = new Socket("localhost", 5432);
            dbSocket.setSoTimeout(200);

            InputStream dbInputStream = dbSocket.getInputStream();
            OutputStream dbOutputStream = dbSocket.getOutputStream();

            int n = 0;
            boolean done = false;
            while (!done) {


                System.out.println("Not done yet. " + new Date());
                boolean remoteReadingDone = false;
                while (!remoteReadingDone /* && remoteInputStream.available()>0*/) {
                    try {

                        n = remoteInputStream.read(buf);
                        System.out.println("Read from remote " + n + ". " + new Date());

                        if (n > 0) {
                            System.out.println("About to write n=" + n);
                            dbOutputStream.write(buf, 0, n);
                            System.out.println("write done");

                        }
                    } catch (java.net.SocketTimeoutException ex) {
                        System.out.println("Socket read timeout");
                        remoteReadingDone = true;
                    }
                    if (n == -1) {
                        remoteReadingDone = true;
                        System.out.println("remoteReadingDone, " + new Date());
                        continue;
                    }
                }
//                if (n <= 1) {
//                    System.out.println("Looks like we're done");
//                    done = true;
//                    continue;
//                }
//                System.out.println("Buf length is " + buf.length + ", n is " + n);

                boolean dbReadingDone = false;
                while (!dbReadingDone /* && dbInputStream.available()> 0 */) {
                    System.out.println("Read from db");
                    try {

                        n = dbInputStream.read(buf);
                        System.out.println("Read from db " + n + ". " + new Date());
                        if (n > 0) {

                            remoteOutputStream.write(buf, 0, n);
                        }
                    } catch (java.net.SocketTimeoutException ex) {
                        System.out.println("db read timeout");
                        dbReadingDone = true;
                    }

                    if (n == -1) {
                        dbReadingDone = true;
                        System.out.println("dbReadingDone. " + new Date());
                        continue;
                    }
                }
            }
            System.out.println("Done");
        }
    }
}
