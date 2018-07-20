package Standard_Calculator_Professional.Java_Ct;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome implements Initializable {

    @FXML
    private StackPane welcome;

    @FXML
    private Label description;

    private boolean clicked = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcome.setOpacity(0);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), welcome);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        Load_First_Part_Of_Transition();
    }

    private void Load_First_Part_Of_Transition() {
        TranslateTransition translateTransition_of_description = new TranslateTransition(Duration.seconds(1), description);
        translateTransition_of_description.setToY(-260);

        ScaleTransition scaleTransition_of_description = new ScaleTransition(Duration.seconds(1), description);
        scaleTransition_of_description.setToX(1.5);
        scaleTransition_of_description.setToY(1.5);

        scaleTransition_of_description.setOnFinished(event_scaleTransition_Of_description -> {
            Load_Second_Part_Of_Transition();
        });

        translateTransition_of_description.play();
        scaleTransition_of_description.play();
    }

    private void Load_Second_Part_Of_Transition() {
        TranslateTransition translateTransition_of_description = new TranslateTransition(Duration.seconds(1), description);
        translateTransition_of_description.setToY(24);

        ScaleTransition scaleTransition_of_description = new ScaleTransition(Duration.seconds(1), description);
        scaleTransition_of_description.setToX(.5);
        scaleTransition_of_description.setToY(.5);

        scaleTransition_of_description.setOnFinished(event_scaleTransition_Of_description -> {
            Load_First_Part_Of_Transition();
        });

        translateTransition_of_description.play();
        scaleTransition_of_description.play();
    }

    public void Load_Standard_Calculator_Professional_Temporary_Login(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.PRIMARY && !clicked) {
            FadeTransition fadeTransition_of_Description = new FadeTransition(Duration.seconds(2), description);

            fadeTransition_of_Description.setFromValue(1);
            fadeTransition_of_Description.setToValue(0);

            fadeTransition_of_Description.setOnFinished(event_Of_Description -> {
                FadeTransition fadeTransition_Log_Out_Welcome_Screen = new FadeTransition(Duration.seconds(2), welcome);

                fadeTransition_Log_Out_Welcome_Screen.setFromValue(1);
                fadeTransition_Log_Out_Welcome_Screen.setToValue(0);

                fadeTransition_Log_Out_Welcome_Screen.setOnFinished(event_Log_Out_Welcome_Screen -> {
                    try {
                        Stage stage = (Stage) welcome.getScene().getWindow();
                        Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator_Professional/FXML_Files/Standard_Calculator_Professional.fxml")));

                        stage.setTitle("Standard Calculator Professional");
                        stage.setScene(sc);
                        stage.setResizable(false);
                        stage.show();
                    } catch (IOException e) {
                        Alert error = new Alert(Alert.AlertType.ERROR);

                        error.setTitle("Standard Calculator Professional");
                        error.setContentText("Error loading the file. \nCould not find the file.");
                        error.show();
                    }
                });

                fadeTransition_Log_Out_Welcome_Screen.play();
            });

            fadeTransition_of_Description.play();
            clicked = true;
        } else if(clicked) {
            // Nothing happens here
        }
    }

}