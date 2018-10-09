package TCPServer.Commands;


public class Help implements Command{
    private String commandsInfo="";

    public void addHelp(String commandInfo){
        commandsInfo+=commandInfo;
    }

    @Override
    public String executeCommand(String line) {
        return commandsInfo;
    }

    @Override
    public String getCommand() {
        return "HELP";
    }

    @Override
    public String getCommandInfo() {
        return "HELP,(Example HELP) used to get info for the key words!\n";
    }
}
