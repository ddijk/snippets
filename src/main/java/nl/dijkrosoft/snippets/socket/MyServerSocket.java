package nl.dijkrosoft.snippets.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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

            System.out.println("Socket got connection");

            byte[] buf = new byte[1024 * 1024];

            InputStream remoteInputStream = socket.getInputStream();
            OutputStream remoteOutputStream = socket.getOutputStream();

            Socket dbSocket = new Socket("localhost", 5432);

            InputStream dbInputStream = dbSocket.getInputStream();
            OutputStream dbOutputStream = dbSocket.getOutputStream();

            int n;
            boolean done = false;
            while (!done) {


                boolean remoteReadingDone = false;
                while ( !remoteReadingDone) {
                    n = remoteInputStream.read(buf);
                    if (n == -1) {
                        remoteReadingDone = true;
                        continue;
                    }
                    dbOutputStream.write(buf, 0, n);
                }
//                if (n <= 1) {
//                    System.out.println("Looks like we're done");
//                    done = true;
//                    continue;
//                }
//                System.out.println("Buf length is " + buf.length + ", n is " + n);

                boolean dbReadingDone = false;
                while (!dbReadingDone) {
                    n = dbInputStream.read(buf);
                    if (n == -1) {
                        dbReadingDone = true;
                        continue;
                    }
                    remoteOutputStream.write(buf, 0, n);
                }
            }
            System.out.println("Done");
        }
    }
}
