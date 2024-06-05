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

import com.example.hitachi_store.DTO.HitachiStoreUserDTO;
import com.example.hitachi_store.DTO.HitachiStoreUserSaveDTO;
import com.example.hitachi_store.DTO.HitachiStoreUserUpdateDTO;
import com.example.hitachi_store.service.HitachiStoreService;

@RestController
@CrossOrigin
@RequestMapping("hitachistore/v1/user")

public class HitachiUserController {

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

    @PostMapping(path = "/addUser")
    public String saveUser(@RequestBody HitachiStoreUserSaveDTO hitachiStoreUserSaveDTO)
    {
        String id = hitachiStoreService.addUser(hitachiStoreUserSaveDTO);
        return id + " Berhasil Ditambahkan!";
    }

    @GetMapping(path = "/getAllUser")
    public List<HitachiStoreUserDTO> getAllUser()
    {
       List<HitachiStoreUserDTO> allUserHitachiStore = hitachiStoreService.getAllUser();
       return allUserHitachiStore;
    }

    @PutMapping(path = "/updateUser")
    public String HitachiStoreUserUpdateDTO(@RequestBody HitachiStoreUserUpdateDTO hitachiStoreUserUpdateDTO)
    {
        String id = hitachiStoreService.updateUser(hitachiStoreUserUpdateDTO);
        return id + " Berhasil di Update!";
    }


    @DeleteMapping(path = "/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id)
    {
        boolean deleteUser = hitachiStoreService.deleteUser(id);
        return "User Berhasil di Hapus!";
    }



}