package io.paradoxical.common.valuetypes.adapters.xml;

import io.paradoxical.common.valuetypes.UuidValue;

import java.util.UUID;

public abstract class JaxbUuidValueAdapter<ValueClass extends UuidValue> extends JaxbValueAdapter<UUID, ValueClass> { }
