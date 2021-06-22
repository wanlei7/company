package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper8;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread8 extends Thread{

    public CopyThread8(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper8 companyMapper8 = SpringContextUtil.getBean(CompanyMapper8.class);
        while(true){
            Long maxId = companyMapper8.selectMaxId();
            if (maxId == null) {
                maxId = 1400000000L;
            }
            List<Company> companyList = companyMapper8.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp8已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper8.insert(companyList.get(i));
            }
        }
    }
}
