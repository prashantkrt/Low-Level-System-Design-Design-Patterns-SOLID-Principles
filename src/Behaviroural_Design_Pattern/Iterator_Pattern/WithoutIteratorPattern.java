package Behaviroural_Design_Pattern.Iterator_Pattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Book{

     private String title;

     public Book(String title){
         this.title = title;
     }

     public String getTitle(){
         return title;
     }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}

class BookCollection{

    //what if I wanted to make this List to Set
     private List<Book> books = new ArrayList<Book>();

    //have to make changes for iterating over the set interface
    // private Set<Book> books = new HashSet<>();

     public void addBook(Book book){
         books.add(book);
     }

    public List<Book> getBooks() {
        return books;
    }
}


public class WithoutIteratorPattern {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(new Book("Book 1"));
        bookCollection.addBook(new Book("Book 2"));
        bookCollection.addBook(new Book("Book 3"));

        //suppose I have changed the List to Set in that case we won't have the get(index) method
        for (int i = 0; i < bookCollection.getBooks().size(); i++) {
            System.out.println(bookCollection.getBooks().get(i).getTitle());
        }

    }
}
