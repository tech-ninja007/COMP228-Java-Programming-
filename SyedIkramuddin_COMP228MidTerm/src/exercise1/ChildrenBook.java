package exercise1;

public class ChildrenBook extends Book{
    public ChildrenBook(String title, String ISBN, String publisher, int year) {
        super(title, ISBN, publisher, year);
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getGenre() {
        return "Children";
    }
}
