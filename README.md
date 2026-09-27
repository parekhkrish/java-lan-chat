# 💬 Java LAN Chat Application

A multi-client chat application built using **Java, AWT, TCP Socket Programming, and Multithreading**. It allows multiple users to connect to a server and exchange messages in real time over a local network.

---

## 🚀 Features

* Multi-client communication
* Real-time messaging using TCP sockets
* Message broadcasting to all connected clients
* Multithreading for handling multiple clients
* Graphical user interface using Java AWT
* Client connection and disconnection handling

## 🛠️ Technologies Used

* Java
* Java AWT
* TCP Socket Programming
* Multithreading
* BufferedReader and PrintWriter

---

## 🏗️ System Architecture

The application uses a **client-server architecture**. The server accepts multiple client connections and creates a separate thread to handle each client.

```mermaid
flowchart TB
    subgraph Clients["💻 Client Applications"]
        C1["Client 1<br/>ChatWindow.java"]
        C2["Client 2<br/>ChatWindow.java"]
        C3["Client 3<br/>ChatWindow.java"]
    end

    subgraph Server["🖥️ Chat Server"]
        S["ChatServer.java<br/>ServerSocket : 8080"]
        A["Accept Connections"]
        B["Create Client Handler Thread"]
        L["Shared List of PrintWriters"]
        R["Receive Messages"]
        BR["Broadcast Messages"]
        S --> A --> B --> L
        L --> R --> BR
    end

    C1 <--> S
    C2 <--> S
    C3 <--> S
    BR --> C1
    BR --> C2
    BR --> C3
```

---

## 🔄 Message Flow

This diagram shows how a message travels from one client to all connected clients.

```mermaid
flowchart TD
    A["Client types a message"] --> B["Client sends message through TCP socket"]
    B --> C["Server receives message"]
    C --> D["Server broadcasts message to all connected clients"]
    D --> E["Client 1 displays message"]
    D --> F["Client 2 displays message"]
    D --> G["Client 3 displays message"]
```

---

## 🔁 Client-Server Communication Sequence

```mermaid
sequenceDiagram
    participant C1 as Client 1
    participant S as Chat Server
    participant C2 as Client 2

    C1->>S: Connect to port 8080
    S-->>C1: Connection established
    C2->>S: Connect to port 8080
    S-->>C2: Connection established

    C1->>S: Send message
    S->>C1: Broadcast message
    S->>C2: Broadcast message

    C2->>S: Send reply
    S->>C1: Broadcast reply
    S->>C2: Broadcast reply
```

---

## ⚙️ How It Works

1. The server starts and listens on port `8080`.
2. Clients connect to the server using TCP sockets.
3. The server creates a separate thread for each connected client.
4. Each client's output stream is stored in a shared list.
5. When a client sends a message, the server broadcasts it to all connected clients.
6. Clients display the received messages in their chat windows.

---

## 📂 Project Structure

```text
java-lan-chat/
│
├── src/
│   ├── ChatServer.java
│   └── ChatWindow.java
│
├── run.bat
└── README.md
```

---

## ▶️ How to Run

### Requirements

* Java Development Kit (JDK) installed.
* Two or more client instances for multi-client testing.
* A local network connection for LAN communication between different computers.

### 1. Clone the repository

```bash
git clone https://github.com/parekhkrish/java-lan-chat.git
```

### 2. Open the project folder

```bash
cd java-lan-chat
```

### 3. Start the server

Run `ChatServer.java` first.

The server listens on port `8080`.

### 4. Start the client

Run `ChatWindow.java` to open the chat interface.

For clients on another computer, replace `localhost` in the client connection code with the server computer's local IP address.

### 5. Start chatting

Connect multiple clients and exchange messages in real time.

---

## 🔮 Future Improvements

* User join and leave notifications
* Online users list
* Message timestamps
* Improved graphical interface
* Username validation
* Better error handling and connection management
* Room-code-based connections

---

## 👨‍💻 Author

**Krish Parekh**

B.Tech Information Technology Student

[GitHub Profile](https://github.com/parekhkrish)

---

⭐ If you find this project interesting, feel free to explore the repository!
