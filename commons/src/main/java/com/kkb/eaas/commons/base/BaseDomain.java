package com.kkb.eaas.commons.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lixzh on 1/17/17.
 */
@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
public abstract class BaseDomain implements Serializable {
    private static final long serialVersionUID = -3905527698553456808L;

    protected Integer deleteFlag;
    protected Date createdAt;
    protected Date updatedAt;
}