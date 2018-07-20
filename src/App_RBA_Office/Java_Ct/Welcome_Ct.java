package App_RBA_Office.Java_Ct;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Welcome_Ct implements Initializable {

    @FXML
    private StackPane welcome;

    public static void main(String[] args) {

    }

    @FXML
    private Label description;

    private String[] types_of_animation_at_start = {"TSR", "T"};
    private Random random = new Random();

    private boolean clicked = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int random_value = random.nextInt(2);
        String random_main_value = types_of_animation_at_start[random_value];

        if (random_main_value.equals("TSR")) {
            Load_Inner_Part_TSR();
        } else if (random_main_value.equals("T")) {
            description.setLayoutY(190);
            description.setFont(new Font(18));
            Load_Inner_Part_T();
        }
    }

    private void Load_Inner_Part_T() {
        TranslateTransition tt_in = new TranslateTransition(Duration.seconds(1), description);
        tt_in.setToX(-158);

        tt_in.setOnFinished(event -> {
            Load_Outer_Part_T();
        });

        tt_in.play();
    }

    private void Load_Outer_Part_T() {
        TranslateTransition tt_in = new TranslateTransition(Duration.seconds(1), description);
        tt_in.setToX(150);

        tt_in.setOnFinished(event -> {
            Load_Inner_Part_T();
        });

        tt_in.play();
    }

    private void Load_Inner_Part_TSR() {
        TranslateTransition tt_in = new TranslateTransition(Duration.seconds(1), description);
        tt_in.setToY(-220);

        ScaleTransition st_in = new ScaleTransition(Duration.seconds(1), description);
        st_in.setToX(1.6);
        st_in.setToY(1.6);

        RotateTransition rt_in = new RotateTransition(Duration.seconds(1), description);
        rt_in.setToAngle(365);

        rt_in.setOnFinished(event -> Load_Outer_Part_TSR());

        tt_in.play();
        st_in.play();
        rt_in.play();
    }

    private void Load_Outer_Part_TSR() {
        TranslateTransition tt_out = new TranslateTransition(Duration.seconds(1), description);
        tt_out.setToY(20);

        ScaleTransition st_out = new ScaleTransition(Duration.seconds(1), description);
        st_out.setToX(0.6);
        st_out.setToY(0.6);

        RotateTransition rt_out = new RotateTransition(Duration.seconds(1), description);
        rt_out.setToAngle(-10);

        rt_out.setOnFinished(event -> Load_Inner_Part_TSR());

        tt_out.play();
        st_out.play();
        rt_out.play();
    }

    public void Load_RBA_Office() {
        if (!clicked) {
            FadeTransition ft_first = new FadeTransition(Duration.seconds(2), description);
            ft_first.setToValue(1);
            ft_first.setToValue(0);

            ft_first.setOnFinished(event_first -> {
                FadeTransition ft_next = new FadeTransition(Duration.seconds(2), welcome);
                ft_next.setFromValue(1);
                ft_next.setToValue(0);

                ft_next.setOnFinished(event_next -> {
                    try {
                        Stage stage = (Stage) welcome.getScene().getWindow();
                        Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/App_RBA_Office/FXML_Files/Rahul_Baradols_Application_Office.fxml")));

                        stage.setTitle("Rahul Baradol's Application Office");
                        stage.setScene(sc);
                        stage.setResizable(false);
                        stage.show();
                    } catch (Exception ep) {
                        Alert error = new Alert(Alert.AlertType.ERROR);

                        error.setTitle("RBA Office");
                        error.setContentText("Error loading the file. \nCould not find the file.");
                        error.show();
                    }
                });

                ft_next.play();
            });

            ft_first.play();
            clicked = true;
        } else {
            // Nothing happens here
        }
    }

}