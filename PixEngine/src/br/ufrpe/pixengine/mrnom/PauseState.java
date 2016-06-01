package br.ufrpe.pixengine.mrnom;

import br.ufrpe.pixengine.components.ObjectManager;
import br.ufrpe.pixengine.components.State;
import br.ufrpe.pixengine.core.GameContainer;
import br.ufrpe.pixengine.core.Renderer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class PauseState extends State {
	double score;
	public PauseState(double score) {
		this.score = score;
		manager.addObject(new GameImage(new Image("/mr.nom/background.png"),0 ,0));
		manager.addObject(new Player(0, 0));
		manager.addObject(new Stain(156, 116));
		manager.addObject(new Score(score,450, 160));
		if(score == 0){
			manager.addObject(new GameImage(new Image("/mr.nom/ready.png"), 0, 160));
		}else{
			manager.addObject(new GameImage(new Image("/mr.nom/pauseMenu.png"), 0, 160));
		}
	}

	@Override
	public void update(GameContainer gc, float dt) {
		if (gc.getInput().isKeyPressed(KeyCode.ENTER.ordinal())){
			gc.getGame().pop();
			if(score == 0){
				gc.getGame().push(new PlayState());
				gc.getGame().peek().getManager().findObject("player").setY(gc.getHeight()/2);
				gc.getGame().peek().getManager().findObject("player").setX(gc.getWidth()/2);
			}
		}
		manager.updateObjects(gc, dt);
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		manager.renderObjects(gc, r);
	}

	@Override
	public void dipose() {
		manager.diposeObjects();
	}

	public ObjectManager getManager() {
		return manager;
	}

	public void setManager(ObjectManager manager) {
		this.manager = manager;
	}

}
