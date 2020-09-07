package com.chs.note.steam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/4 19:46
 */
public class PersonTest {


    static abstract class Tt extends PersonTest {
        void add(String a) {
        }
    }

    void cc(String aa) {
        new PersonTest() {
            @Override
            void cc(String aa) {
                super.cc(aa);
            }
        };
    }

    public static void main(String[] args) {

        int a = Stream.of(1, 2, 3).reduce(Integer::sum).get();
        int b = Stream.of(1, 2, 3).reduce(1, Integer::sum);
        List<Integer> c = Stream.of(1, 2, 3).reduce(new ArrayList<>(), (x, y) -> {
            x.add(y);
            return x;
        }, (x, y) -> {
            x.addAll(y);
            return x;
        });
        List<Integer> d = Stream.of(1, 2, 3).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Integer> e = Stream.of(1, 2, 3).map(x -> x + 1).collect(Collectors.toList());

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        String[] words = new String[]{"Hello","World"};

        List<String> collect = Arrays.stream(words).map(x->x.split("")).flatMap(Stream::of).collect(Collectors.toList());
        System.out.println(collect);


        List<Person> roster = Person.createRoster();
        Map<Person.Sex, Long> count = roster.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.counting()));
        Map<Person.Sex, Optional<Person>> collect1 = roster.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.maxBy(Comparator.comparingInt(Person::getAge))));


        Map<String,String> map = new HashMap<>();

        map.computeIfAbsent("name",x->x+"cc");
        map.computeIfAbsent("name",x->x+"aa");
        System.out.println(map);

        Stream.of(1, 2, 3).mapToInt(x -> x).sum();

//
//        roster.stream().filter(x->x.getGender() == Person.Sex.MALE).collect(Collectors.toList());
//        long count = roster.stream().mapToInt(Person::getAge).count();
//        Integer sum = roster.stream().filter(x -> x.getGender() == Person.Sex.MALE).mapToInt(Person::getAge).sum();
        //Integer reduceSum = roster.stream().map(Person::getAge).reduce(1, Integer::sum);

//
//
//        // collect  第一个方法存放结果容器,  容器添加元素,  结果容器合并
//        ArrayList<Integer> oo = roster.stream().map(Person::getAge).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//
//        // 分组

//        Map<Person.Sex, List<Integer>> collect1 = roster.stream()
//                .collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getAge, Collectors.toList())));


        //List<Person> collect2 = roster.stream().filter(x -> x.getGender() == Person.Sex.MALE).collect(Collectors.toList());

    }
}
