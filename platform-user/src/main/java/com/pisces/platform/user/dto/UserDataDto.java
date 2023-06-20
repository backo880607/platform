package com.pisces.platform.user.dto;

import com.pisces.platform.user.bean.dataset.DataSetAccount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据dto
 *
 * @author jason
 * @date 2022/12/07
 */
@Data
public class UserDataDto {
    private Long accountId;
    private String username;
    private String fullName;
    private String avatar;
    private String email;
    private String telephone;
    private Long lastDataSet;
    private List<DataSetAccount> dataSets = new ArrayList<>();
}
