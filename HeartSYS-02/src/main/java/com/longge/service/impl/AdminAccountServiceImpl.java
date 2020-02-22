package com.longge.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longge.dao.AdminAccountDao;
import com.longge.pojo.AdminAccount;
import com.longge.service.IAdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAccountServiceImpl implements IAdminAccountService {

    @Autowired
    private AdminAccountDao dao;

    @Override
    public List<AdminAccount> findAllAccount() {
        return dao.selectAll();
    }

    @Override
    public void addAccount(AdminAccount account) {
        dao.insert(account);
    }

    @Override
    public void deleteAccount(String id) {
        AdminAccount account = new AdminAccount();
        account.setId(Integer.parseInt(id));
        dao.delete(account);
    }

    @Override
    public AdminAccount updateAdminAccount(String adminAccountStr) {
        adminAccountStr = adminAccountStr.substring(1,adminAccountStr.length()-1);
        adminAccountStr = adminAccountStr.replace("\\\"","\"");
        JSONObject jsonObject = JSONObject.parseObject(adminAccountStr);
        AdminAccount adminAccount = JSON.toJavaObject(jsonObject,AdminAccount.class);
        dao.updateByPrimaryKeySelective(adminAccount);
        return adminAccount;
    }

    @Override
    public String findByUserName(String username) {
        return dao.findByUsername(username).getName();
    }
}
