package com.example.hitachi_store.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hitachi_store.DTO.HitachiStoreCustomerDTO;
import com.example.hitachi_store.DTO.HitachiStoreCustomerUpdateDTO;
import com.example.hitachi_store.DTO.HitachiStoreProductDTO;
import com.example.hitachi_store.DTO.HitachiStoreProductSaveDTO;
import com.example.hitachi_store.DTO.HitachiStoreProductUpdateDTO;
import com.example.hitachi_store.DTO.HitachiStoreTransactionDTO;
import com.example.hitachi_store.DTO.HitachiStoreUserDTO;
import com.example.hitachi_store.DTO.HitachiStoreUserSaveDTO;
import com.example.hitachi_store.DTO.HitachiStoreUserUpdateDTO;
import com.example.hitachi_store.HitachiStoreRepo.HitachiStoreCustomerRepo;
import com.example.hitachi_store.HitachiStoreRepo.HitachiStoreProductRepo;
import com.example.hitachi_store.HitachiStoreRepo.HitachiStoreTransactionRepo;
import com.example.hitachi_store.HitachiStoreRepo.HitachiStoreUserRepo;
import com.example.hitachi_store.entity.HitachiStoreCustomer;
import com.example.hitachi_store.entity.HitachiStoreProduct;
import com.example.hitachi_store.entity.HitachiStoreTransaction;
import com.example.hitachi_store.entity.HitachiStoreUser;

@Service
public class HitachiStoreServiceIMPL implements HitachiStoreService
{
    
    @Autowired
    private HitachiStoreUserRepo hitachiStoreUserRepo;

    @Autowired
    private HitachiStoreProductRepo hitachiStoreProductRepo;

    @Autowired
    private HitachiStoreTransactionRepo hitachiStoreTransactionRepo;

    @Autowired
    private HitachiStoreCustomerRepo hitachiStoreCustomerRepo;

    @Override
    public String addUser(HitachiStoreUserSaveDTO hitachiStoreUserSaveDTO)
    {
        HitachiStoreUser hitachiStoreUser = new HitachiStoreUser(

            hitachiStoreUserSaveDTO.getHitachiStoreUserUsername(),
            hitachiStoreUserSaveDTO.getHitachiStoreUserEmail(),
            hitachiStoreUserSaveDTO.getHitachiStoreUserPassword(),
            hitachiStoreUserSaveDTO.getHitachiStoreUserRole()
        );

        hitachiStoreUserRepo.save(hitachiStoreUser);

        // Add customer
        HitachiStoreCustomer hitachiStoreCustomer = new HitachiStoreCustomer();

        hitachiStoreCustomer.setUserId(hitachiStoreUser.getHitachiStoreUserId());

        //Date 
        Date created_at = new Date(System.currentTimeMillis());
        hitachiStoreCustomer.setCreatedAt(created_at);

        hitachiStoreCustomer.setCreatedBy("admin");
        
        hitachiStoreCustomerRepo.save(hitachiStoreCustomer);

        return hitachiStoreUser.getHitachiStoreUserUsername();
    }

    @Override
    public List<HitachiStoreUserDTO> getAllUser() {
        List<HitachiStoreUser> getAllUser = hitachiStoreUserRepo.findAll();
        List<HitachiStoreUserDTO> hitachiStoreUserDTOList = new ArrayList<>();
        
        for(HitachiStoreUser a:getAllUser)
        {
            HitachiStoreUserDTO hitachiStoreUserDTO = new HitachiStoreUserDTO(
  
                    a.getHitachiStoreUserId(),
                    a.getHitachiStoreUserUsername(),
                    a.getHitachiStoreUserEmail(),
                    a.getHitachiStoreUserPassword(),
                    a.getHitachiStoreUserRole()
            );
            hitachiStoreUserDTOList.add(hitachiStoreUserDTO);
        }
  
        return  hitachiStoreUserDTOList;
     }

     @Override
     public boolean deleteUser(int id) {
  
         if(hitachiStoreUserRepo.existsById(id))
         {
            hitachiStoreUserRepo.deleteById(id);
         }
         else
         {
             System.out.println("User id not found");
         }
  
         return true;
     }

    @Override
    public String updateUser(HitachiStoreUserUpdateDTO hitachiStoreUserUpdateDTO) 
    {
            if (hitachiStoreUserRepo.existsById(hitachiStoreUserUpdateDTO.getHitachiStoreUserId())) {
                HitachiStoreUser hitachiStoreUser = hitachiStoreUserRepo.getById(hitachiStoreUserUpdateDTO.getHitachiStoreUserId());

                hitachiStoreUser.setHitachiStoreUserUsername(hitachiStoreUserUpdateDTO.getHitachiStoreUserUsername());
                hitachiStoreUser.setHitachiStoreUserEmail(hitachiStoreUserUpdateDTO.getHitachiStoreUserEmail());
                hitachiStoreUser.setHitachiStoreUserPassword(hitachiStoreUserUpdateDTO.getHitachiStoreUserPassword());
                hitachiStoreUser.setHitachiStoreUserRole(hitachiStoreUserUpdateDTO.getHitachiStoreUserRole());
                hitachiStoreUserRepo.save(hitachiStoreUser);
            }
            else
            {
                System.out.println("User ID do not Exist");
            }
            
            return hitachiStoreUserUpdateDTO.getHitachiStoreUserUsername();
    }

