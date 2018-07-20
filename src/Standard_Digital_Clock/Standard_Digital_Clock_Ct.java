package Standard_Digital_Clock;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.System.exit;
import static javafx.scene.paint.Color.LIME;
import static javafx.scene.paint.Color.WHITE;

public class Standard_Digital_Clock_Ct implements Initializable {

    @FXML
    private Label showTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            Date date = new Date();
            showTime.setText(date.toString());
    }

    public void Refresh() {
        Date date = new Date();
        showTime.setText(date.toString());
    }

    public void About() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Digital_Clock/About.fxml")));

            stage.setTitle("About - Standard Digital Clock");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Digital Clock");
            error.setContentText("Could not find the file");
            error.setContentText("Error loading the file");

            StringWriter sw = new StringWriter();
            new FileNotFoundException("Could not find the file")
                    .printStackTrace(new PrintWriter(sw));

            JFXTextArea ta = new JFXTextArea(sw.toString());
            ta.setFocusColor(LIME);
            ta.setUnFocusColor(WHITE);

            error.getDialogPane().setExpandableContent(ta);
            error.show();
        }
    }

    public void Exit() {
        Alert exit = new Alert(Alert.AlertType.CONFIRMATION);

        exit.setTitle("Standard Digital Clock");
        exit.setHeaderText("Exit?");
        exit.setContentText("Are you sure, you want to exit?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        exit.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> op = exit.showAndWait();

        if(op.get() == yes) {
            exit(0);
        }
    }

}