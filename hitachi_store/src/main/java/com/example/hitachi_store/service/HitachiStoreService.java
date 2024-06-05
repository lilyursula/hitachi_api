package com.example.hitachi_store.service;
import java.time.LocalDate;
import java.util.List;

import com.example.hitachi_store.DTO.HitachiStoreCustomerDTO;
import com.example.hitachi_store.DTO.HitachiStoreCustomerUpdateDTO;
import com.example.hitachi_store.DTO.HitachiStoreProductDTO;
import com.example.hitachi_store.DTO.HitachiStoreProductSaveDTO;
import com.example.hitachi_store.DTO.HitachiStoreProductUpdateDTO;
import com.example.hitachi_store.DTO.HitachiStoreTransactionDTO;
import com.example.hitachi_store.DTO.HitachiStoreUserDTO;
import com.example.hitachi_store.DTO.HitachiStoreUserSaveDTO;
import com.example.hitachi_store.DTO.HitachiStoreUserUpdateDTO;

public interface HitachiStoreService {

    String addUser(HitachiStoreUserSaveDTO hitachiStoreUserSaveDTO);

    List<HitachiStoreUserDTO> getAllUser();

    boolean deleteUser(int id);

    String updateUser(HitachiStoreUserUpdateDTO hitachiStoreUserUpdateDTO);

    String addProduct(HitachiStoreProductSaveDTO hitachiStoreProductSaveDTO);

    List<HitachiStoreProductDTO> getAllProduct();

    boolean deleteProduct(int id);

    String updateProduct(HitachiStoreProductUpdateDTO hitachiStoreProductUpdateDTO);

    List<HitachiStoreTransactionDTO> getAllTransaction();

    List<HitachiStoreTransactionDTO> getAllTransactionByCustomer(int customer);

    List<HitachiStoreTransactionDTO> getAllTransactionByPaymentStatus(String payment_status);

    List<HitachiStoreTransactionDTO> getAllTransactionByPaymentMethod(String payment_method);

    List<HitachiStoreTransactionDTO> getAllTransactionByDateRange(LocalDate startDate, LocalDate endDate);

    List<HitachiStoreTransactionDTO> getAllTransactionSortTime(String sortOrder);

    List<HitachiStoreTransactionDTO> getAllTransactionByStaffCreated(int staffId);
    
    double getTotalAmountSpentByCustomer(LocalDate startDate, LocalDate endDate);

    int getTotalTransactionsByProduct(int productId);

    int getTotalTransactionSpentByCustomer(int customerId);

    List<HitachiStoreCustomerDTO> getAllCustomer();

    String updateCustomer(HitachiStoreCustomerUpdateDTO hitachiStoreCustomerUpdateDTO);
}