    @Override
    public String addProduct(HitachiStoreProductSaveDTO hitachiStoreProductSaveDTO) 
    {
        HitachiStoreProduct hitachiStoreProduct = new HitachiStoreProduct(
            
        hitachiStoreProductSaveDTO.getProductName(),
        hitachiStoreProductSaveDTO.getProductPrice(),
        hitachiStoreProductSaveDTO.getProductTax()
        );
        
        hitachiStoreProductRepo.save(hitachiStoreProduct);
        return hitachiStoreProduct.getProductName();
    }


    @Override
    public List<HitachiStoreProductDTO> getAllProduct() {
        List<HitachiStoreProduct> getAllProduct = hitachiStoreProductRepo.findAll();
        List<HitachiStoreProductDTO> hitachiStoreUserDTOList = new ArrayList<>();
        
        for(HitachiStoreProduct a:getAllProduct)
        {
            HitachiStoreProductDTO hitachiStoreProductDTO = new HitachiStoreProductDTO(
  
                    a.getProductId(),
                    a.getProductName(),
                    a.getProductPrice(),
                    a.getProductTax()
            );
            hitachiStoreUserDTOList.add(hitachiStoreProductDTO);
        }

        return  hitachiStoreUserDTOList;
     }

    
    @Override
    public boolean deleteProduct(int id) {
        if(hitachiStoreProductRepo.existsById(id))
        {
           hitachiStoreProductRepo.deleteById(id);
        }
        else
        {
            System.out.println("User id not found");
        }

        return true;
    }

    @Override
    public String updateProduct(HitachiStoreProductUpdateDTO hitachiStoreProductUpdateDTO) {
        
        if (hitachiStoreProductRepo.existsById(hitachiStoreProductUpdateDTO.getProductId())) {
            HitachiStoreProduct hitachiStoreProduct = hitachiStoreProductRepo.getById(hitachiStoreProductUpdateDTO.getProductId());

            hitachiStoreProduct.setProductName(hitachiStoreProductUpdateDTO.getProductName());
            hitachiStoreProduct.setProductPrice(hitachiStoreProductUpdateDTO.getProductPrice());
            hitachiStoreProduct.setProductTax(hitachiStoreProductUpdateDTO.getProductTax());
            hitachiStoreProductRepo.save(hitachiStoreProduct);
            }
        else
        {
            System.out.println("Product ID do not Exist");
        }
        
        return hitachiStoreProductUpdateDTO.getProductName();

    }

    
    @Override
    public List<HitachiStoreTransactionDTO> getAllTransaction() {
        List<HitachiStoreTransaction> getAllTransaction = hitachiStoreTransactionRepo.findAll();
        List<HitachiStoreTransactionDTO> hitachiStoreTransactionDTOList = new ArrayList<>();
        
        for(HitachiStoreTransaction a:getAllTransaction)
        {
            HitachiStoreTransactionDTO hitachiStoreTransactionDTO = new HitachiStoreTransactionDTO(
                    a.getTransactionId(),
                    a.getCustomer(),
                    a.getNetAmountPaid(),
                    a.getTotalAmountPaid(),
                    a.getTotalTaxPaid(),
                    a.getTransactionTime(),
                    a.getPaymentStatus(),
                    a.getPaymentMethod(),
                    a.getProductId(),
                    a.getStaffId()
            );
            hitachiStoreTransactionDTOList.add(hitachiStoreTransactionDTO);
        }

        return  hitachiStoreTransactionDTOList;
    }


    
    @Override
    public List<HitachiStoreTransactionDTO> getAllTransactionByCustomer(int customer) {
        List<HitachiStoreTransaction> getAllTransaction = hitachiStoreTransactionRepo.findAll();
        List<HitachiStoreTransactionDTO> hitachiStoreTransactionDTOList = new ArrayList<>();
        
        for(HitachiStoreTransaction a : getAllTransaction) {
            if(a.getCustomer() == customer) { // Filter transaksi berdasarkan pelanggan
                HitachiStoreTransactionDTO hitachiStoreTransactionDTO = new HitachiStoreTransactionDTO(
                    a.getTransactionId(),
                    a.getCustomer(),
                    a.getNetAmountPaid(),
                    a.getTotalAmountPaid(),
                    a.getTotalTaxPaid(),
                    a.getTransactionTime(),
                    a.getPaymentStatus(),
                    a.getPaymentMethod(),
                    a.getProductId(),
                    a.getStaffId()
                );
                hitachiStoreTransactionDTOList.add(hitachiStoreTransactionDTO);
            }
        }

        return hitachiStoreTransactionDTOList;
    }

