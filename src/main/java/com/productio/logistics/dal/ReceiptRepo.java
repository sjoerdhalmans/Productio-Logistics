package com.productio.logistics.dal;

import com.productio.logistics.models.OrderReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepo extends JpaRepository<OrderReceipt, Long> {
}
