package com.netcracker.service;

import com.netcracker.repository.BookRepository;
import com.netcracker.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TaskService {

    @Autowired
    BuyRepository buyRepository;
    @Autowired
    BookRepository bookRepository;

    public Set<String> findAllMonth(){
        List<Date> dates = buyRepository.findAllDateOfBuys();
        Set<String> res = new HashSet<>();
        for(Date d: dates){
            int m = d.getMonth();
            switch (m){
                case 0 : res.add("Январь"); break;
                case 1 : res.add("Февраль"); break;
                case 2 : res.add("Март"); break;
                case 3 : res.add("Апрель"); break;
                case 4 : res.add("Май"); break;
                case 5 : res.add("Июнь"); break;
                case 6 : res.add("Июль"); break;
                case 7 : res.add("Август"); break;
                case 8 : res.add("Сентябрь"); break;
                case 9 : res.add("Октябрь"); break;
                case 10 : res.add("Ноябрь"); break;
                case 11 : res.add("Декабрь"); break;
                default: break;
            }
        }
        return res;
    }

    public List<String> findAllBookBySubnameOrHighlyByPrice(String subname, Integer edge){
        List<String> list = new ArrayList<>();

        list.addAll(bookRepository.findBooksHighlyEdgeByPrice(edge));
        list.addAll(bookRepository.findBooksBySubname(subname));

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(",");
                String[] s2 = o2.split(",");

                return  s1[0].compareTo(s2[0]) - Integer.valueOf(s1[1]).compareTo(Integer.valueOf(s2[1]));
            }
        };

        list.sort(comparator);

        return list;
    }

    public List<String> findBuysInBuyersAreaLaterMonth (Integer month){
        List<String> list = buyRepository.findBuysInBuyersArea();
        List<String> res = new ArrayList<>();
        for (String s: list){

            String sub = s.split(",")[2];
            if (Integer.valueOf(sub.substring(5,7)) >= month) {
                res.add(s);
            }
        }

        return res;
    }
}
