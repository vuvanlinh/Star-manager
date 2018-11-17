package will.starmanager.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stars")
public class Star {

    @Id
    @NotNull
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String type;

    @NotEmpty
    private String galaxy;

    @Min(0)
    private double luminosity;

    @Min(0)
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
