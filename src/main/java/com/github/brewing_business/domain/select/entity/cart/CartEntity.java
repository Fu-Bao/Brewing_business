package com.github.brewing_business.domain.select.entity.cart;

import com.github.brewing_business.domain.product.entity.ProductEntity;
import com.github.brewing_business.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cart")
public class CartEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private UserEntity user;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartProductEntity> cartProductEntityList = new ArrayList<>();

    public static CartEntity toCartEntity(UserEntity user) {
        return CartEntity.builder()
                .user(user)
                .build();
    }
}
