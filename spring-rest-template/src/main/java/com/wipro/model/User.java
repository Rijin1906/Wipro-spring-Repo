package com.wipro.model;
import org.springframework.stereotype.Component;
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
@Component
public class User {
   private Integer userid;
   @NotBlank
   private String username;
   @Size(min = 5)
   private String password;
   @Email
   private String email;
   private Long mobile;
   private Role role;
}
