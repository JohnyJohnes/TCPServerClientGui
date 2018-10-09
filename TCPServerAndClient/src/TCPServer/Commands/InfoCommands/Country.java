package TCPServer.Commands.InfoCommands;

import org.json.simple.JSONObject;

public class Country implements InformationCommand {
    @Override
    public String executeCommand(JSONObject jsonObject) {
        System.out.println(String.valueOf(jsonObject.get("country")));
        return String.valueOf(jsonObject.get("country"));
    }

    @Override
    public String getCommand() {
        return "COUNTRY";
    }

    @Override
    public String getCommandInfo() {
        return "INFO COUNTRY, used to get your country\n";
    }
}
