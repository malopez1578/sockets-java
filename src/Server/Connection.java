package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {
    ServerSocket server;
    Socket client;
    ObjectInputStream data;
    ObjectOutputStream response;
    String message;

    public void init(){
        try {
            server = new ServerSocket(4500);
            client = server.accept();
            data = new ObjectInputStream(client.getInputStream());
            System.out.println("data received");
            System.out.println("Send message to client.");

            message = (String)data.readObject();
            System.out.println("Message: "+ message);

            response = new ObjectOutputStream(client.getOutputStream());
            response.writeObject("Welcome to shop");
            System.out.println("Message send");

            client.close();
            server.close();

        } catch(IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch( ClassNotFoundException ex ) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
