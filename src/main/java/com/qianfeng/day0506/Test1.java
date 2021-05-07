package com.qianfeng.day0506;

import com.qianfeng.DruidUtils;
import com.qianfeng.day0506.service.AccountService;
import com.qianfeng.day0506.service.impl.AccountServiceImpl;

public class Test1 {
    public static void main(String[] args) {
        AccountService service = new AccountServiceImpl();
        //service.transfer2(2,1,100d);
        System.out.println(DruidUtils.getConnection());
//        if (service.transfer2(2, 1, 100d)) {
//            System.out.println("transfer success!");
//        } else {
//            System.out.println("transfer failed!");
//        }
//        if (service.transfer(2, 1, 100d)) {
//            System.out.println("transfer success!");
//        } else {
//            System.out.println("transfer failed!");
//        }

    }
}
