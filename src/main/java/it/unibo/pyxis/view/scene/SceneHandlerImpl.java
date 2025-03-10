package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.Controller;
import it.unibo.pyxis.controller.linker.Linker;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class SceneHandlerImpl implements SceneHandler {

    private final Linker linker;
    private final Loader loader;
    private final Stage stage;
    private Controller currentController;

    public SceneHandlerImpl(final Stage inputStage, final Linker inputLinker) {
        this.linker = inputLinker;
        this.loader = new LoaderImpl();
        this.stage = inputStage;
        this.stage.setOnCloseRequest(event -> this.linker.quit());
        this.stage.show();
    }

    /**
     * Loads the new current {@link Controller} from the new {@link Scene} loaded,
     * and binds it to the {@link Linker}.
     *
     * @param inputSceneType The {@link SceneType} to get the current {@link Controller}
     *                       from.
     */
    private void currentControllerSetup(final SceneType inputSceneType) {
        this.currentController = inputSceneType.getController();
        this.currentController.setLinker(this.linker);
    }

    /**
     * Loads and returns the new {@link Parent} loaded by the {@link Loader}.
     *
     * @param inputSceneType The {@link SceneType} to load.
     * @return The new {@link Parent} loaded.
     */
    private Parent loadNewParent(final SceneType inputSceneType) {
        return this.loader.getScene(inputSceneType, this.currentController);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
        this.stage.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Controller getCurrentController() {
        return this.currentController;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchScene(final SceneType inputSceneType) {
        this.currentControllerSetup(inputSceneType);
        if (this.stage.getScene() == null) {
            this.stage.setScene(new Scene(this.loadNewParent(inputSceneType)));
        } else {
            this.stage.getScene().setRoot(this.loadNewParent(inputSceneType));
        }
    }
}
