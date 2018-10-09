package sample.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CommandSender {

    private Socket clientSocket;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;

    public CommandSender() {
        try {
            this.clientSocket = new Socket("localhost", 1337);
            this.outToServer = new DataOutputStream(clientSocket.getOutputStream());
            this.inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendRequest(String command){
        try {
            outToServer.writeBytes(command + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FROM SERVER: ");
        String output = "";
        String[] answer = new String[0];
        try {
            answer = inFromServer.readLine().split("qwer");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String str : answer) {
            System.out.println(str);
            output += str + "\n";
        }

        if (output.trim().equals("GOOD BYE")){
            socketClose();
            System.exit(0);
        }

        return output;
    }

    public void socketClose(){
        try {
            clientSocket.close();
            outToServer.close();
            inFromServer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<String> getCommands(){
        List<String> result = new ArrayList<>();
        result.add("HELLO");
        result.add("HELP");
        result.add("INFO ALL");
        result.add("INFO CITY");
        result.add("INFO COUNTRY");
        result.add("INFO IP");
        result.add("INFO ORGANIZATION");
        result.add("INFO TIMEZONE");
        result.add("JOKE");
        result.add("QUESTION");
        result.add("SCREENSHOT");
        result.add("TEMP");
        result.add("TIME");
        result.add("WEATHER");
        result.add("QUIT");
        return result;
    }
}
