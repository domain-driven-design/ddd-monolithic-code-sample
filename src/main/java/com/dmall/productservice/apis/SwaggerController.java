package com.dmall.productservice.apis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class SwaggerController {
    @RequestMapping("/products/swagger")
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}