package Standard_Calculator.V_1_1;

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

public class Welcome_Cr implements Initializable {

    @FXML
    private StackPane welcome;

    @FXML
    private Label description;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        First();
    }

    private void First() {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), description);

        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            Last();
        });

        ft.play();
    }

    private void Last() {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), description);

        ft.setFromValue(0);
        ft.setToValue(1);

        ft.setOnFinished(event -> {
            First();
        });

        ft.play();
    }

    public void Load_Calculator() {
        FadeTransition ft = new FadeTransition(Duration.seconds(2), welcome);

        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) welcome.getScene().getWindow();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator/V_1_1/Calculator.fxml")));

                stage.setTitle("Standard Calculator");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (Exception ep) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Standard Calculator - Welcome");
                error.setContentText("Error loading the file. \nCould not find the file");
                error.showAndWait();
            }

        });

        ft.play();
    }

}