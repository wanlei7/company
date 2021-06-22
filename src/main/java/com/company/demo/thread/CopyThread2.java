package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper2;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread2 extends Thread{

    public CopyThread2(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper2 companyMapper2 = SpringContextUtil.getBean(CompanyMapper2.class);
        while(true){
            Long maxId = companyMapper2.selectMaxId();
            if (maxId == null) {
                maxId = 200000000L;
            }
            List<Company> companyList = companyMapper2.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp2已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper2.insert(companyList.get(i));
            }
        }
    }
}
