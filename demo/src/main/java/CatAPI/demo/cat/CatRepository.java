package CatAPI.demo.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
    List<Cat> getCatByBreed(String breed);

    @Query(value = "select * from cats c where c.age >= ?2", nativeQuery = true)
    List<Cat> getOldCats(double age);

    @Query(value = "select * from cats c where c.name like %?1% ", nativeQuery = true)
    List<Cat> getCatsByName(String name);
}
