package Table_Detector.V_2.Java_Cts;

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
    private StackPane help;

    @FXML
    private JFXButton whats_new;

    @FXML
    private JFXButton back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        help.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), help);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();

        whats_new.setOnMouseClicked(event -> {
            try {
                Stage stage = new Stage();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Table_Detector/V_2/FXML_Files/Whats_New.fxml")));

                stage.setTitle("Table Detector - What's New");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (Exception ep) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Table Detector - About");
                error.setContentText("Error loading the file. \nCould not find the file.");
                error.showAndWait();
            }
        });

        back.setOnMouseClicked(event -> {
            FadeTransition ft_back = new FadeTransition(Duration.seconds(2), help);
            ft_back.setFromValue(1);
            ft_back.setToValue(0);

            ft_back.setOnFinished(event2 -> {
                try {
                    Stage stage = (Stage) help.getScene().getWindow();
                    Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Table_Detector/V_2/FXML_Files/Table_Detector.fxml")));

                    stage.setTitle("Table Detector");
                    stage.setScene(sc);
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException e) {
                    Alert error = new Alert(Alert.AlertType.ERROR);

                    error.setTitle("Table Detector");
                    error.setContentText("Error loading the file. \nCould not find the file.");
                    error.showAndWait();
                }
            });

            ft_back.play();

            back.setDisable(true);
        });
    }

}