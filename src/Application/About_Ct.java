package Application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class About_Ct implements Initializable {

    @FXML
    private JFXButton whats_New;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        whats_New.setOnMouseClicked(event -> {
            try {
                Stage stage = new Stage();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Application/Whats_New.fxml")));

                stage.setTitle("File Reader");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("File Reader - About");
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
    }
}