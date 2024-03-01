package com.mayank.book_store.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.book_store.entity.Book;
import com.mayank.book_store.repository.bookRepository;

@Service
public class bookService {

    @Autowired
    private bookRepository bRepo;

    public void save(Book b)
    {
        if(b.getId() == 0 )
        {
            b.setId(0);
        }
        bRepo.save(b);
    }


    public java.util.List<Book> getAllBooks()
    {
        return bRepo.findAll();
    }

    public Book getBookById(int id)
    {
        return bRepo.findById(id).get();
    }

}
