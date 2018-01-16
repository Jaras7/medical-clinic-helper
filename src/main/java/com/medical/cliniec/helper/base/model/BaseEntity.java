package com.medical.cliniec.helper.base.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String uuid = UUID.randomUUID().toString();

  @CreationTimestamp
  private LocalDateTime created;

  @UpdateTimestamp
  private LocalDateTime updated;

  @Version
  private int version;


  @Override
  public int hashCode() {
    return Objects.hashCode(uuid);
  }

  @Override
  public boolean equals(Object that) {
    return this == that || that instanceof BaseEntity
        && Objects.equals(uuid, ((BaseEntity) that).uuid);
  }
}
