package com.company.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.demo.entity.Company;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@DS("master")
public interface CompanyMapper9 extends BaseMapper<Company> {

    @Override
    @DS("slave_9")
    public int insert(Company company);


    @DS("slave_9")
    @Select("select max(id) from company")
    public Long selectMaxId();


    @Select("select * from company where id > #{maxId} and id<=1800000000 order by id limit 1000")
    public List<Company> selectNextPageCompany(Long maxId);

}
