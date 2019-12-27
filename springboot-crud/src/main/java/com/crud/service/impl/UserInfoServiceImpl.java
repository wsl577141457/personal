package com.crud.service.impl;

import com.crud.dao.UserInfoRepository;
import com.crud.domain.UserInfo;
import com.crud.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoRepository dao;

    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    @Override
    public void create(UserInfo userInfo) {
        dao.save(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        dao.save(userInfo);
    }

    @Override
    public void delete(String id) {
        dao.deleteById(Integer.parseInt(id));
    }


}
