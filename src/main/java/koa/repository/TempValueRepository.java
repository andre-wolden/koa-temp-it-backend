package koa.repository;

import koa.models.TempValue;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempValueRepository extends JpaRepository<TempValue, Long> {
}

