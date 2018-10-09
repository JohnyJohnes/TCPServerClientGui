package TCPServer.Commands;

import TCPServer.HTTPGet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Question implements Command{
    @Override
    public String executeCommand(String line) {
        try {
            String yesNoMaybeApi = HTTPGet.getHTML("https://yesno.wtf/api");
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject)parser.parse(yesNoMaybeApi);
            System.out.println(String.valueOf(jsonObject.get("answer")));
            return String.valueOf(jsonObject.get("answer"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "PROBLEM";
    }

    @Override
    public String getCommand() {
        return "QUESTION";
    }

    @Override
    public String getCommandInfo() {
        return "QUESTION, (Example: QUESTION userQuestion) used to return YES/NO/MAYBE\n";
    }
}
