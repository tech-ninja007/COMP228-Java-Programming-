package exercise1;

public abstract class Book {
    String title;
    String ISBN;
    String publisher;
    double price;
    int year;

    public Book(String title, String ISBN, String publisher, int year) {
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract void setPrice(double price);
    public abstract String getGenre();

    @Override
    public String toString() {
        return  "\nTitle= " + title +
                "\nISBN= " + ISBN  +
                "\nPublisher= " + publisher +
                "\nPrice= " + price +
                "\nYear= " + year;
    }
}
