package CatAPI.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CatAPI.demo.cat.CatController.java.
 * Includes all REST API endpoint mappings for the Cat object.
 */
@RestController
@RequestMapping("/cats")
public class CatController {
    @Autowired
    private CatService service;

    /**
     * Get a list of all Cats in the database.
     * http://localhost:8080/cats/all
     *
     * @return a list of Cats  objects.
     */
    @GetMapping("/all")
    public Object getAllCatts() {
        return new ResponseEntity<>(service.getAllCats(), HttpStatus.OK);

    }

    /**
     * Get a specific Cat by Id.
     * http://localhost:8080/cats/2
     *
     * @param catId the unique Id for a Cat.
     * @return One Cat object.
     */
    @GetMapping("/{catId}")
    public Object getOneCat(@PathVariable int catId) {
        return new ResponseEntity<>(service.getCatById(catId), HttpStatus.OK);

    }


    /**
     * Get a list of cats with a name that contains the given string.
     * http://localhost:8080/cats/name?search=alex
     *
     * @param search the search key
     * @return list of Cat objects matching the search key.
     */
    @GetMapping("/name")
    public Object getCatsByName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getCatsByName(search), HttpStatus.OK);

    }

    /**
     * Get a list of Cats based on their breed.
     * http://localhost:8080/cats/breed/Tabby
     *
     * @param breed the search key.
     * @return A list of Cat objects matching the search key.
     */
    @GetMapping("/breed/{breed}")
    public Object getCatsByBreed(@PathVariable String breed) {
        return new ResponseEntity<>(service.getCatsByBreed(breed), HttpStatus.OK);
    }


    /**
     * Create a new Cat entry.
     * http://localhost:8080/cats/new --data '{  "name": "sample cat name", "description": "orange", "breed": "Tabby", "age": 2}'
     *
     * @param cat the new Cat object.
     * @return the updated list of Cats.
     */
    @PostMapping("/new")
    public Object addNewCat(@RequestBody Cat cat) {
        service.addNewCat(cat);
        return new ResponseEntity<>(service.getAllCats(), HttpStatus.CREATED);

    }

    /**
     * Update an existing Cat object.
     * http://localhost:8080/cats/update/2 --data '{ "catID": 1, "name": "sampleUpdated", "description": "orange", "age": 3.0}'
     *
     * @param catId the unique Cat Id.
     * @param cat   the new update Cat details.
     * @return the updated Cat object.
     */
    @PutMapping("/update/{catId}")
    public Object updateCat(@PathVariable int catId, @RequestBody Cat cat) {
        service.updateCat(catId, cat);
        return new ResponseEntity<>(service.getCatById(catId), HttpStatus.CREATED);

    }

    /**
     * Delete a Cat object.
     * http://localhost:8080/cats/delete/2
     *
     * @param catId the unique Cat Id.
     * @return the updated list of Cat.
     */
    @DeleteMapping("/delete/{catId}")
    public Object deleteCatById(@PathVariable int catId) {
        service.deleteCatById(catId);
        return new ResponseEntity<>(service.getAllCats(), HttpStatus.OK);
    }
}
