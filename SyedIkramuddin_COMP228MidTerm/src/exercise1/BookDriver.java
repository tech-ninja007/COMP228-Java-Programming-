package exercise1;

import javax.swing.*;

public class BookDriver {
    public static void main(String[] args){
        System.out.println("Welcome to MidTermExam");
        JOptionPane.showMessageDialog(null, "Welcome to Mid Term Lab \nEnter 2 Book details");
        Book[] book= new Book[2];
        for(int i = 0; i<2; i++) {
            /*
            String titleField = JOptionPane.showInputDialog("Enter the Title:");
            String ISBNField = JOptionPane.showInputDialog("Enter the ISBN value:");
            String publisherField = JOptionPane.showInputDialog("Enter the Publisher:");
            String priceField = JOptionPane.showInputDialog("Enter the Price:");
            String yearfield = JOptionPane.showInputDialog("Enter the Year value:");
            */
            // Here we are taking input all at once
            JTextField titleField = new JTextField();
            JTextField ISBNField = new JTextField();
            JTextField publisherField = new JTextField();
            JTextField priceField = new JTextField();
            JTextField yearfield = new JTextField();
            Object[] message = {
                    "Enter the Title:", titleField,
                    "Enter the ISBN value:", ISBNField,
                    "Enter the Publisher:", publisherField,
                    "Enter the Price value:", priceField,
                    "Enter the Year value:", yearfield,
            };
            int option;
            if(i == 0){
                option = JOptionPane.showConfirmDialog(null, message, "Enter Science Book values", JOptionPane.OK_CANCEL_OPTION);
            }
            else{
                option = JOptionPane.showConfirmDialog(null, message, "Enter Children Book values", JOptionPane.OK_CANCEL_OPTION);
            }
            if (option == JOptionPane.OK_OPTION) {
                String title = titleField.getText();
                String ISBN = ISBNField.getText();
                String publisher = publisherField.getText();
                double price = Double.parseDouble(priceField.getText());
                int year = Integer.parseInt(yearfield.getText());
                if(i == 0){
                    book[i] = new ScienceBook(title, ISBN, publisher,year);
                    book[i].setPrice(price);
                }
                else{
                    book[i] = new ChildrenBook(title, ISBN, publisher, year);
                    book[i].setPrice(price);
                }
                //JOptionPane.showMessageDialog(null, title + " " + ISBN + " " + publisher + " " + price + " " + year);
            }
            else {
                JOptionPane.showMessageDialog(null,"You clicked cancel!");
                continue;
            }
        }

        JOptionPane.showMessageDialog(null, book[0].getGenre()+" Book"+ book[0]+"\n\n\n"
                                                    +book[1].getGenre()+" Book"+ book[1]);

    }
}
