package ph.oron.working.sample.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.oron.working.sample.resttemplate.dto.ToDo;
import ph.oron.working.sample.resttemplate.service.PostalService;

@RestController
@RequestMapping("/api/v1")
public class PostalController {

    @Autowired
    PostalService postalService;

    @PostMapping("/addPostal")
    public ResponseEntity<ToDo> postTest() {

        return this.postalService.post();

    }
}
