package com.example.lab1;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    /*
    word를 담는 list 만들기
    word의 정보를 받은 add
    word를 arraylist에 넣기
     */
    ArrayList <Word> list;
    Scanner s;

    WordCRUD(Scanner s){ // 왜 여기서 scanner를 굳이 받을까?
        list = new ArrayList<>();
        this.s = s;
    }
    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력: ");
        int new_level = s.nextInt();
        String new_word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String new_meaning = s.nextLine();

        return new Word(0, new_level, new_word, new_meaning);
    }

    public void addWord(){
        Word tmp = (Word)add();
        list.add(tmp);
        System.out.println("새 단어가 단어장에 추가되었습니다!");
    }
    public void listAll(){
        System.out.println("--------------------------------");

        for(int i=0; i<list.size(); i++){
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }

        System.out.println("--------------------------------");
    }
    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
    //list all 모든 단어 출력
    //word object에서 자신의 데이터를 출력할 수 있는 함수를 구현, tostring을 override하기
    // updateItem 함수 생성
    // delete Item 함수 생성
    // create word 추가
    // read word 조회
}
