package TCPServer;

import TCPServer.Commands.Command;
import TCPServer.Commands.Help;

import java.util.ArrayList;

public class CommandOperator {

    private ArrayList<Command> commands;
    private Help help = new Help();

    public CommandOperator() {
        this.commands = new ArrayList<>();
        this.commands.add(help);
        help.addHelp(help.getCommandInfo());
    }

    public boolean addCommand(Command commandToAdd){
        for (Command command : commands) {
            if (command.getCommand().equals(commandToAdd.getCommand()))
                return false;
        }
        commands.add(commandToAdd);
        addHelp(commandToAdd);
        return true;
    }

    public boolean removeCommand(String commandToRemove){
        return commands.removeIf(command -> command.getCommand().equals(commandToRemove));
    }

    public String acceptibleCommands(String commandFromUser) {
        String[] str = commandFromUser.split(" ");
        for (Command command: commands) {
            if (command.getCommand().equals(str[0])){
                if (str.length==1)
                    return command.executeCommand(str[0]);
                else
                    return command.executeCommand(str[1]);
            }
        }
        return "Invalid command: "+ commandFromUser;
    }

    private void addHelp(Command commandToAdd){
        help.addHelp(commandToAdd.getCommandInfo());
    }
}