package will.starmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "stars")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String type;

    private String galaxy;

    private double luminosity;

    private double distance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Star(String name, String type, String galaxy, double luminosity, double distance) {
        this.name = name;
        this.type = type;
        this.galaxy = galaxy;
        this.luminosity = luminosity;
        this.distance = distance;
    }

    public Star() {
    }
}
