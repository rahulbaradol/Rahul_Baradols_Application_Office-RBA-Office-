package App_RBA_Office.Java_Ct;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Rahul_Baradols_Application_Office_Ct implements Initializable {

    @FXML
    private StackPane main;

    @FXML
    private JFXButton help;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), main);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    public void Age_Calculator() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Age_Calculator/FXML_Files/Welcome.fxml")));

            stage.setTitle("Age Calculator");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Age Calculator");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void File_Reader() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/File_Reader/File_Reader.fxml")));

            stage.setTitle("File Reader");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("File Reader");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Standard_Digital_Clock() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Digital_Clock/Standard_Digital_Clock.fxml")));

            stage.setTitle("Standard Digital Clock");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Digital Clock");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Standard_Text_Editor() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Text_Editor/Standard_Text_Editor.fxml")));

            stage.setTitle("Standard Text Editor");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Text Editor");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Standard_Calculator_1() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator/V_1/Calculator.fxml")));

            stage.setTitle("Standard Calculator");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Standard_Calculator_1_1() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator/V_1_1/Welcome.fxml")));

            stage.setTitle("Standard Calculator");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Standard_Calculator_Professional() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator_Professional/FXML_Files/Welcome.fxml")));

            stage.setTitle("Standard Calculator - Professional");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator - Professional");
            error.setContentText("Error loading the file.\nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Standard_Folder_File_Maker_1() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Folder_File_Maker/V_1/Folder_File_Maker.fxml")));

            stage.setTitle("Standard Folder File Maker");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Folder File Maker");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Standard_Folder_File_Maker_2() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Folder_File_Maker/V_2/Folder_File_Maker.fxml")));

            stage.setTitle("Standard Folder File Maker");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Folder File Maker");
            error.setContentText("Error loading the file. \nCould not find the file.");
            error.showAndWait();
        }
    }

    public void Table_Detector_1() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Table_Detector/V_1/FXML_Files/Welcome.fxml")));

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
    }

    public void Table_Detector_2() {
        try {
            Stage stage = new Stage();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Table_Detector/V_2/FXML_Files/Welcome.fxml")));

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
    }

    public void Help() {
        help.setDisable(true);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), main);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) main.getScene().getWindow();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/App_RBA_Office/FXML_Files/About.fxml")));

                stage.setTitle("RBA Office - About");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (Exception ep) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("RBA Office");
                error.setContentText("Error loading the file. \nCould not find the file");
                error.showAndWait();
            }
        });

        ft.play();
    }

    public void Exit() {
        Alert exit = new Alert(Alert.AlertType.CONFIRMATION);

        exit.setTitle("RBA Office");
        exit.setHeaderText("Exit?");
        exit.setContentText("Are you sure, you want to exit?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        exit.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> op = exit.showAndWait();

        if (op.get() == yes) {
            Alert exit_description = new Alert(Alert.AlertType.INFORMATION);

            exit_description.setTitle("RBA Office");
            exit_description.setHeaderText("Talk");
            exit_description.setContentText("THANKS for using RBA(Rahul Baradol's Application) Office. \nHave a nice day. See you soon.");
            exit_description.showAndWait();

            exit(0);
        }
    }

}