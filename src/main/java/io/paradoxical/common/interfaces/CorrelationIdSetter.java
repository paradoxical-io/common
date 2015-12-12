package io.paradoxical.common.interfaces;

import java.util.UUID;

public interface CorrelationIdSetter {
    void setCorrelationId(UUID correlationId);
}
