package com.brandon.resttemplate.service;

import com.brandon.resttemplate.dto.DataDTO;
import com.brandon.resttemplate.mapper.DataMapper;
import com.brandon.resttemplate.model.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DataService {

    private final RestTemplate restTemplate;

    private String hash() {
        String credenciales = "admin:1234";
        return new String(Base64.encodeBase64(credenciales.getBytes()));
    }

    public DataDTO getById(Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization","Basic " + hash() );

        ResponseEntity<Data> response = restTemplate.exchange(
                "https://lr742.wiremockapi.cloud/json/" + id.toString(),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Data.class
                );

        return DataMapper.buildDataDTO(response.getBody());
    }

}
