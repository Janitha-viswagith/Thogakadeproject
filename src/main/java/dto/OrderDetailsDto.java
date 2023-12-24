package dto;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderDetailsDto extends RecursiveTreeObject<OrderDetailsDto> {
    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
}
