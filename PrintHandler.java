package Lab2;

import java.net.*; 
import java.io.*;

public class PrintHandler implements Runnable{
    private Socket socket;

    public PrintHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            NumberService request = (NumberService) ois.readObject();
            System.out.println("The number " + request.number + " is received");

        } catch (Exception ex) {
            System.err.println(ex);
        }


    }
}
