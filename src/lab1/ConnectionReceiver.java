package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zacharias
 */
public class ConnectionReceiver extends Thread {


    private int port;

    public void setPort(int port) {
        this.port = port;
    }

    public void readInput(Socket socket){
        BufferedReader in = null;
        try {

            System.out.println("Handling client at " + socket.getInetAddress().getHostAddress() + " on port " + socket.getPort());

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("exit")) {
                    break;
                }

                outputLine = DataFilter.filter(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Invalid")) {
                    break;
                }
            }

            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(ConnectionReceiver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionReceiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void run() {
                try {
            ServerSocket servSocket = new ServerSocket(port);
            while (true) {
                Socket socket = servSocket.accept();
                readInput(socket);
            }
        } catch (IOException ex) {
            Logger.getLogger(ConnectionReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
