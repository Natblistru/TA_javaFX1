package edu.step.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class MainController {
    Boolean resultOperation=false;
    @FXML
    private TextField txtDisplay;

    @FXML
    void handleDigitAndOperationAction(ActionEvent event) {
        if(resultOperation){
            txtDisplay.clear();
            resultOperation=false;
        }
        String digit = ((Button) event.getSource()).getText();
        String oldText = txtDisplay.getText();
        if (oldText.startsWith("0") && !digit.matches(".*[+\\-*/].*") && !oldText.matches(".*[+\\-*/].*")){ // nu contine +-*/
            oldText = oldText.substring(1);
        }
        String newText = oldText + digit;
        txtDisplay.setText(newText);
    }
    @FXML
    void handleClearAction(ActionEvent event) {
        txtDisplay.clear();
    }

    public double[] parseParts(String[] parts) {
        String part1 = parts[0];
        String part2 = parts[1];
        double num1 = Double.parseDouble(part1);
        double num2 = Double.parseDouble(part2);
        return new double[] {num1, num2};
    }

    @FXML
    void handleEqualOperation(ActionEvent event) {
        Double num1,num2,result;
        DecimalFormat decimalFormat = new DecimalFormat("0.#"); // Formatare fara partea zecimala=0
        String inputText = txtDisplay.getText();
        if (inputText.contains("+")) {
            String[] parts = inputText.split("\\+");
            num1 = parseParts(parts)[0];
            num2 = parseParts(parts)[1];
            result=num1+num2;
            txtDisplay.setText(inputText + "="+ decimalFormat.format(result));
        }else if(inputText.contains("-")){
            String[] parts = inputText.split("-");
            num1 = parseParts(parts)[0];
            num2 = parseParts(parts)[1];
            result=num1-num2;
            txtDisplay.setText(inputText + "="+ decimalFormat.format(result));
        }else if(inputText.contains("/")){
            String[] parts = inputText.split("/");
            num1 = parseParts(parts)[0];
            num2 = parseParts(parts)[1];
            result=num1/num2;
            txtDisplay.setText(inputText + "="+ decimalFormat.format(result));
        }else if(inputText.contains("*")){
            String[] parts = inputText.split("\\*");
            num1 = parseParts(parts)[0];
            num2 = parseParts(parts)[1];
            result=num1*num2;
            txtDisplay.setText(inputText + "="+ decimalFormat.format(result));
        }
        resultOperation=true;

    }
}
