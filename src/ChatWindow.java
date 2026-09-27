
import java.awt.*;

class ChatWindow extends Frame {
    Label name;
    TextField Name, typemassage;
    TextArea message;
    Button connect, send;

    public ChatWindow() {
        setSize(700, 700);
        setTitle("Java LAN Chat");
        setLayout(null);

        name = new Label("Username:");
        name.setBounds(20, 30, 100, 30);
        add(name);

        Name = new TextField("Enter User Name");
        Name.setBounds(150, 30, 350, 30);
        add(Name);

        connect = new Button("Connect");
        connect.setBounds(530, 30, 100, 30);
        add(connect);

        message = new TextArea("Chat Message appear Here...");
        message.setBounds(20, 75,600 , 500);
        add(message);

        typemassage = new TextField("Type Message Here ...");
        typemassage.setBounds(20, 600, 450, 30);
        add(typemassage);

        send = new Button("Send");
        send.setBounds(500, 600, 100, 30);
        add(send);

        setVisible(true);
    }

    public static void main(String[] args) {
        ChatWindow C = new ChatWindow();
    }
}