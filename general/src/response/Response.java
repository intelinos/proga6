package response;

import java.io.Serializable;

public class Response implements Serializable {
    //private static final long serialVersionUID = 343423422434234L;
    private String responseMessage="";
    public Response() {
    }
    public Response(String responseMessage){
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
}
