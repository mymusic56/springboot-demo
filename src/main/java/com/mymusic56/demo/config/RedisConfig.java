package com.mymusic56.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Configuration
@PropertySource("multi-datasource.properties")
public class RedisConfig {
	
	@Value("${spring.data.redis.host}")
	private String host;
	
	@Value("${spring.data.redis.port}")
	private int port;
	
	@Value("${spring.data.redis.password}")
	private String password;
	
	@Value("${spring.data.redis.timeout}")
	private int timeout;

	@Value("${spring.data.redis.auth}")
	private boolean auth;

	@Value("${spring.data.redis.db}")
	private int db;
	
	@Bean
	public JedisPoolConfig getRedisConfig(){
		return new JedisPoolConfig();
	}
	
	@Bean
	public JedisPool getJedisPool(){
		JedisPoolConfig config = getRedisConfig();
		return new JedisPool(config, host, port, timeout, password, db);
	}
	
	@Bean
	public Jedis redis() {
		log.info("-----Redis: host="+host+", port="+port+", db="+db);
		Jedis redis= new Jedis(host, port, timeout);
		if (auth) {
			redis.auth(password);
		}
		redis.select(db);
		return redis;
	}
}
