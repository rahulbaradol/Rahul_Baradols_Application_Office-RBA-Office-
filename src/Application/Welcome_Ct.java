package Application;

import com.jfoenix.controls.JFXTextArea;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome_Ct implements Initializable {

    @FXML
    private StackPane welcome;

    @FXML
    private Label description;

    private boolean clicked = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Load_First_Part_Of_Transition();
    }

    private void Load_First_Part_Of_Transition() {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), description);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            Load_Second_Part_Of_Transition();
        });

        ft.play();
    }

    private void Load_Second_Part_Of_Transition() {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), description);
        ft.setFromValue(0);
        ft.setToValue(1);

        ft.setOnFinished(event -> {
            Load_First_Part_Of_Transition();
        });

        ft.play();
    }

    public void Load_File_Reader(MouseEvent mouseEvent) {
        if((mouseEvent.getButton() == MouseButton.PRIMARY) && !clicked) {
            FadeTransition ft = new FadeTransition(Duration.seconds(2), welcome);
            ft.setFromValue(1);
            ft.setToValue(0);

            ft.setOnFinished(event -> {
                try {
                    Stage stage = (Stage) welcome.getScene().getWindow();
                    Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Application/File_Reader.fxml")));

                    stage.setTitle("File Reader");
                    stage.setScene(sc);
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception e) {
                    Alert error = new Alert(Alert.AlertType.ERROR);

                    error.setTitle("File Reader");
                    error.setContentText("Error opening the File Reader");

                    FileNotFoundException fnfe = new FileNotFoundException("Could not find the file");
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    fnfe.printStackTrace(pw);

                    JFXTextArea ta = new JFXTextArea(sw.toString());
                    ta.setFocusColor(Color.LIME);
                    ta.setUnFocusColor(Color.WHITE);

                    error.getDialogPane().setExpandableContent(ta);
                    error.show();
                }
            });

            ft.play();
            clicked = true;
        } else if(clicked) {
            // Nothing happens here
        }
    }
}