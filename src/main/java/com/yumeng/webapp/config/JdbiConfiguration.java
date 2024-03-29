package com.yumeng.webapp.config;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbiConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(JdbiConfiguration.class);
    @Bean
    public Jdbi jdbi(DataSource dataSource){  //@Autowired DataSource dataSource
        logger.info("Connect to jdbi...");
        Jdbi j = Jdbi.create(dataSource)
                .installPlugin(new PostgresPlugin())
                .installPlugin(new SqlObjectPlugin());
        logger.info("[SUCCESS]Connect to jdbi SUCCESS.");
        return j;
    }
}
