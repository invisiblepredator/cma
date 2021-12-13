package com.gpw.cma;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories({
        "com.gpw.cma.domain.repository"
})
@EntityScan({
        "com.gpw.cma.domain"
})
public class ClientManageAppConfig {
}
