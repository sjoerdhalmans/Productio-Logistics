package com.productio.logistics.dal;

import com.productio.logistics.models.Material;
import com.productio.logistics.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {
}
