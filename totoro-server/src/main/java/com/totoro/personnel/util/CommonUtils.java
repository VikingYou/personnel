package com.totoro.personnel.util;

import com.totoro.personnel.exception.BadRequestException;

/**
 * Created by ycd20 on 2022/06/11
 */
public class CommonUtils {
    public void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new BadRequestException("Page number can not be less than zero");
        }
    }
}
