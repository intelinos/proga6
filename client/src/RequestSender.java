import request.Request;
import response.Response;

import java.io.IOException;
import java.io.ObjectInputStream;

public class RequestSender {
    public RequestSender(Request request) {

    }
    public Response sendRequest(Request request) {
        try {
            ObjectInputStream ois = new ObjectInputStream(System.in);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
