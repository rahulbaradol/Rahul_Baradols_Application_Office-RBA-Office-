package Standard_Calculator_Professional.Java_Ct;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Standard_Calculator_Professional implements Initializable {

    @FXML
    private StackPane main;

    @FXML
    private Label value;

    @FXML
    private JFXButton num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, equals;

    @FXML
    private JFXButton plus, subtract, multiply, divide, modulas, square, square_root, cube, cube_root, pi, dot;

    @FXML
    private JFXButton exit, help;

    private String calculating_symbol;
    private double first_num, second_num;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        main.setOpacity(0);
        equals.setDisable(true);

        FadeTransition fadeTransition_Of_Standard_Calculator_Fade_In = new FadeTransition(Duration.seconds(2), main);

        fadeTransition_Of_Standard_Calculator_Fade_In.setFromValue(0);
        fadeTransition_Of_Standard_Calculator_Fade_In.setToValue(1);
        fadeTransition_Of_Standard_Calculator_Fade_In.play();
    }

    public void dot() {
        value.setText(value.getText() + ".");
        dot.setDisable(true);
    }

    public void PI() {
        value.setText(value.getText() + "3.14");
    }

    public void num0() {
        value.setText(value.getText() + "0");
    }

    public void num1() {
        value.setText(value.getText() + "1");
    }

    public void num2() {
        value.setText(value.getText() + "2");
    }

    public void num3() {
        value.setText(value.getText() + "3");
    }

    public void num4() {
        value.setText(value.getText() + "4");
    }

    public void num5() {
        value.setText(value.getText() + "5");
    }

    public void num6() {
        value.setText(value.getText() + "6");
    }

    public void num7() {
        value.setText(value.getText() + "7");
    }

    public void num8() {
        value.setText(value.getText() + "8");
    }

    public void num9() {
        value.setText(value.getText() + "9");
    }

    public void Plus() {
        try {
            first_num = Double.parseDouble(value.getText());
            calculating_symbol = "+";

            value.setText("");

            Decide_whether_Disable_Or_Enable("Calculated");
            dot.setDisable(false);
        } catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard_Calculator_Professional");
            error.setContentText("Type a valid number.");
            error.showAndWait();
        }
    }

    public void Decide_whether_Disable_Or_Enable(String type) {
        if (type.equals("After the answer")) {
            num0.setDisable(true);
            num1.setDisable(true);
            num2.setDisable(true);
            num3.setDisable(true);
            num4.setDisable(true);
            num5.setDisable(true);
            num6.setDisable(true);
            num7.setDisable(true);
            num8.setDisable(true);
            num9.setDisable(true);

            plus.setDisable(true);
            subtract.setDisable(true);
            multiply.setDisable(true);
            divide.setDisable(true);
            modulas.setDisable(true);
            square.setDisable(true);
            square_root.setDisable(true);
            cube.setDisable(true);
            cube_root.setDisable(true);
            dot.setDisable(true);
            pi.setDisable(true);
            equals.setDisable(true);
        } else if (type.equals("Calculated")) {
            plus.setDisable(true);
            subtract.setDisable(true);
            multiply.setDisable(true);
            divide.setDisable(true);
            modulas.setDisable(true);
            square.setDisable(true);
            square_root.setDisable(true);
            cube.setDisable(true);
            cube_root.setDisable(true);

            equals.setDisable(false);
        }
    }

    public void Subtract() {
        try {
            first_num = Double.parseDouble(value.getText());
            calculating_symbol = "-";

            value.setText("");

            Decide_whether_Disable_Or_Enable("Calculated");
            dot.setDisable(false);
        } catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard_Calculator_Professional");
            error.setContentText("Type a valid number.");
            error.showAndWait();
        }
    }

    public void Multiply() {
        try {
            first_num = Double.parseDouble(value.getText());
            calculating_symbol = "x";

            value.setText("");

            Decide_whether_Disable_Or_Enable("Calculated");
            dot.setDisable(false);
        } catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard_Calculator_Professional");
            error.setContentText("Type a valid number.");
            error.showAndWait();
        }
    }

    public void Divide() {
        try {
            first_num = Double.parseDouble(value.getText());
            calculating_symbol = "/";

            value.setText("");

            Decide_whether_Disable_Or_Enable("Calculated");
            dot.setDisable(false);
        } catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard_Calculator_Professional");
            error.setContentText("Type a valid number.");
            error.showAndWait();
        }
    }

    public void Modulas() {
        try {
            first_num = Double.parseDouble(value.getText());
            calculating_symbol = "%";

            value.setText("");

            Decide_whether_Disable_Or_Enable("Calculated");
            dot.setDisable(false);
        } catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard_Calculator_Professional");
            error.setContentText("Type a valid number.");
            error.showAndWait();
        }
    }

    public void Square() {
        try {
            first_num = Double.parseDouble(value.getText());
            double square = first_num * first_num;

            Alert answer_Square = new Alert(Alert.AlertType.INFORMATION);

            answer_Square.setTitle("Standard_Calculator_Professional");
            answer_Square.setHeaderText("Square");
            answer_Square.setContentText("The square of " + first_num + " is " + square);
            answer_Square.showAndWait();

            value.setText("You just founded the square of " + first_num);
            Decide_whether_Disable_Or_Enable("After the answer");
        } catch (NumberFormatException e) {
            Alert invalid_Number = new Alert(Alert.AlertType.ERROR);

            invalid_Number.setTitle("Standard_Calculator_Professional");
            invalid_Number.setContentText("Type a valid number");
            invalid_Number.showAndWait();

            Clear();
        }
    }

    public void Clear() {
        first_num = 0;
        second_num = 0;
        value.setText("");

        num0.setDisable(false);
        num1.setDisable(false);
        num2.setDisable(false);
        num3.setDisable(false);
        num4.setDisable(false);
        num5.setDisable(false);
        num6.setDisable(false);
        num7.setDisable(false);
        num8.setDisable(false);
        num9.setDisable(false);

        plus.setDisable(false);
        subtract.setDisable(false);
        multiply.setDisable(false);
        divide.setDisable(false);
        modulas.setDisable(false);
        square.setDisable(false);
        square_root.setDisable(false);
        cube.setDisable(false);
        cube_root.setDisable(false);
        dot.setDisable(false);
        pi.setDisable(false);
        equals.setDisable(true);
    }

    public void Cube() {
        try {
            first_num = Double.parseDouble(value.getText());
            double cube = first_num * first_num * first_num;

            Alert answer_Cube = new Alert(Alert.AlertType.INFORMATION);

            answer_Cube.setTitle("Standard_Calculator_Professional");
            answer_Cube.setHeaderText("Square");
            answer_Cube.setContentText("The cube of " + first_num + " is " + cube);
            answer_Cube.showAndWait();

            value.setText("You just founded the cube of " + first_num);
            Decide_whether_Disable_Or_Enable("After the answer");
        } catch (NumberFormatException e) {
            Alert invalid_Number = new Alert(Alert.AlertType.ERROR);

            invalid_Number.setTitle("Standard_Calculator_Professional");
            invalid_Number.setContentText("Type a valid number");
            invalid_Number.showAndWait();

            Clear();
        }
    }

    public void Square_Root() {
        try {
            first_num = Double.parseDouble(value.getText());
            double square_Root = Math.sqrt(first_num);

            Alert answer_Square_Root = new Alert(Alert.AlertType.INFORMATION);

            answer_Square_Root.setTitle("Standard_Calculator_Professional");
            answer_Square_Root.setHeaderText("Square");
            answer_Square_Root.setContentText("The square root of " + first_num + " is " + square_Root);
            answer_Square_Root.showAndWait();

            value.setText("You just founded the square root of " + first_num);
            Decide_whether_Disable_Or_Enable("After the answer");
        } catch (NumberFormatException e) {
            Alert invalid_Number = new Alert(Alert.AlertType.ERROR);

            invalid_Number.setTitle("Standard_Calculator_Professional");
            invalid_Number.setContentText("Type a valid number");
            invalid_Number.showAndWait();

            Clear();
        }
    }

    public void Cube_Root() {
        try {
            first_num = Double.parseDouble(value.getText());
            double cube_Root = Math.cbrt(first_num);

            Alert answer_Cube_Root = new Alert(Alert.AlertType.INFORMATION);

            answer_Cube_Root.setTitle("Standard_Calculator_Professional");
            answer_Cube_Root.setHeaderText("Square");
            answer_Cube_Root.setContentText("The cube root of " + first_num + " is " + cube_Root);
            answer_Cube_Root.showAndWait();

            value.setText("You just founded the cube root of " + first_num);
            Decide_whether_Disable_Or_Enable("After the answer");
        } catch (NumberFormatException e) {
            Alert invalid_Number = new Alert(Alert.AlertType.ERROR);

            invalid_Number.setTitle("Standard_Calculator_Professional");
            invalid_Number.setContentText("Type a valid number");
            invalid_Number.showAndWait();

            Clear();
        }
    }

    public void Equals() {
        try {
            switch (calculating_symbol) {

                case "+":
                    double second_value_Add = Double.parseDouble(value.getText());
                    second_num = first_num + second_value_Add;

                    Alert answer_Add = new Alert(Alert.AlertType.INFORMATION);

                    answer_Add.setTitle("Standard_Calculator_Professional");
                    answer_Add.setHeaderText("Answer");
                    answer_Add.setContentText("The sum of " + first_num + " and " + value.getText() + " is " + second_num);
                    answer_Add.showAndWait();

                    value.setText("You just added " + first_num + " and " + second_value_Add);
                    Decide_whether_Disable_Or_Enable("After the answer");
                    break;

                case "-":
                    double second_value_Subtract = Double.parseDouble(value.getText());
                    second_num = first_num - second_value_Subtract;

                    Alert answer_Subtract = new Alert(Alert.AlertType.INFORMATION);

                    answer_Subtract.setTitle("Standard_Calculator_Professional");
                    answer_Subtract.setHeaderText("Answer");
                    answer_Subtract.setContentText("The difference of " + first_num + " and " + value.getText() + " is " + second_num);
                    answer_Subtract.showAndWait();

                    value.setText("You just subtract " + first_num + " and " + second_value_Subtract);
                    Decide_whether_Disable_Or_Enable("After the answer");
                    break;

                case "x":
                    double second_value_Multiply = Double.parseDouble(value.getText());
                    second_num = first_num * second_value_Multiply;

                    Alert answer_Multiply = new Alert(Alert.AlertType.INFORMATION);

                    answer_Multiply.setTitle("Standard_Calculator_Professional");
                    answer_Multiply.setHeaderText("Answer");
                    answer_Multiply.setContentText("The product of " + first_num + " and " + value.getText() + " is " + second_num);
                    answer_Multiply.showAndWait();

                    value.setText("You just multiplied " + first_num + " and " + second_value_Multiply);
                    Decide_whether_Disable_Or_Enable("After the answer");
                    break;

                case "/":
                    double second_value_Divide = Double.parseDouble(value.getText());

                    if (second_value_Divide == 0) {
                        Alert invalid_Answer = new Alert(Alert.AlertType.WARNING);

                        invalid_Answer.setTitle("Standard_Calculator_Professional");
                        invalid_Answer.setHeaderText("Answer");
                        invalid_Answer.setContentText("There is no answer dividing any number with 0. \nI think you must be knowing.");
                        invalid_Answer.showAndWait();

                        Clear();
                    } else {
                        second_num = first_num / second_value_Divide;

                        Alert answer_Divide = new Alert(Alert.AlertType.INFORMATION);

                        answer_Divide.setTitle("Standard_Calculator_Professional");
                        answer_Divide.setHeaderText("Answer");
                        answer_Divide.setContentText("By dividing  " + first_num + " and " + value.getText() + " we get the quotient " + second_num);
                        answer_Divide.showAndWait();

                        value.setText("You just founded quotient by dividing " + first_num + " and " + second_value_Divide);
                        Decide_whether_Disable_Or_Enable("After the answer");
                    }
                    break;

                case "%":
                    double second_value_Modulas = Double.parseDouble(value.getText());
                    second_num = first_num % second_value_Modulas;

                    Alert answer_Modulas = new Alert(Alert.AlertType.INFORMATION);

                    answer_Modulas.setTitle("Standard_Calculator_Professional");
                    answer_Modulas.setHeaderText("Answer");
                    answer_Modulas.setContentText("By dividing  " + first_num + " and " + value.getText() + " we get the remainder " + second_num);
                    answer_Modulas.showAndWait();

                    value.setText("You just founded remainder by dividing " + first_num + " and " + second_value_Modulas);
                    Decide_whether_Disable_Or_Enable("After the answer");
                    break;
            }
        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);

            error.setTitle("Standard_Calculator_Professional");
            error.setContentText("Type a valid number.");
            error.showAndWait();

            Clear();
        }
    }

    public void Help() {
        FadeTransition fadeTransition_Of_Help_Fade_Out = new FadeTransition(Duration.seconds(2), main);

        fadeTransition_Of_Help_Fade_Out.setFromValue(1);
        fadeTransition_Of_Help_Fade_Out.setToValue(0);

        fadeTransition_Of_Help_Fade_Out.setOnFinished(event_Of_Fade_Out -> {
            try {
                Stage stage = (Stage) main.getScene().getWindow();
                Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator_Professional/FXML_Files/Help.fxml")));

                stage.setTitle("Standard Calculator Professional - Help");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.ERROR);

                error.setTitle("Standard_Calculator_Professional");
                error.setContentText("Error loading the file. \nCould not find the file.");
                error.show();
            }
        });

        fadeTransition_Of_Help_Fade_Out.play();
        help.setDisable(true);
        exit.setDisable(true);
    }

    public void KeyBoard_Key_Functioning(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case P:
                Plus();
                break;

            case S:
                Subtract();
                break;

            case M:
                Multiply();
                break;

            case Q:
                Divide();
                break;

            case R:
                Modulas();
                break;

            case E:
                Equals();
                break;

            case F6:
                Square();
                break;

            case F8:
                Square_Root();
                break;

            case F10:
                Cube();
                break;

            case F12:
                Cube_Root();
                break;

            case C:
                Clear();
                break;

            case H:
                Help();
                break;

            case BACK_SPACE:
                FadeTransition fadeTransition_Of_Help_Fade_Out = new FadeTransition(Duration.seconds(2), main);

                fadeTransition_Of_Help_Fade_Out.setFromValue(1);
                fadeTransition_Of_Help_Fade_Out.setToValue(0);

                fadeTransition_Of_Help_Fade_Out.setOnFinished(event_Of_Fade_Out -> {
                    try {
                        Stage stage = (Stage) main.getScene().getWindow();
                        Scene sc = new Scene(FXMLLoader.load(getClass().getResource("/Standard_Calculator_Professional/FXML_Files/Welcome.fxml")));

                        stage.setTitle("Standard Calculator Professional - Welcome");
                        stage.setScene(sc);
                        stage.setResizable(false);
                        stage.show();
                    } catch (Exception e) {
                        Alert error = new Alert(Alert.AlertType.ERROR);

                        error.setTitle("Standard_Calculator_Professional");
                        error.setContentText("Error loading the file. \nCould not find the file.");
                        error.show();
                    }
                });

                fadeTransition_Of_Help_Fade_Out.play();
                help.setDisable(true);
                exit.setDisable(true);
                break;

            case ESCAPE:
                Exit();
                break;

            case END:
                exit(0);
                break;
        }
    }

    public void Exit() {
        Alert exit_Standard_Calculator_Professional = new Alert(Alert.AlertType.CONFIRMATION);

        exit_Standard_Calculator_Professional.setTitle("Standard_Calculator_Professional");
        exit_Standard_Calculator_Professional.setHeaderText("Exit?");
        exit_Standard_Calculator_Professional.setContentText("Are you sure, you want to exit?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        exit_Standard_Calculator_Professional.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> op = exit_Standard_Calculator_Professional.showAndWait();

        if (op.get() == yes) exit(0);
    }

}