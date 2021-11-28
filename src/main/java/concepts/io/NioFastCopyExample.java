package concepts.io;/**
 * @author Weiyan Xiang on 2021/11/28
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

public class NioFastCopyExample {
    public static void fastCopy(String src, String dist) throws IOException {
        FileInputStream fin = new FileInputStream(src);
        FileChannel fcin = fin.getChannel();

        FileOutputStream fout = new FileOutputStream(dist);
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            int r = fcin.read(buffer);

            // when its EOF
            if (r == -1) {
                break;
            }

            buffer.flip();

            fcout.write(buffer);

            buffer.clear();
        }
    }
}
