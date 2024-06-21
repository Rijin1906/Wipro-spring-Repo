import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Service
@ToString
@Table(name = "countries")
@Entity
public class Country {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String name;
   public Country() {
   	
   }
 
}
