import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import request.Request;

public class Main {
    public static void main(String[] args) {
        try {
            Request request;
            InetAddress host = InetAddress.getLocalHost();
            int port = 43497;
            SocketAddress addr = new InetSocketAddress(host, port);
            SocketChannel sock;
            try (ServerSocketChannel serv = ServerSocketChannel.open()) {
                serv.configureBlocking(false);
                serv.bind(addr);
                sock = serv.accept();
                while (true) {
                    if (sock == null)
                        sock = serv.accept();
                    else break;
                }
                ByteBuffer buf = ByteBuffer.allocate(50000);
                sock.read(buf);
                System.out.println("Получено, вот оно:");
                ByteArrayInputStream byteStream = new ByteArrayInputStream(buf.array());
                ObjectInputStream objectStream = new ObjectInputStream(byteStream);
                System.out.println("Тут ошибка?");
                Object deserializedObject = objectStream.readObject();
                System.out.println("Вывод");
                System.out.println(((Request) deserializedObject).getCommandName());
            }
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}