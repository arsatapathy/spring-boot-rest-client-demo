package com.arsatapathy.springboot.rest.client.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class CostomerConfig {

    private RestTemplate restTemplate;

    @Value("${GET_CUSTOMERS}")
    private String getCustomers;

    @Value("${GET_CUSTOMER_BY_ID}")
    private String getCustomerById;

    @Value("${ADD_CUSTOMER}")
    private String addCustomer;

    @Value("${DELETE_CUSTOMER_BY_ID}")
    private String deleteCustomerById;

    @Value("${UPDATE_CUSTOMER}")
    private String updateCustomer;

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder
                    .setConnectTimeout(Duration.ofMillis(3000))
                    .build();
    }

    @Bean
    @Qualifier(value = "GET_CUSTOMERS")
    public String getGetCustomers() {
        return getCustomers;
    }

    @Bean
    @Qualifier(value = "GET_CUSTOMER_BY_ID")
    public String getGetCustomerById() {
        return getCustomerById;
    }

    @Bean
    @Qualifier(value = "ADD_CUSTOMER")
    public String getAddCustomer() {
        return addCustomer;
    }

    @Bean
    @Qualifier(value = "DELETE_CUSTOMER_BY_ID")
    public String getDeleteCustomerById() {
        return deleteCustomerById;
    }

    @Bean
    @Qualifier(value = "UPDATE_CUSTOMER")
    public String getUpdateCustomer() {
        return updateCustomer;
    }
}
