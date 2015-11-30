package jdbc.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Configuration
public class SimpleJdbcApplication {
    private static Logger logger = LoggerFactory.getLogger(SimpleJdbcApplication.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleJdbcConfiguration.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        List<City> cities = jdbcTemplate.query("select * from City", (rs, rowNum) -> { // need to have sql in code
            return new City( // explicit mapping from ResultSet rs to City
                    rs.getLong("ID"),
                    rs.getString("Name"),
                    rs.getString("CountryCode"),
                    rs.getString("District"),
                    rs.getInt("Population")
            );
        });
        cities.forEach(city -> logger.info(city.toString()));

        logger.info("CountBefore: " + jdbcTemplate.queryForObject("select count(*) from City", Integer.class));
        jdbcTemplate.update("INSERT INTO `City` (NAME, CountryCode, District, Population) VALUES ('TEST','TST','Test',123456)");
        logger.info("CountAfter: " + jdbcTemplate.queryForObject("select count(*) from City", Integer.class));
    }
}
