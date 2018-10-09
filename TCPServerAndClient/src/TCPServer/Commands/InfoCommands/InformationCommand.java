package TCPServer.Commands.InfoCommands;

import org.json.simple.JSONObject;

public interface InformationCommand {
    String executeCommand(JSONObject jsonObject);
    String getCommand();
    String getCommandInfo();
}
