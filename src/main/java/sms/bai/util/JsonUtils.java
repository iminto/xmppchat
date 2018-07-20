package sms.bai.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.text.SimpleDateFormat;

public class JsonUtils {
    private final static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_YAML_COMMENTS, true);
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public final static ObjectMapper getObjectMapper() {
        return mapper;
    }

    /**
     * 把json转换成对象
     *
     * @param json
     *            json数据
     * @param cls
     *            要转换的class
     * @return 转换好的对象
     */
    public final static <T> T readValue(String json, Class<T> cls) {
        try {
            return mapper.readValue(json, cls);
        } catch (Exception e) {
            System.out.println(json);
        }
        return null;
    }

    public static <T> T readValue(byte[] bytes, Class<T> cls) {
        try {
            return mapper.readValue(bytes, cls);
        } catch (Exception e) {
            System.out.println(bytes);
        }
        return null;
    }

    /**
     * 把json转换成对象
     *
     * @param json
     *            json数据
     * @param TypeReference
     *            要转换的class
     * @return 转换好的对象
     */
    @SuppressWarnings({ "rawtypes" })
    public static <T> T readValue(String json, TypeReference valueTypeRef) {
        try {
            return mapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
            System.out.println(json);
        }
        return null;
    }

    @SuppressWarnings({ "rawtypes" })
    public static <T> T readValue(byte[] bytes, TypeReference valueTypeRef) {
        try {
            return mapper.readValue(bytes, valueTypeRef);
        } catch (Exception e) {
            System.out.println(bytes);
        }
        return null;
    }

    /**
     * 把对象转换的json数据
     *
     * @param entity
     *            要转换的对象
     * @return 转换好的数据
     */
    public static String writeValue(Object entity) {
        try {
            return mapper.writeValueAsString(entity);
        } catch (Exception e) {
            System.out.println(entity.toString());
        }
        return null;
    }

    public static byte[] writeByteValue(Object entity) {
        try {
            return mapper.writeValueAsBytes(entity);
        } catch (Exception e) {
            System.out.println(entity.toString());
        }
        return null;
    }
}
