package com.huike.eaas.commons.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by lixzh on 1/20/17.
 */

@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
public abstract class BaseObject implements Serializable {
    private static final long serialVersionUID = 1L;
}