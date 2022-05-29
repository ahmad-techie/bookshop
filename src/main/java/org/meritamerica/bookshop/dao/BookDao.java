package org.meritamerica.bookshop.dao;

import org.meritamerica.bookshop.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class BookDao {
    private List<Book> bookList;

    public BookDao() {
        this.bookList = new ArrayList<>();
    }


    public List<Book> getAllBooks(){
        return bookList;
    }

    public Book addBook(Book book){
        bookList.add(book);
        return book;
    }

    public Book getBookById(int id){
        for (Book book :bookList){
            if (book.getId() == id){
                return book;
            }
        }

        return null;
    }

    public void deleteBook(int id){
        for (Book book :bookList){
            if (book.getId() == id){
                bookList.remove(book);
                break;
            }
        }
    }

    public void updateBook(Book updatedBook, int id){
       for (int i = 0; i<bookList.size(); i++){
           if (bookList.get(i).getId()==id){
               bookList.set(i, updatedBook);
               break;
           }
       }
    }

}
