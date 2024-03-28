import java.io.*;

class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private String category;
    private double price;

    // Constructor
    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters and setters
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SerializationExample <filename>");
            return;
        }

        String filename = args[0];

        // Create a Product object
        Product product = new Product(1, "TV", "Electronics", 11999);

        // Serialize the object
        serializeProduct(product, filename);

        // Deserialize the object
        Product deserializedProduct = deserializeProduct(filename);
        
        // Print the deserialized object
        System.out.println("Deserialized Product:");
        System.out.println("ID: " + deserializedProduct.getId());
        System.out.println("Name: " + deserializedProduct.getName());
        System.out.println("Category: " + deserializedProduct.getCategory());
        System.out.println("Price: " + deserializedProduct.getPrice());
    }

    // Serialize Product object to a file
    public static void serializeProduct(Product product, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(product);
            out.close();
            fileOut.close();
            System.out.println("Product object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize Product object from a file
    public static Product deserializeProduct(String filename) {
        Product product = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            product = (Product) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Product object deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }
}

/*Output :-
javac .\SerializationExample.java
java SerializationExample product.ser

Product object serialized successfully.
Product object deserialized successfully.
Deserialized Product:
ID: 1
Name: TV
Category: Electronics
Price: 11999.00 
*/