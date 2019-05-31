package sample.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
public class Controller {
    @FXML
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    int num = 1;
    boolean finish;
    public void start() {
        finish = false;
        num = 1;
        clear(button1);
        clear(button2);
        clear(button3);
        clear(button4);
        clear(button5);
        clear(button6);
        clear(button7);
        clear(button8);
        clear(button9);
    }
    public void clear(Button b){
        b.setText("");
        b.setBlendMode(BlendMode.RED);
    }
    public void action(ActionEvent event) {
        if (!finish) {
            if (((Button) event.getTarget()).getText().equals("")) {
                if (num % 2 == 1) {
                    ((Button) event.getTarget()).setText("X");
                } else {
                    ((Button) event.getTarget()).setText("O");
                }
            }
            if (num > 4) {
                checker(button1, button2, button3);
                checker(button1, button5, button9);
                checker(button1, button4, button7);
                checker(button3, button5, button7);
                checker(button4, button5, button6);
                checker(button7, button8, button9);
                checker(button2, button5, button8);
                checker(button3, button6, button9);
            }
            if (num == 9) {
                System.out.println("ничья");
            }
            ++num;
        }
    }
    private void checker(Button b1, Button b2, Button b3) {
        if (b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText())) {
            if (!b1.getText().equals("")) {
                b1.setBlendMode(BlendMode.MULTIPLY);
                b2.setBlendMode(BlendMode.MULTIPLY);
                b3.setBlendMode(BlendMode.MULTIPLY);
                finish = true;
            }
        }
    }
}