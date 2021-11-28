package concepts.io;/**
 * @author Weiyan Xiang on 2021/11/28
 */

import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MulticastServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        try {

            MulticastSocket socket = new MulticastSocket();

            byte[] b = "hello world".getBytes();
            DatagramPacket dgram = new DatagramPacket(b, b.length, InetAddress.getByName("235.1.1.1"), 4000);

            System.out.println("Sending " + b.length + " bytes a " + dgram.getAddress() + ':' + dgram.getPort());
            while (true) {
                System.out.print(".");
                socket.send(dgram);
                Thread.sleep(1000);
            }

        } catch (SocketException ex) {
            Logger.getLogger(MulticastServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MulticastServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
