package com.zzj.data;

import static org.junit.Assert.assertTrue;

import com.zzj.data.kfka.IExampleKafkaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class AppTest 
{
    @Autowired
    private IExampleKafkaService exampleKafkaService;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test()
    {
        exampleKafkaService.send("my-topic","你好");
    }
}
