package Age_Calculator.Java_Cts;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
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

    public void back() {
        back.setDisable(true);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), about);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) about.getScene().getWindow();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Age_Calculator/FXML_Files/Age_Calculator.fxml")));

                stage.setTitle("Age Calculator");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Age Calculator - About");
                error.setContentText("Error loading the file. \nCould not find the file.");
                error.show();
            }
        });

        ft.play();
    }

}