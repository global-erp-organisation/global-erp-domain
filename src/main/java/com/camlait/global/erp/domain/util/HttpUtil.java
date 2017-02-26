package com.camlait.global.erp.domain.util;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Utility for http calls.
 * 
 * @author Martin Blaise Signe
 * @param <T> Expected response body type.
 */
@Component
public class HttpUtil<T> {

    @Value("${rest.auth.user}")
    private String username;
    @Value("${rest.auth.password}")
    private String password;

    private final RestTemplate restTemplate;

    @Autowired
    public HttpUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Perform an http request using the POST verb.
     * 
     * @param url Resource URL.
     * @param body incoming body request.
     * @param clazz expected response body type
     * @return An ResponseEntity object that contains the response as a body.
     */
    public ResponseEntity<T> doPost(String url, String body, Class<T> clazz) {
        return restTemplate.exchange(url, HttpMethod.POST, buildEntity(body), clazz);
    }

    /**
     * Perform an http request using the GET verb.
     * 
     * @param url Resource URL.
     * @param clazz expected response body type
     * @param body incoming body request.
     * @return An ResponseEntity object that contains the response as a body.
     */

    public ResponseEntity<T> doGet(String url, Class<T> clazz) {
        return restTemplate.exchange(url, HttpMethod.GET, buildEntity(), clazz);
    }

    /**
     * Build an HttpEntity object that contain the authentification header and the body of the request to send.
     * 
     * @param body request body
     * @return
     */
    private HttpEntity<String> buildEntity(String body) {
        final HttpHeaders headers = createHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<String>(body, headers);
    }

    /**
     * Build an HttpEntity object that only contains the authentification header.
     * 
     * @return
     */
    private HttpEntity<String> buildEntity() {
        final HttpHeaders headers = createHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<String>(headers);
    }

    /**
     * Build an authentification header with provided credentials.
     * 
     * @param username
     * @param password
     * @return
     */
    @SuppressWarnings("serial")
    private HttpHeaders createHeaders() {
        return new HttpHeaders() {
            {
                final String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }
}
