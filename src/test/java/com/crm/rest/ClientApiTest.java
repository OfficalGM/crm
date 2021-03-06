package com.crm.rest;

import com.crm.core.vo.Client;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientApiTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test_create_success() throws Exception {
        final ClientApi.CreateClientReq req = ClientApi.CreateClientReq.builder()
                .companyId(1L)
                .email("test")
                .name("test")
                .phone("test")
                .createdBy("operator")
                .updatedBy("operator")
                .build();
        HttpHeaders headers = createHttpHeaders("operator", "123");

        HttpEntity<ClientApi.CreateClientReq> request = new HttpEntity<>(req, headers);

        ResponseEntity<ClientApi.ResInfo> response =
                testRestTemplate.postForEntity("/client", request, ClientApi.ResInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().isResult()).isTrue();
    }

    @Test
    public void test_multiple_create() throws Exception {
        final ClientApi.CreateClientReq req = ClientApi.CreateClientReq.builder()
                .companyId(1L)
                .email("test")
                .name("test")
                .phone("test")
                .createdBy("operator")
                .updatedBy("operator")
                .build();
        HttpHeaders headers = createHttpHeaders("operator", "123");

        HttpEntity<List<ClientApi.CreateClientReq>> request = new HttpEntity<>(List.of(req, req), headers);

        ResponseEntity<ClientApi.ResInfo> response =
                testRestTemplate.postForEntity("/clients", request, ClientApi.ResInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().isResult()).isTrue();
    }

    @Test
    public void test_create_fail() throws Exception {
        final ClientApi.CreateClientReq req = ClientApi.CreateClientReq.builder()
                .companyId(1L)
                .email("test")
                .name("test")
                .phone("test")
                .createdBy("operator")
                .updatedBy("operator")
                .build();
        HttpHeaders headers = createHttpHeaders("manager", "123");

        HttpEntity<ClientApi.CreateClientReq> request = new HttpEntity<>(req, headers);

        ResponseEntity<ClientApi.ResInfo> response =
                testRestTemplate.postForEntity("/client", request, ClientApi.ResInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }

    private HttpHeaders createHttpHeaders(String username, String password) {
        String basicCredentials = username + ":" + password;
        byte[] base64Bytes = Base64.encodeBase64(basicCredentials.getBytes());
        String basicBase64EncodeCredentials = new String(base64Bytes);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + basicBase64EncodeCredentials);
        return headers;
    }


}