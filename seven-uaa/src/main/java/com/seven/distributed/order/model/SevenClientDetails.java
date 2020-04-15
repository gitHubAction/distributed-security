package com.seven.distributed.order.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.io.Serializable;
import java.util.Set;

@Data
@ToString
public class SevenClientDetails implements Serializable {

    private String clientId;

    private Set<String> resourceIds;

    private boolean secretRequired;

    private String clientSecret;

    private boolean scoped;

    private Set<String> scope;


    private Set<String> authorizedGrantTypes;

    private String authorities;

    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    private boolean autoApprove;

}
