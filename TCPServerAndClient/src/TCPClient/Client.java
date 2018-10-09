package TCPClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

class Client {
    public static void main(String argv[]) throws Exception {
        String sentence="";
        Socket clientSocket = new Socket("localhost", 1337);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        Scanner inFromUser = new Scanner(System.in);
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while (!(sentence.toUpperCase().equals("QUIT"))) {
            if(!sentence.equals("")){
                System.out.println();
                sentence = inFromUser.nextLine();}
            else sentence = "HELP";
            outToServer.writeBytes(sentence + '\n');
            System.out.println("FROM SERVER: ");
            String[] answer = inFromServer.readLine().split("qwer");
            for (String str:answer) {
                System.out.println(str);
            }

        }
        clientSocket.close();
        inFromUser.close();
        outToServer.close();
        inFromServer.close();
    }
}