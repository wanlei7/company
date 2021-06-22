package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper5;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread5 extends Thread{

    public CopyThread5(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper5 companyMapper5 = SpringContextUtil.getBean(CompanyMapper5.class);
        while(true){
            Long maxId = companyMapper5.selectMaxId();
            if (maxId == null) {
                maxId = 150000000L;
            }
            List<Company> companyList = companyMapper5.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp5已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper5.insert(companyList.get(i));
            }
        }
    }
}
