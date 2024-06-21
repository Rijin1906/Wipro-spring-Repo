package com.wipro.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
@Entity
@Table(name = "customer")
@Builder
@AllArgsConstructor
public class Customer {
   @Id
   @GeneratedValue
   private Long id;
   @Column(name = "first_name", nullable = false)
   private String firstName;
   @Column(name = "last_name", nullable = false)
   private String lastName;
   public Customer() {
   }
  
   public Customer(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
   }
  
}
