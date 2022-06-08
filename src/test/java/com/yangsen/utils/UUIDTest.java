package com.yangsen.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class UUIDTest {
    //声明logger
    public static final Logger logger = LogManager.getLogger();
    @Test
    public void getUUID(){
        logger.info(UUIDUtil.getUUID());
    }
}
