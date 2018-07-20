package Table_Detector.V_1.Java_Cts;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Table_Detector_Ct implements Initializable {

    @FXML
    private StackPane main;

    @FXML
    private Label mainHeading;

    @FXML
    private JFXTextField value;

    @FXML
    private JFXTextArea answer;

    @FXML
    private JFXButton showTable;

    @FXML
    private JFXButton reset;

    @FXML
    private JFXButton help;

    @FXML
    private JFXButton exit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main.setOpacity(0);
        mainHeading.setOpacity(0);
        value.setOpacity(0);
        showTable.setOpacity(0);
        reset.setOpacity(0);
        help.setOpacity(0);
        exit.setOpacity(0);

        FadeTransition ft_main = new FadeTransition(Duration.seconds(1), main);
        FadeTransition ft_mainHeading = new FadeTransition(Duration.seconds(1), mainHeading);
        FadeTransition ft_value = new FadeTransition(Duration.seconds(1), value);
        FadeTransition ft_showTable = new FadeTransition(Duration.seconds(1), showTable);
        FadeTransition ft_reset = new FadeTransition(Duration.seconds(1), reset);
        FadeTransition ft_help = new FadeTransition(Duration.seconds(1), help);
        FadeTransition ft_exit = new FadeTransition(Duration.seconds(1), exit);

        ft_main.setFromValue(0);
        ft_main.setToValue(1);

        ft_main.setOnFinished(event -> {
            ft_mainHeading.setFromValue(0);
            ft_mainHeading.setToValue(1);

            ft_mainHeading.setOnFinished(event3 -> {
                ft_showTable.setFromValue(0);
                ft_showTable.setToValue(1);
                ft_showTable.play();

                ft_reset.setFromValue(0);
                ft_reset.setToValue(1);
                ft_reset.play();

                ft_help.setFromValue(0);
                ft_help.setToValue(1);
                ft_help.play();

                ft_exit.setFromValue(0);
                ft_exit.setToValue(1);

                ft_exit.setOnFinished(event4 -> {
                    ft_value.setFromValue(0);
                    ft_value.setToValue(1);
                    ft_value.play();
                });

                ft_exit.play();
            });

            ft_mainHeading.play();
        });

        ft_main.play();

        showTable.setOnMouseClicked(event -> {
            try {
                int number_to_be_multiplied_by = 1;
                double value_entered = Double.parseDouble(value.getText());

                answer.setVisible(true);

                while (number_to_be_multiplied_by <= 1000) {
                    double answer_obtained = value_entered * number_to_be_multiplied_by;
                    answer.setText(answer.getText() + Double.toString(answer_obtained) + "\n");

                    if (number_to_be_multiplied_by == 1000) break;

                    number_to_be_multiplied_by++;
                }
            } catch (Exception ep) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Table Detector");
                error.setContentText("Type a valid number. \n'" + value.getText() + "' is not a valid number");
                error.showAndWait();

                value.setText("");

                answer.setText("");
                answer.setVisible(false);
            }
        });

        reset.setOnMouseClicked(event -> {
            value.setText("");

            answer.setText("");
            answer.setVisible(false);
        });

        help.setOnMouseClicked(event -> {
            help.setDisable(true);

            FadeTransition ft = new FadeTransition(Duration.seconds(2), main);
            ft.setFromValue(1);
            ft.setToValue(0);

            ft.setOnFinished(event2 -> {
                try {
                    Stage stage = (Stage) main.getScene().getWindow();
                    Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Table_Detector/V_1/FXML_Files/About.fxml")));

                    stage.setTitle("Table Detector - About");
                    stage.setScene(sc);
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception ep) {
                    Alert error = new Alert(Alert.AlertType.ERROR);

                    error.setTitle("Table Detector");
                    error.setContentText("Error loading the file. \nCould not find the file.");
                    error.showAndWait();
                }
            });

            ft.play();
        });

        exit.setOnMouseClicked((MouseEvent event) -> {
            Alert exit = new Alert(Alert.AlertType.ERROR);

            exit.setTitle("Table Detector");
            exit.setHeaderText("Exit?");
            exit.setContentText("Are you sure, you want to exit?");

            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");

            exit.getButtonTypes().setAll(yes, no);

            Optional<ButtonType> op = exit.showAndWait();

            if(op.get() == yes) {
                System.exit(0);
            }
        });
    }

}