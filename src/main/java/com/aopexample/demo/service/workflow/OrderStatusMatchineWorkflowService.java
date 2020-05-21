package com.aopexample.demo.service.workflow;

import com.aopexample.demo.annotation.DoneTime;
import com.aopexample.demo.annotation.StatusMachineService;

@StatusMachineService
public interface OrderStatusMatchineWorkflowService {

    /**
     * 测试
     * @param context
     */
    @DoneTime
    void testOneStatusMatch(String context);
}
