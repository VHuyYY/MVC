package ModelTest.Model;

public class Product {
    private int id;
    private String name;
    private double price;
    private static int idIncrement = 1;

    public Product(String name, double price) {
        this.id = idIncrement;
        this.name = name;
        this.price = price;
        idIncrement++;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "; Name: " + this.name + "; Price: " + this.price;
    }
}
