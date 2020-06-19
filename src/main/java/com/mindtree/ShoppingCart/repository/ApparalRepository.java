package com.mindtree.ShoppingCart.repository;


import com.mindtree.ShoppingCart.entity.ApparalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApparalRepository extends JpaRepository<ApparalEntity,Integer> {
}
