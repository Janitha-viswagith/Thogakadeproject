package bo;

import bo.custom.impl.CustomerBoImpl;
import bo.custom.impl.ItemBOImpl;
import dao.Util.BoType;

public class BoFactory {

    private static  BoFactory boFactory;
    private BoFactory(){

    }
    public static BoFactory getInstance(){
        return boFactory!=null ? boFactory:(boFactory= new BoFactory());
    }

    public <T extends SuperBo>T getBo(BoType type){
        switch (type){


            case CUSTOMER:
                return (T) new CustomerBoImpl();

            case ITEM:
                // Process item business object
                return (T) new ItemBOImpl();

            case ORDER:
                // Process order business object

            case ORDER_DETAIL:
                // Process order detail business object

            default:
                // Handle unexpected business object type


        }

         return null;

    }


}
