package Standard_Folder_File_Maker.V_1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Folder_File_Maker_Ct implements Initializable {

    // Folder
    @FXML
    private JFXTextField folder_location;

    @FXML
    private JFXTextField folder_name;

    @FXML
    private JFXButton folder_create;

    @FXML
    private JFXButton folder_clear;

    @FXML
    private JFXButton folder_exit;

    @FXML
    private JFXButton folder_help;

    // File

    @FXML
    private JFXTextField file_location;

    @FXML
    private JFXTextField file_name;

    @FXML
    private JFXTextField file_extension;

    @FXML
    private JFXButton file_create;

    @FXML
    private JFXButton file_clear;

    @FXML
    private JFXButton file_exit;

    @FXML
    private JFXButton file_help;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // ------------------------------------------------ Folder ------------------------------------ //
        folder_create.setOnMouseClicked(event -> {
            File folder = new File(folder_location.getText() + "\\" + folder_name.getText());

            Alert create = new Alert(Alert.AlertType.CONFIRMATION);

            create.setTitle("Standard Folder/File Maker");
            create.setHeaderText("Create?");
            create.setContentText("Are you sure, you want to create a folder named '" + folder_name.getText() + "' in the location '" + folder_location.getText() + "'?");

            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");

            create.getButtonTypes().setAll(yes, no);

            Optional<ButtonType> op = create.showAndWait();

            if(op.get() == yes) {

                if(!folder.exists()) {
                    folder.mkdir();

                    Alert done = new Alert(Alert.AlertType.INFORMATION);

                    done.setTitle("Standard Folder/File Maker");
                    done.setHeaderText("Created");
                    done.setContentText("Successfully created the folder '" + folder_name.getText() + "' in the location '" + folder_location.getText() + "'");
                    done.showAndWait();
                }else if(folder.exists()) {
                    Alert warning = new Alert(Alert.AlertType.WARNING);

                    warning.setTitle("Standard Folder/File Maker");
                    warning.setContentText("There is already a folder named '" + folder_name.getText() + "' in the location '" + folder_location.getText() + "'");
                    warning.showAndWait();
                }

            }
        });

        folder_clear.setOnMouseClicked(event -> {
            folder_location.setText("");
            folder_name.setText("");
        });

        folder_help.setOnMouseClicked(event -> {
            try {
                Stage stage = new Stage();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Folder_File_Maker/V_1/About.fxml")));

                stage.setTitle("Standard Folder/File Maker - About");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Standard Folder/File Maker");
                error.setHeaderText("Error");
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

        folder_exit.setOnMouseClicked(event -> {
            Alert exit = new Alert(Alert.AlertType.CONFIRMATION);

            exit.setTitle("Standard Folder/File Maker");
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

        // ------------------------------------ File ---------------------------------------- //
        file_create.setOnMouseClicked(event -> {
            try {
                File file = new File(file_location.getText() + "/" + file_name.getText() + file_extension.getText());

                Alert create = new Alert(Alert.AlertType.CONFIRMATION);

                create.setTitle("Standard Folder/File Maker");
                create.setHeaderText("Create?");
                create.setContentText("Are you sure, you want to create a file named '" + file_name.getText() + file_extension.getText() + "' in the location '" + file_location.getText() + "'");

                ButtonType yes = new ButtonType("Yes");
                ButtonType no = new ButtonType("No");

                create.getButtonTypes().setAll(yes, no);

                Optional<ButtonType> op = create.showAndWait();

                if (op.get() == yes) {

                    if (!file.exists()) {
                        file.createNewFile();

                        Alert done = new Alert(Alert.AlertType.INFORMATION);

                        done.setTitle("Standard Folder/File Maker");
                        done.setContentText("Successfully created file named '" + file_name.getText() + file_extension.getText() + "' in the location '" + file_location.getText() + "'");
                        done.showAndWait();

                        if(file_extension.getText().equals(".txt")) {
                            PrintWriter pw = new PrintWriter(file);

                            pw.println("Welcome to " + file_name.getText());
                            pw.close();
                        }else if(file_extension.getText().equals(".java")) {
                            PrintWriter pw = new PrintWriter(file);

                            pw.println("public class " + file_name.getText() + " {");
                            pw.println("     public static void main(String[] args) {");
                            pw.println("            System.out.println('Welcome to " + file_name.getText() + "');");
                            pw.println("     }");
                            pw.println("}");
                            pw.close();
                        }else if(file_extension.getText().equals(".html") | file_extension.getText().equals(".htm") | file_extension.getText().equals(".HTML") |
                                file_extension.getText().equals(".HTM") | file_extension.getText().equals(".Html")) {

                            PrintWriter pw = new PrintWriter(file);

                            pw.println("<html>");
                            pw.println("<head> <title> " + file_name.getText() + " </title> </head>");
                            pw.println("<body bgcolor='aqua' text='white'>");
                            pw.println("     <h1> Welcome to " + file_name.getText() + " </h1>");
                            pw.println("</body>");
                            pw.println("</html>");
                            pw.close();
                        }else if(file_extension.getText().equals(".php")) {
                            PrintWriter pw = new PrintWriter(file);

                            pw.println("<html>");
                            pw.println("<head> <title> " + file_name.getText() + " </title> </head>");
                            pw.println("<body bgcolor='aqua' text='white'>");
                            pw.println("     <?php");
                            pw.println("          echo 'Welcome to " + file_name.getText() + "';");
                            pw.println("      ?>");
                            pw.println("</body>");
                            pw.println("</html>");
                            pw.close();
                        }

                    }else if(file.exists()) {
                        Alert warning = new Alert(Alert.AlertType.WARNING);

                        warning.setTitle("Standard Folder/File Maker");
                        warning.setContentText("There is already a file named '" + file_name.getText() + file_extension.getText() + "' in the location '" + file_location.getText() + "");
                        warning.showAndWait();
                    }

                }

            }catch (Exception ep) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Standard Folder/File Maker");
                error.setHeaderText("Error");
                error.setContentText("Error creating the file");

                FileNotFoundException fnfe = new FileNotFoundException("Error creating the file");
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

        file_clear.setOnMouseClicked(event -> {
            file_location.setText("");
            file_name.setText("");
            file_extension.setText("");
        });

        file_help.setOnMouseClicked(event -> {
            try {
                Stage stage = new Stage();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Folder_File_Maker/V_1/About.fxml")));

                stage.setTitle("Standard Folder/File Maker - About");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Standard Folder/File Maker");
                error.setHeaderText("Error");
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

        file_exit.setOnMouseClicked(event -> {
            Alert exit = new Alert(Alert.AlertType.CONFIRMATION);

            exit.setTitle("Standard Folder/File Maker");
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