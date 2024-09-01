package ru.chavkin.billservice.entity.enumeration;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author vladimirchavkinwork@gmail.com
 */


public enum BillEnum {
    RUB,
    EUR,
    USD
}
