package com.mdynightfire.statusmachine.config;

import com.mdynightfire.statusmachine.annotation.StatusMachineScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName StatusMatchConfiguration
 * @Description TODO
 * @Author deyin.mdy
 * @Date 2020/5/12 11:57 上午
 */
@Component
@StatusMachineScan(path = "com.mdynightfire.statusmachine.service.workflow")
public class StatusMachConfiguration {

}
