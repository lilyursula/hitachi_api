package com.example.hitachi_store.HitachiStoreController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hitachi_store.DTO.HitachiStoreProductDTO;
import com.example.hitachi_store.DTO.HitachiStoreProductSaveDTO;
import com.example.hitachi_store.DTO.HitachiStoreProductUpdateDTO;
import com.example.hitachi_store.service.HitachiStoreService;

@RestController
@CrossOrigin
@RequestMapping("hitachistore/v1/product")

public class HitachiProductController {

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

    @PostMapping(path = "/addProduct")
    public String saveProduct(@RequestBody HitachiStoreProductSaveDTO hitachiStoreProductSaveDTO)
    {
        String id = hitachiStoreService.addProduct(hitachiStoreProductSaveDTO);
        return id + " Berhasil Ditambahkan!";
    }

    @GetMapping(path = "/getAllProduct")
    public List<HitachiStoreProductDTO> getAllProduct()
    {
       List<HitachiStoreProductDTO> allProductHitachiStore = hitachiStoreService.getAllProduct();
       return allProductHitachiStore;
    }

    @PutMapping(path = "/updateProduct")
    public String HitachiStoreProductUpdateDTO(@RequestBody HitachiStoreProductUpdateDTO hitachiStoreProductUpdateDTO)
    {
        String id = hitachiStoreService.updateProduct(hitachiStoreProductUpdateDTO);
        return id + " Berhasil di Update!";
    }


    @DeleteMapping(path = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id)
    {
        boolean deleteProduct = hitachiStoreService.deleteProduct(id);
        return "Produk Berhasil di Hapus!";
    }


}
