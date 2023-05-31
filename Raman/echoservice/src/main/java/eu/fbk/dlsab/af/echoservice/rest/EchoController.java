package eu.fbk.dlsab.af.echoservice.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class EchoController {
    
    @Value("${echomessage:default message}")
    private String message;

    @GetMapping("/echo")
    public @ResponseBody String getMessage() {
        return message;
    }
}
