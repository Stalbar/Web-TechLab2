package com.poit.main;

import com.poit.dao.ApplianceDAO;
import com.poit.dao.impl.ApplianceDAOImpl;
import com.poit.entity.criteria.Criteria;
import com.poit.service.ApplianceService;
import com.poit.service.impl.ApplianceServiceImpl;

public class Main {
    public static void main(String[] args) {
        ApplianceService applianceService = new ApplianceServiceImpl();
        Criteria criteria = new Criteria("Kettle");
        criteria.add("color", "White");
        for (var item: applianceService.find(criteria)){
            System.out.println(item);
        }
    }
}