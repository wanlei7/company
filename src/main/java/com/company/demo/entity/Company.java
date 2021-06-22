package com.company.demo.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 工商基本信息(Company)表实体类
 *
 * @author makejava
 * @since 2021-06-15 13:07:51
 */
@SuppressWarnings("serial")
@Data
public class Company extends Model<Company> {

    private Long id;
    //公司标识
    private Long cid;
    //归属省份的首字母小写
    private String base;
    //公司名称
    private String name;
    //英文名
    private String nameEn;
    //公司别名
    private String nameAlias;
    //公司历史名称
    private String historyNames;
    //法人ID：人标识或公司标识
    private Long legalEntityId;
    //法人类型，1 人 2 公司
    private Integer legalEntityType;
    //注册号
    private String regNumber;
    //公司类型
    private String companyOrgType;
    //注册地址
    private String regLocation;
    //成立日期
    private Date estiblishTime;
    //营业期限开始日期
    private Date fromTime;
    //营业期限终止日期
    private Date toTime;
    //经营范围
    private String businessScope;
    //登记机关
    private String regInstitute;
    //核准日期
    private Date approvedTime;
    //企业状态
    private String regStatus;
    //注册资本
    private String regCapital;
    //组织机构代码
    private String orgNumber;
    //组织机构批准单位
    private String orgApprovedInstitute;
    //如果该条记录为历史名称，则该字段值对应最新名称那条记录的id
    private Long currentCid;
    //上级机构ID
    private Long parentCid;
    //机构类型-1-公司，2-香港公司，3-社会组织，4-律所，5-事业单位，6-基金会，7-不存在法人、注册资本、统一社会信用代码、经营状态
    private Integer companyType;
    //统一社会信用代码
    private String creditCode;
    //公司评分
    private String score;
    //行业分类
    private String categoryCode;
    //公司纬度
    private Double lat;
    //公司经度
    private Double lng;
    //行政区划码
    private Integer areaCode;
    //注册资本金额，数值类型
    private Long regCapitalAmount;
    //注册资本币种  人民币 美元 欧元 等
    private String regCapitalCurrency;
    //实收资本金额（单位：分）
    private Long actualCapitalAmount;
    //实收资本币种 人民币 美元 欧元等
    private String actualCapitalCurrency;
    //公司注册状态标准化
    private String regStatusStd;
    //职工参保人数
    private Integer socialSecurityStaffNum;
    //注销日期
    private Date cancelDate;
    //注销原因
    private String cancelReason;
    //吊销日期
    private Date revokeDate;
    //吊销原因/吊销凭证
    private String revokeReason;
    //邮箱列表
    private String emails;
    //电话
    private String phones;
    //微信公众号
    private String wechatPublicNum;
    //公司logo
    private String logo;
    //解析完成时间
    private Date crawledTime;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;


}
