package Age_Calculator.Java_Cts;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome_Ct implements Initializable {

    @FXML
    private StackPane welcome;

    @FXML
    private Label description;

    private boolean clicked = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Transition_In();
    }

    private void Transition_In() {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), description);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> Transition_Out());

        ft.play();
    }

    private void Transition_Out() {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), description);
        ft.setFromValue(0);
        ft.setToValue(1);

        ft.setOnFinished(event -> Transition_In());

        ft.play();
    }

    public void Load_Age_Calculator() {
        if(!clicked) {
            FadeTransition ft = new FadeTransition(Duration.seconds(2), welcome);
            ft.setFromValue(1);
            ft.setToValue(0);

            ft.setOnFinished(event -> {
                try {
                    Stage stage = (Stage) welcome.getScene().getWindow();
                    Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Age_Calculator/FXML_Files/Age_Calculator.fxml")));

                    stage.setTitle("Age Calculator");
                    stage.setScene(sc);
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception ep) {
                    Alert error = new Alert(Alert.AlertType.ERROR);

                    error.setTitle("Age Calculator");
                    error.setContentText("Error loading the file. \nCould not find the file.");
                    error.show();
                }
            });

            ft.play();

            clicked = true;
        } else if(clicked) {
            // Nothing happens here
        }
    }

}