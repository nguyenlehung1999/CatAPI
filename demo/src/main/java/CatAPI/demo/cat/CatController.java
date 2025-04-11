package CatAPI.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * CatAPI.demo.cat.CatController.java.
 * Includes all REST API endpoint mappings for the Cat object.
 */
//RestController
@Controller
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
    public Object getAllCats(Model model) {
        model.addAttribute("catList", service.getAllCats());
        model.addAttribute("title", "All Cats");
        return "cat-list";
    }

    /**
     * Get a specific Cat by Id.
     * http://localhost:8080/cats/2
     *
     * @param catId the unique Id for a Cat.
     * @return One Cat object.
     */
    @GetMapping("/{catId}")
    public Object getOneCat(@PathVariable int catId, Model model) {
        model.addAttribute("cat", service.getCatById(catId));
        model.addAttribute("title", "Cat #: " + catId);
        return "cat-details";
    }


    /**
     * Get a list of cats with a name that contains the given string.
     * http://localhost:8080/cats/name?search=neko
     *
     * @param search the search key
     * @return list of Cat objects matching the search key.
     */
    @GetMapping("/name")
    public Object getCatsByName(@RequestParam(name = "search", defaultValue = "") String search, Model model) {
        model.addAttribute("catList", service.getCatsByName(search));
        model.addAttribute("title", "Cats by Name: " + search);
        return "cat-list";
    }

    /**
     * Get a list of Cats based on their breed.
     * http://localhost:8080/cats/breed/Tabby
     *
     * @param breed the search key.
     * @return A list of Cat objects matching the search key.
     */
    @GetMapping("/breed/{breed}")
    public Object getCatsByBreed(@PathVariable String breed, Model model) {
        model.addAttribute("catList", service.getCatsByBreed(breed));
        model.addAttribute("title", "Cats by breed: " + breed);
        return "cat-list";
    }

    /**
     * Get a list of old cats.
     * http://localhost:8080/cats/old
     */
    @GetMapping("/old")
    public Object getOldCats(@RequestParam(name = "age", defaultValue = "2.0") double age) {
        return new ResponseEntity<>(service.getOldCats(age), HttpStatus.OK);
    }

    /**
     * Show the view for a new Cat Form.
     *
     * @param model
     * @return the form view
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Cat cat = new Cat();
        model.addAttribute("cat", cat);
        model.addAttribute("title", "Create New Cat");
        return "cat-create";
    }

    /**
     * Create a new Cat entry.
     * http://localhost:8080/cats/new --data '{  "name": "sample cat name", "description": "orange", "breed": "Tabby", "age": 2}'
     *
     * @param cat the new Cat object.
     * @return the updated list of Cats.
     */
    @PostMapping("/new")
    public Object addNewCat(Cat cat) {
        if (cat.getImgPath() != null && cat.getImgPath().trim().isEmpty()) {
            cat.setImgPath(null);
        }
        service.addNewCat(cat);
        return "redirect:/cats/all";
    }

    /**
     * Update an existing Cat object.
     * http://localhost:8080/cats/update/2 --data '{ "catID": 1, "name": "sampleUpdated", "description": "orange", "breed": "white", "age": 3.0}'
     *
     * @param catId the unique Cat Id.
     * @return the updated Cat object.
     */
    @GetMapping("/update/{catId}")
    public Object updateCat(@PathVariable int catId, Model model) {
        model.addAttribute("cat", service.getCatById(catId));
        model.addAttribute("title", "Update Cat");
        return "cat-update";
    }

    /**
     * Update an existing Cat object.
     * http://localhost:8080/cats/update/2
     *
     * We do not need the @RequestBody!
     *
     * @param catId the unique Student Id.
     * @param cat   the new update Student details.
     * @return the updated Student object.
     */
    @PostMapping("/update/{catId}")
    public Object updateStudent(@PathVariable int catId, Cat cat) {
        service.updateCat(catId, cat);
        return "redirect:/cats/" + catId;
    }

    /**
     * Delete a Cat object.
     * http://localhost:8080/cats/delete/2
     *
     * @param catId the unique Cat Id.
     * @return the updated list of Cat.
     */
    @GetMapping("/delete/{catId}")
    public Object deleteCatById(@PathVariable int catId) {
        service.deleteCatById(catId);
        return "redirect:/cats/all";
    }
}
