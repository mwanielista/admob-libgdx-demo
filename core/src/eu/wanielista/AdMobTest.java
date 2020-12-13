package eu.wanielista;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AdMobTest extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	AdHandler handler;
	boolean toggle;

	public AdMobTest(AdHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {

		//if user click on screen -> ad disable on enable
		//toggle variable control ad visibility
		if(Gdx.input.justTouched()){
			handler.showAds(toggle);
			toggle = !toggle;
		}

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
