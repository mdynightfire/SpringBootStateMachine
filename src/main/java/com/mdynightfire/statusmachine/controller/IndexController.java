package com.mdynightfire.statusmachine.controller;

import com.mdynightfire.statusmachine.annotation.DoneTime;
import com.mdynightfire.statusmachine.service.bean.BeanCopierService;
import com.mdynightfire.statusmachine.service.workflow.OrderStatusMatchineWorkflowService;
import com.mdynightfire.statusmachine.service.workflow.TaskStatusMatchineWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@DoneTime
@RestController
public class IndexController {

    private static final String paramStr = "IndexController";

    @Autowired
    private OrderStatusMatchineWorkflowService orderStatusMatchineWorkflowService;

    @Autowired
    private TaskStatusMatchineWorkflowService taskStatusMatchineWorkflowService;

    @Autowired
    private BeanCopierService beanCopierService;

    @GetMapping("/index")
    @DoneTime(param = paramStr)
    public String index() {
        System.out.println("方法执行");
        //return "hello dalaoyang";
        throw new RuntimeException("exception");
    }

    @GetMapping("/index2")
    public String index2() {
        System.out.println("方法2执行");
        orderStatusMatchineWorkflowService.testOneStatusMatch("conetxt");
        taskStatusMatchineWorkflowService.test("context");
        return "hello dalaoyang";
    }

    @GetMapping("/index3")
    public String index3() {
        try {
            beanCopierService.testBeanCopier();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hello index3";
    }
}
