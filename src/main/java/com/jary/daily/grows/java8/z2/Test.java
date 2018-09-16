package com.jary.daily.grows.java8.z2;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import com.jary.daily.grows.java8.bean.Dish;
import com.jary.daily.grows.java8.z1.Apple;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanzhengjie
 * @create 2018/7/22 下午2:28
 * @description
 */
public class Test {

    private static List<Apple> inventory = Lists.newArrayList();

    static {
        Apple apple1 = new Apple();
        apple1.setWeight(100);
        apple1.setColor(ColorEnum.RED.getColor());

        Apple apple2 = new Apple();
        apple2.setWeight(50);
        apple2.setColor(ColorEnum.BLUE.getColor());

        Apple apple3 = new Apple();
        apple3.setWeight(120);
        apple3.setColor(ColorEnum.YELLOW.getColor());

        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
    }

    public static void main(String[] args){
        //testThread();
        //commonStream();
        //testDish();
        testDish2();
        testMap();
        testArray();
        testReduce();
    }

    private static void testThread(){
        Thread t = new Thread(()-> System.out.println("Hello World"));
        t.start();
    }

    private static void print(){
        inventory.stream().forEach(a -> System.out.println(a));
    }

    private static void commonStream(){
        inventory.sort(Comparator.comparing(Apple::getWeight));
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
    }

    private static void testDish(){

        //1.数据初始化
        List<Dish> menus = Lists.newArrayList();
        menus.add(new Dish("aa", 450));
        menus.add(new Dish("bb", 300));
        menus.add(new Dish("cc", 130));
        menus.add(new Dish("dd", 350));
        menus.add(new Dish("ee", 500));

        List<String> lowCaloriesDishsName = menus.stream().filter(dish -> dish.getCalories() < 400)
            .sorted(comparing(Dish::getCalories))
            .map(Dish::getName)
            .collect(toList());

        System.out.println(lowCaloriesDishsName);

        //依据菜品名称分组
        Map<String, List<Dish>> listMap = menus.stream().collect(groupingBy(Dish::getName));
        System.out.println(listMap);

    }

    public static void testDish2(){
        List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<String> threeHighCaloricDishName = menu.stream().filter(dish -> dish.getCalories() > 300)
            .map(Dish::getName)
            .limit(3)
            .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishName);

        List<Integer> dishNameLen = menu.stream().map(Dish::getName)
            .map(String::length).collect(toList());
        System.out.println(dishNameLen);

        if(menu.stream().anyMatch(Dish::isVegetarian)){//至少匹配一个
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        menu.stream().allMatch(d -> d.getCalories() > 100);//匹配所有

        menu.stream().filter(Dish::isVegetarian)
            .findAny()
            .ifPresent(dish -> System.out.println(dish.getName()));
    }

    public static void testMap(){
        List<String> words = Arrays.asList("Java8", "C++", "Python");
        List<Integer> wordsLen = words.stream().map(String::length).collect(toList());
        System.out.println(wordsLen);
    }

    public static void testArray(){
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        List<String> list = streamOfWords.map(s -> s.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(toList());

        System.out.println(list);

        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        intList = intList.stream().map(num -> num * num)
            .collect(toList());
        System.out.println(intList);
    }

    public static void testReduce(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int sum = list.stream().reduce(0, (a,b)-> a+b);
        System.out.println(sum);
    }

    private enum ColorEnum{

        RED("red"),
        BLUE("blue"),
        YELLOW("yello");

        private final String color;

        private ColorEnum(String color){
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

}
