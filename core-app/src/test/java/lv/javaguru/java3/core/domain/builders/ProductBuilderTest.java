package lv.javaguru.java3.core.domain.builders;

import lv.javaguru.java3.core.domain.Product;
import org.junit.Test;

import static lv.javaguru.java3.core.domain.builders.ProductBuilder.createProduct;
import static lv.javaguru.java3.core.domain.builders.ShoppingListBuilder.createShoppingList;
import static lv.javaguru.java3.core.domain.builders.UserBuilder.createUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ProductBuilderTest {

    @Test
    public void shouldBuildProductWithShoppingListAndUser() {
        Product product = createProduct()
                .withId(1L)
                .withTitle("product_title")
                .withDescription("description")
                .with(createShoppingList()
                        .withId(1L)
                        .with(createUser()
                                .withId(1L)
                                .withLogin("login")
                                .withPassword("password")
                                .withEmail("email"))
                        .withTitle("shopping_list_title"))
                .build();
        assertThat(product.getId(), is(1L));
        assertThat(product.getTitle(), is("product_title"));
        assertThat(product.getDescription(), is("description"));
        assertThat(product.getShoppingList(), is(notNullValue()));
        assertThat(product.getShoppingList().getId(), is(1L));
        assertThat(product.getShoppingList().getTitle(), is("shopping_list_title"));
        assertThat(product.getShoppingList().getUser(), is(notNullValue()));
        assertThat(product.getShoppingList().getUser().getId(), is(1L));
        assertThat(product.getShoppingList().getUser().getLogin(), is("login"));
        assertThat(product.getShoppingList().getUser().getPassword(), is("password"));
        assertThat(product.getShoppingList().getUser().getEmail(), is("email"));
    }

}
