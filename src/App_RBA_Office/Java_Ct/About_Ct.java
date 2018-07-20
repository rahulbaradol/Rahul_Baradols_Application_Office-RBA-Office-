package App_RBA_Office.Java_Ct;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class About_Ct implements Initializable {

    @FXML
    private StackPane about;

    @FXML
    private JFXButton back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        about.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), about);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    public void Whats_New() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/App_RBA_Office/FXML_Files/Whats_New.fxml")));

            stage.setTitle("RBA Office - What's New");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (Exception ep) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("RBA Office");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Information_Accessing_Mode() {
        Random random = new Random();
        String[] letters = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o",
                "P", "p", "Q", "r", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};

        String random_letters = letters[random.nextInt(52)] + letters[random.nextInt(52)] + letters[random.nextInt(52)] +
                letters[random.nextInt(52)] + letters[random.nextInt(52)] + letters[random.nextInt(52)];

        TextInputDialog tid = new TextInputDialog();
        tid.setTitle("RBA Office - IA Mode - Confirmation");
        tid.setContentText("Enter this code to login to IA(Information Accessing) Mode: " + random_letters);

        Optional<String> op_string = tid.showAndWait();

        try {
            if (op_string.get().equals(random_letters)) {
                try {
                    Stage stage = new Stage();
                    Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/App_RBA_Office/IA_Mode/IA_Mode.fxml")));

                    stage.setTitle("RBA Office - IA Mode");
                    stage.setScene(sc);
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception ep) {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("RBA Office");
                    error.setContentText("Error loading the file. \nCould not find the file.");
                    error.showAndWait();
                }
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("RBA Office - IA Mode - Confirmation");
                error.setHeaderText("Confirmation Failed");
                error.setContentText("Wrong code");
                error.showAndWait();
            }
        } catch (RuntimeException re) {}
    }

    public void Back() {
        back.setDisable(true);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), about);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) about.getScene().getWindow();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/App_RBA_Office/FXML_Files/Rahul_Baradols_Application_Office.fxml")));

                stage.setTitle("RBA Office");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (Exception ep) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("RBA Office");
                error.setContentText("Error loading the file. \nCould not find the file");
                error.showAndWait();
            }
        });

        ft.play();
    }

}