package com.chs.task;

import com.chs.task.element.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/21 19:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TaskPoolConfigTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void tt() {

        try {
            for (int i = 0; i < 100; i++) {
                Future<String> future = asyncTask.tesTask(i);
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addTest() {

        for (int i = 0; i < 100; i++) {
            asyncTask.add(i);
        }

    }
}
