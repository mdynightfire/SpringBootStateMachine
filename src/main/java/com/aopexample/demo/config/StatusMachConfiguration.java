package com.aopexample.demo.config;

import com.aopexample.demo.annotation.StatusMachineScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName StatusMatchConfiguration
 * @Description TODO
 * @Author deyin.mdy
 * @Date 2020/5/12 11:57 上午
 */
@Component
@StatusMachineScan(path = "com.aopexample.demo.service.workflow")
public class StatusMachConfiguration {

}
