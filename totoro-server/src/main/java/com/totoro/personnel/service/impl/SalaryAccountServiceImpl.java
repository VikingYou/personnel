package com.totoro.personnel.service.impl;

import com.totoro.personnel.model.SalaryAccount;
import com.totoro.personnel.payload.request.SalaryAccountRequest;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.payload.response.SalaryAccountResponse;
import com.totoro.personnel.service.SalaryAccountService;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * Created by ycd20 on 2022/06/14
 */
public class SalaryAccountServiceImpl implements SalaryAccountService {
    @Override
    public PagedResponse<SalaryAccountResponse> getAllSalaryAccount(int page, int size) {
        return null;
    }

    @Override
    public SalaryAccount createSalaryAccount(SalaryAccountRequest salaryAccountRequest) {
        return null;
    }
}
