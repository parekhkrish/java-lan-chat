import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

class ChatServer {
    static List<PrintWriter> clients = new ArrayList<>();
    static void handleClient(Socket client){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            synchronized (clients) {
                clients.add(out);
            }

            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Client: " + msg);
                synchronized (clients) {                    
                    for(PrintWriter writer : clients){
                        writer.println(msg);
                    }
                }

            }
            synchronized (clients) {
                clients.remove(out);
            }    
        } catch (IOException  e) {
            System.out.println("Client disconnected.");
        }  
    }
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is waiting for client...");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected!");

                new Thread(() -> handleClient(client)).start();
            }

            
        }catch(Exception e){}
    }
}