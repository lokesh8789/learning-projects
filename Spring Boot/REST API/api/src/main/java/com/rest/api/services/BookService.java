package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rest.api.dao.BookRepository;
import com.rest.api.entities.Book;

// @Component
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks()
    {
        return (List<Book>)bookRepository.findAll();
    }
    public Book getBookById(int id)
    {
        Book book=null;
        try {
            book=bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
    public Book addBook(Book b)
    {
        Book res=bookRepository.save(b);
        return res;
    }
    public void deleteBook(int id)
    {
        bookRepository.deleteById(id);
    }
    public void updateBook(int id,Book book)
    {
        book.setId(id);
        bookRepository.save(book);
    }
}

// private static List<Book> list=new ArrayList<>();
//     static{
//         list.add(new Book(12,"java","lokesh"));
//         list.add(new Book(13,"c++","ankit"));
//         list.add(new Book(14,"python","harsh"));
//     }
//     public List<Book> getAllBooks()
//     {
//         return list;
//     }
//     public Book getBookById(int id)
//     {
//         for(Book b:list)
//         {
//             if(b.getId()==id)
//             {
//                 return b;
//             }
//         }
//         //Book b=list.stream().filter(e->e.getId()==id).findFirst().get();
//         return null;
//     }
//     public Book addBook(Book b)
//     {
//         list.add(b);
//         return b;
//     }
//     public void deleteBook(int id)
//     {
//         // for(Book b:list)
//         // {
//         //     if(b.getId()==id)
//         //     {
//         //         list.remove(b);
//         //     }
//         // }
//         list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
//     }
//     public void updateBook(int id,Book book)
//     {
//         for (Book b: list) {
//             if(b.getId()==id)
//             {
//                 b.setTitle(book.getTitle());
//                 b.setAuthor(book.getAuthor());
//                 break;
//             }
//         }
//         // list=list.stream().map(e->{
//         //     if(e.getId()==id)
//         //     {
//         //         e.setTitle(book.getTitle());
//         //         e.setAuthor(book.getAuthor());
//         //     }
//         //     return e;
//         // }).collect(Collectors.toList());
