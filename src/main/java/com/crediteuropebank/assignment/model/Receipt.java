package com.crediteuropebank.assignment.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Receipt {

    @Id
    @GeneratedValue
    @Column(name = "receipt_id")
    private Long id;

    @Column(name = "receipt_name", nullable = false)
    private String name;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "is_vegetarian")
    private Boolean vegetarian = Boolean.FALSE;

    @Column(name = "portion")
    private Integer portion;

    @OneToMany(targetEntity=Ingredient.class, mappedBy = "receipt", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;

    @OneToMany(targetEntity=Instruction.class, mappedBy = "receipt", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Instruction> instructions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Integer getPortion() {
        return portion;
    }

    public void setPortion(Integer portion) {
        this.portion = portion;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", vegetarian=" + vegetarian +
                ", portion=" + portion +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }
}
