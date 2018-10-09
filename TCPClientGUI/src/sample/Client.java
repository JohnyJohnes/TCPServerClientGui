package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.CommandSender;

public class Client extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = (Controller)loader.getController();




        controller.setCommandSender(new CommandSender());

        primaryStage.setTitle("TCPCLIENT");

        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();


    }

}
