package com.kreise.game;

import com.badlogic.gdx.Gdx;

public class Spieler {
    static float w=0;
    static float speed=4;
    public static void update(int i){
        if(i==0) {
            if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2 && Gdx.input.isTouched()) {


                w = w + speed;
            } else if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2 && Gdx.input.isTouched()) {


                w = w - speed;
            }
        }

        Var.ball_rot_y=(int)(Var.abstandzwballs*Math.sin(Math.toRadians(w)))          +Var.spieler_y  -Var.ball_d/2;
        Var.ball_rot_x=(int)(Var.abstandzwballs*Math.cos(Math.toRadians(w)))          +Var.spieler_x  -Var.ball_d/2;

        Var.ball_gruen_y=(int)(Var.abstandzwballs*Math.sin(Math.toRadians(w-180)))    +Var.spieler_y  -Var.ball_d/2;
        Var.ball_gruen_x=(int)(Var.abstandzwballs*Math.cos(Math.toRadians(w-180)))    +Var.spieler_x  -Var.ball_d/2;
    }
}
