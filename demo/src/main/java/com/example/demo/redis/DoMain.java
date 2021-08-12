package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-04-22 14:43  //时间
 */
public class DoMain {
    public static final String SEPARATOR_KEY = ":";
    public static final String LATEST_MESSAGE = "ltms";
    public static final String TOPICS = "tps";

    public static void main(String[] args) {
        boolean isreg = true;
        String project = "OK2E";
        String target = "316";
        String topics = "chat.*";

        RedisConnectionFactory redisConnectionFactory;
        JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
        jedisConnectionFactory.setPort(6379);
        RedisTemplate redisTemplate = new RedisTemplate();
        SetOperations<String, String> setOp = redisTemplate.opsForSet();
        HashOperations hashOp = redisTemplate.opsForHash();
        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();


        Set<String> topicSet;
        if (isreg) {
            String key = toKey(project, target, TOPICS);
            System.out.println(key + "---------具体的key");
            topicSet = setOp.members(key);
        } else {
            topicSet = StringUtils.commaDelimitedListToSet(topics);
            if (topicSet.size() == 0) topicSet = setOp.members(toKey(project, target, TOPICS));
        }

        long total = 0, count;
        System.out.println(System.currentTimeMillis() + "start");
        for (String topic : topicSet) {
            if (isreg && !Pattern.matches(topics, topic)) continue;
            count = hashOp.size(toKey(project, target, topic));
            String latestMsg = valueOp.get(toKey(project, target, topic, LATEST_MESSAGE));
            if (Objects.nonNull(latestMsg)) {
                String[] array = splitKey(latestMsg);
            }
            total += count;
        }
        System.out.println(System.currentTimeMillis() + "end");
    }

    public static String toKey(String... factors) {
        return String.join(SEPARATOR_KEY, factors);
    }

    public static String[] splitKey(String key) {
        if (Objects.isNull(key)) return new String[]{"null"};
        return key.split(SEPARATOR_KEY, 2);
    }
}
