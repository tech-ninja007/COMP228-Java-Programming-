package excerise1;

import javax.swing.*;

public class Test {
    Question question1;
    Question question2;
    Question question3;
    Question question4;
    Question question5;

    Test(){
        question1 = new Question(
                "\n What is the variables declared in a class for the use of all methods of the class called?",
                "b) instance variables",
                new String[]{" a) reference variables",  "b) instance variables" ,"c) methods ", "d) static variables"});
        question2 = new Question(
                "\n Identify the return type of a method that does not return any value.",
                        "c) void", new String[]{"a) int", "b) float", "c) void", "d) boolean"});
        question3 = new Question(
                "\n In which of the following is toString() method defined",
                "a) java.lang.Object",
                new String[]{"a) java.lang.Object", "b) java.lang.String", "c) java.lang.util", "d) None"});
        question4 = new Question(
                "\n Output of Math.floor(3.6)",
                "b) 3.0",
                new String[]{"a) 3", "b) 3.0", "c) 4.0", "d) 4"});
        question5 = new Question(
                "\n Identify the modifier which cannot be used for constructor",
                "d) static",
                new String[]{"a) public", "b) private", "c)protected" ,"d) static"});
    }
    Question simulateQuestion(int questionNo){
        Question tempQuestion =null;
        switch (questionNo){
            case 1:
                tempQuestion = question1;
                break;
            case 2:
                tempQuestion = question2;
                break;
            case 3:
                tempQuestion= question3;
                break;
            case 4:
                tempQuestion= question4;
                break;
            case 5:
                tempQuestion= question5;
                break;
        }
        return tempQuestion;

    }

    int checkAnswer(int option, int questionNo){
        int flag = 0;
        if(questionNo == 1){
            if(question1.options[option].equals(question1.getAnswer()))
                flag = 1;
        }
        else if(questionNo == 2){
            if(question2.options[option].equals(question2.getAnswer()))
                flag = 1;
        }
        else if(questionNo == 3){
            if(question3.options[option].equals(question3.getAnswer()))
                flag = 1;
        }
        else if(questionNo == 4){
            if(question4.options[option].equals(question4.getAnswer()))
                flag = 1;
        }
        else{
            if(question5.options[option].equals(question5.getAnswer()))
                flag = 1;
        }
        return flag;
    }
    String generateMessage(int flag){
        String[] correct = {"Excellent","Keep up the Good Work!", "Good Job!", "Nice Work!"};
        String[] wrong = {"Wrong", "Try Again", "No. Please Try Again", "Dont Give Up", "No. Please, keep trying"};
        double randomNumber = Math.floor((Math.random() * 10)%4);
        if(flag == 1){
            if(randomNumber == 0.0)
                return correct[0];
            else if(randomNumber == 1.0)
                return correct[1];
            else if(randomNumber == 2.0)
                return correct[2];
            else
                return correct[3];
        }
        else{
            if(randomNumber == 0.0)
                return wrong[0];
            else if(randomNumber == 1.0)
                return wrong[1];
            else if(randomNumber == 2.0)
                return wrong[2];
            else
                return wrong[3];
        }
    }
    void inputAnswer(){
        int x, score=0;
        String message;
        Question tempQuestion;
        for(int i=1;i<=5;i++) {
            tempQuestion = simulateQuestion(i);
            if(tempQuestion == null)
                break;
            String[] options= tempQuestion.getOptions();
            x = JOptionPane.showOptionDialog(null, tempQuestion.getPrompt(),
                    "question" + i,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            message = generateMessage(checkAnswer(x,i));
            if(checkAnswer(x,i)==1)
                score++;

            JOptionPane.showMessageDialog(null, "your option is " + options[x]+"\n"+ message);

        }
        JOptionPane.showMessageDialog(null,"Your Test is completed.\nYour score is "+score);
    }

}
