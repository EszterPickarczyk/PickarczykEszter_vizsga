import org.w3c.dom.ranges.RangeException;

public abstract class Rekord {

    private String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public Rekord(String ISBN) {
        this.ISBN = ISBN;
    }

    public Rekord() {
    }

    public void setISBN(String ISBN) {
        if(ISBN.length()==10 || ISBN.length()==13 ){
        this.ISBN = ISBN;}
        else System.out.println("Az ISBN értéke csak 10 vagy 13 hosszú számsor lehet");
    }
}
