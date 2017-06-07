package mylogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by LG-2 on 6/6/2017.
 */
public class ThreeDPacking {
    public ArrayList<Point> list;
    public void addAllPoints(Cuboid c){
//        list.add(c.topLeftFront);
        list.add(c.topLeftRear);
//        list.add(c.topRightFront);
//        list.add(c.topRightRear);
        list.add(c.bottomLeftFront);
//        list.add(c.bottomLeftRear);
//        list.add(c.bottomRightFront);
        list.add(c.bottomRightRear);
//        System.out.println(list);
//        Collections.sort(list,new XZYComparator());
        Collections.sort(list,new YZXComparator());
//        System.out.println(list);
    }
    public ThreeDPacking(){
        list=new ArrayList<Point>();
        ArrayList<Cuboid> cuboids=new ArrayList<Cuboid>();
        Random r=new Random();
        for(int i=0;i<1000;i++) {
            cuboids.add(new Cuboid(r.nextInt(10)+1,r.nextInt(10)+1,r.nextInt(10)+1));
        }
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));
//        cuboids.add(new Cuboid(10,10,10));

        int length=50,breadth=50,height=50;

        ArrayList<Cuboid> fitCuboids=new ArrayList<Cuboid>();
        Cuboid c=cuboids.get(0);
        c.setBottomLeftRear(new Point(0, 0, 0));
        addAllPoints(c);
        fitCuboids.add(c);

        for(int i=1;i<cuboids.size();i++){
            Cuboid cuboid=cuboids.get(i);
            for(int j=0;j<list.size();j++) {
                Point p = list.get(j);
                cuboid.setBottomLeftRear(p);
                if (!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length >= 0 && p.y+cuboid.height<=height && p.y+cuboid.height >= 0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>= 0) {
                    fitCuboids.add(cuboid);
                    addAllPoints(cuboid);
                    System.out.println("IF1");
                    break;
                }else{
                    cuboid.reset();
                    cuboid.rotate();
                    cuboid.setBottomLeftRear(p);
                    if (!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length >= 0 && p.y+cuboid.height<=height && p.y+cuboid.height >= 0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>= 0) {
                        fitCuboids.add(cuboid);
                        addAllPoints(cuboid);
                        System.out.println("IF2");
                        break;
                    }
                }
            }

        }

//        for(int i=1;i<cuboids.size();i++){
//
//            Cuboid cuboid=cuboids.get(i);
//
//            FOR1: for(int j=0;j<list.size();j++){
//                Point p=list.get(j);
//                cuboid.setBottomLeftFront(p);
//                if(!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z-cuboid.breadth<=breadth && p.z-cuboid.breadth>=0) {
//                    fitCuboids.add(cuboid);
//                    addAllPoints(cuboid);
//                    System.out.println("IF1");
//                    break FOR1;
//                }else {
//                    for(int k=0;k<list.size();k++){
//                        p=list.get(k);
//                        cuboid.setBottomRightRear(p);
//                        if(!cuboid.intersects(fitCuboids) && p.x-cuboid.length<=length && p.x-cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>=0){
//                            fitCuboids.add(cuboid);
//                            addAllPoints(cuboid);
//                            System.out.println("IF2");
//                            break FOR1;
//                        }else {
//                            for(int l=0;l<list.size();l++){
//                                p=list.get(l);
//                                cuboid.setBottomRightFront(p);
//                                if(!cuboid.intersects(fitCuboids) && p.x-cuboid.length<=length && p.x-cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z-cuboid.breadth<=breadth && p.z-cuboid.breadth>=0){
//                                    fitCuboids.add(cuboid);
//                                    addAllPoints(cuboid);
//                                    System.out.println("IF3");
//                                    break FOR1;
//                                }else {
//                                    for(int m=0;m<list.size();m++){
//                                        p=list.get(m);
//                                        cuboid.setBottomLeftRear(p);
//                                        if(!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>=0){
//                                            fitCuboids.add(cuboid);
//                                            addAllPoints(cuboid);
//                                            System.out.println("IF4");
//                                            break FOR1;
//
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }

//            FOR1: for(int j=0;j<list.size();j++){
//                Point p=list.get(j);
//                cuboid.setBottomRightRear(p);
//                if(!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>=0){
//                    fitCuboids.add(cuboid);
//                    addAllPoints(cuboid);
//                    System.out.println("IF1");
//                    break OUTER_FOR;
//                }else {
//                    break;
//                }
//            }
//
//            for(int j=0;j<list.size();j++){
//                Point p=list.get(j);
//                cuboid.setBottomRightRear(p);
//                if(!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>=0){
//                    fitCuboids.add(cuboid);
//                    addAllPoints(cuboid);
//                    System.out.println("IF1");
//                    break OUTER_FOR;
//                }else {
//                    break;
//                }
//            }


//            for(int j=0;j<list.size();j++){
//
//                Point p=list.get(j);
//
//                cuboid.setBottomLeftRear(p);
//
//                if(!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>=0){
//                    fitCuboids.add(cuboid);
//                    addAllPoints(cuboid);
//                    System.out.println("IF1");
//                    break;
//
//                }else {
//
//
//
//                    cuboid.reset();
//                    cuboid.setBottomRightRear(p);
//
//                    if(!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>=0){
//
//                        fitCuboids.add(cuboid);
//                        addAllPoints(cuboid);
//                        System.out.println("IF2");
//                        break;
//
//                    }else {
//
//                        cuboid.reset();
//                        cuboid.setBottomRightFront(p);
//
//                        if(!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>=0){
//
//                            fitCuboids.add(cuboid);
//                            addAllPoints(cuboid);
//                            System.out.println("IF3");
//                            break;
//
//                        }else {
//
//                            cuboid.reset();
//                            cuboid.setBottomLeftFront(p);
//
//                            if(!cuboid.intersects(fitCuboids) && p.x+cuboid.length<=length && p.x+cuboid.length>=0 && p.y+cuboid.height<=height && p.y+cuboid.height>=0 && p.z+cuboid.breadth<=breadth && p.z+cuboid.breadth>=0){
//
//                                fitCuboids.add(cuboid);
//                                addAllPoints(cuboid);
//                                System.out.println("IF4");
//                                break;
//
//                            }else {
//
//
//
//                            }
//
//                        }
//
//                    }
//
//                }
//
//            }



//        }

        System.out.println("FIT CUBOIDS:- "+fitCuboids.size());
        System.out.println(fitCuboids);
//        System.out.println(list);

    }
    public static void main(String[] args) {
        new ThreeDPacking();
    }
}
