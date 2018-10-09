package TCPServer.Commands.InfoCommands;

import org.json.simple.JSONObject;

public class City implements InformationCommand {
    @Override
    public String executeCommand(JSONObject jsonObject) {
        System.out.println(String.valueOf(jsonObject.get("city")));
        return String.valueOf(jsonObject.get("city"));
    }

    @Override
    public String getCommand() {
        return "CITY";
    }

    @Override
    public String getCommandInfo() {
        return "INFO CITY, used to get your city\n";
    }
}
