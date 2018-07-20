package Age_Calculator.Java_Cts;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Age_Calculator_Ct implements Initializable {

    @FXML
    private StackPane main;

    @FXML
    private JFXButton calculate;

    @FXML
    private JFXButton help;

    @FXML
    private JFXButton reset;

    @FXML
    private JFXButton exit;

    @FXML
    private JFXTextField from;

    @FXML
    private JFXTextField current;

    @FXML
    private Label description;

    @FXML
    private Label answer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main.setOpacity(0);
        description.setOpacity(0);
        from.setOpacity(0);
        current.setOpacity(0);
        calculate.setOpacity(0);
        reset.setOpacity(0);
        help.setOpacity(0);
        exit.setOpacity(0);
        answer.setOpacity(0);

        FadeTransition ft_Main = new FadeTransition(Duration.seconds(1), main);
        ft_Main.setFromValue(0);
        ft_Main.setToValue(1);

        ft_Main.setOnFinished(event_Main -> {
            FadeTransition ft_description = new FadeTransition(Duration.seconds(1), description);
            ft_description.setFromValue(0);
            ft_description.setToValue(1);

            ft_description.setOnFinished(event_description -> {
                FadeTransition ft_calculate = new FadeTransition(Duration.seconds(1), calculate);
                ft_calculate.setFromValue(0);
                ft_calculate.setToValue(1);

                FadeTransition ft_reset = new FadeTransition(Duration.seconds(1), reset);
                ft_reset.setFromValue(0);
                ft_reset.setToValue(1);

                FadeTransition ft_help = new FadeTransition(Duration.seconds(1), help);
                ft_help.setFromValue(0);
                ft_help.setToValue(1);

                FadeTransition ft_exit = new FadeTransition(Duration.seconds(1), exit);
                ft_exit.setFromValue(0);
                ft_exit.setToValue(1);

                ft_exit.setOnFinished(event_Exit -> {
                    FadeTransition ft_from = new FadeTransition(Duration.seconds(1), from);
                    ft_from.setFromValue(0);
                    ft_from.setToValue(1);

                    FadeTransition ft_current = new FadeTransition(Duration.seconds(1), current);
                    ft_current.setFromValue(0);
                    ft_current.setToValue(1);

                    FadeTransition ft_answer = new FadeTransition(Duration.seconds(1), answer);
                    ft_answer.setFromValue(0);
                    ft_answer.setToValue(1);

                    ft_from.play();
                    ft_current.play();
                    ft_answer.play();
                });

                ft_calculate.play();
                ft_reset.play();
                ft_help.play();
                ft_exit.play();
            });

            ft_description.play();
        });

        ft_Main.play();
    }

    public void Calculate() {
        try {
            int from_value = Integer.parseInt(from.getText());
            int current_value = Integer.parseInt(current.getText());

            if(from_value <= current_value) {
                int answer_value = current_value - from_value;
                answer.setText("Your Age is " + Integer.toString(answer_value));
            } else if(from_value > current_value) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Age Calculator");
                error.setContentText("Invalid Answer(Year)");
                error.showAndWait();

                from.setText("");
                current.setText("");
            }
        } catch (Exception ep) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Age Calculator");
            error.setContentText("Type a valid year.");
            error.showAndWait();

            from.setText("");
            current.setText("");
        }
    }

    public void Reset() {
        from.setText("");
        current.setText("");
        answer.setText("");
    }

    public void Exit() {
        Alert exit = new Alert(Alert.AlertType.CONFIRMATION);

        exit.setTitle("Age Calculator");
        exit.setHeaderText("Exit?");
        exit.setContentText("Are you sure, you want to exit?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        exit.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> op = exit.showAndWait();

        if(op.get() == yes) exit(0);
    }

    public void Help() {
        help.setDisable(true);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), main);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) main.getScene().getWindow();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Age_Calculator/FXML_Files/About.fxml")));

                stage.setTitle("Age Calculator - About");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Age Calculator");
                error.setContentText("Error loading the file. \nCould not find the file.");
                error.show();
            }
        });

        ft.play();
    }

}