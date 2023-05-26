package com.academy.libray_task.model.entity;

import com.academy.libray_task.model.entity.enums.RequestStatus;
import com.academy.libray_task.model.entity.enums.RequestType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "librarian_id")
    @NotNull
    private User librarian;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id")
    @NotNull
    private User reader;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    @NotNull
    private Book book;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date_of_return")
    private LocalDate dateOfReturn;

    @Column(name = "request_status")
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    @Column(name = "request_type")
    @Enumerated(EnumType.STRING)
    private RequestType requestType;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updatedAt;

}

