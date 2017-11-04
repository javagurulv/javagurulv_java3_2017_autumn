package lv.javaguru.java3.core.domain.repositories;

import lv.javaguru.java3.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
