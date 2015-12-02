package io.paradoxical.common.valuetypes.adapters.xml;

import io.paradoxical.common.valuetypes.LongValue;
import com.tguzik.value.adapters.JaxbValueAdapter;

public abstract class JaxbLongValueAdapter<ValueClass extends LongValue> extends JaxbValueAdapter<Long, ValueClass> { }