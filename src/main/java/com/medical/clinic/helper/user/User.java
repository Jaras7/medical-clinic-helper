package com.medical.clinic.helper.user;

import com.medical.cliniec.helper.base.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
class User extends BaseEntity implements Serializable {

  private String login;
  private String firstname;
  private String lastname;
  private String password;
  private String email;
  private String phone;
  private String pesel;
  private LocalDate birthday;
  private UserType userType = UserType.PATIENT;

}
