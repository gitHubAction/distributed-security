package com.seven.distributed.uaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @Author: zhangsh
 * @Date: 2020/4/16 12:13
 * @Version 1.0
 * Description
 */

@Data
@AllArgsConstructor
public class SevenUserDto {

    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
    /**
     * 用户权限
     */
    private Set<String> authorities;
}
