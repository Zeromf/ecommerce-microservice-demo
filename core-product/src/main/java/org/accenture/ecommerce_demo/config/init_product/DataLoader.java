package org.accenture.ecommerce_demo.config.init_product;

import org.accenture.ecommerce_demo.entity.Category;
import org.accenture.ecommerce_demo.entity.Product;
import org.accenture.ecommerce_demo.repository.ICategoryRepository;
import org.accenture.ecommerce_demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verificar y crear categorías si no existen
        if (!categoryRepository.existsByName("Electrodomésticos")) {
            Category category1 = new Category(1, "Electrodomésticos");
            categoryRepository.save(category1);
        }
        if (!categoryRepository.existsByName("Tecnología y Electrónica")) {
            Category category2 = new Category(2, "Tecnología y Electrónica");
            categoryRepository.save(category2);
        }
        if (!categoryRepository.existsByName("Moda y Accesorios")) {
            Category category3 = new Category(3, "Moda y Accesorios");
            categoryRepository.save(category3);
        }
        if (!categoryRepository.existsByName("Hogar y Decoración")) {
            Category category4 = new Category(4, "Hogar y Decoración");
            categoryRepository.save(category4);
        }
        if (!categoryRepository.existsByName("Salud y Belleza")) {
            Category category5 = new Category(5, "Salud y Belleza");
            categoryRepository.save(category5);
        }

        // Verificar y crear productos si no existen
        if (!productRepository.existsByName("Heladera samsung")) {
            Product product1 = new Product("Heladera samsung",
                    "308L Rt29k577js8 No Frost Ix Inv", 50.0, 1, 20,
                    "https://www.megatone.net/Images/Articulos/zoom2x/36/HEL2958SSG.jpg");
            productRepository.save(product1);
        }

        if (!productRepository.existsByName("Lg lavarropas automático")) {
            Product product2 = new Product("Lg lavarropas automático",
                    "LAvarropas automático WM-85VVC5S6P Inverter vivace 8.5 kg silver", 40.0, 1, 10,
                    "https://76338a6a.flyingcdn.com/44686-large_default/lg-lavarropas-autwm-85vvc5s6p-inverter-vivace-85kg-silver.jpg");
            productRepository.save(product2);
        }

        if (!productRepository.existsByName("Smart TV 50 pulgadas 4K")) {
            Product product3 = new Product("Smart TV 50 pulgadas 4K",
                    "Smart TV 50 Pulgadas 4K Ultra Hd", 40.0, 2, 5,
                    "https://www.megatone.net/Images/Articulos/zoom2x/253/TEL5006PHI.jpg");
            productRepository.save(product3);
        }

        if (!productRepository.existsByName("Zapatillas Reebok Mujer")) {
            Product product4 = new Product("Zapatillas Reebok Mujer",
                    "Reebok zapatillas mujer - Glide mujer ch. - Dk grey-green", 40.0, 5, 5,
                    "https://megasports.vteximg.com.br/arquivos/ids/224093-1000-1000/41104788055_0.jpg?v=638267497579500000");
            productRepository.save(product4);
        }
    }
}