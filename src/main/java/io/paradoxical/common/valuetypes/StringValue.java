package io.paradoxical.common.valuetypes;

import io.paradoxical.common.valuetypes.annotations.WrapsValueType;

@WrapsValueType(String.class)
public abstract class StringValue extends com.tguzik.value.StringValue implements ValueTypeWrapper {
    protected StringValue(final String value) {
        super(value);
    }

    public boolean isEmpty() {
        return this.get() == null || this.get().isEmpty();
    }

    public int indexOf(String str) {
        return this.get().indexOf(str);
    }

    public String[] split(String str) {
        return this.get().split(str);
    }

    public String substring(int beginIndex) {
        return this.get().substring(beginIndex);
    }
}
