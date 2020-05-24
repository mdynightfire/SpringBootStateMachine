package com.mdynightfire.statusmachine.service.workflow;

import com.mdynightfire.statusmachine.annotation.DoneTime;
import com.mdynightfire.statusmachine.annotation.StatusMachineService;

@StatusMachineService
public interface OrderStatusMatchineWorkflowService {

    /**
     * 测试
     * @param context
     */
    @DoneTime
    void testOneStatusMatch(String context);
}
