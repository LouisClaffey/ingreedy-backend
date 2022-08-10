package com.ingreedy.hdsdevproject.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repo;

    public List<Recipes> listAllReverse(){
        Iterable<Recipes> recipesReversed = repo.findAll(Sort.by("id").descending());
        return (List<Recipes>) recipesReversed;
    }


    public void save (Recipes recipe){
        repo.save(recipe);
    }

    public Recipes get(Integer id){
        return repo.findById(id).get();
    }



    /** time constraints stopped full implementation
     * this code would be used to allow a user to delete a recipe
     * nb. see @DeleteMapping method in RecipeController
     */
    public List<Recipes> delete(){

        List<Recipes> theList =  repo.findAll();

        if(theList != null) {
            Integer max = 0;

            for (Recipes recipe : theList) {
                Integer i = recipe.getId();
                if (i > max) {
                    max = i;
                }

            }
            repo.deleteById(max);
        }

        return theList;
    }
    /** delete by id -- unused */
    public void delete(Integer id){
        repo.deleteById(id);
    }

    /** return oldest first -- unused */
    public List<Recipes> listAll(){
        return repo.findAll();
    }
}
