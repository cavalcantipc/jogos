package br.ufrpe.pixengine.mrnom;

import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import br.ufrpe.pixengine.core.fx.Image;

public class GameImage extends GameObject {
	Image image;
	
	public GameImage(Image image, float x, float y){
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void update(GameContainer gc, float dt) {
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(image);		
	}

	@Override
	public void componentEvent(String name, GameObject object) {
		
	}

	@Override
	public void dispose() {
		
	}
	
}
