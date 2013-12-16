/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.jackson;

import ch.heigvd.skeleton.model.Employee;
import java.io.IOException;
import javax.ejb.Stateless;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

/**
 *
 * @author luis
 */
@Stateless
public class JacksonConverter {
    
    private ObjectWriter ow;
    private ObjectMapper mp;
    
    public JacksonConverter(){
        mp = new ObjectMapper();
        ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    }
    
    public Object fromJson(String json) throws JsonParseException
                                                   , JsonMappingException, IOException{
                Employee empl = mp.readValue(json, Employee.class);
                return empl;
    }
    
    public String toJSon(Object object){
        String json;
        try {
            json = ow.writeValueAsString(object);
        } catch (IOException ex) {
            json = "An error has occured. Look at your code.";
        }
        return json;
    }
}
