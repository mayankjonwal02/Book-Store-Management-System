package com.mayank.book_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.book_store.entity.MyBookList;
import com.mayank.book_store.repository.MyBooksRepository;

@Service
public class MyBookListService {

    @Autowired
    private MyBooksRepository mybookrepo;

    public void savemybook(MyBookList book)
    {
        mybookrepo.save(book);
    }

    public List<MyBookList> getMyAllBooks()
    {
        return mybookrepo.findAll();
    }

    public void deleteById(int id)
    {
        mybookrepo.deleteById(id);
    }

}
