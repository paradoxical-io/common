package io.paradoxical.common.tests.tinytypes.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.paradoxical.common.valuetypes.adapters.xml.JaxbUuidValueAdapter;
import io.paradoxical.common.valuetypes.UuidValue;
import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.util.UUID;

@Immutable
@XmlJavaTypeAdapter(value = SequenceId.XmlAdapter.class)
@JsonSerialize(using = SequenceId.JsonSerializeAdapter.class)
@JsonDeserialize(using = SequenceId.JsonDeserializeAdapater.class)
public final class SequenceId extends UuidValue {
    protected SequenceId(final UUID value) {
        super(value);
    }

    public static SequenceId valueOf(UUID value) {
        return new SequenceId(value);
    }

    public static class XmlAdapter extends JaxbUuidValueAdapter<SequenceId> {
        @Nonnull
        @Override
        protected SequenceId createNewInstance(UUID value) {
            return SequenceId.valueOf(value);
        }
    }

    public static class JsonDeserializeAdapater extends JsonDeserializer<SequenceId> {

        @Override public SequenceId deserialize(
                final JsonParser jp, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return SequenceId.valueOf(UUID.fromString(jp.getValueAsString()));
        }
    }

    public static class JsonSerializeAdapter extends JsonSerializer<SequenceId> {
        @Override public void serialize(
                final SequenceId value, final JsonGenerator jgen, final SerializerProvider provider) throws
                                                                                                              IOException,
                                                                                                              JsonProcessingException {
            jgen.writeObject(value.get());
        }
    }
}
