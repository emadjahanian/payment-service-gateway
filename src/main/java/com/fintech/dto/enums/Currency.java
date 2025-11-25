package com.fintech.dto.enums;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "Currency")
@XmlEnum
public enum Currency {
    IRR, USD, EUR;
}
