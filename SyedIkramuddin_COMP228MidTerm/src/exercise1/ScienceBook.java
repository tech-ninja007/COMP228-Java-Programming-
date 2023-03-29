package exercise1;

public class ScienceBook extends Book {

    public ScienceBook(String title, String ISBN, String publisher, int year) {
        super(title, ISBN, publisher, year);
    }

    @Override
    public void setPrice(double price) {
        this.price = price - (price*0.1);
    }

    @Override
    public String getGenre() {
        return "Science";
    }
}
