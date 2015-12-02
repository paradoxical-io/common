package io.paradoxical.common.tests.tinytypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.paradoxical.common.tests.tinytypes.data.SequenceId;
import io.paradoxical.common.tests.tinytypes.data.FirstName;
import io.paradoxical.common.valuetypes.locator.ValueTypeLocator;
import io.paradoxical.common.valuetypes.locator.ValueTypeLocatorResult;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


public class TinyTypesTests {
    @Test
    public void test_string_serializer_works() throws JsonProcessingException {
        final String targetString = "foo";

        final FirstName firstName = FirstName.valueOf(targetString);

        final ObjectMapper objectMapper = new ObjectMapper();

        final String s = objectMapper.writeValueAsString(firstName);

        assertThat(s).isEqualTo(String.format("\"%s\"", targetString));
    }

    @Test
    public void test_string_deserializer_works() throws IOException {
        final String sourceString = "foo";

        final String targetString = String.format("\"%s\"", sourceString);

        final ObjectMapper objectMapper = new ObjectMapper();

        final FirstName s = objectMapper.readValue(targetString, FirstName.class);

        assertThat(s).isEqualTo(FirstName.valueOf(sourceString));
    }

    @Test
    public void test_uuid_serializer_works() throws JsonProcessingException {
        final UUID targetUuid = UUID.randomUUID();

        final SequenceId transactionId = SequenceId.valueOf(targetUuid);

        final ObjectMapper objectMapper = new ObjectMapper();

        final String s = objectMapper.writeValueAsString(transactionId);

        assertThat(s).isEqualTo(String.format("\"%s\"", targetUuid.toString()));
    }

    @Test
    public void test_uuid_deserializer_works() throws IOException {
        final UUID sourceUuid = UUID.randomUUID();

        final String targetUuid = String.format("\"%s\"", sourceUuid.toString());

        final ObjectMapper objectMapper = new ObjectMapper();

        final SequenceId s = objectMapper.readValue(targetUuid, SequenceId.class);

        assertThat(s).isEqualTo(SequenceId.valueOf(sourceUuid));
    }

    @Test
    public void test_tiny_types_equal() throws IOException {
        final FirstName foo = FirstName.valueOf("foo");

        final FirstName secondFoo = FirstName.valueOf("foo");

        assertThat(foo).isEqualTo(secondFoo);

        assertThat(foo.equals(secondFoo)).isTrue();
    }

    @Test
    public void find_value_types() {
        final ValueTypeLocator valueTypeLocator = new ValueTypeLocator();

        final ArrayList<ValueTypeLocatorResult> valueTypes =
                valueTypeLocator.getValueTypes(getClass().getPackage().getName());

        assertThat(valueTypes).isNotEmpty();

        assertThat(valueTypes.stream().anyMatch(i -> i.getValueType() == FirstName.class)).isTrue();
        assertThat(valueTypes.stream().anyMatch(i -> i.getValueType() == SequenceId.class)).isTrue();
    }
}