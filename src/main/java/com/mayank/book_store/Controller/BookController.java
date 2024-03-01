package com.mayank.book_store.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mayank.book_store.entity.Book;
import com.mayank.book_store.entity.MyBookList;
import com.mayank.book_store.service.MyBookListService;
import com.mayank.book_store.service.bookService;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BookController {


    @Autowired
    private bookService service;

    @Autowired
    private MyBookListService service2;


    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "bookRegister";
    }
    
    @GetMapping("/available_books")
    public ModelAndView availableBooks()
    {
        List<Book> list = service.getAllBooks();
        ModelAndView m = new ModelAndView();
        m.setViewName("availableBooks");
        m.addObject("books", list);
        return m;
    }

    @GetMapping("/available")
    @ResponseBody
    public Object getresp()
    {
        Map<String,Object> object = new HashMap<>();
        object.put("message", "hello mayank");
        object.put("books",service.getAllBooks());
        return object;
    }


    @PostMapping("/addbypost")
    @ResponseBody
    public Object postresp(@RequestBody Book b)
    {
        service.save(b);
        Map<String,Object> object = new HashMap<>();
        object.put("id", b.getId());
        object.put("name",b.getName());
        return object;
    }

    @GetMapping("/my_books")
    public ModelAndView myBooks()
    {
        List<MyBookList> list = service2.getMyAllBooks();
        ModelAndView m = new ModelAndView();
        m.setViewName("myBooks");
        m.addObject("books", list);
        return m;
    }

    @RequestMapping("/myrequest")
    public String myreq()
    {
        return "request1";
    }


    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        Book book = new Book("test", "test", "test");
        service.save(b);
       return "redirect:/available_books";
    }


    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id)
    {
        Book b = service.getBookById(id);
        MyBookList b1 = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        service2.savemybook(b1);
        return "redirect:/my_books";
    }


    @RequestMapping("/mydelete/{id}")
    public String deletebook(@PathVariable("id") int id)
    {
        service2.deleteById(id);
        return "redirect:/my_books";
    }
    
}
