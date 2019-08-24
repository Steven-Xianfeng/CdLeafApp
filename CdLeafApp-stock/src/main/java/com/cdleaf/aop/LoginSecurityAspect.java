package com.cdleaf.aop;

import com.cdleaf.dao.entity.Account;
import com.cdleaf.helper.ControllerHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoginSecurityAspect {
    @Autowired
    private ControllerHelper controllerHelper;

    @Before("execution(* com.cdleaf.controller.StockController+.*(..))")
    public void checkAccountLogin(JoinPoint joinPoint){
        System.out.println(this.getClass() + " before() " + joinPoint.getSignature());

        HttpServletRequest request = null;
        Model model = null;
        Account account = null;

        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for(Object obj : args){
                if(obj instanceof HttpServletRequest) {
                    request = (HttpServletRequest)obj;
                    System.out.println("    ==============  find request !");
                } else if (obj instanceof Model){
                    model = (Model)obj;
                    System.out.println("    ==============  find model !");
                }
            }
        }

        account = controllerHelper.findAccountFromCookie(request, model);
        if(model != null){
            if(account != null){
                model.addAttribute(ControllerHelper.USER_ATTRIBUTE_NAME, account);
            }
        }





    }
}
