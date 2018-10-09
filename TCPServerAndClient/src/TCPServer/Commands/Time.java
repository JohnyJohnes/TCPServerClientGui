package TCPServer.Commands;

public class Time implements Command{
    @Override
    public String executeCommand(String line) {
        java.util.Date date = new java.util.Date();
        return "System time is "+date.toString();
    }

    @Override
    public String getCommand() {
        return "TIME";
    }

    @Override
    public String getCommandInfo() {
        return "TIME, Used to return current time in your system\n";
    }
}
