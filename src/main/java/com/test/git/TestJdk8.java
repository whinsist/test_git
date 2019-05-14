package com.test.git;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TestJdk8 {

    public static void main(String[] args) {
        List<Student> list = getData();


        // List转Map
        Map<String, Student> appleMap = list.stream().collect(Collectors.toMap(Student::getAge, a -> a,(k1,k2)->k1));
        Map<String, Integer> appleMap2 = list.stream().collect(Collectors.toMap(Student::getAge, Student::getSex,(k1,k2)->k1));
        // List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起：
        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getAge));
        // toList
        List<Student> filterList = list.stream().filter(a -> a.getAge().equals("香蕉")).collect(Collectors.toList());
        // 求和
        //BigDecimal totalSex = list.stream().map(Student::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalSex = list.stream().map(student -> {return student.getMoney()==null?new BigDecimal(0):student.getMoney();}).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalSex:"+totalSex);
        // 计算 数量
        int sum = list.stream().mapToInt(Student::getSex).sum();
        System.err.println("sum:"+sum);


        // 原始数据
        System.out.println("原始数据 组装list<demo>*******************");
        List<Demo> demos = list.stream().map(student -> new Demo(student.getAge(), student.getSex())).collect(Collectors.toList());
        demos.forEach(demo -> {
            System.out.println("年龄 " + demo.getAge() + "  性别 " + demo.getSex() + ",");
        });





        // 只取sex为0
        System.out.println("只取sex为0****************");
        List<Demo> demorm = demos.stream().filter(demo -> demo.getSex() == 0).distinct().collect(Collectors.toList());
        demorm.forEach(demo -> {
            System.out.println("年龄 " + demo.getAge() + "  性别 " + demo.getSex() + ",");
        });


        // 筛选年龄大于12岁
        System.out.println("筛选年龄大于12岁的*************");
        List<Demo> demoFilter = demos.stream().filter(demo -> Integer.valueOf(demo.getAge()) > 12).collect(Collectors.toList());
        demoFilter.forEach(demo -> {
            System.out.println("年龄 " + demo.getAge() + "  性别 " + demo.getSex() + ",");
        });



        // 按照年龄分组
        System.out.println("根据age分组结果为Map****************");
        Map<String, List<Demo>> demoOder = demos.stream().collect(Collectors.groupingBy(Demo::getAge));
        System.out.println(demoOder);

    }

    public static List<Student> getData() {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student();
        student1.setAge("12");
        student1.setSex(0);
        Student student2 = new Student();
        student2.setAge("13");
        student2.setSex(2);
        Student student3 = new Student();
        student3.setAge("11");
        student3.setSex(1);
        Student student4 = new Student();
        student4.setAge("18");
        student4.setSex(1);
        Student student5 = new Student();
        student5.setAge("18");
        student5.setSex(0);
        Student student6 = new Student();
        student6.setAge("18");
        student6.setSex(2);
        Student student7 = new Student();
        student7.setAge("18");
        student7.setSex(2);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        return list;
    }
}


class Demo {
    private String name;
    private Integer sex;
    private String age;

    public Demo(String age, Integer sex) {
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}


class Student {
    private String age;
    private Integer sex;
    private BigDecimal money;
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}


