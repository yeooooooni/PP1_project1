package com.example.lab1;

import java.util.Scanner;

public class WordManager {
// 수정 삭제 메뉴 처리
/*
word CRUD를 사용한
 */
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;

    WordManager(){
        wordCRUD = new WordCRUD(s);
    }
    public int selectMenu(){
        System.out.println("*** 영단어 마스터 ***\n" +
                "********************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기 \n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기 *******************\n" +
                "=> 원하는 메뉴는?");
        return s.nextInt();
    }

    public void start(){
        int menu;
        boolean run = true;

        wordCRUD.load_file();

        while(run){
            menu = selectMenu();
            switch (menu){
                case 0 :
                    run = false;
                    System.out.println("프로그램 종료! 다음에 만나요~");
                    break;
                case 1:
                    wordCRUD.listAll();
                    break;
                case 2 :
                    wordCRUD.searchLevel();
                    break;
                case 3:
                    wordCRUD.search_word();
                    break;
                case 4:
                    wordCRUD.addWord();
                    break;
                case 5:
                    wordCRUD.updateItem();
                    break;
                case 6:
                    wordCRUD.deleteItem();
                    break;
                case 7:
                    wordCRUD.save_file();
                    break;
            }
        }
    }
    //select menu

}
