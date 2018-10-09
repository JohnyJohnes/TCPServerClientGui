package TCPServer.Commands;

public class GetCommands implements Command{
    @Override
    public String executeCommand(String line) {
        return "HELP:TIME";
    }

    @Override
    public String getCommand() {
        return "GETCOMMANDS";
    }

    @Override
    public String getCommandInfo() {
        return null;
    }
}
