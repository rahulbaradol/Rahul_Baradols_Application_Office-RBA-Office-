package App_RBA_Office;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Rahul_Baradols_Application_Office_MC extends Application {

    @Override
    public void start(Stage ps) {
        try {
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/App_RBA_Office/FXML_Files/Welcome.fxml")));

            ps.setTitle("RBA Office - Welcome");
            ps.setScene(sc);
            ps.setResizable(false);
            ps.show();
        } catch (Exception ep) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("RBA Office");
            error.setContentText("Error loading the file. \nCould not find the file");
            error.showAndWait();
        }
    }

    @Override
    public void stop() {
        Alert exit = new Alert(Alert.AlertType.INFORMATION);

        exit.setTitle("RBA Office");
        exit.setHeaderText("Talk");
        exit.setContentText("THANKS for using RBA(Rahul Baradol's Application) Office. \nHave a nice day. See you soon.");
        exit.showAndWait();
    }

}