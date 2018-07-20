package Table_Detector.V_1.Java_Cts;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome_Ct implements Initializable {

    @FXML
    private StackPane welcome;

    @FXML
    private Label description;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        description.setOpacity(0);
        Fade_Transition_First();
    }

    public void Fade_Transition_First() {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), description);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setOnFinished((event) -> {
            Fade_Transition_Second();
        });

        ft.play();
    }

    public void Fade_Transition_Second() {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), description);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setOnFinished((event) -> {
            Fade_Transition_First();
        });

        ft.play();
    }

    public void Load_Table_Detector() {
        FadeTransition ft = new FadeTransition(Duration.seconds(2), welcome);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();

        ft.setOnFinished((event) -> {
            try {
                Stage stage = (Stage) welcome.getScene().getWindow();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Table_Detector/V_1/FXML_Files/Table_Detector.fxml")));

                stage.setTitle("Table Detector");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Table Detector");
                error.setContentText("Error loading the file. \nCould not find the file.");
                error.show();
            }
        });
    }

}