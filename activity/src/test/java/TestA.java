
import com.chs.activity.Application;
import com.chs.activity.aop.Cat;
import com.chs.activity.modal.entity.PersonEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/23 19:47
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class TestA {

    @Autowired
    private Cat cat;


    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void test1() {
        cat.say("ccc");
    }

    @Test
    public void test2() {

        PersonEntity joe = mongoTemplate.insert(new PersonEntity(null, "Joe", 34));

        System.out.println(joe);
        List<PersonEntity> all = mongoTemplate.findAll(PersonEntity.class);
        System.out.println(all);

    }
}
