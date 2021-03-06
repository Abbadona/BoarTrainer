import javax.net.ssl.SSLSocket;
import java.io.*;
import java.io.InputStream;
import javax.net.ssl.SSLSocketFactory;

public class SSLConnector {
    private static SSLConnector instance = null;
    private static SSLSocket sslsocket ;



    protected SSLConnector(){
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        try {
            sslsocket = (SSLSocket)sslsocketfactory.createSocket("localhost", 9999);
        } catch (Exception e) {
            System.out.println("Connection refused");
        }



    }
    public static SSLConnector getInstance()  {
        synchronized(SSLConnector.class){
            if(instance == null) {
                instance = new SSLConnector();
            }
            return instance;
        }
    }//koniec getInstance()


}//koniec klasy SSLConnector