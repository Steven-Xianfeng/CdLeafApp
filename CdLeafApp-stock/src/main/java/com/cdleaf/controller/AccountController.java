package com.cdleaf.controller;

import com.cdleaf.dao.entity.Account;
import com.cdleaf.dao.repository.AccountRepository;
import com.cdleaf.form.UserForm;
import com.cdleaf.helper.ControllerHelper;
import com.cdleaf.util.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Controller
public class AccountController implements StockController{
    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private ControllerHelper controllerHelper;

    @Autowired
    private AccountRepository accountRepository;



    @RequestMapping(value = "/")
    public String home(HttpServletRequest request, Model model) {
//        Account account = controllerHelper.findAccountFromCookie(request, model);

        logger.info(" AccountController :: home ");
        System.out.println(" home ........ zzzzz aaa ");
        Object account = request.getAttribute(ControllerHelper.USER_ATTRIBUTE_NAME);
        if (account == null) {
            logger.error(" AccountController :: home :: login account not found! ");
            return "signin";
        }

        return "home";
    }

    @RequestMapping(value = "/signin")
    public String signIn(@ModelAttribute("form") UserForm form, HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println(this.getClass() + "  signIn ");

        logger.info(" AccountController :: signIn ");

        model.addAttribute("userForm", form);

        Account account = controllerHelper.getAccountByUserName(form.getUserName());
        if (account == null) {
            model.addAttribute("accountNotExistError");
            return "signin";
        }

        if (!account.getPassword().equals(form.getUserPwd())) {
            model.addAttribute("passwordError");
            return "signin";
        }

        String uuid = controllerHelper.setAccountUUID(account);

        if (form.getChkSave() == 1) {
            CookieUtil.setCookie(response, CookieUtil.USER_COOKIE_NAME, uuid, CookieUtil.FOREVER);
        } else {
            CookieUtil.setCookie(response, CookieUtil.USER_COOKIE_NAME, uuid, CookieUtil.DELETE_EXIT);
        }

        return "home";
    }

    @RequestMapping(value = "/signout")
    public String signOut(HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println(this.getClass() + "  sign out ");

        CookieUtil.deleteCookie(response, CookieUtil.USER_COOKIE_NAME);

        return "signin";
    }

    @RequestMapping(value = "/stockList")
    public String stockList(HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println(this.getClass() + "  sign out ");

        CookieUtil.deleteCookie(response, CookieUtil.USER_COOKIE_NAME);

        return "stockList";
    }


    @PostMapping(path= "/addAccount", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addAccount(
            @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Account account)
            throws Exception
    {
        //Generate resource id
//        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
//        employee.setId(id);

        //add resource
//        employeeDao.addEmployee(employee);
        account = accountRepository.save(account);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();

        System.out.println(location.toString());
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
