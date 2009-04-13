package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zacharias
 */
public class Connection {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Connection(String hostname, int port) {
        try {
            socket = new Socket(hostname, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            System.out.println("Failed to connect on host " + hostname +
                    " and port " + port);
            e.printStackTrace();
        }
    }

    public boolean callFunction(String s) {
        try {
            String input = null;
            out.println(s);
            if ((input = in.readLine()) == null) {
                return false;
            }
            if (input.contains("exit")) {
                System.exit(0);
            }
            System.out.println(input);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
