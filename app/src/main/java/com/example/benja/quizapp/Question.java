/*package com.example.benja.quizapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Question implements Parcelable {
    private String question;
    private List<String> choices = new ArrayList<>(4);
    private String correctChoice;
    private int correctIndex;
    private String selectedChoice;
    private int selectedIndex;

    public Question(){
        selectedChoice = null;
        selectedIndex = -1;
    }

    // mutator methods
    public void setQuestion(String q){
        question = q;
    }
    public void setChoices(String c){
        choices.add(c);
    }
    public void setCorrectChoice(String c){
        correctChoice = c;
        shuffleChoices();
        correctIndex = getChoiceIndex(correctChoice);
    }

    public void setSelectedChoice(String s) {
        if(s.equals("null")){
            selectedChoice = "null";
            selectedIndex = -1;
        }
        selectedChoice = s;
        selectedIndex = getChoiceIndex(selectedChoice);
    }

    // accessor methods
    public String getQuestion(){
        return question;
    }
    public List getChoices(){
        return choices;
    }
    public String getCorrectChoice(){
        return correctChoice;
    }
    public int getCorrectIndex(){
        return correctIndex;
    }
    public int getChoiceIndex(String c){
        return choices.indexOf(c);
    }
    public String getSelectedChoice() {
        return selectedChoice;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    // shuffles answers
    public void shuffleChoices(){
        Collections.shuffle(choices);
        correctIndex = getChoiceIndex(correctChoice);
    }

    protected Question(Parcel in) {
        question = in.readString();
        if (in.readByte() == 0x01) {
            choices = new ArrayList<String>();
            in.readList(choices, String.class.getClassLoader());
        } else {
            choices = null;
        }
        correctChoice = in.readString();
        correctIndex = in.readInt();
        selectedChoice = in.readString();
        selectedIndex = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        if (choices == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(choices);
        }
        dest.writeString(correctChoice);
        dest.writeInt(correctIndex);
        dest.writeString(selectedChoice);
        dest.writeInt(selectedIndex);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
*/