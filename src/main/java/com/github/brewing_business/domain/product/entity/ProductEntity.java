package com.github.brewing_business.domain.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.brewing_business.domain.product.dto.ReqProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "stock")
    private int stock;

    private String category;

    private String region;

    @Column(name = "star_rating")
    private Double starRating;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductImgEntity> productImgEntitiesList;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ReviewEntity> reviewEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn


    public static ProductEntity toEntity(ReqProductDto reqProductDto) {
        return ProductEntity.builder()
                .name(reqProductDto.getProduct().getName())
                .description(reqProductDto.getProduct().getDescription())
                .price(reqProductDto.getProduct().getPrice())
                .stock(reqProductDto.getProduct().getStock())
                .category(reqProductDto.getProduct().getCategory())
                .region(reqProductDto.getProduct().getRegion())
                .starRating(0.0)
                .build();
    }

    public void averageStarRating(Double averageStarRating) {
        this.starRating = averageStarRating;
    }
}
