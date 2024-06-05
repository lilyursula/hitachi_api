package com.example.hitachi_store.HitachiStoreController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hitachi_store.DTO.HitachiStoreCustomerDTO;
import com.example.hitachi_store.DTO.HitachiStoreCustomerUpdateDTO;
import com.example.hitachi_store.service.HitachiStoreService;

@RestController
@CrossOrigin
@RequestMapping("hitachistore/v1/customer")

public class HitachiCustomerController {

    @Autowired
    private HitachiStoreService hitachiStoreService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/public/secureAPI")

    public ResponseEntity securedApi(@RequestHeader HttpHeaders headers) {
        if (headers.containsKey(HttpHeaders.AUTHORIZATION)) {
            String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader.startsWith("Basic ")) {
                return new ResponseEntity<>("Authentication passed", HttpStatus.OK);
            }
        }
        return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(path = "/getAllCustomer")
    public List<HitachiStoreCustomerDTO> getAllCustomer()
    {
       List<HitachiStoreCustomerDTO> allCustomerHitachiStore = hitachiStoreService.getAllCustomer();
       return allCustomerHitachiStore;
    }

    @PutMapping(path = "/updateCustomer")
    public String HitachiStoreCustomerUpdateDTO(@RequestBody HitachiStoreCustomerUpdateDTO hitachiStoreCustomerUpdateDTO)
    {
        String id = hitachiStoreService.updateCustomer(hitachiStoreCustomerUpdateDTO);
        return id + " Berhasil di Update!";
    }


}
