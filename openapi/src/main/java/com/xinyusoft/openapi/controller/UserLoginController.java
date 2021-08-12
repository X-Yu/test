package com.xinyusoft.openapi.controller;

import com.xinyusoft.esb.helper.bean.EsbResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniesb.sdk.ESB;
import uniesb.sdk.Response;
import uniesb.sdk.ValueSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program openapi
 * @author: lhy
 * @create: 2019/11/21 10:00
 */

@RestController
@RequestMapping("/user")
public class UserLoginController  {

    /**
     * 获取用户
     * @return
     */
    public EsbResponse getUser(HttpServletRequest request, HttpServletResponse response){
        ESB.getInstance().sendAndGetReply(command, request, timeout);
        Response valueSet = ESBUtils.sendAndGetValidReply(Constant.NEWUSER_LOGIN_PHONE, request,response);
        ValueSet vs= (ValueSet) valueSet.getValue("loginbean");
        if(vs !=null){
            response.setValue("loginbean",vs);
        }
        response.setOPInfo(valueSet.getOPInfo());
    }
}
