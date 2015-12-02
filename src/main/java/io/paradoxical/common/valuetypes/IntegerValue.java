package io.paradoxical.common.valuetypes;

import io.paradoxical.common.valuetypes.annotations.WrapsValueType;
import com.tguzik.value.Value;

@WrapsValueType(Integer.class)
public abstract class IntegerValue extends Value<Integer> implements Comparable<Value<Integer>>, ValueTypeWrapper {
    protected IntegerValue(final Integer encapsulatedValue) {
        super(encapsulatedValue);
    }

    @Override public int compareTo(final Value<Integer> other) {
        if (other == null) {
            throw new NullPointerException("Parameter cannot be null.");
        }

        Integer thisValue = get();
        Integer otherValue = other.get();

        if (thisValue == null || otherValue == null) {
            /* Exploding with NullPointerException when one of the value classes has null inside is damn inconvenient.
             * Instead we return zero
             */
            return 0;
        }

        return thisValue.compareTo(otherValue);
    }
}
