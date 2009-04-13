package lab1;

import java.util.Scanner;

/**
 *
 * @author Zacharias
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create a Scanner object
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter port to start server on: ");
        int port = keyboard.nextInt();
        ConnectionReceiver rec = new ConnectionReceiver();
        rec.setPort(port);
        rec.start();
        //ConnectionReceiver.start(port);

        System.out.println("Enter hostname to connect to server: ");
        String host = keyboard.next();
        System.out.println("Enter port to connect to server: ");
        port = keyboard.nextInt();

        Connection con = new Connection(host, port);
        boolean connection = true;
        String in = "";
        keyboard.nextLine();
        while (connection) {
            System.out.print("Input: ");
            in = keyboard.nextLine();
            connection = con.callFunction(in);
        }
        System.exit(0);
    }
}