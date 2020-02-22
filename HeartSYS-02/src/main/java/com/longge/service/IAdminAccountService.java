package com.longge.service;

import com.longge.pojo.AdminAccount;

import java.util.List;

public interface IAdminAccountService {
    List<AdminAccount> findAllAccount();

    void addAccount(AdminAccount account);

    void deleteAccount(String id);

    AdminAccount updateAdminAccount(String adminAccountStr);

    String findByUserName(String username);
}
