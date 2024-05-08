package com.github.brewing_business.domain.product.entity;

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

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "category")
    private String category;

    @Column(name = "region")
    private String region;

    @Column(name = "star_rating")
    private Double starRating;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductImgEntity> productImgEntitiesList;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ReviewEntity> reviewEntities;


    public static ProductEntity toEntity(ReqProductDto reqProductDto) {
        return ProductEntity.builder()
                .name(reqProductDto.getProductDto().getName())
                .description(reqProductDto.getProductDto().getDescription())
                .price(reqProductDto.getProductDto().getPrice())
                .quantity(reqProductDto.getProductDto().getQuantity())
                .category(reqProductDto.getProductDto().getCategory())
                .region(reqProductDto.getProductDto().getRegion())
                .starRating(0.0)
                .build();
    }

    public void averageStarRating(Double averageStarRating) {
        this.starRating = averageStarRating;
    }
}
