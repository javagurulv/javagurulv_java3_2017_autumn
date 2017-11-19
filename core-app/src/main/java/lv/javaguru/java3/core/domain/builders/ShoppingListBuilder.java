package lv.javaguru.java3.core.domain.builders;

import lv.javaguru.java3.core.domain.ShoppingList;
import lv.javaguru.java3.core.domain.User;

public class ShoppingListBuilder {

    private Long id;
    private User user;
    private String title;

    private ShoppingListBuilder() {}

    public static ShoppingListBuilder createShoppingList() {
        return new ShoppingListBuilder();
    }

    public ShoppingList build() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setId(id);
        shoppingList.setUser(user);
        shoppingList.setTitle(title);
        return shoppingList;
    }

    public ShoppingListBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ShoppingListBuilder with(User user) {
        this.user = user;
        return this;
    }

    public ShoppingListBuilder with(UserBuilder userBuilder) {
        this.user = userBuilder.build();
        return this;
    }

    public ShoppingListBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

}
