package demoblazet.utils.misc;

import com.google.gson.*;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonUtils {

    private static final Logger logger = LogManager.getLogger(JsonUtils.class);

    public static DocumentContext getJsonContext(String request) {
        if (StringUtils.isEmpty(request)) {
            logger.info("Empty request payload");
        }
        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
                .mappingProvider(new JacksonMappingProvider()).build();
        DocumentContext jsonContext = JsonPath.using(configuration).parse(request);

        return jsonContext;
    }

    public static String prettyFormat(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        try {
            JsonElement je = jp.parse(json);
            return gson.toJson(je);
        } catch (JsonSyntaxException e) {
            return json;
        }
    }

    public static boolean isValidJson(String content) {
        Gson gson = new Gson();
        try {
            gson.fromJson(content, Object.class);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

}
