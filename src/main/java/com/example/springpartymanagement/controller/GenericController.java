package com.example.springpartymanagement.controller;

import org.springframework.ui.Model;

public interface GenericController<Entity, Id> {
    public String getList(Model model);

    public String getDetail(Model model, Id id);

    public String add(Model model);

    public String add(Entity entity);

    public String edit(Model model, Id id);

    public String edit(Id id, Entity entity);

    public String delete(Id id);
}
