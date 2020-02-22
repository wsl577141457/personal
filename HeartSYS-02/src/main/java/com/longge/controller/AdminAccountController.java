package com.longge.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longge.pojo.AdminAccount;
import com.longge.service.IAdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminAccount")
public class AdminAccountController {

    @Autowired
    private IAdminAccountService accountService;

    @GetMapping
    public ResponseEntity<List<AdminAccount>> findAllAccount(){
        try {
            List<AdminAccount> accountList = accountService.findAllAccount();
            if(CollectionUtils.isEmpty(accountList)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(accountList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping
    public ResponseEntity<AdminAccount> addAccount(@RequestBody String accountStr){
        try {
            accountStr = accountStr.substring(1,accountStr.length()-1);
            accountStr = accountStr.replace("\\\"","\"");
            JSONObject json = JSONObject.parseObject(accountStr);
            AdminAccount account = JSON.toJavaObject(json,AdminAccount.class);
            accountService.addAccount(account);
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") String id){
        try {
            accountService.deleteAccount(id);
            return ResponseEntity.ok(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping
    public ResponseEntity<AdminAccount> updateAdminAccount(@RequestBody String adminAccountStr){
        try {
            AdminAccount adminAccount = accountService.updateAdminAccount(adminAccountStr);
            return ResponseEntity.ok(adminAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/1")
    public String findByUserName(String username){
        return accountService.findByUserName(username);
    }
}
