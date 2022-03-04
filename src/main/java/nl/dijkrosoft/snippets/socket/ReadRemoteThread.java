package nl.dijkrosoft.snippets.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class ReadRemoteThread implements Runnable {

    boolean remoteReadingDone = false;
    int n;
    private InputStream remoteInputStream;
    private OutputStream dbOutputStream;
    byte[] buf = new byte[1024 * 1024];

    public ReadRemoteThread(InputStream remoteInputStream, OutputStream dbOutputStream) {
        this.remoteInputStream = remoteInputStream;
        this.dbOutputStream = dbOutputStream;
    }

    @Override
    public void run() {
//        while (!remoteReadingDone /* && remoteInputStream.available()>0*/) {
//            try {
        while (true) {

            try {
                n = remoteInputStream.read(buf);

                System.out.println("Read from remote " + n + ". " + new Date());

                if (n > 0) {
                    System.out.println("About to write n=" + n);
                    try {
                        dbOutputStream.write(buf, 0, n);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("write done");

                }
            } catch (java.net.SocketTimeoutException ex) {
                System.out.println("Socket read timeout");
                remoteReadingDone = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (n == -1) {
                remoteReadingDone = true;
                System.out.println("remoteReadingDone, " + new Date());
                break;
            }
        }
//        System.out.println("ReadRemoteThread done." + new Date());
    }


}