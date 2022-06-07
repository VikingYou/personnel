package com.totoro.personnel.payload.response;

import lombok.Data;

/**
 * Created by ycd20 on 2022/06/08
 */
@Data
public class AdministratorResponse {
    private long id;
    private String staffId;
    private String staffName;
    private String photoName;
}
