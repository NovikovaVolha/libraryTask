package com.academy.libray_task.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotNull
    private String ISBN;

    //@NotNull
    private String title;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    //@NotNull
    private List<Author> authors;

    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    //@NotNull
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    //@NotNull
    private Publisher publisher;

    @Column(name = "year_of_issue")
    //@NotNull
    private Integer yearOfIssue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalogue_id")
    //@NotNull
    private Catalogue catalogue;

    @Column(name = "book_amount")
    //@NotNull
    private Integer bookAmount;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Override
    public String toString() {
        return title;
    }
}
