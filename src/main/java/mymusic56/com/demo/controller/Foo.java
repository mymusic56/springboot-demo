package mymusic56.com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import mymusic56.com.demo.dao.BarDao;
import mymusic56.com.demo.dao.FooDao;
import mymusic56.com.demo.dto.FooDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/foo")
@Slf4j
public class Foo {

    @Autowired
    FooDao fooDao;

    @Autowired
    BarDao barDao;

    @RequestMapping("findAll")
    public List<Map<String, Object>> findAll(){
        List<Map<String, Object>> d = fooDao.findAll();

        return d;
    }

    @RequestMapping("findById")
    public FooDto findById(int id){
//        http://localhost:8080/foo/findById?id=1
        FooDto d = fooDao.findById(id, 1);

        return d;
    }

    @GetMapping("/{id}")
    public FooDto findByIdV2(@PathVariable int id){
        //http://localhost:8080/foo/1
        FooDto d = fooDao.findById(id, 1);

        return d;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map<String, String> save(@RequestParam Map<String, String> params) {
        Map<String, String> row = fooDao.insertData(params);
        return row;
    }
}
