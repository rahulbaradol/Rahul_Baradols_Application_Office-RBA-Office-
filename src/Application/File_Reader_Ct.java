package Application;

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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class File_Reader_Ct implements Initializable {

    @FXML
    private StackPane main;

    @FXML
    private JFXTextField location;

    @FXML
    private JFXTextArea answer;

    @FXML
    private Label mouseIdentification;

    // Buttons

    @FXML
    private JFXButton read;

    @FXML
    private JFXButton exit;

    @FXML
    private JFXButton about;

    @FXML
    private JFXButton reset;

    @FXML
    private JFXButton browse;

    // Buttons

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), main);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();

        read.setOnMouseClicked(event -> {
            try {
                if (this.location.getText().endsWith(".txt") | this.location.getText().endsWith(".html") | this.location.getText().endsWith(".java") | this.location.getText().endsWith(".js") |
                        this.location.getText().endsWith(".php") | this.location.getText().endsWith(".xml") | this.location.getText().endsWith(".fxml") | this.location.getText().endsWith(".css") | this.location.getText().endsWith(".dll") | this.location.getText().endsWith(".dmg")) {
                    answer.setVisible(true);

                    FileReader fr = new FileReader(this.location.getText());
                    BufferedReader br = new BufferedReader(fr);
                    String v_Answer;

                    while ((v_Answer = br.readLine()) != null) {
                        answer.setText(answer.getText() + v_Answer + "\n");
                    }
                } else {
                    Alert warning = new Alert(Alert.AlertType.WARNING);

                    warning.setTitle("File Reader");
                    warning.setHeaderText("Invalid File");
                    warning.setContentText("You have specified a invalid file which cannot be read by this application.");
                    warning.showAndWait();

                    this.location.setText("");
                }
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.CONFIRMATION);

                error.setTitle("File Reader");
                error.setContentText("Could not find the file or Error reading the file");

                FileNotFoundException fnfe = new FileNotFoundException("Could not find the file");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                fnfe.printStackTrace(pw);

                JFXTextArea ta = new JFXTextArea(sw.toString());
                ta.setFocusColor(Color.LIME);
                ta.setUnFocusColor(Color.WHITE);

                error.getDialogPane().setExpandableContent(ta);
                error.showAndWait();
            }
        });

        browse.setOnMouseClicked(event -> {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(null);

            if (file != null) {
                this.location.setText(file.getAbsolutePath());
            }

        });

        reset.setOnMouseClicked(event -> {
            this.location.setText("");
            answer.setText("");
            answer.setVisible(false);
        });

        about.setOnMouseClicked(event -> {
            try {
                Stage stage = new Stage();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Application/About.fxml")));

                stage.setTitle("File Reader - About");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.CONFIRMATION);

                error.setTitle("File Reader");
                error.setContentText("Could not find the file");

                FileNotFoundException fnfe = new FileNotFoundException("Could not find the file");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                fnfe.printStackTrace(pw);

                JFXTextArea ta = new JFXTextArea(sw.toString());
                ta.setFocusColor(Color.LIME);
                ta.setUnFocusColor(Color.WHITE);

                error.getDialogPane().setExpandableContent(ta);
                error.showAndWait();
            }
        });

        exit.setOnMouseClicked(event -> {
            Alert exit = new Alert(Alert.AlertType.CONFIRMATION);

            exit.setTitle("File Reader");
            exit.setHeaderText("Exit?");
            exit.setContentText("Are you sure, you want to exit?");

            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");

            exit.getButtonTypes().setAll(yes, no);

            Optional<ButtonType> op = exit.showAndWait();

            if (op.get() == yes) System.exit(0);
        });

    }

    public void ETA() {
        mouseIdentification.setText("Entered the Area");
    }

    public void EXTA() {
        mouseIdentification.setText("Exited the Area");
    }
}