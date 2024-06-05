package com.example.hitachi_store.HitachiStoreController;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hitachi_store.DTO.HitachiStoreTransactionDTO;
import com.example.hitachi_store.service.HitachiStoreService;

@RestController
@CrossOrigin
@RequestMapping("hitachistore/v1/transaction")

public class HitachiTransactionController {

    @Autowired
    private HitachiStoreService hitachiStoreService;
    

    @GetMapping(path = "/getAllTransaction")
    public List<HitachiStoreTransactionDTO> getAllTransaction()
    {
       List<HitachiStoreTransactionDTO> allTransactionHitachiStore = hitachiStoreService.getAllTransaction();
       return allTransactionHitachiStore;

    }
    
    @GetMapping(path = "/getAllTransaction/{customer}")
    public List<HitachiStoreTransactionDTO> getAllTransaction(@PathVariable(value = "customer") int customer)
    {
       List<HitachiStoreTransactionDTO> allTransactionHitachiStore = hitachiStoreService.getAllTransactionByCustomer(customer);
       return allTransactionHitachiStore;
    }

    @GetMapping(path = "/getAllTransactionByStatus")
    public List<HitachiStoreTransactionDTO> getAllTransactionByPaymentStatus(@RequestParam(value = "payment_status") String payment_status) {
        List<HitachiStoreTransactionDTO> allTransactionHitachiStore = hitachiStoreService.getAllTransactionByPaymentStatus(payment_status);
        return allTransactionHitachiStore;
    }

    @GetMapping(path = "/getAllTransactionByMethod")
    public List<HitachiStoreTransactionDTO> getAllTransactionByMethodPayment(@RequestParam(value = "payment_method") String payment_method) {
        List<HitachiStoreTransactionDTO> allTransactionHitachiStore = hitachiStoreService.getAllTransactionByPaymentMethod(payment_method);
        return allTransactionHitachiStore;
    }

    @GetMapping(path = "/getAllTransactionByDate")
    public List<HitachiStoreTransactionDTO> getAllTransactionByDate(
        @RequestParam(value = "start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
        @RequestParam(value = "end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {
        
        LocalDate parsedStartDate = LocalDate.parse(startDate);
        LocalDate parsedEndDate = LocalDate.parse(endDate);
        
        List<HitachiStoreTransactionDTO> allTransactionHitachiStore = hitachiStoreService.getAllTransactionByDateRange(parsedStartDate, parsedEndDate);
        return allTransactionHitachiStore;
    }

    @GetMapping(path = "/getAllTransactionSortTime")
    public List<HitachiStoreTransactionDTO> getAllTransactionSortTime(
        @RequestParam(value = "sort_order", defaultValue = "asc") String sortOrder) {
        
        List<HitachiStoreTransactionDTO> allTransactions = hitachiStoreService.getAllTransactionSortTime(sortOrder);
        
        // Sorting based on transaction time
        if (sortOrder.equalsIgnoreCase("desc")) {
            allTransactions.sort(Comparator.comparing(HitachiStoreTransactionDTO::getTransactionTime).reversed());
        } else {
            allTransactions.sort(Comparator.comparing(HitachiStoreTransactionDTO::getTransactionTime));
        }
        
        return allTransactions;
    }

    @GetMapping(path = "/getAllTransactionByStaffCreated")
    public List<HitachiStoreTransactionDTO> getAllTransactionByStaffCreated(@RequestParam(value = "staff_id") int staffId)
    {
       List<HitachiStoreTransactionDTO> allTransactionHitachiStore = hitachiStoreService.getAllTransactionByStaffCreated(staffId);
       return allTransactionHitachiStore;
    }

    //belum
    @GetMapping(path = "/totalAmountSpent")
    public double getTotalAmountSpentByCustomer(
        @RequestParam(value = "start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
        @RequestParam(value = "end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {

        LocalDate parsedStartDate = LocalDate.parse(startDate);
        LocalDate parsedEndDate = LocalDate.parse(endDate);
        
        double totalAmountSpent = hitachiStoreService.getTotalAmountSpentByCustomer(parsedStartDate, parsedEndDate);
        
        return totalAmountSpent;
    }

    @GetMapping(path = "/totalTransactionSpentByCustomer")
    public ResponseEntity<Integer> getTotalTransactionSpentByCustomer(@RequestParam(value = "customer_id")  int customerId) {
        int totalTransaction = hitachiStoreService.getTotalTransactionSpentByCustomer(customerId);
        return ResponseEntity.ok(totalTransaction);
    }

    @GetMapping(path = "/totalAmountSpentPerProduct")
    public ResponseEntity<Integer> getTotalTransactionsByProduct(@RequestParam(value = "product_id")  int productId) {
        int totalAmountSpent = hitachiStoreService.getTotalTransactionsByProduct(productId);
        return ResponseEntity.ok(totalAmountSpent);
    }

}
