package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.model.CommandSender;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="SendRequestButton"
    private Button SendRequestButton; // Value injected by FXMLLoader

    @FXML // fx:id="ChoiceBoxForCommands"
    private ChoiceBox<String> ChoiceBoxForCommands; // Value injected by FXMLLoader

    @FXML // fx:id="ExtraTextField"
    private TextField ExtraTextField; // Value injected by FXMLLoader

    @FXML // fx:id="outputTextField"
    private TextArea outputTextField; // Value injected by FXMLLoader

    private String commandToReturn = "";

    private String commandToPrint;

    private CommandSender commandSender = new CommandSender();

    public void setCommandSender(CommandSender commandSender){
        this.commandSender = commandSender;
        ChoiceBoxForCommands.getItems().addAll(commandSender.getCommands());
    }

    public String getCommandToPrint() {
        return commandToPrint;
    }

    public void setCommandToPrint(String commandToPrint) {
        this.commandToPrint = commandToPrint;

    }

    public String getCommandToReturn() {
        return commandToReturn;
    }

    public void setCommandToReturn(String command){
        commandToReturn = command;
    }

    public void addCommandToChoiceBox(String command){
        ChoiceBoxForCommands.getItems().add(command);
    }

    // This method is called by the FXMLLoader when initialization is complete
    @FXML
    void initialize(){

        SendRequestButton.setOnAction(event -> {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                    String command;
                    String output = commandSender.sendRequest(command = ChoiceBoxForCommands.getValue() +" "+ ExtraTextField.getText().trim());
                    setCommandToReturn(command);
                        Platform.runLater(() ->{
                    outputTextField.setText(output);
                    ExtraTextField.setText("");});
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        });
    }


}
