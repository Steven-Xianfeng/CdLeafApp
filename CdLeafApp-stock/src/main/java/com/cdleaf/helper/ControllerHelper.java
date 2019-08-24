package com.cdleaf.helper;

import com.cdleaf.dao.entity.Account;
import com.cdleaf.dao.repository.AccountRepository;
import com.cdleaf.form.UserForm;
import com.cdleaf.service.AccountService;
import com.cdleaf.util.CookieUtil;
import com.cdleaf.util.GenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component(value = "controllerHelper")
public class ControllerHelper {
    public static final String USER_ATTRIBUTE_NAME = "account";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AccountRepository accountRepository;

//    @Autowired
//    private AccountService accountService;

    public String setAccountUUID(Account account) {
        if (account == null) {
            return null;
        }

        String id = String.valueOf(account.getId());
        String val = redisTemplate.opsForValue().get(id);
        if(val != null){
            return val;
        }

        val = GenUtil.genUUID();
        redisTemplate.opsForValue().set(val, id);
        redisTemplate.opsForValue().set(id, val);

        return val;
    }

    public Account findAccountFromCookie(HttpServletRequest request, Model model){
        Account account =  this.getAccountByUUID(
                CookieUtil.getCookie(request, CookieUtil.USER_COOKIE_NAME)
        );

        if (account != null) {
            model.addAttribute(USER_ATTRIBUTE_NAME, account);
        }

        return account;
    }

    public Account getAccountByUUID(String uuid){
        if (uuid == null) {
            return null;
        }

        String val = redisTemplate.opsForValue().get(uuid);

        if(val == null) return null;

       return accountRepository.findAccountById(Long.valueOf(val));
    }

    public Account getAccountByUserName(String userName){
        if (userName == null) {
            return null;
        }

        if(userName.trim().equals("")){
            return null;
        }

        return accountRepository.findAccountByUserName(userName);
    }
}
