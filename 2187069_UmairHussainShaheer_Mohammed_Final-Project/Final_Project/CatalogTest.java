package Final_Project;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.List;

public class CatalogTest {

    @Test
    public void testAddProduct() {

        ProductCatalog ProductsCatalog = new ProductCatalog();

        Product SmartWatch = new ElectronicFactory("Smartwatch", 199.99, "Fitness and health tracker", 15);

        ProductsCatalog.addProduct(SmartWatch);

        assertEquals(1, ProductsCatalog.getAllProducts().size());

        assertEquals(SmartWatch, ProductsCatalog.getProductByName("Smartwatch"));

    }

    @Test

    
    public void testAddProducts() {

        ProductCatalog ProductsCatalog = new ProductCatalog();

        List<Product> newProducts = new ArrayList<>();

        Product SmartPhone = new ClothingFactory("Smartphone", 799.99, "Flagship smartphone with advanced features", 12);

        newProducts.add(SmartPhone);

        ProductsCatalog.addProducts(newProducts);

        assertEquals(1, ProductsCatalog.getAllProducts().size());

        assertEquals(SmartPhone, ProductsCatalog.getProductByName("Smartphone"));

    }

    @Test
    public void testGetProductByName() {

        ProductCatalog productCatalog = new ProductCatalog();

        Product Hoodie = new ElectronicFactory("Hoodie", 29.99, "Comfortable fleece hoodie", 40);

        productCatalog.addProduct(Hoodie);

        assertEquals(Hoodie, productCatalog.getProductByName("Hoodie"));

        assertNull(productCatalog.getProductByName("NonexistentProduct"));

    }

}
