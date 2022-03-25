package com.richieoscar.shopaholic.repositories;

import com.richieoscar.shopaholic.entities.AppUser;
import com.richieoscar.shopaholic.entities.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Long> {

    List<UserOrder> findByUser(AppUser user);
}
