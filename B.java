package Lab2;

import java.net.*;
import java.io.*;
import java.util.Random;

public class B {

    public static void main(String... args) {
        Random rand = new Random();
        try {
            while(true) {

                int number = rand.nextInt(100);
                System.out.println("Process B generated: " + number);
                
               
                try (Socket socket = new Socket("localhost", 1081)) {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    NumberService num = new NumberService(number);
                    out.writeObject(num);
                    System.out.println("Number sent to port 1081: Node X");
                } catch (Exception ex) {
                    System.err.println(ex);
                }

                
               
                try (Socket socket = new Socket("localhost", 1082)) {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    NumberService num = new NumberService(number);
                    System.out.println("Number sent to port 1082: Node Y");

                    out.writeObject(num);
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                
                
                Thread.sleep(1000); // Generate every second
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
