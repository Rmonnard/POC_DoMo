/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.skeleton.jackson;

import ch.heigvd.skeleton.model.Employee;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

/**
 *
 * @author luis
 */
public class JacksonConverterUsingNew {

    public Object fromJson(String json) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mp = new ObjectMapper();
        Employee empl = mp.readValue(json, Employee.class);
        return empl;
    }

    public String toJSon(Object object) {
        String json;
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            json = ow.writeValueAsString(object);
        } catch (IOException ex) {
            json = "An error has occured. Look at your code.";
        }
        return json;
    }

    com.fasterxml.jackson.databind.ObjectMapper afterBurnerMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    public Object fromJsonAfterburner(String json) throws JsonParseException, JsonMappingException, IOException {
        //com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        afterBurnerMapper.registerModule(new AfterburnerModule());
        Employee empl = afterBurnerMapper.readValue(json, Employee.class);
        return empl;
    }

    com.fasterxml.jackson.databind.ObjectWriter afterBurnerWriter;

    public String toJSonAfterburner(Object object) {
        //  com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        afterBurnerMapper.registerModule(new AfterburnerModule());
        afterBurnerWriter = afterBurnerMapper.writer();
        // ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = afterBurnerWriter.writeValueAsString(object);
        } catch (IOException ex) {
            json = "An error has occured. Look at your code.";
        }
        return json;
    }
}
