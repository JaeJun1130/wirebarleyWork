package com.wirebarley.work.service.currency;

public class CurrencyFactory {


    public static Currency getCountryCurrency(String recipientCountry) {
        if("JPY".equals(recipientCountry))
            return new UsdToJpyCurrency();
        if("KRW".equals(recipientCountry))
            return new UsdToKrwCurrency();
        if("PHP".equals(recipientCountry))
            return new UsdToPhpCurrency();

        throw new IllegalArgumentException();
    }

}
