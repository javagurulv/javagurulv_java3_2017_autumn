package lv.javaguru.java3.core.domain.builders;

import lv.javaguru.java3.core.domain.ShoppingList;
import org.junit.Test;

import static lv.javaguru.java3.core.domain.builders.ShoppingListBuilder.createShoppingList;
import static lv.javaguru.java3.core.domain.builders.UserBuilder.createUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ShoppingListBuilderTest {

    @Test
    public void shouldCreateShoppingListWithUser() {
        ShoppingList shoppingList = createShoppingList()
                .withId(1L)
                .with(createUser()
                        .withId(1L)
                        .withLogin("login")
                        .withPassword("password")
                        .withEmail("email"))
                .withTitle("shopping_list_title")
                .build();
        assertThat(shoppingList.getId(), is(1L));
        assertThat(shoppingList.getTitle(), is("shopping_list_title"));
        assertThat(shoppingList.getUser(), is(notNullValue()));
        assertThat(shoppingList.getUser().getId(), is(1L));
        assertThat(shoppingList.getUser().getLogin(), is("login"));
        assertThat(shoppingList.getUser().getPassword(), is("password"));
        assertThat(shoppingList.getUser().getEmail(), is("email"));
    }

}
