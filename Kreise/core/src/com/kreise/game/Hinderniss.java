package com.kreise.game;

import static java.lang.System.currentTimeMillis;

public class Hinderniss {
    int x;
    int y;
    int art;
    int w;
    int h;
    public Hinderniss(int _x, int _y, int _w, int _h,  int _art){
        x=_x;
        y=_y;
        art=_art;
        w=_w;
        h=_h;
    }
    void check(){
        if(y<Var.ball_rot_y+Var.ball_d && Var.ball_rot_y<y+h && Var.ball_rot_x<x+w && Var.ball_rot_x+Var.ball_d>x){  //roterball
            Var.gamestatus=1;
            Kreise.d=currentTimeMillis();
            Kreise.u=1;
            //Level.levelrestart();
        }
        if(y<Var.ball_gruen_y+Var.ball_d && Var.ball_gruen_y<y+h && Var.ball_gruen_x<x+w && Var.ball_gruen_x+Var.ball_d>x){  //gruenerball
            Var.gamestatus=1;
            Kreise.d=currentTimeMillis();
            Kreise.u=1;
            //Level.levelrestart();

        }
    }
}
