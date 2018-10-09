package TCPServer.Commands;

import TCPServer.HTTPGet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Temp implements Command{
    @Override
    public String executeCommand(String line) {
        try {
            String jsonLine = HTTPGet.getHTML("http://api.openweathermap.org/data/2.5/forecast?q="+line+"&APPID=3b41be9d5d4de30a43ad217b61d698ad");
            JSONParser parser = new JSONParser();
            JSONObject jsob = (JSONObject)parser.parse(jsonLine);
            JSONArray list = (JSONArray)jsob.get("list");
            Object main = ((JSONObject) list.get(0)).get("main");
            double temp = (double)((JSONObject) main).get("temp");
            System.out.println("\n"+(temp-273.15)+"\n");

            return "Temperature in " + line.toUpperCase() +" is: " + String.valueOf(temp-273.15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Problem";
    }

    @Override
    public String getCommand() {
        return "TEMP";
    }

    @Override
    public String getCommandInfo() {
        return "TEMP, (Example: TEMP city) used to get temperature in asked city\n";
    }
}
