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
import com.google.common.base.CharMatcher;
import io.paradoxical.common.valuetypes.StringValue;
import io.paradoxical.common.valuetypes.adapters.xml.JaxbStringValueAdapter;
import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;

@Immutable
@XmlJavaTypeAdapter(value = FirstName.XmlAdapter.class)
@JsonSerialize(using = FirstName.JsonSerializeAdapter.class)
@JsonDeserialize(using = FirstName.JsonDeserializeAdapater.class)
public final class FirstName extends StringValue {
    protected FirstName(final String value) {
        super(value);
    }

    public static FirstName valueOf(String firstName) {
        return new FirstName(CharMatcher.WHITESPACE.trimFrom(firstName));
    }

    public static class XmlAdapter extends JaxbStringValueAdapter<FirstName> {
        @Override
        protected FirstName createNewInstance(String value) {
            return FirstName.valueOf(value);
        }
    }

    public static class JsonDeserializeAdapater extends JsonDeserializer<FirstName> {

        @Override public FirstName deserialize(
                final JsonParser jp, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return FirstName.valueOf(jp.getValueAsString());
        }
    }

    public static class JsonSerializeAdapter extends JsonSerializer<FirstName> {
        @Override public void serialize(
                final FirstName value, final JsonGenerator jgen, final SerializerProvider provider) throws
                IOException,
                JsonProcessingException {
            jgen.writeString(value.get());
        }
    }
}
