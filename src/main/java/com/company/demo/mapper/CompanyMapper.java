package com.company.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.demo.entity.Company;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@DS("master")
public interface CompanyMapper extends BaseMapper<Company> {

    @Override
    @DS("slave_1")
    public int insert(Company company);


    @DS("slave_1")
    @Select("select max(id) from company")
    public Long selectMaxId();


    @Select("select * from company where id > #{maxId} and id<=50000000 order by id limit 100")
    public List<Company> selectNextPageCompany(Long maxId);

}
