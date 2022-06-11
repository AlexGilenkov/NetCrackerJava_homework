package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Buy;
import com.netcracker.repository.BuyRepository;
import com.netcracker.response.DeleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buys-controller")
public class BuyController {

    @Autowired
    BuyRepository buyRepository;

    @GetMapping("/buys")
    public List<Buy> getAllBuys(){
        return buyRepository.findAll();
    }

    @GetMapping("/buys/{number}")
    public ResponseEntity<Buy> getBuyByNumber(@PathVariable(value = "number") Integer number) throws ResourceNotFoundException {
        Buy buy = buyRepository.findById(number).orElseThrow(() ->
                new ResourceNotFoundException("Buy not found for number = " + number));

        return  ResponseEntity.ok().body(buy);
    }

    @PostMapping("/buys")
    public Buy addBuy(@RequestBody Buy buy){
        return buyRepository.save(buy);
    }

    @DeleteMapping("/buys/{number}")
    public ResponseEntity<DeleteResponse> deleteBuy(@PathVariable(value = "number") Integer number) throws ResourceNotFoundException {
        Buy buy = buyRepository.findById(number).orElseThrow(() ->
                new ResourceNotFoundException("Buy not found for number = " + number));

        buyRepository.delete(buy);

        return  ResponseEntity.ok().body(
                new DeleteResponse("Buy with number: " + number + " deleted"));
    }
}
