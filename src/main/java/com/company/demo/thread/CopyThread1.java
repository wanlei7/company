package com.company.demo.thread;

import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper;
import com.company.demo.mapper.CompanyMapper;
import com.company.demo.util.SpringContextUtil;

import java.util.List;

public class CopyThread1 extends Thread{

    public CopyThread1(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }
    @Override
    public void run() {
        CompanyMapper companyMapper = SpringContextUtil.getBean(CompanyMapper.class);
        while(true){
            Long maxId = companyMapper.selectMaxId();
            if (maxId == null) {
                maxId = 0L;
            }
            List<Company> companyList = companyMapper.selectNextPageCompany(maxId);
            if (companyList == null || companyList.size()==0) {
                System.out.println("cp1已完成");
                break;
            }
            for (int i = 0; i < companyList.size(); i++) {
                companyMapper.insert(companyList.get(i));
            }
        }
    }
}
