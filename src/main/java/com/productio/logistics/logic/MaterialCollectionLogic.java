package com.productio.logistics.logic;

import com.productio.logistics.dal.MaterialRepo;
import com.productio.logistics.dal.OrderRepo;
import com.productio.logistics.models.Material;
import com.productio.logistics.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialCollectionLogic {
    @Autowired
    MaterialRepo materialRepo;

    public List<Material> getAll() {
        return materialRepo.findAll();
    }
}
