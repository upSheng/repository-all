package com.chs.note.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/4 19:46
 */
public class PersonTest {

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        roster.stream().filter(x->x.getGender() == Person.Sex.MALE).forEach(x-> System.out.println(x.getName()));
        double average = roster.stream().filter(x -> x.getGender() == Person.Sex.MALE).mapToInt(Person::getAge).average().getAsDouble();
        Integer sum = roster.stream().filter(x -> x.getGender() == Person.Sex.MALE).mapToInt(Person::getAge).sum();
        Integer reduceSum = roster.stream().map(Person::getAge).reduce(1, Integer::sum);


        // collect  第一个方法存放结果容器,  容器添加元素,  结果容器合并
        ArrayList<Integer> oo = roster.stream().map(Person::getAge).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // 分组
        Map<Person.Sex, List<Person>> collect = roster.stream().collect(Collectors.groupingBy(Person::getGender));
        Map<Person.Sex, List<Integer>> collect1 = roster.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getAge, Collectors.toList())));


        System.out.println(sum);
        System.out.println(reduceSum);
    }
}
