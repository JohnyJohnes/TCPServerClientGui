package TCPServer.Commands;

import TCPServer.HTTPGet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Weather implements Command{
    @Override
    public String executeCommand(String line) {
        try {
            String jsonLine = HTTPGet.getHTML("http://api.openweathermap.org/data/2.5/forecast?q="+line+"&APPID=3b41be9d5d4de30a43ad217b61d698ad");
            JSONParser parser = new JSONParser();
            JSONObject jsob = (JSONObject)parser.parse(jsonLine);
            System.out.println(String.valueOf(((JSONObject)((JSONArray)((JSONObject)((JSONArray)(jsob.get("list"))).get(0)).get("weather")).get(0)).get("description")));
            return "Weather in "+line.toUpperCase()+" is "+String.valueOf(((JSONObject)((JSONArray)((JSONObject)((JSONArray)(jsob.get("list"))).get(0)).get("weather")).get(0)).get("description"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Problem";
    }

    @Override
    public String getCommand() {
        return "WEATHER";
    }

    @Override
    public String getCommandInfo() {
        return "WEATHER, (Example: Weather city) used to get weather in asked city\n";
    }
}
