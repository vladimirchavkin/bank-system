package ru.chavkin.billservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.chavkin.billservice.entity.enumeration.BillEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

//    @Column(name = "amount")
    @NonNull
    private BigDecimal amount;

//    @Column(name = "is_active")
    @NonNull
    private Boolean isActive;

//    @Column(name = "is_confirmed")
    @NonNull
    private Boolean isConfirmed;

//    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    @NonNull
    private BillEnum currency;

//    @Column(name = "created_on")
    @CreationTimestamp
    @NonNull
    private OffsetDateTime createdOn = OffsetDateTime.now();

//    @Column(name = "updated_on")
    @UpdateTimestamp
    @NonNull
    private OffsetDateTime updatedOn = OffsetDateTime.now();

//    @Column(name = "account_id")
    @NonNull
    private Long accountId;

}