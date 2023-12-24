package dto.tm;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrderdateilTm extends RecursiveTreeObject<OrderdateilTm> {

    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
}
