package vn.edu.iuh.fit.wwwlabweek05.backend.models;

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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "add_id")
  private long id;
  @NonNull
  @Column(name = "number", length = 20)
  private String number;
  @NonNull
  @Column(name = "street", length = 150)
  private String street;
  @NonNull
  @Column(name = "city", length = 50)
  private String city;
  @NonNull

  @Column(name = "zipcode", length = 7)
  private String zipcode;
  @NonNull

  @Column(name = "country", length = 6)
  private CountryCode country;

  @Override
  public String toString() {
    return number + " " + street + " " + city + " " + zipcode + " " + country.name();
  }
}
