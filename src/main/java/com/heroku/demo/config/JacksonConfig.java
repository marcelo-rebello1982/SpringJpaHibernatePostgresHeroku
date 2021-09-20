package com.heroku.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroku.demo.model.PagamentoComBoleto;
import com.heroku.demo.model.PagamentoComCartao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
*  código é padrão, exigido pela biblioteca
 * Jackson.
 */
@Configuration
public class JacksonConfig {

    /**
     * No link abaixo há uma discução sobre a criação desse código
     * https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
     */
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            public void configure(ObjectMapper objectMapper) {
                objectMapper.registerSubtypes(PagamentoComCartao.class);
                objectMapper.registerSubtypes(PagamentoComBoleto.class);
                super.configure(objectMapper);
            }
        };
        return builder;
    }
}