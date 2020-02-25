package mymusic56.com.demo.service;

import lombok.extern.slf4j.Slf4j;
import mymusic56.com.demo.component.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
@Slf4j
public class MultiDataSourceService {

    @Autowired
    @Qualifier("fooDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("fooJdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public MultiDataSourceService(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getInfo() {

        jdbcTemplate.queryForList("SELECT * FROM FOO")
                .forEach(row -> log.info("------result:"+row.toString()));

        return "multiDataSourceService";
    }
}
