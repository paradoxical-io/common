package io.paradoxical.common.valuetypes;

import io.paradoxical.common.valuetypes.annotations.WrapsValueType;
import com.tguzik.value.Value;

import java.util.UUID;

@WrapsValueType(UUID.class)
public abstract class UuidValue extends Value<UUID> implements Comparable<Value<UUID>>, ValueTypeWrapper {
    protected UuidValue(final UUID encapsulatedValue) {
        super(encapsulatedValue);
    }

    @Override public int compareTo(final Value<UUID> other) {
        if (other == null) {
            throw new NullPointerException("Parameter cannot be null.");
        }

        UUID thisValue = get();
        UUID otherValue = other.get();

        if (thisValue == null || otherValue == null) {
            /* Exploding with NullPointerException when one of the value classes has null inside is damn inconvenient.
             * Instead we return zero
             */
            return 0;
        }

        return thisValue.compareTo(otherValue);
    }
}