package Standard_Calculator_Professional.Java_Ct;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class Help implements Initializable {

    @FXML
    private StackPane help;

    @FXML
    private JFXButton back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        help.setOpacity(0);

        FadeTransition fadeTransition_Of_Help_Fade_In = new FadeTransition(Duration.seconds(2), help);

        fadeTransition_Of_Help_Fade_In.setFromValue(0);
        fadeTransition_Of_Help_Fade_In.setToValue(1);
        fadeTransition_Of_Help_Fade_In.play();
    }

    public void Back() {
        FadeTransition fadeTransition_Of_Help_Fade_Out = new FadeTransition(Duration.seconds(2), help);

        fadeTransition_Of_Help_Fade_Out.setFromValue(1);
        fadeTransition_Of_Help_Fade_Out.setToValue(0);

        fadeTransition_Of_Help_Fade_Out.setOnFinished(event_Of_Fade_Out -> {
            try {
                Stage stage = (Stage) help.getScene().getWindow();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator_Professional/FXML_Files/Standard_Calculator_Professional.fxml")));

                stage.setTitle("Standard Calculator Professional");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Standard_Calculator_Professional");
                error.setContentText("Error loading the file. \nCould not find the file.");
                error.show();
            }
        });

        fadeTransition_Of_Help_Fade_Out.play();
        back.setDisable(true);
    }

    public void KeyBoard_Key_Functioning(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case BACK_SPACE:
                Back();
                break;
        }
    }
}