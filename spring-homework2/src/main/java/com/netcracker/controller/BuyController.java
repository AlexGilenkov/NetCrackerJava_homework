package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Buy;
import com.netcracker.repository.BuyRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.PatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buys-controller")
public class BuyController {

    @Autowired
    BuyRepository buyRepository;

    @Autowired
    PatchService patchService;

    @GetMapping("/buys")
    public List<Buy> getAllBuys(){
        return buyRepository.findAll();
    }

    @GetMapping("/buys/{number}")
    public ResponseEntity<Buy> getBuyByNumber(@PathVariable(value = "number") Integer number) throws ResourceNotFoundException {
        Buy buy = searchBuy(number);

        return  ResponseEntity.ok().body(buy);
    }

    @PostMapping("/buys")
    public Buy addBuy(@RequestBody Buy buy){
        return buyRepository.save(buy);
    }

    @DeleteMapping("/buys/{number}")
    public ResponseEntity<DeleteResponse> deleteBuy(@PathVariable(value = "number") Integer number) throws ResourceNotFoundException {
        Buy buy = searchBuy(number);
        buyRepository.delete(buy);

        return  ResponseEntity.ok().body(
                new DeleteResponse("Buy with number: " + number + " deleted"));
    }

    @PutMapping("/buys")
    public Buy putBuyByNumber(@RequestBody Buy b) throws ResourceNotFoundException {
        Buy buy = searchBuy(b.getNumber());

        buyRepository.delete(buy);

        return buyRepository.save(b);
    }

    @PatchMapping("/buys")
    public Buy patchBuyByNumber(@RequestBody Buy b) throws ResourceNotFoundException {
        Buy buy = searchBuy(b.getNumber());

        return buyRepository.save(patchService.patchBuy(buy, b));
    }

    private Buy searchBuy(Integer id) throws ResourceNotFoundException {
        return buyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Buy not found for number = " + id));
    }
}
