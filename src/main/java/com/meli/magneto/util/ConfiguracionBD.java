package com.meli.magneto.util;

import org.apache.commons.lang3.StringUtils;

public class ConfiguracionBD {

    public static String MASTER_KEY =
            System.getProperty("ACCOUNT_KEY",
                    StringUtils.defaultString(StringUtils.trimToNull(
                            System.getenv().get("ACCOUNT_KEY")),
                            "V1YMdfFahscit6P8U02lMBFtvqjBTV78eRu8DSsL7aCtgSMieAz3RxB8W6WFGCVkWNT2XuTi4tIIF4Cf29WOYw=="));

    public static String HOST =
            System.getProperty("ACCOUNT_HOST",
                    StringUtils.defaultString(StringUtils.trimToNull(
                            System.getenv().get("ACCOUNT_HOST")),
                            "https://cavallejocosmosdb.documents.azure.com:443/"));

}
