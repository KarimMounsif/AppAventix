package com.qrcodeteam.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

@SuppressWarnings("serial")
public class DateTimeSerializer extends StdSerializer<DateTime> {
 
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    
    public DateTimeSerializer() {
        this(null);
    }

    private DateTimeSerializer(Class<DateTime> classe) {
         super(classe);
     }
     
    @Override
    public void serialize
            (DateTime valeur, JsonGenerator generateur, SerializerProvider arg2)
            throws IOException {
        generateur.writeString(formatter.print(valeur));
    }
    
}

