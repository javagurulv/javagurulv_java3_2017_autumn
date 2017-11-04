package lv.javaguru.java3.core.domain.builders;

import lv.javaguru.java3.core.domain.Product;
import lv.javaguru.java3.core.domain.ShoppingList;

public class ProductBuilder {

    private Long id;
    private ShoppingList shoppingList;
    private String title;
    private String description;

    private ProductBuilder() { }

    public static ProductBuilder createProduct() {
        return new ProductBuilder();
    }

    public Product build() {
        Product product = new Product();
        product.setShoppingList(shoppingList);
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        return product;
    }

    public ProductBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder with(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
        return this;
    }

    public ProductBuilder with(ShoppingListBuilder shoppingListBuilder) {
        this.shoppingList = shoppingListBuilder.build();
        return this;
    }

    public ProductBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

}
