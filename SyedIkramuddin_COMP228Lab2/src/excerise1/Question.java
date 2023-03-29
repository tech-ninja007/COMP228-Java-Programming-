package excerise1;

public class Question {
    String prompt;
    String answer;
    String[] options;

    Question(){}
    Question (String prompt, String answer, String[] options){
        this.prompt = prompt;
        this.answer = answer;
        this.options= options;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
