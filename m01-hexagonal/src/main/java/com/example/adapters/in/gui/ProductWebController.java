package com.example.adapters.in.gui;

import com.example.core.domain.Product;
import com.example.ports.in.ProductReadInPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductWebController {

    private final ProductReadInPort productPort;

    public ProductWebController(ProductReadInPort productPort) {
        this.productPort = productPort;
    }

    @GetMapping("/products")
    public String findAll(Model model){
        List<ProductWebDTO> products = this.productPort.findAll().stream().map(ProductWebMapper::of).toList();
        model.addAttribute("products", products);
        return "product-list";
    }
}
