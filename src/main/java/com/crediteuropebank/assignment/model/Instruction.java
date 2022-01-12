package com.crediteuropebank.assignment.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Instruction {

    @Id
    @GeneratedValue
    @Column(name="instruction_id")
    private Long id;

    @Column(name = "instruction_content", nullable = false)
    private String content;

    @Column(name = "instruction_order")
    private Integer order;

    @ManyToOne
    @JoinColumn(name="receipt_id", referencedColumnName = "receipt_id")
    @JsonIgnore
    private Receipt receipt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", order=" + order +
                ", receipt=" + receipt +
                '}';
    }
}
