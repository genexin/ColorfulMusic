package cn.edu.xidian.cs.cm.entity.serializer;

import cn.edu.xidian.cs.cm.entity.Singer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 *
 * @author Mi Zhou
 */
public class SingerSerializer extends JsonSerializer<Singer> {

	@Override
	public void serialize(Singer singer, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
		jg.writeStartObject();
		jg.writeNumberField("id", singer.getId());
		jg.writeStringField("name", singer.getName());
		jg.writeEndObject();
	}

}
