package com.github.brewing_business.domain.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class ReviewEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    private String title;

    private String content;

    @Column(name = "star_rating")
    private Double starRating;

    @OneToMany(mappedBy = "reviewEntity", fetch = FetchType.EAGER)
    private List<ReviewImgEntity> reviewImgEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_idx")
    @JsonIgnore
    private ProductEntity productId;
}
