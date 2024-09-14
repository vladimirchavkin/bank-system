package ru.chavkin.depositservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Entity
@Data
@NoArgsConstructor
//@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

    @NonNull
//    @Column(name = "amount")
    private BigDecimal amount;

    @NonNull
//    @Column(name = "bill_id")
    private Long billId;

    @NonNull
    private String email;

    @NonNull
    @CreationTimestamp
//    @Column(name = "deposit_date")
    private OffsetDateTime depositDate = OffsetDateTime.now();

    public Deposit(@NonNull BigDecimal amount, @NonNull Long billId, @NonNull String email) {
        this.amount = amount;
        this.billId = billId;
        this.email = email;
    }
}
