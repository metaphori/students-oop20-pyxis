package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.event.Events;
import it.unibo.pyxis.util.*;

import org.greenrobot.eventbus.EventBus;
import com.google.common.base.Objects;

public final class PowerupImpl extends AbstractElement implements Powerup {

    private static final Dimension DIMENSION = new DimensionImpl(1, 1);
    private final PowerupType type;
    private final Vector pace;

    public PowerupImpl(final PowerupType inputType, final Coord inputCoord) {
        super(DIMENSION, inputCoord);
        this.type = inputType;
        this.pace = new VectorImpl(1, 1);
    }

    @Override
    public void apply() {
        EventBus.getDefault().post(Events.newPowerupActivationEvent(this));
    }

    @Override
    public PowerupType getType() {
        return this.type;
    }

    @Override
    public Vector getPace() {
        return this.pace.copyOf();
    }

    @Override
    public void update() {
        this.calculateNewCoord();
        EventBus.getDefault().post(Events.newPowerupMovementEvent(this.getPosition()));
    }

    private void calculateNewCoord() {
        final Coord updatedCoord = this.getPosition();
        updatedCoord.sumVector(this.getPace());
        this.setPosition(updatedCoord);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PowerupImpl)) {
            return false;
        }
        PowerupImpl powerup = (PowerupImpl) o;
        return getType() == powerup.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getType());
    }
}
