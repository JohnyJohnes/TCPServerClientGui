package TCPServer.Commands.InfoCommands;

import org.json.simple.JSONObject;

public class All implements InformationCommand {
    @Override
    public String executeCommand(JSONObject jsonObject) {
        java.util.Date date = new java.util.Date();
        System.out.println(String.valueOf(jsonObject.get("query")));
        return String.valueOf(jsonObject.get("query"))+ "\n"+
                String.valueOf(jsonObject.get("country"))+"\n"+
                String.valueOf(jsonObject.get("city"))+"\n"+
                String.valueOf(jsonObject.get("timezone"))+"\t"+date.toString()+"\n"+
                String.valueOf(jsonObject.get("org"));
    }

    @Override
    public String getCommand() {
        return "ALL";
    }

    @Override
    public String getCommandInfo() {
        return "INFO ALL, used to get all information provided by \'INFO\'\n";
    }
}
