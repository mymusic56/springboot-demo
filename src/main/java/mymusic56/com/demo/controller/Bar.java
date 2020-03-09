package mymusic56.com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import mymusic56.com.demo.dao.BarDao;
import mymusic56.com.demo.dto.BarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bar")
@Slf4j
public class Bar {

    @Autowired
    BarDao barDao;

    @RequestMapping("findById")
    public BarDto findAll(int id){
        BarDto d = barDao.findById(id);
        return d;
    }
}
