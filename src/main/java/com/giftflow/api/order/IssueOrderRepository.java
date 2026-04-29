package com.giftflow.api.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueOrderRepository extends JpaRepository<IssueOrderEntity, Long> {

}
