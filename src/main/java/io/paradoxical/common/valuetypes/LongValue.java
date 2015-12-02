package io.paradoxical.common.valuetypes;

import io.paradoxical.common.valuetypes.annotations.WrapsValueType;
import com.tguzik.value.Value;

@WrapsValueType(Long.class)
public abstract class LongValue extends Value<Long> implements Comparable<Value<Long>>, ValueTypeWrapper {
    protected LongValue(final Long encapsulatedValue) {
        super(encapsulatedValue);
    }

    @Override public int compareTo(final Value<Long> other) {
        if (other == null) {
            throw new NullPointerException("Parameter cannot be null.");
        }

        Long thisValue = get();
        Long otherValue = other.get();

        if (thisValue == null || otherValue == null) {
            /* Exploding with NullPointerException when one of the value classes has null inside is damn inconvenient.
             * Instead we return zero
             */
            return 0;
        }

        return thisValue.compareTo(otherValue);
    }
}
