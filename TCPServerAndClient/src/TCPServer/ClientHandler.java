package TCPServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket client;
    private CommandOperator commands;

    public ClientHandler(Socket client, CommandOperator commands) {
        this.client = client;
        this.commands = commands;
    }

    @Override
    public void run() {
        String clientSentence = "";

        try (BufferedReader inFromClient =
                     new BufferedReader(new InputStreamReader(client.getInputStream()));
             DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());
        ){


            System.out.printf("before while: " + clientSentence);
            while (!clientSentence.equals("QUIT")) {
                String temp = inFromClient.readLine();
                System.out.printf("in while: " + temp);
                if (temp != null) {
                    clientSentence = temp.toUpperCase();
                    System.out.println("Received: " + clientSentence);
                    String output = commands.acceptibleCommands(clientSentence).replaceAll("\n", "qwer");
                    outToClient.writeBytes(output + '\n');
                }
                else {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            inFromClient.close();
            outToClient.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Socket getClient() {
        return client;
    }
}
