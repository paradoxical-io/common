package io.paradoxical.common.valuetypes;

import io.paradoxical.common.valuetypes.annotations.WrapsValueType;
import com.tguzik.value.Value;

@WrapsValueType(Double.class)
public abstract class DoubleValue extends Value<Double> implements Comparable<Value<Double>>, ValueTypeWrapper {
    protected DoubleValue(final Double encapsulatedValue) {
        super(encapsulatedValue);
    }

    @Override public int compareTo(final Value<Double> other) {
        if (other == null) {
            throw new NullPointerException("Parameter cannot be null.");
        }

        Double thisValue = get();
        Double otherValue = other.get();

        if (thisValue == null || otherValue == null) {
            /* Exploding with NullPointerException when one of the value classes has null inside is damn inconvenient.
             * Instead we return zero
             */
            return 0;
        }

        return thisValue.compareTo(otherValue);
    }
}
