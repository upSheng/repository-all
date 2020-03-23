import com.chs.Application;
import com.chs.aop.Cat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/23 19:47
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class TestA {

    @Autowired
    private Cat cat;


    @Test
    public void test1(){
        cat.say("ccc");
    }
}
