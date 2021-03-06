package com.mdynightfire.statusmachine.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mdynightfire.statusmachine.proxy.StatusMachScanRegistrar;
import org.springframework.context.annotation.Import;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(StatusMachScanRegistrar.class)
public @interface StatusMachineScan {

    String[] path() default {};

}
