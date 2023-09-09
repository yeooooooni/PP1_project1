package com.example.lab1;

public interface ICRUD {
    /*
    add() : int
    + update() : int
    + delete() : int
    + select(object o) : void
     */
    public Object add() ;
    public int update(Object obj);
    public int delete(Object obj);
    public void selectOne(int id);
}
