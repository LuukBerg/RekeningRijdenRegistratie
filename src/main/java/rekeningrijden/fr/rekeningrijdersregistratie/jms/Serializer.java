package rekeningrijden.fr.rekeningrijdersregistratie.jms;

import com.owlike.genson.Genson;

public class Serializer {
    public static <T> T deserialize(String str, Class<T> t){
        return new Genson().deserialize(str,t);
    }
    public static String serialize(Object obj){
        return new Genson().serialize(obj);
    }
}
