package com.acitve.mianshi;

import java.util.ArrayList;
import java.util.List;

public class Question {
    public static void main(String[] args) {
//      创建水果对象
        Fruit apple = new Apple("苹果",8);
        Fruit strawberry = new Strawberry("草莓",13);
        Fruit mango = new Mango("芒果",20);
//      创建计算器对象
        Calculator calculator = new Calculator();

        //顾客A
        List<Items> itemsListA  = new ArrayList<>();
        itemsListA.add(new Items(apple,1,1));
        itemsListA.add(new Items(strawberry,0,1));
        System.out.println(calculator.getTotal(itemsListA));

        //顾客B
        List<Items> itemsListB  = new ArrayList<>();
        itemsListB.add(new Items(apple,1,1));
        itemsListB.add(new Items(strawberry,0,1));
        itemsListB.add(new Items(mango,0,1));
        System.out.println(calculator.getTotal(itemsListB));

        //顾客C
        List<Items> itemsListC  = new ArrayList<>();
        itemsListC.add(new Items(apple,1,1));
        itemsListC.add(new Items(strawberry,0,0.8));
        itemsListC.add(new Items(mango,0,1));
        System.out.println(calculator.getTotal(itemsListC));

        //顾客D
        calculator.setEnablefullreduction(100,10);
        List<Items> itemsListD  = new ArrayList<>();
        itemsListD.add(new Items(apple,0,1));
        itemsListD.add(new Items(strawberry,1,0.8));
        itemsListD.add(new Items(mango,4,1));
        System.out.println(calculator.getTotal(itemsListD));


    }

    public static class Fruit{
        private String name;
//        价格
        private Double price;


        public Fruit(String name,double price){
            this.name = name;
            this.price= price;
        }

        public double getPrice() {
            return price;
        }

    }
//水果的列目，包括水果类型，总的重量
    public static class Items{
//        水果类型
        private Fruit item;
//        水果重量
        private int weight;
//        水果的折扣
        private double discount;

        public Items (Fruit item,int weight,double discount){
            this.item = item;
            this.weight = weight;
            this.discount = discount;
        }

        public Fruit getItem() {
            return this.item;
        }

        public int getWeight() {
            return this.weight;
        }

        public double getDiscount() {
            return discount;
        }
}

    public static class Apple extends Fruit{

        private double discount;

        public Apple(String name, double price) {
            super(name, price);
        }

    }



    public static class Strawberry extends Fruit{


        public Strawberry(String name, double price) {
            super(name, price);
        }

    }

    public static class Mango extends Fruit{

        public Mango(String name, double price) {
            super(name, price);
        }
    }

    public static class Calculator{

        private double full;

        private double reduction;

        private Boolean enablefullreduction;

        public Calculator(){

        }
//      设置满减
        public void setEnablefullreduction(double full,double reduction){
            this.full = full;
            this.reduction = reduction;
            this.enablefullreduction = true;
        }
//      计算总数
        public double getTotal(List<Items> itemsList){
            double total = 0.0;
//            遍历循环计算总数
            for (Items item : itemsList) {
//                单价*重量*折扣
                total += item.getItem().price * item.getWeight() * item.getDiscount();
            }
//            是否设置满减且总数大于满减
            if (this.enablefullreduction!=null && this.enablefullreduction && total>=this.full){
                System.out.println("满减前总数："+total);
                double discount = Math.floor(total/this.full);
                System.out.println("满减次数:"+discount);

                return total-discount*this.reduction;
            }

            return total;
        }


    }

}

