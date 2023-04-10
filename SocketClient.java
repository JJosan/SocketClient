import java.io.*;
import java.net.*;
import java.util.logging.*;

public class SocketClient {
    private static final Logger LOGGER = Logger.getLogger(SocketClient.class.getName());
    public static void main(String[] args) {
        // String host = args[0];
        // int port = Integer.valueOf(args[1]);

        // String host = "djxmmx.net";
        //int port = 17;

        // String host = "time.nist.gov";
        // int port = 13;
        
        String host = "tcpbin.com";
        int port = 4242;

        try {
            Socket sock = new Socket(host, port);
            LOGGER.info("connected to Host: " + host + ", Port: " + port);

            sock.setSoTimeout(5000);

            // send to server
            OutputStream output = sock.getOutputStream();
            PrintWriter out = new PrintWriter(output, true);
            String message = "hello";
            out.println(message);
            LOGGER.info("Wrote to server");

            // read from server
            InputStream input = sock.getInputStream();
            for (int readChar = 0; readChar != -1; readChar = input.read()) {
                System.out.print((char)readChar);
            }
            System.out.println();
            LOGGER.info("Done reading");
            sock.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}