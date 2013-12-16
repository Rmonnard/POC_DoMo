/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.jackson;

import ch.heigvd.skeleton.to.PublicEmployeeTO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

/**
 *
 * @author luis
 */
public class JacksonConverter {
    
    public Object fromJson(String json) throws JsonParseException
                                                   , JsonMappingException, IOException{
                PublicEmployeeTO empl = new ObjectMapper().readValue(json, PublicEmployeeTO.class);
                return empl;
    }
    
    public String toJSon(Object object){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(object);
        } catch (IOException ex) {
            json = "NON";
        }
        return json;
    }
}
