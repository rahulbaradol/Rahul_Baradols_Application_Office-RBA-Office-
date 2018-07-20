package Standard_Calculator.V_1_1;

import com.jfoenix.controls.JFXTextArea;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.LIME;
import static javafx.scene.paint.Color.WHITE;

/**
 * @author Rahul Baradol
 * @since 14/9/2017
 */

public class Calculator_Cr implements Initializable {

    @FXML
    private StackPane main;

    @FXML
    protected Label answer;

    private double value1;
    private String fn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition ft = new FadeTransition(Duration.seconds(2), main);

        main.setOpacity(0);

        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    public void Add() {
        try {
            value1 = Double.parseDouble(answer.getText());
            fn = "+";
            answer.setText("");
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setContentText("Type a valid number");
            error.showAndWait();
        }
    }

    public void Subtract() {
        try {
            value1 = Double.parseDouble(answer.getText());
            fn = "-";
            answer.setText("");
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setContentText("Type a valid number");
            error.showAndWait();
        }
    }

    public void Multiply() {
        try {
            value1 = Double.parseDouble(answer.getText());
            fn = "*";
            answer.setText("");
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setContentText("Type a valid number");
            error.showAndWait();
        }
    }

    public void Divide() {
        try {
            value1 = Double.parseDouble(answer.getText());
            fn = "/";
            answer.setText("");
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setContentText("Type a valid number");
            error.showAndWait();
        }
    }

    public void Modulas() {
        try {
            value1 = Double.parseDouble(answer.getText());
            fn = "%";
            answer.setText("");
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setContentText("Type a valid number");
            error.showAndWait();
        }
    }

    public void Equals() {
        double value2;

        try {
            switch (fn) {
                case "+":
                    value2 = value1 + Double.parseDouble(answer.getText());
                    answer.setText(Double.toString(value2));
                    break;

                case "-":
                    value2 = value1 - Double.parseDouble(answer.getText());
                    answer.setText(Double.toString(value2));
                    break;

                case "*":
                    value2 = value1 * Double.parseDouble(answer.getText());
                    answer.setText(Double.toString(value2));
                    break;

                case "/":
                    value2 = value1 / Double.parseDouble(answer.getText());
                    answer.setText(Double.toString(value2));
                    break;

                case "%":
                    value2 = value1 % Double.parseDouble(answer.getText());
                    answer.setText(Double.toString(value2));
                    break;
            }
        }catch(Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setContentText("Type a valid number");
            error.showAndWait();
        }
    }

    public void Dot() {
        answer.setText(answer.getText() + ".");
    }

    public void PI() {
        answer.setText(answer.getText() + "3.14");
    }

    public void num0() {
        answer.setText(answer.getText() + "0");
    }

    public void num1() {
        answer.setText(answer.getText() + "1");
    }

    public void num2() {
        answer.setText(answer.getText() + "2");
    }

    public void num3() {
        answer.setText(answer.getText() + "3");
    }

    public void num4() {
        answer.setText(answer.getText() + "4");
    }

    public void num5() {
        answer.setText(answer.getText() + "5");
    }

    public void num6() {
        answer.setText(answer.getText() + "6");
    }

    public void num7() {
        answer.setText(answer.getText() + "7");
    }

    public void num8() {
        answer.setText(answer.getText() + "8");
    }

    public void num9() {
        answer.setText(answer.getText() + "9");
    }

    public void Clear() {
        answer.setText("");
    }

    public void Help() {
        try {
            Stage stage = new Stage();

            stage.setTitle("Standard Calculator - About");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator/V_1_1/About.fxml"))));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard Calculator");
            error.setHeaderText("Error");
            error.setContentText("Could not find the file. \n");

            FileNotFoundException fnfe = new FileNotFoundException("Could not find the file");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            fnfe.printStackTrace(pw);

            JFXTextArea ta = new JFXTextArea(sw.toString());
            ta.setFocusColor(LIME);
            ta.setUnFocusColor(WHITE);
            error.getDialogPane().setExpandableContent(ta);
            error.showAndWait();
        }
    }

}