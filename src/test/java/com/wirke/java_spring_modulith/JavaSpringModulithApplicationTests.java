package com.wirke.java_spring_modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.core.ApplicationModules;

@ApplicationModuleTest
class JavaSpringModulithApplicationTests {

    @Test
    void contextLoads() {
        ApplicationModules.of(JavaSpringModulithApplication.class).verify();
    }
}