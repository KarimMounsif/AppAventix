package com.qrcodeteam.utilitaire;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class DateTimeSerializer extends StdSerializer<DateTime> {
 
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    
    public DateTimeSerializer() {
        this(null);
    }
 
     public DateTimeSerializer(Class<DateTime> classe) {
         super(classe);
     }
     
    @Override
    public void serialize
      (DateTime valeur, JsonGenerator generateur, SerializerProvider arg2) 
    		  throws IOException, JsonProcessingException {
        generateur.writeString(formatter.print(valeur));
    }
    
}

