package com.totoro.personnel.payload.response;

import lombok.Data;

import java.util.List;

/**
 * Created by ycd20 on 2022/06/07
 */
@Data
public class PagedResponse<T> {
    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
