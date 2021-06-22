package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper3;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread3 extends Thread{

    public CopyThread3(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper3 companyMapper3 = SpringContextUtil.getBean(CompanyMapper3.class);
        while(true){
            Long maxId = companyMapper3.selectMaxId();
            if (maxId == null) {
                maxId = 50000000L;
            }
            List<Company> companyList = companyMapper3.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp3已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper3.insert(companyList.get(i));
            }
        }
    }
}
