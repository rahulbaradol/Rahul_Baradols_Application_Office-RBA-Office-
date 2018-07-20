package Application;

import com.jfoenix.controls.JFXTextArea;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class File_Reader_MC extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Application/Welcome.fxml")));

            primaryStage.setTitle("File Reader - Welcome");
            primaryStage.setScene(sc);
            primaryStage.setResizable(false);
            primaryStage.show();
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
    }

}