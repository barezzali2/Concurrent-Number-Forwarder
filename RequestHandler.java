package Lab2;

import java.net.*; 
import java.io.*;
import java.util.Random;


public class RequestHandler implements Runnable {

    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
            NumberService request = (NumberService) ois.readObject();
            System.out.println("The number " + request.number + " will be forwarded to port 1083: Node Z");

            Socket socket = new Socket("localhost", 1083);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            NumberService number = new NumberService(request.number);
            oos.writeObject(number);


            // Random delay
            Thread.sleep(new Random().nextInt(500) + 500);
            

        } catch (Exception ex) {
            System.err.println(ex);
        }

    }
    
}
