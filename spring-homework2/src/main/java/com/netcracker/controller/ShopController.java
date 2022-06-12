package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Book;
import com.netcracker.model.Shop;
import com.netcracker.repository.ShopRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.PatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    PatchService patchService;

    @GetMapping("/shops")
    public List<Shop> getAllBooks(){
        return shopRepository.findAll();
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Shop shop = searchShop(id);

        return  ResponseEntity.ok().body(shop);
    }

    @PostMapping("/shops")
    public Shop addShop(@RequestBody Shop shop){
        return shopRepository.save(shop);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<DeleteResponse> deleteShop(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Shop shop = searchShop(id);

        shopRepository.delete(shop);

        return  ResponseEntity.ok().body(
                new DeleteResponse("Shop with id: " + id + " deleted"));
    }

    @PutMapping("/shops")
    public Shop putShopById(@RequestBody Shop s) throws ResourceNotFoundException {
        Shop shop = searchShop(s.getId());

        shopRepository.delete(shop);

        return shopRepository.save(s);
    }

    @PatchMapping("/shops")
    public Shop patchShopById(@RequestBody Shop s) throws ResourceNotFoundException {
        Shop shop = searchShop(s.getId());

        return shopRepository.save(patchService.patchShop(shop, s));
    }


    private Shop searchShop(Integer id) throws ResourceNotFoundException {
        return shopRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Shop not found for id = " + id));
    }

}
