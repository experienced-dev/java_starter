package experienced.dev.javastartertemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

    @GetMapping("/healthz")
    public void healthCheck() {
    }

    @GetMapping("/readyz")
    public void readyCheck() {
    }
}
