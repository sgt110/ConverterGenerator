/*
 * Project: ConverterGenerator
 *
 * File Created at 2022-07-20
 *
 * Copyright 2012-2015 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package org.dudariev.converter.generator;

import org.apache.commons.lang3.StringUtils;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-07-20 16:38
 */
public enum ObjectEndEnum {
    /**
     * Business Object
     */
    BO("BO"),
    /**
     * View Object
     */
    VO("VO"),
    /**
     * Persistent Object
     */
    PO("PO"),
    /**
     * Data Transfer Object
     */
    DTO("DTO",3),
    /**
     * 新增或者修改
     */
    Param("Param",5),
    /**
     * 查询
     */
    Query("Query",5),
    ;
    private final String endCode;
    private final Integer len;

    ObjectEndEnum(String endCode) {
        this.endCode = endCode;
        len = 2;
    }
    ObjectEndEnum(String endCode, Integer len) {
        this.endCode = endCode;
        this.len = len;
    }

    public static String getEndCode(String qualifiedName){
        if (StringUtils.isBlank(qualifiedName)){
            return "";
        }
        ObjectEndEnum[] objectEndEnums = ObjectEndEnum.values();
        for (ObjectEndEnum objectEndEnum : objectEndEnums){
            if (qualifiedName.length()<= objectEndEnum.len){
                return "";
            }
            String endName = qualifiedName.substring(qualifiedName.length()- objectEndEnum.len);
            if (endName.equals(objectEndEnum.endCode)){
                return objectEndEnum.endCode;
            }
        }
        return "";
    }
}
