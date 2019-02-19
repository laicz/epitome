/**
 * Date:     2019/2/1920:47
 * AUTHOR:   Administrator
 */
package com.zhou.epitome.spring.anno.cap2.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 2019/2/19  20:47
 * created by zhoumb
 */
@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShowEnableService {
}
