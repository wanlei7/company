package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper6;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread6 extends Thread{

    public CopyThread6(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper6 companyMapper6 = SpringContextUtil.getBean(CompanyMapper6.class);
        while(true){
            Long maxId = companyMapper6.selectMaxId();
            if (maxId == null) {
                maxId = 1000000000L;
            }
            List<Company> companyList = companyMapper6.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp6已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper6.insert(companyList.get(i));
            }
        }
    }
}
