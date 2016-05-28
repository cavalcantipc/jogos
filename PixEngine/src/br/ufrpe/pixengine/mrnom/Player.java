package br.ufrpe.pixengine.mrnom;

import br.ufrpe.pixengine.components.Collider;
import br.ufrpe.pixengine.components.GameObject;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import br.ufrpe.pixengine.core.fx.Image;
import javafx.scene.input.KeyCode;

public class Player extends GameObject {
	//Array de posi��es?
	Image head;
	
	public Player(int x, int y) {
		head = new Image("/mr.nom/headup.png");
		setTag("player");
		this.x = x;
		this.y = y;
		w = 42;
		h = 42;
		addComponent(new Collider());
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if (gc.getInput().isKey(KeyCode.UP.ordinal())) {
			y -= 42 * dt;

			if (y < 0) {
				y = 0;
			}
		}
		
		if (gc.getInput().isKey(KeyCode.DOWN.ordinal())) {
			y += 42 * dt;

			if (y < 0) {
				y = 0;
			}
		}
		
		if (gc.getInput().isKey(KeyCode.LEFT.ordinal())) {
			x -= 42 * dt;

			if (y < 0) {
				y = 0;
			}
		}

		if (gc.getInput().isKey(KeyCode.RIGHT.ordinal())) {
			x += 42 * dt;

			if (y + h > gc.getHeight()) {
				y = gc.getHeight() - h;
			}
		}

		updateComponents(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		r.drawImage(head);
		//r.drawFillRect((int) x, (int) y, (int) w, (int) h, 0xffffffff);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void componentEvent(String name, GameObject object) {

	}

}
