package TCPServer.Commands;

import TCPServer.HTTPGet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Joke implements Command{
    @Override
    public String executeCommand(String line) {
        try{
            String jokeApi = HTTPGet.getHTML("https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_joke");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(jokeApi);
            System.out.println(String.valueOf(jsonObject.get("setup")+"\n"+jsonObject.get("punchline")));
            return String.valueOf(jsonObject.get("setup")+"\n"+jsonObject.get("punchline"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Problem";
    }

    @Override
    public String getCommand() {
        return "JOKE";
    }

    @Override
    public String getCommandInfo() {
        return "JOKE, (Example: JOKE) used to get a random joke\n";
    }
}
