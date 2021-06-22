package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper4;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread4 extends Thread{

    public CopyThread4(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper4 companyMapper4 = SpringContextUtil.getBean(CompanyMapper4.class);
        while(true){
            Long maxId = companyMapper4.selectMaxId();
            if (maxId == null) {
                maxId = 100000000L;
            }
            List<Company> companyList = companyMapper4.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp4已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper4.insert(companyList.get(i));
            }
        }
    }
}
