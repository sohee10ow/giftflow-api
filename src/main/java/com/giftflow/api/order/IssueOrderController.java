package com.giftflow.api.order;

import com.giftflow.api.common.ApiResponse;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueOrderController {

    private final IssueOrderRepository issueOrderRepository;

    public IssueOrderController(IssueOrderRepository issueOrderRepository) {
        this.issueOrderRepository = issueOrderRepository;
    }

    @PostMapping("/partner-api/v1/orders/issue")
    public ApiResponse<IssueOrderResponse> createOrder(@Valid @RequestBody CreateIssueOrderRequest request) {
        LocalDateTime now = LocalDateTime.now();
        IssueOrderEntity order = new IssueOrderEntity();
        order.setPartnerId(request.getPartnerId());
        order.setProductId(request.getProductId());
        order.setPartnerOrderId(request.getPartnerOrderId());
        order.setStatus(IssueOrderStatus.CREATED);
        order.setCreatedAt(now);
        order.setUpdatedAt(now);

        IssueOrderEntity saveObject =  issueOrderRepository.save(order);

        IssueOrderResponse response = new IssueOrderResponse(
            saveObject.getId(),
            saveObject.getPartnerId(),
            saveObject.getProductId(),
            saveObject.getPinInventoryId(),
            saveObject.getPartnerOrderId(),
            saveObject.getStatus(),
            saveObject.getIssuedAt(),
            saveObject.getCanceledAt()
        );

        return ApiResponse.success(response, UUID.randomUUID().toString());

    }

    @GetMapping("/partner-api/v1/orders/{id}")
    public ApiResponse<IssueOrderResponse> getOrderById( @PathVariable long id) {

        IssueOrderEntity order = issueOrderRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("없는 주문입니다."));

        IssueOrderResponse response = new IssueOrderResponse(
            order.getId(),
            order.getPartnerId(),
            order.getProductId(),
            order.getPinInventoryId(),
            order.getPartnerOrderId(),
            order.getStatus(),
            order.getIssuedAt(),
            order.getCanceledAt()

        );

        return ApiResponse.success(response, UUID.randomUUID().toString());
    }
}
