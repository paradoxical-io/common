package io.paradoxical.common.valuetypes.adapters.xml;

import io.paradoxical.common.valuetypes.IntegerValue;
import com.tguzik.value.adapters.JaxbValueAdapter;

public abstract class JaxbIntegerValueAdapter<ValueClass extends IntegerValue> extends JaxbValueAdapter<Integer, ValueClass> { }