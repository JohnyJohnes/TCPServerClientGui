package TCPServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Server {
    public static void main(String argv[]) {
        ServerSocket welcomeSocket;
        try {
            welcomeSocket = new ServerSocket(1337);

            ExecutorService exec = Executors.newCachedThreadPool();

            CommandOperator commands = new CommandOperator();
            CommandAdder commandAdder = new CommandAdder(commands);
            commandAdder.addCommands();

            while (true) {

                ClientHandler clientHandler = new ClientHandler(welcomeSocket.accept(), commands);

                exec.submit(new Thread(clientHandler));

            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}