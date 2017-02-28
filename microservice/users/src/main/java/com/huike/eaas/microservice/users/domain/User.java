package com.huike.eaas.microservice.users.domain;

import com.huike.eaas.commons.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by lixzh on 1/17/17.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class User extends BaseDomain {
    private int id;
    private String firstName;
    private String lastName;
}
