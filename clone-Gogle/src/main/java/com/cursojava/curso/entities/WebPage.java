package com.cursojava.curso.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "webpage")
public class WebPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;
    @Column(name ="url")
    private String url;
    @Column(name ="description")
    private String description;
    @Column(name ="title")
    private String title;

    public WebPage(){}

    public WebPage(String url){
        this.url = url;
    }
}
