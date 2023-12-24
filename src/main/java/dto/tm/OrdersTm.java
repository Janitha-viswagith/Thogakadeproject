package dto.tm;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class OrdersTm extends RecursiveTreeObject<OrdersTm> {

    private String id;
    private String Date;
    private  String CustomerID;


    public OrdersTm(String string, String string1, double aDouble, double aDouble1) {
    }
}
