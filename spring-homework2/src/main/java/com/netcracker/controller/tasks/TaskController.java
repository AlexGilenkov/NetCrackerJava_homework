package com.netcracker.controller.tasks;

import com.netcracker.repository.BookRepository;
import com.netcracker.repository.BuyerRepository;
import com.netcracker.repository.ShopRepository;
import com.netcracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    TaskService taskService;

    @GetMapping("/task2/books")
    public List<String> findAllNameAndPriceForBooks() {
        return bookRepository.findAllNameAndPriceForBooks();
    }

    @GetMapping("/task2/area-buyers")
    public Set<String> findAllAreasWhereLiveBuyers() {
        return buyerRepository.findAllAreasWhereLiveBuyers();
    }

    @GetMapping("/task2/month-of-buys")
    public Set<String> findAllMonthOfBuys(){
        return taskService.findAllMonth();
    }

    @GetMapping("/task3/buyers-from-area")
    public List<String> findAllBuyersFromArea(@RequestParam(name = "area") String area){
        return buyerRepository.findBuyersByArea(area);
    }

    @GetMapping("/task3/shops-from-area")
    public List<String> findAllShopsFromArea(@RequestParam(name = "area") String area){
        return shopRepository.findShopsByArea(area);
    }

    @GetMapping("/task3/books-by-subname-or-highly-price")
    public List<String> findAllBooksBySubnameOrEdgePrice(@RequestParam(name = "subname") String subname,
                                                          @RequestParam(name = "edge") Integer edge){
        return taskService.findAllBookBySubnameOrHighlyByPrice(subname, edge);
    }

}
