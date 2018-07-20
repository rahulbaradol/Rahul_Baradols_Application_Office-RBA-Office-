package Standard_Calculator.V_1_1;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class About_Cr {

    // What's New

    @FXML
    private JFXButton whats_new_and_help;

    @FXML
    private Label  description_1;

    @FXML
    private Label  description_2;

    @FXML
    private Label  description_3;

    @FXML
    private Label  description_4;

    @FXML
    private Label  description_5;

    @FXML
    private Label  description_6;

    // Help

    @FXML
    private Label description_1_help;

    @FXML
    private Label description_2_help;

    @FXML
    private Label description_3_help;

    @FXML
    private Label description_4_help;

    public void Whats_New() {
        if (whats_new_and_help.getText().equals("What's New")) {
            FadeTransition ft_des_1 = new FadeTransition(Duration.seconds(1), description_1);
            FadeTransition ft_des_2 = new FadeTransition(Duration.seconds(1), description_2);
            FadeTransition ft_des_3 = new FadeTransition(Duration.seconds(1), description_3);
            FadeTransition ft_des_4 = new FadeTransition(Duration.seconds(1), description_4);
            FadeTransition ft_des_5 = new FadeTransition(Duration.seconds(1), description_5);
            FadeTransition ft_des_6 = new FadeTransition(Duration.seconds(1), description_6);

            ft_des_1.setFromValue(1);
            ft_des_1.setToValue(0);

            ft_des_1.setOnFinished(event -> {
                ft_des_2.setFromValue(1);
                ft_des_2.setToValue(0);

                ft_des_2.setOnFinished(event2 -> {
                    ft_des_3.setFromValue(1);
                    ft_des_3.setToValue(0);

                    ft_des_3.setOnFinished(event3 -> {
                        ft_des_4.setFromValue(1);
                        ft_des_4.setToValue(0);

                        ft_des_4.setOnFinished(event4 -> {
                            ft_des_5.setFromValue(1);
                            ft_des_5.setToValue(0);

                            ft_des_5.setOnFinished(event5 -> {
                                ft_des_6.setFromValue(1);
                                ft_des_6.setToValue(0);

                                ft_des_6.setOnFinished(event6 -> {
                                    whats_new_and_help.setText("Help");
                                    Whats_New_Next();
                                });

                                ft_des_6.play();
                            });

                            ft_des_5.play();
                        });

                        ft_des_4.play();
                    });

                    ft_des_3.play();
                });

                ft_des_2.play();
            });

            ft_des_1.play();

            whats_new_and_help.setDisable(true);

        } else if(whats_new_and_help.getText().equals("Help")) {
            FadeTransition ft_help_1 = new FadeTransition(Duration.seconds(1), description_1_help);
            FadeTransition ft_help_2 = new FadeTransition(Duration.seconds(1), description_2_help);
            FadeTransition ft_help_3 = new FadeTransition(Duration.seconds(1), description_3_help);
            FadeTransition ft_help_4 = new FadeTransition(Duration.seconds(1), description_4_help);

            ft_help_1.setFromValue(1);
            ft_help_1.setToValue(0);

            ft_help_1.setOnFinished(event -> {
                ft_help_2.setFromValue(1);
                ft_help_2.setToValue(0);

                ft_help_2.setOnFinished(event2 -> {
                    ft_help_3.setFromValue(1);
                    ft_help_3.setToValue(0);

                    ft_help_3.setOnFinished(event3 -> {
                        ft_help_4.setFromValue(1);
                        ft_help_4.setToValue(0);

                        ft_help_4.setOnFinished(event4 -> {
                            whats_new_and_help.setText("What's New");
                            Help();
                        });

                        ft_help_4.play();
                    });

                    ft_help_3.play();
                });

                ft_help_2.play();
            });

            ft_help_1.play();

            whats_new_and_help.setDisable(true);
        }

    }

    public void Whats_New_Next() {
        FadeTransition ft_help_1 = new FadeTransition(Duration.seconds(1), description_1_help);
        FadeTransition ft_help_2 = new FadeTransition(Duration.seconds(1), description_2_help);
        FadeTransition ft_help_3 = new FadeTransition(Duration.seconds(1), description_3_help);
        FadeTransition ft_help_4 = new FadeTransition(Duration.seconds(1), description_4_help);

        ft_help_1.setFromValue(0);
        ft_help_1.setToValue(1);

        ft_help_1.setOnFinished(event -> {
            ft_help_2.setFromValue(0);
            ft_help_2.setToValue(1);

            ft_help_2.setOnFinished(event2 -> {
                ft_help_3.setFromValue(0);
                ft_help_3.setToValue(1);

                ft_help_3.setOnFinished(event3 -> {
                    ft_help_4.setFromValue(0);
                    ft_help_4.setToValue(1);

                    ft_help_4.setOnFinished(event4 -> {
                        whats_new_and_help.setText("Help");
                        whats_new_and_help.setDisable(false);
                    });

                    ft_help_4.play();
                });

                ft_help_3.play();
            });

            ft_help_2.play();
        });

        ft_help_1.play();
    }

    public void Help() {
        FadeTransition ft_des_1 = new FadeTransition(Duration.seconds(1), description_1);
        FadeTransition ft_des_2 = new FadeTransition(Duration.seconds(1), description_2);
        FadeTransition ft_des_3 = new FadeTransition(Duration.seconds(1), description_3);
        FadeTransition ft_des_4 = new FadeTransition(Duration.seconds(1), description_4);
        FadeTransition ft_des_5 = new FadeTransition(Duration.seconds(1), description_5);
        FadeTransition ft_des_6 = new FadeTransition(Duration.seconds(1), description_6);

        ft_des_1.setFromValue(0);
        ft_des_1.setToValue(1);

        ft_des_1.setOnFinished(event -> {
            ft_des_2.setFromValue(0);
            ft_des_2.setToValue(1);

            ft_des_2.setOnFinished(event2 -> {
                ft_des_3.setFromValue(0);
                ft_des_3.setToValue(1);

                ft_des_3.setOnFinished(event3 -> {
                    ft_des_4.setFromValue(0);
                    ft_des_4.setToValue(1);

                    ft_des_4.setOnFinished(event4 -> {
                        ft_des_5.setFromValue(0);
                        ft_des_5.setToValue(1);

                        ft_des_5.setOnFinished(event5 -> {
                            ft_des_6.setFromValue(0);
                            ft_des_6.setToValue(1);

                            ft_des_6.setOnFinished(event6 -> {
                                whats_new_and_help.setDisable(false);
                            });

                            ft_des_6.play();
                        });

                        ft_des_5.play();
                    });

                    ft_des_4.play();
                });

                ft_des_3.play();
            });

            ft_des_2.play();
        });

        ft_des_1.play();

    }

}