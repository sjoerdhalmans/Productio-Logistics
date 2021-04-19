package com.productio.logistics.controllers;

import com.productio.logistics.logic.MaterialCollectionLogic;
import com.productio.logistics.logic.OrderCollectionLogic;
import com.productio.logistics.models.Material;
import com.productio.logistics.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MaterialController {
    @Autowired
    MaterialCollectionLogic materialCollectionLogic;

    //these are added straight in the database
    @GetMapping(value = "/getAllMaterials")
    public List<Material> getAll() {
        return materialCollectionLogic.getAll();
    }
}
