package com.fintech.dto.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "TransactionStatus")
@XmlEnum
public enum TransactionStatus {
    PENDING, SUCCESS, FAILED, CANCELED, REFUNDED;
}
