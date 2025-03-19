package CatAPI.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public List<Cat> getAllCats() {

        return catRepository.findAll();
    }

    public Cat getCatById(int catId) {

        return catRepository.findById(catId).orElse(null);
    }

    public List<Cat> getCatsByBreed(String breed) {

        return catRepository.getCatByBreed(breed);
    }

    public List<Cat> getOldCats(double age) {

        return catRepository.getOldCats(age);
    }

    public List<Cat> getCatsByName(String name) {

        return catRepository.getCatsByName(name);
    }

    public void addNewCat(Cat cat) {

        catRepository.save(cat);
    }

    public void updateCat(int catId, Cat cat) {
        Cat existing = getCatById(catId);
        existing.setName(cat.getName());
        existing.setDescription(cat.getDescription());
        existing.setBreed(cat.getBreed());
        existing.setAge(cat.getAge());

        catRepository.save(existing);
    }

    public void deleteCatById(int catId) {

        catRepository.deleteById(catId);
    }
}
