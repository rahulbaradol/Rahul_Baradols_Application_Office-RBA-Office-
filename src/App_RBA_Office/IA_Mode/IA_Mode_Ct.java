package App_RBA_Office.IA_Mode;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class IA_Mode_Ct {

    @FXML
    private JFXTextField question;

    @FXML
    private JFXTextArea answer;

    public void Ask() {
        String question_value = question.getText();

        if(question_value.equals("About RBA Office") | question_value.equals("About Rahul Baradol's Office")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                                          "RBA Office or Rahul Baradol's Office contains all the updated applications of Rahul Baradol! \nIt is free to Use that's the cool part!\n\nAnswer Ends");
        } else if(question_value.equals("About File Reader")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "It is a application developed by Rahul Baradol which reads the files that you specify! \nIn the next update the problem will be fixed that it will not read the media files and image files. \n\nAnswer Ends");
        } else if(question_value.equals("About Folder File Maker") | question_value.equals("About FF Maker")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "It is a application developed by Rahul Baradol which you can create folders and files! \nIf you have many folders or files to create, then, you can use this application! \n\nAnswer Ends");
        } else if(question_value.equals("About Standard Calculator")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "It is a application developed by Rahul Baradol which can calculate numbers with the very nice user interface! \n\nAnswer Ends");
        } else if(question_value.equals("About Standard Text Editor")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "It is a application developed by Rahul Baradol which you can write your information for temporarily and remove it! \n\nAnswer Ends");
        } else if(question_value.equals("About Digital Clock")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "It is a application developed by Rahul Baradol which you can know timing! \nIn this application you need to refresh to get the perfect time. But the cool part is that you can get the correct time if you are doing some event! \n\nAnswer Ends");
        } else if(question_value.equals("About Table Detector")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "It is a application developed by Rahul Baradol which you can get Tables whichever you want! \nYou can get tables of also decimal numbers! \n\nAnswer Ends");
        } else if(question_value.equals("About Age Calculator")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "It is a application developed by Rahul Baradol which you can get how old are you by just specifying your date of birth and the current year! \n\nAnswer Ends");
        } else if(question_value.equals("How are you?")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "I am fine!");

            TextInputDialog tid = new TextInputDialog();
            tid.setTitle("RBA Office - IA Mode");
            tid.setContentText("What about you?");

            Optional<String> op = tid.showAndWait();

            if(op.get().equals("Good") | op.get().equals("Good!") | op.get().equals("Very Good") | op.get().equals("Very Good!") |
                    op.get().equals("Amazing") | op.get().equals("Amazing!") | op.get().equals("I am also fine") | op.get().equals("I am also fine!") | op.get().equals("I'm also fine") | op.get().equals("I'm also fine!") |
                          op.get().equals("I am fine") | op.get().equals("I am fine!") | op.get().equals("I'm fine") | op.get().equals("I'm fine!") | op.get().equals("Yes") | op.get().equals("Yes!") | op.get().equals("YES") | op.get().equals("YES!")) {

                Alert response = new Alert(Alert.AlertType.INFORMATION);
                response.setTitle("RBA Office - IA Mode");
                response.setContentText("Good to hear!!");
                response.showAndWait();
            } else if(op.get().equals("Not Good") | op.get().equals("Not good")) {
                Alert response = new Alert(Alert.AlertType.INFORMATION);
                response.setTitle("RBA Office - IA Mode");
                response.setContentText("Never Mind");
                response.showAndWait();
            } else {
                Alert response = new Alert(Alert.AlertType.ERROR);
                response.setTitle("RBA Office - IA Mode");
                response.setContentText("I'm sorry but i did not understand what you said.");
                response.showAndWait();
            }

        } else if(question_value.equals("Do you want pizza?")) {
            Alert response = new Alert(Alert.AlertType.INFORMATION);
            response.setTitle("RBA Office - IA Mode");
            response.setContentText("With extra sauce no cheese!");
            response.showAndWait();
        } else if(question_value.equals("%Help%")) {
            answer.setText(answer.getText() + "\n\nHelp\n\nIA(Information Accessing) Mode is used to get additional information about Rahul Baradol's Applications! \n" +
                                          "This is available only in RBA Office, but, this may be released as a separate application on or the other day!\n\nHelp Ends");
        } else if(question_value.equals("About Standard Calculator - Professional") | question_value.equals("About Standard Calculator - Pro") |
                         question_value.equals("About Standard Calculator Professional") | question_value.equals("About Standard Calculator Pro")) {
            answer.setText(answer.getText() + "\n\n Question occupied.\n\n Answer:\n " +
                    "Standard Calculator - Professional (Pro) is a application developed by Rahul Baradol in  which you can use more customized and powerful Calculator!\n\nAnswer Ends");
        } else {
            Alert response = new Alert(Alert.AlertType.ERROR);
            response.setTitle("RBA Office - IA Mode");
            response.setContentText("Invalid question.");
            response.showAndWait();

            question.setText("");
            answer.setText(answer.getText() + "\n\nQuestion occupied\nInvalid Question");
        }
    }

    public void Clear() {
        question.setText("");
        answer.setText("Successfully Logged in IA Mode \nWaiting for Questions............");
    }

}