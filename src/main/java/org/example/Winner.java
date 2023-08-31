package org.example;

public class Winner {

    public String hasComputerWon(String message){

        if (message.isEmpty()){
            return  "Congratulations! You won! The computer can't find the next move.";
        }else{
            return "";
        }

    }

    public String userHasGivenUp(String textFromTextField){

        if (textFromTextField.equals("I give up")) {
            return "Computer won!";
        }else{
            return "";
        }

    }
}
