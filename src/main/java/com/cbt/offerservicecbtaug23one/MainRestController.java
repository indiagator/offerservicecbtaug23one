package com.cbt.offerservicecbtaug23one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class MainRestController {

    @Autowired
   ProductofferRepository productofferRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FullProductOfferService fullProductOfferService;

    @GetMapping("get/offer/all")
    public List<FullProductOffer> getAllOffers()
    {
        List<Productoffer> productofferList =  productofferRepository.findAll();

        return productofferList.stream().map(productoffer ->
                { return fullProductOfferService.composeFullProductOffer(productoffer.getId());}
        ).collect(Collectors.toList());

    }

    @GetMapping("get/product/all")
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @PostMapping("save/offer")
    public ResponseEntity<Productoffer> saveOffer(@RequestBody Productoffer offer)
    {
        offer.setId(String.valueOf((int)(Math.random()*100000)));
        productofferRepository.save(offer);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }



}
