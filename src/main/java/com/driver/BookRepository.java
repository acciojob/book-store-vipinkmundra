package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    HashMap<Integer,Book> hm = new HashMap<>();
    public BookRepository(){

    }

    public Book save(Book book){
        int id = book.getId();
        hm.put(id,book);
        return book;
    }

    public Book findBookById(int id){
        if(hm.containsKey(id)){
            return hm.get(id);
        }else{
            return null;
        }
    }

    public List<Book> findAll(){
        List<Book> list = new ArrayList<>();
        for(int id : hm.keySet()){
            list.add(hm.get(id));
        }
        return list;
    }

    public void deleteBookById(int id){
        if(hm.containsKey(id)){
            hm.remove(id);
        }
    }

    public void deleteAll(){
        hm.clear();;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> list = new ArrayList<>();
        for(Map.Entry<Integer,Book> it : hm.entrySet()){
            if(it.getValue().getAuthor().equals(author)){
                list.add(it.getValue());
            }
        }
        return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list = new ArrayList<>();
        for(Map.Entry<Integer,Book> it : hm.entrySet()){
            if(it.getValue().getGenre().equals(genre)){
                list.add(it.getValue());
            }
        }
        return list;
    }
}
