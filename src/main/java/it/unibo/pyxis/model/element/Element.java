package it.unibo.pyxis.model.element;

import it.unibo.pyxis.ecs.Entity;
import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;

public interface Element extends Entity {

    /**
     * Returns the element's dimension.
     *
     * @return The element's {@link Dimension}
     */
    Dimension getDimension();

    /**
     * Returns the element's {@link Hitbox}.
     *
     * @return The element's {@link Hitbox}
     */
    Hitbox getHitbox();

    /**
     * Returns the element's pace.
     *
     * @return The pace's {@link Vector}
     */
    Vector getPace();

    /**
     * Returns the element's position.
     *
     * @return The element's {@link Coord}
     */
    Coord getPosition();

    /**
     * Returns the element's update time multiplier.
     *
     * @return The dt multiplier
     */
    double getUpdateTimeMultiplier();

    /**
     * Increases the element's height value.
     *
     * @param increaseValue The increment value
     */
    void increaseHeight(double increaseValue);

    /**
     * Increases the element's width value.
     *
     * @param increaseValue The increment value
     */
    void increaseWidth(double increaseValue);

    /**
     * Sets the element's height value.
     *
     * @param height The height value
     */
    void setHeight(double height);

    /**
     * Sets the element's pace.
     *
     * @param inputPace The input pace's {@link Vector}
     */
    void setPace(Vector inputPace);

    /**
     * Sets the element's position.
     *
     * @param position The {@link Coord}
     */
    void setPosition(Coord position);

    /**
     * Sets the element's width value.
     *
     * @param width The width value
     */
    void setWidth(double width);

    /**
     * Execute an update on the element.
     *
     * @param dt The time gap intercurred between an update
     */
    void update(double dt);
}
