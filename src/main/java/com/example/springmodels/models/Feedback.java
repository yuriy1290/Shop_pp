package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Введите содержание")
    private String content;

    @NotBlank(message = "Введите оценка")
    private String mark;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    public Feedback() {
    }

    public Feedback(Long id, String content, String mark, Order order) {
        this.id = id;
        this.content = content;
        this.mark = mark;
        this.order = order;
    }

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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
