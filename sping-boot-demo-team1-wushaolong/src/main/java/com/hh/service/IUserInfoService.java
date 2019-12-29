package com.hh.service;

import com.hh.domain.UserInfo;

import java.util.List;

public interface IUserInfoService {
    public List<UserInfo> findAll();

    void create(UserInfo userInfo);

    void update(UserInfo userInfo);

    void delete(String id);
}
