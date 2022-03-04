package nl.dijkrosoft.snippets.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class ReadDbThread implements Runnable {

    private InputStream dbInputStream;
    private OutputStream remoteOutputStream;
    byte[] buf = new byte[1024 * 1024];
    int n;

    public ReadDbThread(InputStream dbInputStream, OutputStream remoteOutputStream) {
        this.dbInputStream = dbInputStream;
        this.remoteOutputStream = remoteOutputStream;
    }

    @Override
    public void run() {
        boolean dbReadingDone = false;
//        while (!dbReadingDone /* && dbInputStream.available()> 0 */) {
        while (true) {
            System.out.println("Read from db");
            try {

                n = dbInputStream.read(buf);

                System.out.println("Read from db " + n + ". " + new Date());
                if (n > 0) {

                    try {
                        remoteOutputStream.write(buf, 0, n);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (java.net.SocketTimeoutException ex) {
                System.out.println("db read timeout");
                dbReadingDone = true;
            } catch (IOException ex) {
                System.out.println("io ex" + ex);
            }


            if (n == -1) {
                dbReadingDone = true;
                System.out.println("dbReadingDone. " + new Date());
                break;
            }
        }
//        System.out.println("ReadDbThread done." + new Date());
    }
}
