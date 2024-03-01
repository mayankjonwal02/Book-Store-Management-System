package com.mayank.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayank.book_store.entity.Book;

@Repository
public interface bookRepository extends JpaRepository<Book,Integer> {

}
