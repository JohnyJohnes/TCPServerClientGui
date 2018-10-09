package TCPServer.Commands;

import TCPServer.ScreenshotMaker;

public class Screenshot implements Command{
    @Override
    public String executeCommand(String line) {
        try {
            ScreenshotMaker.takeAScreenShot(line);
            System.out.println("ScreenshotMaker was made ;)");
            return "ScreenshotMaker was made ;)";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PROBLEM";
    }

    @Override
    public String getCommand() {
        return "SCREENSHOT";
    }

    @Override
    public String getCommandInfo() {
        return "SCREENSHOT, (Example: SCREENSHOT URL) used to print screenshot of website to the \'Screenshots\' directory \n";
    }
}
