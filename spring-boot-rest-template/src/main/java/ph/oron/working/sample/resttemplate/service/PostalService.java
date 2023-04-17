package ph.oron.working.sample.resttemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ph.oron.working.sample.resttemplate.dto.ToDo;

@Service
public class PostalService {

    public static final String URL = "https://jsonplaceholder.typicode.com/todos";
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<ToDo> post() {
        ToDo todoObject = ToDo.builder().id("123").userId("345").title("Learn Rest Template").completed(false).build();

        ResponseEntity<ToDo> todoResponse = restTemplate
                .postForEntity(URL, todoObject, ToDo.class);
        ToDo toDoInserted = todoResponse.getBody();
        System.out.println(todoResponse.getStatusCode().name()); // CREATED
        System.out.println(todoResponse.getStatusCodeValue());   // 201
        System.out.println(toDoInserted);
        return todoResponse;
    }


}
