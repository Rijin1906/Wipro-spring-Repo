

package com.wipro.entity;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "registered_charu")
//use named queries for static queries, queries without where clause
@NamedQueries(
       @NamedQuery(name = "get-all-users" , query = "select u from User u")
)
@NamedNativeQueries(
       @NamedNativeQuery(name = "get-all-native-users",
               query = "select * from registered_user",resultClass =User.class )
)
@Component
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer userid;
   @NotBlank
   private String username;
   @Size(min = 5)
   private String password;
   @Email
   private String email;
   private Long mobile;
   @Enumerated(EnumType.STRING)
   private Role role;
}
