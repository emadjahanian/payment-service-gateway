package com.fintech.utils;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class XmlDateUtil {

    private XmlDateUtil() {}

    public static XMLGregorianCalendar from(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }

        try {
            var gregorianCalendar = java.util.GregorianCalendar.from(
                    localDateTime.atZone(ZoneId.systemDefault())
            );

            return DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gregorianCalendar);

        } catch (Exception e) {
            throw new IllegalStateException("Cannot convert LocalDateTime to XMLGregorianCalendar", e);
        }
    }
}