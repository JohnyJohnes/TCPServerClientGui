package TCPServer.Commands;

public class Quit implements Command{
    @Override
    public String executeCommand(String line) {
        return "GOOD BYE";
    }

    @Override
    public String getCommand() {
        return "QUIT";
    }

    @Override
    public String getCommandInfo() {
        return "QUIT, (Example QUIT) used to leave the server\n";
    }
}
