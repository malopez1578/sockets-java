package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {
    Socket client;
    ObjectOutputStream data;
    ObjectInputStream response;
    String message;

    public void init(){
        try{

            client = new Socket("localhost", 4500);
            data = new ObjectOutputStream(client.getOutputStream());
            data.writeObject("Hi connected server");

            response = new ObjectInputStream(client.getInputStream());
            message = (String)response.readObject();

            System.out.println("Message response server : "+ message);

            client.close();
            System.out.println("connection closed");


        }catch(UnknownHostException ex){
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }catch( ClassNotFoundException ex ) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
