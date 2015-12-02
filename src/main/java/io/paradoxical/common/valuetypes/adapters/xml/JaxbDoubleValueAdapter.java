package io.paradoxical.common.valuetypes.adapters.xml;

import io.paradoxical.common.valuetypes.DoubleValue;
import com.tguzik.value.adapters.JaxbValueAdapter;

public abstract class JaxbDoubleValueAdapter<ValueClass extends DoubleValue> extends JaxbValueAdapter<Double, ValueClass> { }

