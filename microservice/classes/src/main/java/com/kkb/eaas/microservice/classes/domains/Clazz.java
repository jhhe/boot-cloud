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
public class Clazz extends BaseDomain {
    private Long class_id;
    private String class_name;
    private Long classId;
    private String className;
}
