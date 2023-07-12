package com.pisces.platform.user.bean.organization;

import com.pisces.framework.core.entity.BeanObject;
import com.pisces.framework.type.annotation.PropertyMeta;
import com.pisces.framework.type.annotation.TableMeta;
import com.pisces.platform.user.enums.organization.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 员工
 *
 * @author jason
 * @date 2022/12/03
 */
@Getter
@Setter
@TableMeta(name = "USER_EMPLOYEE")
public class Employee extends BeanObject {
    private String employeeCode;
    @PropertyMeta(popDisplay = true)
    private String employeeName;
    private String englishName;
    private String avatar;
    private EMPLOYEE_TYPE type;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$")
    @NotBlank()
    private String telephone;
    @Email
    private String email;
    private GENDER gender;
    /**
     * 是否已婚
     */
    private Boolean married;
    /**
     * 证件类型
     */
    private IDENTITY_TYPE idType;
    /**
     * 证件编号
     */
    private String idCode;
    /**
     * 出生日期
     */
    private Date dob;
    /**
     * 国籍
     */
    private String country;
    /**
     * 籍贯
     */
    private NATIVE_PLACE nativePlace;
    /**
     * 名族
     */
    private NATIONALITY_TYPE nationality;
    private String address;

    /**
     * 毕业学校
     */
    private String school;
    /**
     * 专业
     */
    private String major;
    /**
     * 学历
     */
    private DEGREE_TYPE degree;
    /**
     * 毕业日期
     */
    private Date graduateDate;
    /**
     * 紧急联系人
     */
    private String emergeContact;
    /**
     * 紧急电话
     */
    private String emergePhone;
    /**
     * 入职日期
     */
    private Date onboardDate;
    /**
     * 转正日期
     */
    private Date permanentDate;
    /**
     * 离职日期
     */
    private Date departureDate;

    @Override
    public void init() {
        super.init();
        employeeCode = "";
        employeeName = "";
        englishName = "";
        type = EMPLOYEE_TYPE.TRAINEE;
        avatar = "";
        telephone = "";
        email = "";
        gender = GENDER.MALE;
        address = "";
        married = false;
        idType = IDENTITY_TYPE.ID;
        idCode = "";
        dob = new Date();
        country = "";
        school = "";
        degree = DEGREE_TYPE.COLLEGE;
        major = "";
        graduateDate = new Date();
        nativePlace = NATIVE_PLACE.BEIJING;
        nationality = NATIONALITY_TYPE.HAN_ETHNIC;
        emergeContact = "";
        emergePhone = "";
        onboardDate = new Date();
        permanentDate = new Date();
        departureDate = new Date();
    }
}
