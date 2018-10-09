package TCPServer.Commands.InfoCommands;

import org.json.simple.JSONObject;

public class Organization implements InformationCommand {
    @Override
    public String executeCommand(JSONObject jsonObject) {
        System.out.println(String.valueOf(jsonObject.get("org")));
        return String.valueOf(jsonObject.get("org"));
    }

    @Override
    public String getCommand() {
        return "ORGANIZATION";
    }

    @Override
    public String getCommandInfo() {
        return "INFO ORGANIZATION, uses to get your organization\n";
    }
}
