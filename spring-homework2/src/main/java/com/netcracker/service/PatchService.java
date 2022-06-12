package com.netcracker.service;

import com.netcracker.model.Book;
import com.netcracker.model.Buy;
import com.netcracker.model.Buyer;
import com.netcracker.model.Shop;
import org.springframework.stereotype.Service;

@Service
public class PatchService {
    public Buy patchBuy(Buy oldBuy, Buy newBuy){
        if(newBuy.getNumber() != 0 && newBuy.getNumber() != oldBuy.getNumber()){
            oldBuy.setNumber(newBuy.getNumber());
        }
        if(newBuy.getDate() != null && !(newBuy.getDate().equals(oldBuy.getDate()))){
            oldBuy.setDate(newBuy.getDate());
        }
        if(newBuy.getSeller() != 0 && newBuy.getSeller() != oldBuy.getSeller()){
            oldBuy.setSeller(newBuy.getSeller());
        }
        if(newBuy.getBuyer() != 0 && newBuy.getBuyer() != oldBuy.getBuyer()){
            oldBuy.setBuyer(newBuy.getBuyer());
        }
        if(newBuy.getBook() != 0 && newBuy.getBook() != oldBuy.getBook()){
            oldBuy.setBook(newBuy.getBook());
        }
        if(newBuy.getCount() != 0 && newBuy.getCount() != oldBuy.getCount()){
            oldBuy.setCount(newBuy.getCount());
        }
        if(newBuy.getSumm() != 0 && newBuy.getSumm() != oldBuy.getSumm()){
            oldBuy.setSumm(newBuy.getSumm());
        }
        return oldBuy;
    }

    public Book patchBook(Book oldBook, Book newBook){
        if(newBook.getId() != 0 && newBook.getId() != oldBook.getId()){
            oldBook.setId(newBook.getId());
        }
        if(newBook.getName() != null && !(newBook.getName().equals(oldBook.getName()))){
            oldBook.setName(newBook.getName());
        }
        if(newBook.getCount() != 0 && newBook.getCount() != oldBook.getCount()){
            oldBook.setCount(newBook.getCount());
        }
        if(newBook.getStock() != null && !(newBook.getStock().equals(oldBook.getStock()))){
            oldBook.setStock(newBook.getStock());
        }
        if(newBook.getPrice() != 0 && newBook.getPrice() != oldBook.getPrice()) {
            oldBook.setPrice(newBook.getPrice());
        }
        return oldBook;
    }

    public Buyer patchBuyer(Buyer oldBuyer, Buyer newBuyer) {
        if(newBuyer.getId() != 0 && newBuyer.getId() != oldBuyer.getId()){
            oldBuyer.setId(newBuyer.getId());
        }
        if(newBuyer.getFamily() != null && !(newBuyer.getFamily().equals(oldBuyer.getFamily()))){
            oldBuyer.setFamily(newBuyer.getFamily());
        }
        if(newBuyer.getArea() != null && !(newBuyer.getArea().equals(oldBuyer.getArea()))){
            oldBuyer.setArea(newBuyer.getArea());
        }
        if(newBuyer.getDiscount() != 0 && newBuyer.getDiscount() != oldBuyer.getDiscount()){
            oldBuyer.setDiscount(newBuyer.getDiscount());
        }
        return oldBuyer;
    }

    public Shop patchShop(Shop oldShop, Shop newShop) {
        if(newShop.getId() != 0 && newShop.getId() != oldShop.getId()){
            oldShop.setId(newShop.getId());
        }
        if(newShop.getName() != null && !(newShop.getName().equals(oldShop.getName()))){
            oldShop.setName(newShop.getName());
        }
        if(newShop.getArea() != null && !(newShop.getArea().equals(oldShop.getArea()))){
            oldShop.setArea(newShop.getArea());
        }
        if(newShop.getCommission() != 0 && newShop.getCommission() != oldShop.getCommission()){
            oldShop.setCommission(newShop.getCommission());
        }
        return oldShop;
    }
}
