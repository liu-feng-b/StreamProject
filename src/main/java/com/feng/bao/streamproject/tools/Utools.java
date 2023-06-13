package com.feng.bao.streamproject.tools;

import com.feng.bao.streamproject.entity.People;

import java.util.*;
import java.util.stream.Collectors;

public class Utools {
    public static void main(String[] args) {
        List<People> list = Arrays.asList(new People("tom", 18, "伦敦"),
                new People("jerry", 20, "伦敦"),
                new People("mock", 22, "家里敦"),
                new People("check", 19, "家里敦"),
                new People("jec", 15, "伦敦"));

        orderSorting(list);
        descSorting(list);
        avgAge(list);
        grouping(list);
        maxAndMinAge(list);
        getMedian(list);
        mapping(list);
    }

    /**
     * 顺序排序
     * @param list 列表
     */
    public static void orderSorting(List<People> list) {
        List<People> peopleList = list.stream()
                .sorted(Comparator.comparing(People::getAge))
                .collect(Collectors.toList());
        for (People people : peopleList) {
            System.out.println(people);
        }
    }

    /**
     * 降序排序
     * @param list 列表
     */
    public static void descSorting(List<People> list) {
        List<People> peopleList = list.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .collect(Collectors.toList());
        /**
         * 匿名内部类可改成lambda表达式
         * */
        for (People people : peopleList) {
            System.out.println(people);
        }
    }

    /**
     * 平均年龄
     * @param list 列表
     */
    public static void avgAge(List<People> list) {
        double avg = list.stream().mapToInt(People::getAge).average().orElse(0);
        System.out.println("平均年龄为 : " + avg);
    }

    /**
     * 最大和最小年龄
     * @param list 列表
     */
    public static void maxAndMinAge(List<People> list) {
        Integer maxAge = list.stream().mapToInt(People::getAge).max().orElse(0);
        Integer minAge = list.stream().mapToInt(People::getAge).min().orElse(0);
        System.out.println("最大年龄为：" + maxAge);
        System.out.println("最小年龄为：" + minAge);
    }

    /**
     * 获取中位数
     * @param list 列表
     */
    public static void getMedian(List<People> list) {
        int[] ages = list.stream().mapToInt(People::getAge).sorted().toArray();
        if (ages.length / 2 == 0) {
            System.out.println("中位数:" + (ages[ages.length / 2 - 1] + ages[ages.length / 2]) / 2);
        } else {
            System.out.println("中位数:" + ages[ages.length / 2]);
        }
    }

    /**
     * 按城市分组
     * @param list 列表
     */
    public static void grouping(List<People> list) {
        Map<String, List<People>> map = list.stream().collect(Collectors.groupingBy(People::getCity));
        map.forEach((k, v) -> System.out.println("城市" + k + "有 : " + v + "个" + v.size() + "人"));
    }

    /**
     * 映射
     * @param list 列表
     */
    public static void mapping(List<People> list){
        list.stream()
                .map(item->new People(item.getName(),item.getCity()))
                .collect(Collectors.toList())
                .forEach(item-> System.out.println(item.getName()+"->"+item.getCity()));
    }
}
