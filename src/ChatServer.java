import java.net.*;

class ChatServer {
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is waiting for client...");
            Socket client = server.accept();
            System.out.println("Client connected!");
        }catch(Exception e){}
    }
}