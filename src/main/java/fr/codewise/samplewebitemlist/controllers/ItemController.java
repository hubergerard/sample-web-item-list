package fr.codewise.samplewebitemlist.controllers;

import fr.codewise.samplewebitemlist.dto.CreateItemDto;
import fr.codewise.samplewebitemlist.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public String getItemsPage(Model model) {
        model.addAttribute("items", itemService.findAllItems());
        return "items";
    }

    @PostMapping("/items")
    public String createItem(CreateItemDto dto) {
        itemService.createItem(dto);
        return "redirect:/";
    }
}
