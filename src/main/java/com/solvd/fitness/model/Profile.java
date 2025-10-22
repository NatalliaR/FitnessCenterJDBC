package com.solvd.fitness.model;

public class Profile {

    private Integer id;
    private String profile_type;


    public Profile(Integer id, String profile_type) {
        this.id = id;
        this.profile_type = profile_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfile_type() {
        return profile_type;
    }

    public void setProfile_type(String profile_type) {
        this.profile_type = profile_type;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", profile_type='" + profile_type + '\'' +
                '}';
    }
}
