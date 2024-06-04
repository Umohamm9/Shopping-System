package Final_Project;


public class ClothingFactory implements Product {

    private String Name;
    private double Price;
    private String Description;
    private int QuantityInStock;


    public ClothingFactory(String name, double price, String description, int quantityInStock) {

        this.Name = name;
        this.Price = price;
        this.Description = description;
        this.QuantityInStock = quantityInStock;

    }

    @Override

    public String getName() {

        return Name;

    }

    @Override

    public double getPrice() {

        return Price;

    }

    @Override

    public String getDescription() {

        return Description;

    }

    @Override

    public int getQuantityInStock() {

        return QuantityInStock;

    }

    public String toString() {
        return "ClothingFactory{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", description='" + getDescription() + '\'' +
                ", quantityInStock=" + getQuantityInStock() +
                '}';
    }

}

