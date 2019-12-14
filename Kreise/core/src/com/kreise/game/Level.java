package com.kreise.game;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;



public class Level {
    static int level;
    static int abstand;
    static int speed;
    static int lepos;
    static ArrayList<Hinderniss> kisten = new ArrayList<Hinderniss>();

    static void links(int a){
        Level.kisten.add(new Hinderniss(0,Gdx.graphics.getHeight()+a,Gdx.graphics.getWidth() / 2, 100,1));

    }
    static void rechts(int a){
        Level.kisten.add(new Hinderniss(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()+a,Gdx.graphics.getWidth() / 2, 100,1));

    }
    static void mitte(int a,int h,int w){
        Level.kisten.add(new Hinderniss(Gdx.graphics.getWidth()/2-w/2,Gdx.graphics.getHeight()+a,w, h,1));
        abstand=abstand+h;

    }
    static void doppelkasten(int a,int a2){
        Level.kisten.add(new Hinderniss(Gdx.graphics.getWidth()/2-350,Gdx.graphics.getHeight()+a,300, 200,1));
        a+=a2;
        Level.kisten.add(new Hinderniss(Gdx.graphics.getWidth()/2+50,Gdx.graphics.getHeight()+a,300, 200,1));
        abstand=a;
    }
    static void lrhinderniss(int a,int rl){
        if(rl==0) {
            Level.kisten.add(new Hinderniss((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.1f), Gdx.graphics.getHeight() + a, (int) (Gdx.graphics.getWidth() / 2.1f), 100, 1));
            a = a + 400;
            Level.kisten.add(new Hinderniss(0, Gdx.graphics.getHeight() + a, Gdx.graphics.getWidth() / 4, 100, 1));
        }
        if(rl==1) {
            Level.kisten.add(new Hinderniss(0, Gdx.graphics.getHeight() + a, (int) (Gdx.graphics.getWidth() / 2.1f), 100, 1));
            a = a + 400;
            Level.kisten.add(new Hinderniss(Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() + a, Gdx.graphics.getWidth() / 4, 100, 1));
        }
    }



    public static void levelzuende(){

    }

    public static void create(int le){

        switch(le){
            case 1:
                level=1;
                lepos=0;
                Level.speed=8;
                Spieler.speed=3;

                abstand=0;
                mitte(abstand,500,200);
                abstand=abstand+1500;
                links(abstand);
                abstand=abstand+1500;
                rechts(abstand);


                lepos=abstand;
                break;
            case 2:
                level=2;
                lepos=0;
                Level.speed=10;
                Spieler.speed=4;


                abstand =0;
                lrhinderniss(abstand,0);
                abstand=abstand+1000;
                doppelkasten(abstand,500);
                abstand=abstand+1000;


                lepos=abstand;
                break;
            case 3:
                level=3;
                lepos=0;
                Level.speed=10;
                Spieler.speed=3.2f;


                abstand =0;
                links(abstand);
                abstand=abstand+1100;
                links(abstand);
                abstand=abstand+1100;
                links(abstand);
                abstand=abstand+1100;
                links(abstand);
                abstand=abstand+1100;
                links(abstand);
                abstand=abstand+550;
                links(abstand);
                abstand=abstand+550;
                links(abstand);
                abstand=abstand+550;
                links(abstand);
                abstand=abstand+550;
                links(abstand);
                abstand=abstand+550;



                lepos=abstand;
                break;
            case 4:
                level=4;
                lepos=0;
                Level.speed=10;
                Spieler.speed=3.2f;


                abstand =0;
                rechts(abstand);
                abstand=abstand+1100;
                rechts(abstand);
                abstand=abstand+1100;
                rechts(abstand);
                abstand=abstand+1100;
                rechts(abstand);
                abstand=abstand+550;
                rechts(abstand);
                abstand=abstand+550;
                rechts(abstand);
                abstand=abstand+550;
                rechts(abstand);
                abstand=abstand+550;
                rechts(abstand);
                abstand=abstand+550;



                lepos=abstand;
                break;
        }

        //rechts();

}


public static void levelup(){
        kisten.clear();
        create(level+1);
}
public static void levelrestart(){
    kisten.clear();
    create(level);
}


}
