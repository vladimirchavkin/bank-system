package ru.chavkin.accountservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

    @NonNull
//    @Column(name = "name")
    private String name;

    @NonNull
//    @Column(name = "surname")
    private String surname;

    @NonNull
//    @Column(name = "email")
    private String email;

    @NonNull
//    @Column(name = "phone_number")
    private String phoneNumber;

    @NonNull
    @CreationTimestamp
//    @Column(name = "created_on")
    private OffsetDateTime createdOn = OffsetDateTime.now();

    @NonNull
    @UpdateTimestamp
//    @Column(name = "updated_on")
    private OffsetDateTime updatedOn = OffsetDateTime.now();

    @NonNull
//    @Column(name = "bill_id")
    private Long billId;

}
