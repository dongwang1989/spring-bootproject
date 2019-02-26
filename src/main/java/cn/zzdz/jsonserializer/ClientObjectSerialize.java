package cn.zzdz.jsonserializer;

import cn.zzdz.domain.User;
import cn.zzdz.dto.UserDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
import springfox.documentation.spring.web.json.JsonSerializer;

import java.io.IOException;
import java.util.List;

public class ClientObjectSerialize extends JsonSerializer {


    public ClientObjectSerialize(List<JacksonModuleRegistrar> modules) {
        super(modules);
    }
}
