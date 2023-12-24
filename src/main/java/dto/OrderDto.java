package dto;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderDto extends RecursiveTreeObject<OrderDto> {
    private String orderId;
    private String date;
    private String custId;
    private List<OrderDetailsDto> list;

    public OrderDto(String orderId, String date, String custId) {
        this.orderId = orderId;
        this.date = date;
        this.custId = custId;
    }
}
