package com.example.Proyecto_Vet.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaController {

    @RequestMapping(value = {
        "/", "/login", "/categorias", "/productos",
        "/proveedores", "/clientes", "/empleados", "/ventas"
    })
    public String index() {
        return "forward:/index.html";
    }
}
