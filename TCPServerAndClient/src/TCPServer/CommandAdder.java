package TCPServer;

import TCPServer.Commands.*;
import TCPServer.Commands.InfoCommands.*;

public class CommandAdder {

    private CommandOperator commandOperator;

    public CommandAdder(CommandOperator commandOperator) {
        this.commandOperator = commandOperator;
    }

    public void addCommands(){
        addMainCommands();
        addInfoCommands();
    }

    private void addMainCommands(){
        commandOperator.addCommand(new Hello());
        commandOperator.addCommand(new Joke());
        commandOperator.addCommand(new Question());
        commandOperator.addCommand(new Quit());
        commandOperator.addCommand(new Screenshot());
        commandOperator.addCommand(new Temp());
        commandOperator.addCommand(new Time());
        commandOperator.addCommand(new Weather());
    }

    private void addInfoCommands(){
        Info info = new Info();
        info.addInfoCommand(new All());
        info.addInfoCommand(new City());
        info.addInfoCommand(new Country());
        info.addInfoCommand(new Ip());
        info.addInfoCommand(new Organization());
        info.addInfoCommand(new Timezone());
        commandOperator.addCommand(info);
    }
}
