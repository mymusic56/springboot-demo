package mymusic56.com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@Slf4j
@RestController
@RequestMapping("/helloWorld")
public class HelloWorld {

    @Autowired
    private Jedis redis;

    @RequestMapping("getRedisValue")
    public String getRedisValue(@RequestParam(value = "name", defaultValue = "a") String name){
        //http://localhost:8080/helloWorld/getRedisValue?name=name
        String a = redis.get(name);
        log.info("----name="+a);
        return a;
    }

}
