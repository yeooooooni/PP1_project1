package com.example.lab1;

public class Word {
    //data class
    //id, level, string word, string mean
    private int id;
    private int level;
    private String word;
    private String mean;

    Word(){

    }
    Word(int id, int level, String word, String mean){
        this.id = id;
        this.level = level;
        this.word = word;
        this.mean = mean;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    //TODO
    //to string override

//    @Override
//    public String toString() {
//        String slevel = "";
//        for(int i=0; i<level; i++){
//            slevel += "*";
//        }
//        String list_string = String.format("%-3s", slevel) +
//                String.format("%15s", word)+ " " + mean;
//        return list_string;
//    }
}
