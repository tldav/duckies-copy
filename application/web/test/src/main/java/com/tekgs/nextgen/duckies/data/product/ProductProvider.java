package com.tekgs.nextgen.duckies.data.product;

import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class ProductProvider {
    private final ProductRepository productRepository = ProductRepository.getInstance();

    public static ProductProvider getInstance() {
        return new ProductProvider();
    }

    public Product get() {
        return this.productRepository.query(ProductDefinition.getInstance());
    }

    public Product get(ProductDefinition productDefinition) {
        return this.productRepository.query(productDefinition);
    }

    public List<Product> getAll() {
        return this.productRepository.query();
    }

    public Product getOtherThan(List<CartItemCalibratable> items) {
        List<ProductCalibratable> existingProducts = new ArrayList<>();
        for (CartItemCalibratable item : items) {
            existingProducts.add(item.getProduct());
        }
        for (Product candidate : getAll()) {
            if (!existingProducts.contains(candidate)) {
                return candidate;
            }
        }
        return null;
    }
}
