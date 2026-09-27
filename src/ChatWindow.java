
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

class ChatWindow extends Frame implements ActionListener{
    Label name;
    TextField Name, typemassage;
    TextArea message;
    Button connect, send;
    Socket socket;
    PrintWriter out;

    public ChatWindow() {
        setSize(700, 700);
        setTitle("Java LAN Chat");
        setLayout(null);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        name = new Label("Username:");
        name.setBounds(20, 30, 100, 30);
        add(name);

        Name = new TextField("Enter User Name");
        Name.setBounds(150, 30, 350, 30);
        add(Name);

        connect = new Button("Connect");
        connect.setBounds(530, 30, 100, 30);
        connect.addActionListener(this);
        add(connect);

        message = new TextArea("Chat Message appear Here...");
        message.setBounds(20, 75,600 , 500);
        add(message);

        typemassage = new TextField("Type Message Here ...");
        typemassage.setBounds(20, 600, 450, 30);
        add(typemassage);

        send = new Button("Send");
        send.setBounds(500, 600, 100, 30);
        send.addActionListener(this);
        add(send);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connect) {
            try {
                socket = new Socket("localhost", 8080);
                out = new PrintWriter(socket.getOutputStream(), true);

                message.append("Connected to server!\n");
                connect.setEnabled(false);

            } catch (IOException ex) {
                message.append("Connection failed!\n");
            }
        }
        else if (e.getSource() == send) {
            String msg = typemassage.getText().trim();

            if (!msg.isEmpty()) {
                message.append(Name.getText() + ": " + msg + "\n");
                typemassage.setText("");
            }
        }
}

    public static void main(String[] args) {
        ChatWindow C = new ChatWindow();
    }
}