package com.mymusic56.demo.dao;

import com.mymusic56.demo.rowMaper.BarRowMapper;
import com.mymusic56.demo.dto.BarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BarDao {

    @Autowired
    @Qualifier("db1JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public BarDto findById(int id) {
        String sql = "select * from bar where id=? limit 1";
        List<BarDto> barList = jdbcTemplate.query(sql, new Object[]{id}, new BarRowMapper());

        if (!barList.isEmpty()) {
            return barList.get(0);
        }
        return null;
    }

}
