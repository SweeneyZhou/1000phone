package com.qianfeng.day0325.homework;

import java.util.*;

/*
* 一，用方法完成：
1.创建一副扑克牌（数组）
2.打乱扑克牌
3.随机拿出3张牌，作为地主的底牌（数组）
4.将剩余的牌分发给3个玩家（数组）
5.随机一个确定地主，将底牌给这个地主
* */
public class Test1 {
    //主程序
    public static void main(String[] args) throws Exception {
        Random r=new Random();
        Pokers pokers=new Pokers(1)//创建一副牌组
                .shuffles();//打乱这副牌组
        System.out.println("创建一副牌并且打乱:");
        System.out.println(Arrays.toString(pokers.toArray()));
        System.out.println(pokers.toArray().length);

        Poker[] landlord_cards=new Poker[3];//创建地主的底牌
        for (int i = 0; i < landlord_cards.length; i++) {
            landlord_cards[i]=pokers.get(0);//将打乱后的牌组最上面一张作为地主的底牌
            pokers.remove(0);//从牌组中移去这张牌
        }
        System.out.println("地主的底牌:");
        System.out.println(Arrays.toString(landlord_cards));
        Pokers[] players=pokers.splits(3);//将一个牌堆分成3个牌组
        System.out.println("3位玩家的牌:");
        for (Pokers player : players) {
            System.out.println(Arrays.toString(player.toArray()));
        }

        int landlord_index= r.nextInt(3);//随机一个地主
        players[landlord_index].add(landlord_cards);
        System.out.println((landlord_index+1)+"号玩家成为地主，他的手牌是：");
        System.out.println(Arrays.toString(players[landlord_index].toArray()));
    }
    //牌组及其功能
    public static class Pokers{
        private Poker[] pokers;
        public Pokers(){
            this.pokers= new Poker[0];
        }
        public Pokers(Poker[] pokers){
            this.pokers=pokers;
        }
        //创建 n 副牌
        public Pokers(int n) throws Exception {
            Poker[] pokers=new Poker[54*n];
            int count = 0;
            while(n>0){
                for (int i = 0; i < Color.values().length; i++) {
                    for (int j = 0; j < Figure.values().length-2; j++) {
                        pokers[count]=new Poker(Color.values()[i],Figure.values()[j]);
                        count++;
                        if(count%54>=52){
                            pokers[count++]=new Poker(Figure.BLACK);
                            pokers[count++]=new Poker(Figure.RED);
                        }
                    }
                }
                n--;
            }
            this.pokers=pokers;
        }
        //打乱扑克牌
        public Pokers shuffles(){
            ArrayList<Integer> a = new ArrayList<>();
            Poker[] pokers=this.pokers.clone();
            for (int i = 0; i < pokers.length; i++) {
                a.add(i);
            }
            Collections.shuffle(a);
            for (int i = 0; i < pokers.length; i++) {
                this.pokers[i]=pokers[a.get(i)];
            }
            return this;
        }
        //返回下标为index的牌
        public Poker get(int index){
            return this.pokers[index];
        }
        //抽出下标为index的牌
        public Pokers remove(int n){
            Poker[] pokers=new Poker[this.pokers.length-1];
            if (n >= 0) System.arraycopy(this.pokers, 0, pokers, 0, n);
            if (pokers.length - n >= 0) System.arraycopy(this.pokers, n + 1, pokers, n, pokers.length - n);
            this.pokers=pokers;
            return this;
        }
        //均分牌
        public Pokers[] splits(int n){
            Pokers[] pokersN=new Pokers[n];
            for (int i = 0; i < pokersN.length; i++) {
                pokersN[i]=new Pokers();
            }
            for (int i = 0; i < this.pokers.length; i++) {
                pokersN[i%n].add(get(i));
            }
            return pokersN;
        }
        //增加牌
        public Pokers add(Poker... addPokers) {
            Poker[] pokers=new Poker[this.pokers.length+ addPokers.length];
            System.arraycopy(this.pokers, 0, pokers, 0, this.pokers.length);
            System.arraycopy(addPokers, 0, pokers,  this.pokers.length, addPokers.length);
            this.pokers=pokers;
            return this;
        }
        public Poker[] toArray(){
            return this.pokers;
        }
    }
    //扑克牌
    public static class Poker{

        Color color;
        Figure figure;

        public Poker(Color color,Figure figure) {
            this.color = color;
            this.figure = figure;
        }

        public Poker(Figure figure) throws Exception {
            if(figure==Figure.BLACK||figure==Figure.RED)
                this.figure = figure;
            else throw new Exception("缺少花色!");
        }
        @Override
        public String toString() {
            if(color!=null)
                return color.toString()+figure.toString();
            else return figure.toString();
        }
    }
    enum Color{
        DIAMOND("方片"),CLUB("梅花"),HEART("红心"),SPADE("黑桃");
        private final String name;
        Color(String name) {
            this.name=name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    enum Figure{
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K"),
        ACE("A"),
        TWO("2"),
        BLACK("小王"),
        RED("大王");
        private final String name;

        Figure(String s) {
            this.name=s;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}