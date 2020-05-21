package com.aopexample.demo.service.workflow;

import com.aopexample.demo.annotation.DoneTime;
import com.aopexample.demo.annotation.StatusMachineService;

/**
 * @ClassName TaskStatusMatchineWorkflowService
 * @Description TODO
 * @Author deyin.mdy
 * @Date 2020/5/13 10:24 上午
 */
@StatusMachineService
public interface TaskStatusMatchineWorkflowService {

    /**
     * 测试
     * @param context
     */
    @DoneTime
    void test(String context);
}
