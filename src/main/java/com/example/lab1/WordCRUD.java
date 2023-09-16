package com.example.lab1;
import java.io.*;
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
    String fname = "dictionary.txt";

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
    public ArrayList<Integer> listAll(String search_word){
        System.out.println("--------------------------------");
        ArrayList <Integer> search_list = new ArrayList<>();

        int j = 0;
        String contain_word;
        for(int i=0; i<list.size(); i++){
            if((list.get(i).toString()).contains(search_word)){
                contain_word = list.get(i).toString();
                System.out.print((j+1) + " ");
                System.out.println(contain_word);
                search_list.add(i);
                j++;
            }
        }

        System.out.println("--------------------------------");

        return search_list;
    }
    public void listALL(int level){
        System.out.println("--------------------------------");

        int j = 0;
        String contain_word;
        for(int i=0; i<list.size(); i++){
            if((list.get(i).getLevel()) == level){
                contain_word = list.get(i).toString();
                System.out.print((j+1) + " ");
                System.out.println(contain_word);
                j++;
            }
        }

        System.out.println("--------------------------------");
    }

    public int search_word(){
        System.out.println("=> 검색할 단어 입력 : t");

        String search_word = s.next();
        ArrayList <Integer> index_list = this.listAll(search_word);
        return 1;

    }

    public int updateItem(){
        System.out.print("=> 수정할 단어 검색 : ");

        String search_word = s.next();
        ArrayList <Integer> index_list = this.listAll(search_word);

        System.out.print("=> 수정할 번호 선택 : ");
        int index = s.nextInt();
        s.nextLine();
        Word updateWord = list.get(index_list.get(index-1));

        System.out.print("=> 뜻 입력 : ");
        String update_mean = s.nextLine();
        updateWord.setMean(update_mean);

        System.out.println("단어 수정이 성공적으로 되었습니다!!");
        return 0;
    }

    public int deleteItem(){
        /*
        => 삭제할 단어 검색 : er
        --------------------------------
        1 * transfer 옮기다, 이동하다
        2 * scatter 흩뿌리다, 살포하다
        --------------------------------
        => 삭제할 번호 선택 : 1
        => 정말로 삭제하실래요?(Y/n) Y
        선택한 단어 삭제 완료 !!!
         */
        System.out.print("=> 삭제할 단어 검색 : ");

        String search_word = s.next();
        ArrayList <Integer> index_list = this.listAll(search_word);

        System.out.print("=> 삭제할 번호 선택 : ");
        int index = s.nextInt();
        s.nextLine();

        System.out.print("=> 정말로 삭제하실래요?(Y/n) ");
        if((s.nextLine()).equalsIgnoreCase("y")){
            list.remove((int)(index_list.get(index-1)));
            System.out.println("선택한 단어 삭제 완료 !!!");
        }
        else{
            System.out.println("단어 삭제 취소 !!!");
        }

        return 0;
    }
    public int load_file(){
        int count = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            while((line = br.readLine()) != null){
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                list.add(new Word(0, level, data[1], data[2]));
                count ++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("=> "+ count +"개 단어 로딩 완료! ");
        return 0;
    }

    public int save_file(){
        try{
            PrintWriter pr = new PrintWriter(new FileWriter(fname));

            for( Word one : list){
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("데이터 저장 완료!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public void searchLevel(){
        System.out.print("=> 레벨(1:초급, 2:중급, 3:고급) 선택 :");
        int input_level = s.nextInt();

        listALL(input_level);
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
