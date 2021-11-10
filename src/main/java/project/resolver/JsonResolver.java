package project.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

public class JsonResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) {
        MappingJackson2JsonView view = new MappingJackson2JsonView();

        //Formatting date
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //mapper.registerModule(new JavaTimeModule());
        //mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        view.setObjectMapper(mapper);

        return view;
    }
}
