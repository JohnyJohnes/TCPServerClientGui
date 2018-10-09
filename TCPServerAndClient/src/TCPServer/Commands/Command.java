package TCPServer.Commands;

public interface Command {
    public String executeCommand (String line);
    public String getCommand();
    public String getCommandInfo();
}
