package com.inventi.updownloadcsv.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventi.updownloadcsv.model.Customer;





@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
