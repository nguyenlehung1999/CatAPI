package CatAPI.demo.cat;


import jakarta.persistence.*;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private double age;

    public Cat(int catId, String name, String description, String breed, double age) {
        this.catId = catId;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public Cat(String name, String description, String breed, double age) {
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    //Always include a no-argument constructor.
    public Cat() {
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

}
