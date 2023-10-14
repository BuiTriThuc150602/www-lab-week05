package vn.edu.iuh.fit.wwwlabweek05.models;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Address")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "add_id")
  private long id;
  @Column(name = "number",length = 20)
  private String number;
  @Column(name = "street",length = 150)
  private String street;
  @Column(name = "city",length = 50)
  private String city;
  @Column(name = "zipcode",length = 7)
  private String zipcode;
  @Column(name = "country",length = 6)
  private CountryCode country;

}
