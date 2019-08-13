package com.zzj.data;

import static org.junit.Assert.assertTrue;

import com.zzj.data.moudles.produre.service.ISendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes={Application.class})
@RunWith(SpringRunner.class)
public class AppTest 
{
    @Autowired
    private ISendService sendService;

    @Test
    public void test()
    {
        sendService.testSend();
    }

    @Test
    public void custom(){
        sendService.custom();
    }
}
