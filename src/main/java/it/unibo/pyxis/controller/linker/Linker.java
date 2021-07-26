package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.view.scene.SceneType;

public interface Linker {

    void pause();

    void quit();

    void endGame();

    void run();

    void switchScene(SceneType sceneType);

    GameState getGameState();

    void render();

    void handleCommandControl();

    void handleApplicationCommand();
}
