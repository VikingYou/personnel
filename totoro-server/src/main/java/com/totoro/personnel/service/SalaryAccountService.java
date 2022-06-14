package com.totoro.personnel.service;

import com.totoro.personnel.model.SalaryAccount;
import com.totoro.personnel.payload.request.SalaryAccountRequest;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.payload.response.SalaryAccountResponse;

/**
 * Created by ycd20 on 2022/06/14
 */
public interface SalaryAccountService {
    PagedResponse<SalaryAccountResponse> getAllSalaryAccount(int page, int size);

    SalaryAccount createSalaryAccount(SalaryAccountRequest salaryAccountRequest);
}
