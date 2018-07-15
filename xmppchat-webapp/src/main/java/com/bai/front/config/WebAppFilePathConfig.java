package com.bai.front.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppFilePathConfig extends WebMvcConfigurerAdapter {


    @Value("${file.img.savePath}")
    private String savePath;

    @Value("${file.img.showPath}")
    private String showPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(showPath+"**")
     .addResourceLocations("file:"+savePath+"/");
     super.addResourceHandlers(registry);
     }
}
