package com.example.eventmanagementdemo.controllers;
import com.example.eventmanagementdemo.models.Category;
import com.example.eventmanagementdemo.services.ICategoryService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public List<Category> list(){
        return categoryService.getAll();
    }


    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public Category getById(@PathVariable @NotNull  Long id){
        return categoryService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody final Category category){
        return categoryService.create(category);
    }


    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        // need to check for children records before deleting
        categoryService.delete(id);
    }

    @PutMapping
    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Category update(@PathVariable Long id, @RequestBody Category category){
        return categoryService.update(id,category);
    }
}
