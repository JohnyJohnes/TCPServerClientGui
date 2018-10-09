package TCPServer.Commands.InfoCommands;

import org.json.simple.JSONObject;

public class Timezone implements InformationCommand {
    @Override
    public String executeCommand(JSONObject jsonObject) {
        System.out.println(String.valueOf(jsonObject.get("timezone")));
        return String.valueOf(jsonObject.get("timezone"));
    }

    @Override
    public String getCommand() {
        return "TIMEZONE";
    }

    @Override
    public String getCommandInfo() {
        return "INFO TIMEZONE, used to get your timezone\n";
    }
}
