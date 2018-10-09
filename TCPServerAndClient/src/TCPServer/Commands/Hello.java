package TCPServer.Commands;

public class Hello implements Command{
    @Override
    public String executeCommand(String line) {
        return line + ", Sir!";
    }

    @Override
    public String getCommand() {
        return "HELLO";
    }

    @Override
    public String getCommandInfo() {
        return "HELLO, Will answer \'HELLO\'\n";
    }
}
