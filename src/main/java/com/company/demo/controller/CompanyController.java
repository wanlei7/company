package com.company.demo.controller;

import com.company.demo.service.CompanyService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 工商基本信息(Company)表控制层
 *
 * @author makejava
 * @since 2021-06-15 13:07:57
 */
@RestController
@RequestMapping(value = "/company")
public class CompanyController {
    /**
     * 服务对象
     */
    @Autowired
    private CompanyService companyService;


//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping(value = "/{id}")
//    public String selectOne(@PathVariable Long id) {
//        return this.companyService.selectCompanyById(id).toString();
//    }

    @GetMapping(value = "/copyCompany")
    public String copyCompany(){
        this.companyService.copyCompany();
        return "success";
    }

}
