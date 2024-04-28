package com.github.brewing_business.domain.address.entity;

import com.github.brewing_business.domain.address.dto.AddressDto;
import com.github.brewing_business.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address")
public class AddressEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "address_name")
    private String addressName;

    private String receiver;

    @Column(name = "phone_number")
    private String phoneNum;

    private String address;

    private boolean isDefault;

    public static AddressEntity toEntity(AddressDto addressDto) {
        return AddressEntity.builder().build();
    }
}
