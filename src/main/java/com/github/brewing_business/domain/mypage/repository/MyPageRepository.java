package com.github.brewing_business.domain.mypage.repository;

import com.github.brewing_business.domain.mypage.entity.MyPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPageRepository extends JpaRepository<MyPageEntity, Long> {
}