    @Override
    public List<HitachiStoreTransactionDTO> getAllTransactionByPaymentStatus(String payment_status) {
        List<HitachiStoreTransaction> getAllTransaction = hitachiStoreTransactionRepo.findAll();
        List<HitachiStoreTransactionDTO> hitachiStoreTransactionDTOList = new ArrayList<>();
        
        for(HitachiStoreTransaction a : getAllTransaction) {
            if(a.getPaymentStatus().equals(payment_status)) { // Filter transaksi berdasarkan pelanggan
                HitachiStoreTransactionDTO hitachiStoreTransactionDTO = new HitachiStoreTransactionDTO(
                    a.getTransactionId(),
                    a.getCustomer(),
                    a.getNetAmountPaid(),
                    a.getTotalAmountPaid(),
                    a.getTotalTaxPaid(),
                    a.getTransactionTime(),
                    a.getPaymentStatus(),
                    a.getPaymentMethod(),
                    a.getProductId(),
                    a.getStaffId()
                );
                hitachiStoreTransactionDTOList.add(hitachiStoreTransactionDTO);
            }
        }

        return hitachiStoreTransactionDTOList;
    }

    @Override
    public List<HitachiStoreTransactionDTO> getAllTransactionByPaymentMethod(String payment_method) {
        List<HitachiStoreTransaction> getAllTransaction = hitachiStoreTransactionRepo.findAll();
        List<HitachiStoreTransactionDTO> hitachiStoreTransactionDTOList = new ArrayList<>();
        
        for(HitachiStoreTransaction a : getAllTransaction) {
            if(a.getPaymentMethod().equals(payment_method)) { // Filter transaksi berdasarkan pelanggan
                HitachiStoreTransactionDTO hitachiStoreTransactionDTO = new HitachiStoreTransactionDTO(
                    a.getTransactionId(),
                    a.getCustomer(),
                    a.getNetAmountPaid(),
                    a.getTotalAmountPaid(),
                    a.getTotalTaxPaid(),
                    a.getTransactionTime(),
                    a.getPaymentStatus(),
                    a.getPaymentMethod(),
                    a.getProductId(),
                    a.getStaffId()
                );
                hitachiStoreTransactionDTOList.add(hitachiStoreTransactionDTO);
            }
        }

        return hitachiStoreTransactionDTOList;
    }

    @Override
    public List<HitachiStoreTransactionDTO> getAllTransactionByDateRange(LocalDate startDate, LocalDate endDate) {
    List<HitachiStoreTransaction> allTransaction = hitachiStoreTransactionRepo.findAll();
    List<HitachiStoreTransactionDTO> transactionDTOList = new ArrayList<>();
    
    for (HitachiStoreTransaction transaction : allTransaction) {
        LocalDate transactionDate = transaction.getTransactionTime().toLocalDate();
        if (transactionDate.isEqual(startDate) || transactionDate.isEqual(endDate) || (transactionDate.isAfter(startDate) && transactionDate.isBefore(endDate))) {
            HitachiStoreTransactionDTO transactionDTO = new HitachiStoreTransactionDTO(
                transaction.getTransactionId(),
                transaction.getCustomer(),
                transaction.getNetAmountPaid(),
                transaction.getTotalAmountPaid(),
                transaction.getTotalTaxPaid(),
                transaction.getTransactionTime(),
                transaction.getPaymentStatus(),
                transaction.getPaymentMethod(),
                transaction.getProductId(),
                transaction.getStaffId()
            );
            transactionDTOList.add(transactionDTO);
        }
    }

    return transactionDTOList;
}

    @Override
    public List<HitachiStoreTransactionDTO> getAllTransactionSortTime(String sortOrder) {
        List<HitachiStoreTransaction> allTransactions = hitachiStoreTransactionRepo.findAll();
        
        // Sorting based on transaction time
        if (sortOrder.equalsIgnoreCase("desc")) {
            allTransactions.sort(Comparator.comparing(HitachiStoreTransaction::getTransactionTime).reversed());
        } else {
            allTransactions.sort(Comparator.comparing(HitachiStoreTransaction::getTransactionTime));
        }
        
        List<HitachiStoreTransactionDTO> transactionDTOList = new ArrayList<>();
        for (HitachiStoreTransaction transaction : allTransactions) {
            HitachiStoreTransactionDTO transactionDTO = new HitachiStoreTransactionDTO(
                transaction.getTransactionId(),
                transaction.getCustomer(),
                transaction.getNetAmountPaid(),
                transaction.getTotalAmountPaid(),
                transaction.getTotalTaxPaid(),
                transaction.getTransactionTime(),
                transaction.getPaymentStatus(),
                transaction.getPaymentMethod(),
                transaction.getProductId(),
                transaction.getStaffId()
            );
            transactionDTOList.add(transactionDTO);
        }
        
        return transactionDTOList;
    }

