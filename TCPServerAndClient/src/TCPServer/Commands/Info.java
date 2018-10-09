package TCPServer.Commands;

import TCPServer.Commands.InfoCommands.InformationCommand;
import TCPServer.HTTPGet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class Info implements Command{

    private ArrayList<InformationCommand> infoCommands;

    public Info() {
        this.infoCommands = new ArrayList<>();
    }

    public boolean addInfoCommand(InformationCommand commandToAdd){
        for (InformationCommand infoCommand: infoCommands) {
            if (infoCommand.getCommand().equals(commandToAdd.getCommand()))
                return false;
        }
        infoCommands.add(commandToAdd);
        return true;
    }

    public boolean removeInfoCommand(String commandToRemove){
        return infoCommands.removeIf(iC -> iC.getCommand().equals(commandToRemove));
    }

    @Override
    public String executeCommand(String line) {
        try {
            String getIpApi = HTTPGet.getHTML("http://ip-api.com/json");
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(getIpApi);
        for (InformationCommand infoCommand : infoCommands) {
            if (infoCommand.getCommand().equals(line))
                return infoCommand.executeCommand(jsonObject);
        }
        return "Command \'INFO "+line+"\' is not supported";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Problem";
    }

    @Override
    public String getCommand() {
        return "INFO";
    }

    @Override
    public String getCommandInfo() {
        String output="";
        for (InformationCommand command:infoCommands) {
            output+=command.getCommandInfo();
        }
        return output;
    }
}
