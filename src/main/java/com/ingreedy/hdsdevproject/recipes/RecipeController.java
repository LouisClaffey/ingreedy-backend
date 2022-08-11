package com.ingreedy.hdsdevproject.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
////@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "https://ingreedy.vercel.app/" )
public class RecipeController {

    @Autowired
    private RecipeService service;
    private Recipes recipe;


    @GetMapping(path = "users/home")
    public List<Recipes> listReverse(){
        return service.listAllReverse();
    }


    @PostMapping(path = "recipes")
    public void add(@RequestBody Recipes recipe){
        service.save(recipe);
    }


    /** time constraints stopped full implementation
     * this code would be used to select a specific recipe
     * linked to a users profile
     */
    @GetMapping(path = "users/recipes/{id}")
    public ResponseEntity<Recipes> get(@PathVariable Integer id){
        try {
            Recipes recipe = service.get(id);
            return new ResponseEntity<Recipes>(recipe, HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<Recipes>(HttpStatus.NOT_FOUND);
        }
    }

    /** return oldest first -- unused */
//    @GetMapping(path = "users/recipes")
//    public List<Recipes> list(){
//        return service.listAll();
//    }

    /** time constraints stopped full implementation
     * this code would be used to allow a user to delete a recipe
     * nb. see delete function in RecipeService
     */
    @DeleteMapping(path ="users/home")
    public List<Recipes> theNewList(){
        service.delete();
        return service.listAllReverse();
    }

}