    @Override
    public List<HitachiStoreTransactionDTO> getAllTransactionByStaffCreated(int staffId) {
        List<HitachiStoreTransaction> getAllTransaction = hitachiStoreTransactionRepo.findAll();
        List<HitachiStoreTransactionDTO> hitachiStoreTransactionDTOList = new ArrayList<>();
        
        for(HitachiStoreTransaction a : getAllTransaction) {
            if(a.getStaffId() == staffId) { // Filter transaksi berdasarkan pelanggan
                HitachiStoreTransactionDTO hitachiStoreTransactionDTO = new HitachiStoreTransactionDTO(
                    a.getTransactionId(),
                    a.getCustomer(),
                    a.getNetAmountPaid(),
                    a.getTotalAmountPaid(),
                    a.getTotalTaxPaid(),
                    a.getTransactionTime(),
                    a.getPaymentStatus(),
                    a.getPaymentMethod(),
                    a.getProductId(),
                    a.getStaffId()
                );
                hitachiStoreTransactionDTOList.add(hitachiStoreTransactionDTO);
            }
        }

        return hitachiStoreTransactionDTOList;
    }

    @Override
    public double getTotalAmountSpentByCustomer(LocalDate startDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalAmountSpentByCustomer'");
    }

    @Override
    public int getTotalTransactionSpentByCustomer(int customerId) {
        List<HitachiStoreTransaction> allTransactions = hitachiStoreTransactionRepo.findAll();
        int totalTransaction = 0;
        
        for (HitachiStoreTransaction hitachiStoreTransaction : allTransactions) {
            if (hitachiStoreTransaction.getCustomer() == customerId) {
                totalTransaction += hitachiStoreTransaction.getTotalAmountPaid();
            }
        }
        
        return totalTransaction;
    }   
    
    @Override
    public int getTotalTransactionsByProduct(int productId) {
        List<HitachiStoreTransaction> allTransactions = hitachiStoreTransactionRepo.findAll();
        int totalAmount = 0;
        
        for (HitachiStoreTransaction hitachiStoreTransaction : allTransactions) {
            if (hitachiStoreTransaction.getProductId() == productId) {
                totalAmount += hitachiStoreTransaction.getTotalAmountPaid();
            }
        }
        
        return totalAmount;
    }

    @Override
    public List<HitachiStoreCustomerDTO> getAllCustomer() {
        List<HitachiStoreCustomer> getAllCustomer = hitachiStoreCustomerRepo.findAll();
        List<HitachiStoreCustomerDTO> hitachiStoreCustomerDTOList = new ArrayList<>();
        
        for(HitachiStoreCustomer a:getAllCustomer)
        {
            HitachiStoreCustomerDTO hitachiStoreCustomerDTO = new HitachiStoreCustomerDTO(
                    a.getUserId(),
                    a.getCustomerName(),
                    a.getBirthDate(),
                    a.getBirthPlace(),
                    a.getCreatedBy(),
                    a.getCreatedAt(),
                    a.getUpdatedAt(),
                    a.getUpdatedBy()
            );
            hitachiStoreCustomerDTOList.add(hitachiStoreCustomerDTO);
        }
  
        return  hitachiStoreCustomerDTOList;
    }

    @Override
        public String updateCustomer(HitachiStoreCustomerUpdateDTO hitachiStoreCustomerUpdateDTO) {

            if (hitachiStoreCustomerRepo.existsById(hitachiStoreCustomerUpdateDTO.getUserId())) {
            
                HitachiStoreCustomer hitachiStoreCustomer = hitachiStoreCustomerRepo.getById(hitachiStoreCustomerUpdateDTO.getUserId());
                hitachiStoreCustomer.setCustomerName(hitachiStoreCustomerUpdateDTO.getCustomerName());
                hitachiStoreCustomer.setBirthDate(hitachiStoreCustomerUpdateDTO.getBirthDate());
                hitachiStoreCustomer.setBirthPlace(hitachiStoreCustomerUpdateDTO.getBirthPlace());

                // Set updatedAt to current date
                Date updated_at = new Date(System.currentTimeMillis());
                hitachiStoreCustomer.setUpdatedAt(updated_at);

                hitachiStoreCustomerRepo.save(hitachiStoreCustomer);
            }
            else
            {
                System.out.println("Customer ID does not exist");
            }
            
            return hitachiStoreCustomerUpdateDTO.getCustomerName();
}
 
}
