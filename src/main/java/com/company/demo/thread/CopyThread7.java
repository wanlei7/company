package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper7;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread7 extends Thread{

    public CopyThread7(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper7 companyMapper7 = SpringContextUtil.getBean(CompanyMapper7.class);
        while(true){
            Long maxId = companyMapper7.selectMaxId();
            if (maxId == null) {
                maxId = 1200000000L;
            }
            List<Company> companyList = companyMapper7.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp7已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper7.insert(companyList.get(i));
            }
        }
    }
}
