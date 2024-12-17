package Behaviroural_Design_Pattern.Iterator_Pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//This Iterator already exists, so we can even ignore it and use existing one!!
//interface Iterator<T> {
//    public boolean hasNext();
//
//    public T next();
//}

class MyBook {

    private String title;

    public MyBook(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }

}

class MyBookCollection implements Iterable<MyBook> {

    private final List<MyBook> books = new ArrayList<>();
    private int position = 0;

    public void addBook(MyBook book) {
        books.add(book);
    }

    public List<MyBook> getBooks() {
        return books;
    }

    @Override
    public Iterator<MyBook> iterator() {
        return new MyBookIterator();
    }

    private class MyBookIterator implements Iterator<MyBook> {

        @Override
        public boolean hasNext() {
            return position < books.size();
        }

        @Override
        public MyBook next() {
            if (!hasNext()) {
                return null;
            }
            return books.get(position++);
        }
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        MyBookCollection myBookCollection = new MyBookCollection();
        myBookCollection.addBook(new MyBook("Book 1"));
        myBookCollection.addBook(new MyBook("Book 2"));
        myBookCollection.addBook(new MyBook("Book 3"));
        myBookCollection.addBook(new MyBook("Book 4"));
        myBookCollection.addBook(new MyBook("Book 5"));

        //Client code doesnot need to change as iteration logic is enclosed within the class itself
        Iterator<MyBook> myBookIterator = myBookCollection.iterator();
        while (myBookIterator.hasNext()) {
            MyBook book = myBookIterator.next();
            System.out.println(book.getTitle());
        }

    }
}
