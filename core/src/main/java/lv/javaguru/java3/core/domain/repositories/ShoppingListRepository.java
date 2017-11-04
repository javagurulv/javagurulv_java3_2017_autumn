package lv.javaguru.java3.core.domain.repositories;

import lv.javaguru.java3.core.domain.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

}
