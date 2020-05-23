package com.yajad.jmeter.util;


import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author honggenxiang
 * @date 2020/5/23
 **/
public class JsonUtilsTest {

    @Test
    public void toJson() {
        Sample sample = new Sample();
        sample.setName("小明");
        sample.setGmtCreate(LocalDateTime.now());
        System.out.println(JsonUtils.toJson(sample));
    }

    public static class Sample {
        private String name;
        private LocalDateTime gmtCreate;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDateTime getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(LocalDateTime gmtCreate) {
            this.gmtCreate = gmtCreate;
        }
    }
}