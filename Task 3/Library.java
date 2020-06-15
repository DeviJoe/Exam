import java.util.*;

public class Library {

    /**
     * Класс описывает 1 экземпляр книги
     */
    protected class Book {
        String bookName;
        String author;
        int year;

        public Book(String bookName, String author, int year) {
            this.bookName = bookName;
            this.author = author;
            this.year = year;
        }
    }

    // Массив со всеми книгами
    List dataBase = new ArrayList();

    public void add(String bookName, String author, int year) {
        dataBase.add(new Book(bookName, author, year));
    }

    public void sort() {
        Collections.sort(dataBase, author);
        Collections.sort(dataBase, year);
    }



    Comparator<Book> author = new Comparator<Book>() {
        public int compare(Book o1, Book o2) {
            int i = 0;
            while (o1.author.charAt(i) != ' ') {
                i++;
            }
            String surname1 = o1.author.substring(0, i);

            i = 0;
            while (o2.author.charAt(i) != ' ') {
                i++;
            }
            String surname2 = o2.author.substring(0, i);

            if (surname1.equals(surname2)) {
                return -1;
            } else return 0;
        }
    };

    Comparator<Book> year = new Comparator<Book>() {
        public int compare(Book o1, Book o2) {
            int i = 0;
            while (o1.author.charAt(i) != ' ') {
                i++;
            }
            String surname1 = o1.author.substring(0, i);

            i = 0;
            while (o2.author.charAt(i) != ' ') {
                i++;
            }
            String surname2 = o2.author.substring(0, i);

            if (surname1.equals(surname2)) {
                if (o1.year == o2.year) {
                    return 0;
                } else if (o1.year > o2.year) {
                    return -1;
                } else return 1;
            } else return -2;
        }
    };
    
}
