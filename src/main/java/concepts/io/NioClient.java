package concepts.io;/**
 * @author Weiyan Xiang on 2021/11/28
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

public class NioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
