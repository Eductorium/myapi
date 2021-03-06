package ru.mtuci.myapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mtuci.myapi.model.Product;

@Transactional(readOnly = true)
// https://stackoverflow.com/questions/44409120/what-is-the-difference-between-transactional-and-transactionalreadonly-true
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.id=:id")
    int delete(@Param("id") Long id);
}
