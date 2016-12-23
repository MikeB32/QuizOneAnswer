package am.tsd.inchuner.program26.utils;

/**
 * Created by araratm on 7/28/16.
 */
public class Question {

    private String question;
    private String answerTrue;
    private String answerWrong1;
    private String answerWrong2;
    private String answerWrong3;

    public Question(String question, String answerTrue, String answerWrong1, String answerWrong2, String answerWrong3){
        this.question = question;
        this.answerTrue = answerTrue;
        this.answerWrong1 = answerWrong1;
        this.answerWrong2 = answerWrong2;
        this.answerWrong3 = answerWrong3;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(String answerTrue) {
        this.answerTrue = answerTrue;
    }

    public String getAnswerWrong1() {
        return answerWrong1;
    }

    public void setAnswerWrong1(String answerWrong1) {
        this.answerWrong1 = answerWrong1;
    }

    public String getAnswerWrong2() {
        return answerWrong2;
    }

    public void setAnswerWrong2(String answerWrong2) {
        this.answerWrong2 = answerWrong2;
    }

    public String getAnswerWrong3() {
        return answerWrong3;
    }

    public void setAnswerWrong3(String answerWrong3) {
        this.answerWrong3 = answerWrong3;
    }

}
