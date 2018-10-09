package TCPServer.Commands.InfoCommands;

import org.json.simple.JSONObject;

public class Ip implements InformationCommand {
    @Override
    public String executeCommand(JSONObject jsonObject) {
        System.out.println(String.valueOf(jsonObject.get("query")));
        return String.valueOf(jsonObject.get("query"));
    }

    @Override
    public String getCommand() {
        return "IP";
    }

    @Override
    public String getCommandInfo() {
        return "INFO IP, returns your IP\n";
    }
}
