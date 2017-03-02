package com.kkb.eaas.microservice.classes.domains;

import com.kkb.eaas.commons.base.BaseDomain;
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
    private String username;
}
