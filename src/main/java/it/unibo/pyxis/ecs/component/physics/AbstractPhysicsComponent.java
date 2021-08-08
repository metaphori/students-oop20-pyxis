package it.unibo.pyxis.ecs.component.physics;

import java.util.logging.Level;
import java.util.logging.Logger;

import it.unibo.pyxis.ecs.component.AbstractComponent;
import it.unibo.pyxis.ecs.Entity;

public abstract class AbstractPhysicsComponent<E extends Entity> extends AbstractComponent<E> implements PhysicsComponent<E> {

    private boolean isAttached;

    public AbstractPhysicsComponent(final E entity) {
        super(entity);
        this.isAttached = false;
    }

    /**
     * Returns a {@link Logger} instance.
     *
     * @return A {@link Logger} instance
     */
    private Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void attach() {
        this.isAttached = true;
        this.getLogger().log(Level.INFO, "Physics component attached");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void detach() {
        this.isAttached = false;
        this.getLogger().log(Level.INFO, "Physics component detached");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isAttached() {
        return this.isAttached;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void update(double elapsed);
}
