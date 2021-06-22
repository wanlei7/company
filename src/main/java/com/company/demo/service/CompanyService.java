package com.company.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.demo.entity.Company;
import com.company.demo.mapper.CompanyMapper;
import com.company.demo.thread.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工商基本信息(Company)表服务接口
 *
 * @author makejava
 * @since 2021-06-15 13:07:53
 */
@Service
public class CompanyService  {

//    @Autowired
//    CompanyMapper companyMapper;
//
//    public Company selectCompanyById(Long id){
//
//       Company com =  companyMapper.selectById(id);
//       return com;
//    }

    public void  copyCompany(){
        CopyThread1 cp1 =new CopyThread1("cp1");
        cp1.start();

        CopyThread2 cp2 =new CopyThread2("cp2");
        cp2.start();

        CopyThread3 cp3 =new CopyThread3("cp3");
        cp3.start();

        CopyThread4 cp4 =new CopyThread4("cp4");
        cp4.start();

        CopyThread5 cp5 =new CopyThread5("cp5");
        cp5.start();

//        CopyThread6 cp6 =new CopyThread6("cp6");
//        cp6.start();
//
//        CopyThread7 cp7 =new CopyThread7("cp7");
//        cp7.start();
//
//        CopyThread8 cp8 =new CopyThread8("cp8");
//        cp8.start();
//
//        CopyThread9 cp9 =new CopyThread9("cp9");
//        cp9.start();

        CopyThread10 cp10 =new CopyThread10("cp10");
        cp10.start();



//        for (int j = 0; j < 10000; j++) {
//            Long maxId = companyMapper.selectMaxId();
//            List<Company> companyList = companyMapper.selectNextPageCompany(maxId);
//            for (int i = 0; i < companyList.size(); i++) {
//                companyMapper.insert(companyList.get(i));
//            }
//        }

    }

}
