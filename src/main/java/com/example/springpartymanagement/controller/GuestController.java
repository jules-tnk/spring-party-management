package com.example.springpartymanagement.controller;

import com.example.springpartymanagement.entity.Guest;
import com.example.springpartymanagement.repository.GuestRepository;
import com.example.springpartymanagement.repository.WeddingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest")
public class GuestController implements GenericController<Guest, String> {
    private final GuestRepository guestRepository;
    private final WeddingRepository weddingRepository;

    public GuestController(GuestRepository guestRepository,
                           WeddingRepository weddingRepository) {
        this.guestRepository = guestRepository;
        this.weddingRepository = weddingRepository;
    }

    @Override
    @GetMapping
    public String getList(Model model) {
        model.addAttribute("guests",  guestRepository.findAll());
        return "guest/list";
    }

    @Override
    @GetMapping("/{id}")
    public String getDetail(Model model, @PathVariable("id") String s) {
        model.addAttribute("guest", guestRepository.findById(s).get());
        return "guest/detail";
    }

    @Override
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("guest", new Guest());
        model.addAttribute("weddingChoiceList", weddingRepository.findAll());
        return "guest/add";
    }

    @Override
    @PostMapping("/add")
    public String add(@ModelAttribute("guest") Guest guest) {
        guestRepository.save(guest);
        return "redirect:/guest";
    }

    @Override
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String s) {
        model.addAttribute("guest", guestRepository.findById(s).get());
        model.addAttribute("weddingChoiceList", weddingRepository.findAll());
        return "guest/edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") String s, Guest guest) {
        guestRepository.save(guest);
        return null;
    }

    @Override
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") String s) {
        guestRepository.deleteById(s);
        return "redirect:/guest";
    }
}
