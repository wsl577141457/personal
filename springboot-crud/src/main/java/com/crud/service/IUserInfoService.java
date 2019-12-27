package com.crud.service;

import com.crud.domain.UserInfo;

import java.util.List;

public interface IUserInfoService {
    public List<UserInfo> findAll();

    void create(UserInfo userInfo);

    void update(UserInfo userInfo);

    void delete(String id);
}
