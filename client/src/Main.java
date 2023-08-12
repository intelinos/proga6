import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import Organization.Organization;
import request.Request;

public class Main {
    public static void main(String[] args) {
        try {
            Request request= new Request("help");
            Socket sock;
            OutputStream os;
            InputStream is;
            System.out.println("Getting localhost.");
            InetAddress host = InetAddress.getLocalHost();
            int port;
            port = 43497;
            System.out.println("Creating Socket.");
            while(true) {
                try {
                    sock = new Socket(host, port);
                } catch (ConnectException e) {
                    continue;
                }
                break;
            }
            os = sock.getOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(os);
            System.out.println("Writing.");
            ous.writeObject(request);
            System.out.println("Sended.");
            /*is = new ObjectInputStream(sock.getInputStream());
            System.out.println("Reading.");
            is.read(arr);
            for(byte j : arr) {
                System.out.println(j);
            }*/
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}