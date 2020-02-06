package com.chs.gof23.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/1/21<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/1/21            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class Teacher {


    private List<Student> students = new ArrayList<>();

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {

        students.remove(student);
    }

    public void notifyStudent(String msg) {
        for (Student student : students) {
            student.update(msg);
        }
    }

    public static void main(String[] args) {


        Teacher subject = new Teacher();
        Student studentOne = new StudentOne();
        Student studentSecond = new StudentSecond();
        subject.registerStudent(studentOne);
        subject.registerStudent(studentSecond);

        subject.notifyStudent("作业1");
        subject.removeStudent(studentOne);
        subject.notifyStudent("作业2");


        /**
         * 运行控制台打印结果如下
         *
         * studentOne收到作业1
         * studnetSecond收到作业1
         * studnetSecond收到作业2
         */



    }
}
