package concepts.io;/**
 * @author Weiyan Xiang on 2021/11/28
 */

import java.util.*;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MulticastClient {
    public static void main(String[] args) throws IOException {

        try {
            byte[] b = new byte[100];
            DatagramPacket dgram = new DatagramPacket(b, b.length);
            MulticastSocket socket = new MulticastSocket(4000);
            socket.joinGroup(InetAddress.getByName("235.1.1.1"));

            while (true) {
                socket.receive(dgram); // Locks up until a datagram arrives
                System.out.println("Received " + dgram.getLength() +
                        " bytes " + dgram.getAddress() + " " + new String(dgram.getData()));

            }

        } catch (SocketException ex) {
            Logger.getLogger(MulticastClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MulticastClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
