package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper9;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread9 extends Thread{

    public CopyThread9(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper9 companyMapper9 = SpringContextUtil.getBean(CompanyMapper9.class);
        while(true){
            Long maxId = companyMapper9.selectMaxId();
            if (maxId == null) {
                maxId = 1600000000L;
            }
            List<Company> companyList = companyMapper9.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp9已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper9.insert(companyList.get(i));
            }
        }
    }
}
