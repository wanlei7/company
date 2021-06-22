package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper10;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread10 extends Thread{

    public CopyThread10(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper10 companyMapper10 = SpringContextUtil.getBean(CompanyMapper10.class);
        while(true){
            Long maxId = companyMapper10.selectMaxId();
            if (maxId == null) {
                maxId = 2000000000L;
            }
            List<Company> companyList = companyMapper10.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp10已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper10.insert(companyList.get(i));
            }
        }
    }
}
