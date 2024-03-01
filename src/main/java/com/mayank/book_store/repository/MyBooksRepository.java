package com.mayank.book_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mayank.book_store.entity.MyBookList;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBookList,Integer>
{

}
