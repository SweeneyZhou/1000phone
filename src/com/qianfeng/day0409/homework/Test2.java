package com.qianfeng.day0409.homework;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
//        a.创建牌
        List<Poker> pokers = new ArrayList<>();

        for (int i = 0; i < Color.values().length; i++) {
            for (int j = 0; j < Point.values().length - 2; j++) {
                pokers.add(new Poker(Color.values()[i], Point.values()[j]));
            }
        }
        pokers.add(new Poker(null, Point.BLACK));
        pokers.add(new Poker(null, Point.RED));
        System.out.println("创建牌:");
        printPokers(pokers);

//        b.打乱牌
        System.out.println("打乱牌");
        Collections.shuffle(pokers);
        printPokers(pokers);

//        c.发牌   3个玩家和1个底牌
        List<Poker>[] players=new List[]{
                new ArrayList<Poker>(),
                new ArrayList<Poker>(),
                new ArrayList<Poker>()
        };
        for (int i = 0,size=pokers.size(); i < size-3; i++) {
            players[i%3].add(pokers.get(0));
            pokers.remove(0);
        }

        System.out.println("给三个玩家发牌:");
        for (List<Poker> player : players) {
            printPokers(player);
        }

        System.out.println("剩余底牌:");
        printPokers(pokers);

//        d.选地主 添加底牌
        Random random=new Random();
        int indexLandlord=random.nextInt(3);
        System.out.println(indexLandlord+"号玩家成为地主。");
        players[indexLandlord].addAll(pokers);
        System.out.println("地主的牌:");
        printPokers(players[indexLandlord]);

//        e.整理牌
        System.out.println("整理三位玩家的牌:");
        for (List<Poker> player : players) {
            player.sort(Comparator.comparing(o -> o.point));
            printPokers(player);
        }

//        f.打牌
    }
    public static <T> void printPokers(Collection<T> collection){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        for (Iterator iter=collection.iterator();iter.hasNext();){
            stringBuilder.append(iter.next());
            if (!iter.hasNext()){
                stringBuilder.append("]");
                System.out.println(stringBuilder);
                return;
            }
            stringBuilder.append(", ");
        }
    }
}

