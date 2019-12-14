package com.kreise.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.omg.CORBA.TIMEOUT;

import static java.lang.System.currentTimeMillis;

public class Kreise extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ShapeRenderer shapeRenderer;
	BitmapFont comicsans;

static int rectx=0;
static int recty=0;
static int a=0;
static double c=0;
static double d=0;
static float t=0;
static float u=0;
	@Override
	public void create () {

	    recty=Gdx.graphics.getHeight();
		shapeRenderer = new ShapeRenderer();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");




		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("comicsans.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 75;
		comicsans = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!




		Level.create(1);

	}

	@Override
	public void render () {



		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		if(Var.gamestatus==0) {
			Spieler.update(0);
		}
		Spieler.update(1);

	shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
	shapeRenderer.ellipse(Var.spieler_x - Var.abstandzwballs, Var.spieler_y - Var.abstandzwballs, Var.abstandzwballs * 2, Var.abstandzwballs * 2);
	shapeRenderer.end();

	shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);




	a=0;
	int b=0;
	for (int i = 0; i < Level.kisten.size(); i = i + 1) {
		Hinderniss k;
		k = Level.kisten.get(i);
		k.check();
		if(k.y>0){
			a=1;
		}
		if(k.y-3000<0){
			b=1;
		}
		if(k.y<Gdx.graphics.getHeight()) {
			switch (k.art) {
				case 1:
					shapeRenderer.setColor(1, 1, 0, 1);
					shapeRenderer.rect(k.x, k.y, k.w, k.h);
					break;
			}
		}
		if(Var.gamestatus==0) {
			k.y -= Level.speed;
		}
		if(Var.gamestatus==1){
			k.y += 80;
		}
	}

		shapeRenderer.setColor(1, 0, 0, 1);
		shapeRenderer.ellipse(Var.ball_rot_x, Var.ball_rot_y, Var.ball_d, Var.ball_d);

		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.ellipse(Var.ball_gruen_x, Var.ball_gruen_y, Var.ball_d, Var.ball_d);

		//shapeRenderer.line(Var.ball_rot_x,Var.ball_rot_y,Var.ball_gruen_x,Var.ball_gruen_y);


		//shapeRenderer.ellipse(Var.ball_gruen_x,200,50,50);
		shapeRenderer.end();



	if(Var.gamestatus==1){
		Spieler.w-=10;
	}

		if(a == 0){
			//System.out.println(a);
			Level.levelup();
			c=currentTimeMillis();
			t=1;
		}

		if(currentTimeMillis()<c+3000){
			t=t-0.005f;
			System.out.println("tatatiti");
			batch.begin();
			comicsans.setColor(new Color(1,1,1,t));
			comicsans.draw(batch, "Levelaufstieg: "+Level.level, 100, Gdx.graphics.getHeight()/2);
			batch.end();

		}

		if(currentTimeMillis()<d+3000){
			u=u-0.005f;
			System.out.println("tatatiti");
			batch.begin();
			comicsans.setColor(new Color(1,1,1,u));
			comicsans.draw(batch, "nochmal (-:", 100, Gdx.graphics.getHeight()/4);
			batch.end();

		}


		if(b==0){
			Var.gamestatus=0;
		}





}


	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
