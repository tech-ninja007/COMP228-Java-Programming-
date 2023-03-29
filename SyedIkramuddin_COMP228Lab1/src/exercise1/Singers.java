package exercise1;

import java.time.LocalDate;

public class Singers {
    int singerId;
    String singerName;
    String singerAddress;
    LocalDate dateOfBirth;
    int numberOfAlbumsPublished;

    Singers(){}

    Singers(int singerId, String singerName, String singerAddress,
            LocalDate dateOfBirth, int numberOfAlbumsPublished){
        this.singerName = singerName;
        this.singerId = singerId;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerAddress() {
        return singerAddress;
    }

    public void setSingerAddress(String singerAddress) {
        this.singerAddress = singerAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumberOfAlbumsPublished() {
        return numberOfAlbumsPublished;
    }

    public void setNumberOfAlbumsPublished(int numberOfAlbumsPublished) {
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }

    public void setSinger(int singerId, String singerName, String singerAddress,
                          LocalDate dateOfBirth, int numberOfAlbumsPublished){
        this.singerName = singerName;
        this.singerId = singerId;
        this.singerAddress = singerAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbumsPublished = numberOfAlbumsPublished;
    }

    @Override
    public String toString() {
        return
                " singerId=" + singerId +
                "\n singerName='" + singerName + '\'' +
                "\n singerAddress='" + singerAddress + '\'' +
                "\n dateOfBirth=" + dateOfBirth+
                "\n numberOfAlbumsPublished=" + numberOfAlbumsPublished ;
    }
}
