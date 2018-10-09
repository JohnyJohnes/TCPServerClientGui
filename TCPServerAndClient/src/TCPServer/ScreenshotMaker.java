package TCPServer;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ScreenshotMaker {

    public static void takeAScreenShot(String websiteURL) throws Exception {

        String accessKey = "4fe31380e4684cdba2662fc9822d20c3";
        String apiUrl = "https://apileap.com/api/screenshot/v1/urltoimage";
        URL url = new URL(String.format("%s?access_key=%s&url="+websiteURL, apiUrl, accessKey));
        InputStream inputStream = url.openStream();
        OutputStream outputStream = new FileOutputStream("/Users/arseniybelyakov/Documents/Java project/TCPServerAndClient/Screenshots/screenshot.jpeg");

        byte[] b = new byte[2048];
        int length;

        while ((length = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, length);
        }

        inputStream.close();
        outputStream.close();
    }
}