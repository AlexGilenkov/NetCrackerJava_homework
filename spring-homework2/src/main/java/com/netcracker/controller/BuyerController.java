package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Buyer;
import com.netcracker.repository.BuyerRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.PatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    PatchService patchService;

    @GetMapping("/buyers")
    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }

    @GetMapping("/buyers/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Buyer buyer = searchBuyer(id);

        return  ResponseEntity.ok().body(buyer);
    }

    @PostMapping("/buyers")
    public Buyer addBuyer(@RequestBody Buyer buyer){
        return buyerRepository.save(buyer);
    }

    @DeleteMapping("/buyers/{id}")
    public ResponseEntity<DeleteResponse> deleteBuyer(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Buyer buyer = searchBuyer(id);

        buyerRepository.delete(buyer);

        return  ResponseEntity.ok().body(
                new DeleteResponse("Buyer with number: " + id + " deleted"));
    }

    @PutMapping("/buyers")
    public Buyer putBuyerById(@RequestBody Buyer b) throws ResourceNotFoundException {
        Buyer buyer = searchBuyer(b.getId());

        buyerRepository.delete(buyer);

        return buyerRepository.save(b);
    }

    @PatchMapping("/buyers")
    public Buyer patchBuyerById(@RequestBody Buyer b) throws ResourceNotFoundException {
        Buyer buyer = searchBuyer(b.getId());

        return buyerRepository.save(patchService.patchBuyer(buyer, b));
    }

    private Buyer searchBuyer(Integer id) throws ResourceNotFoundException {
        return buyerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Buyer not found for id = " + id));
    }

}
