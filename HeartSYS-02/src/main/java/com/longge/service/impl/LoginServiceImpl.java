package com.longge.service.impl;

import com.longge.dao.AdminAccountDao;
import com.longge.dao.StudentAccountDao;
import com.longge.dao.TeacherAccountDao;
import com.longge.pojo.AdminAccount;
import com.longge.pojo.StudentAccount;
import com.longge.pojo.TeacherAccount;
import com.longge.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private AdminAccountDao adminAccountDao;
    @Autowired
    private TeacherAccountDao teacherAccountDao;
    @Autowired
    private StudentAccountDao studentAccountDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String role = s.substring(0,s.indexOf("-"));
        String username = s.substring(s.indexOf("-")+1,s.length());
        if("admin".equals(role)){
            AdminAccount adminAccount = adminAccountDao.findByUsername(username);
            if (adminAccount == null){
                throw new UsernameNotFoundException("没有该用户");
            }
            else {
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_管理员");
                grantedAuthorities.add(grantedAuthority);
                return new User(adminAccount.getUsername(),new BCryptPasswordEncoder().encode(adminAccount.getPassword()),grantedAuthorities);
            }

        }
        else if ("teacher".equals(role)){
            TeacherAccount teacherAccount = teacherAccountDao.findByUsername(username);
            if (teacherAccount == null){
                throw new UsernameNotFoundException("没有该用户");
            }
            else {
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_老师");
                grantedAuthorities.add(grantedAuthority);
                return new User(teacherAccount.getUsername(),new BCryptPasswordEncoder().encode(teacherAccount.getPassword()),grantedAuthorities);
            }
        }
        else if("student".equals(role)){
            StudentAccount studentAccount = studentAccountDao.findByUsername(username);
            if (studentAccount == null){
                throw new UsernameNotFoundException("没有该用户");
            }
            else {
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_学生");
                grantedAuthorities.add(grantedAuthority);
                return new User(studentAccount.getUsername(),new BCryptPasswordEncoder().encode(studentAccount.getPassword()),grantedAuthorities);
            }
        }
        throw new UsernameNotFoundException("没有该用户");
    }
}
