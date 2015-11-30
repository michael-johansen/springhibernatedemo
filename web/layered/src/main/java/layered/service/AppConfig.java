package layered.service;

import layered.repositories.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@Import(PersistenceConfig.class)
@EnableTransactionManagement
public class AppConfig {
}
