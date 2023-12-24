package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import db.DBConnection;
import dto.OrderDetailsDto;
import dto.OrderDto;
import dto.tm.ItemTm;
import dto.tm.OrderTm;
import dto.tm.OrderdateilTm;
import dto.tm.OrdersTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderdetailFormcontroller {
    public TreeTableColumn OrderDetailTable;
    public TreeTableColumn itemcode_col;
    public TreeTableColumn qty_col;
    public TreeTableColumn UnitPrice_col;
    public JFXButton backButton;
    public ImageView png;
    public TreeTableColumn OrderID;
    public JFXTreeTableView <OrderdateilTm>OrderTable;

    public JFXButton reportsButton;

    public void initialize(){
        OrderID.setCellValueFactory(new TreeItemPropertyValueFactory<>("orderId"));
        itemcode_col.setCellValueFactory(new TreeItemPropertyValueFactory<>("itemCode"));
        qty_col.setCellValueFactory(new TreeItemPropertyValueFactory<>("qty"));
        UnitPrice_col.setCellValueFactory(new TreeItemPropertyValueFactory<>("unitPrice"));
        loadOrdersTable();


    }

    private void loadOrdersTable() {
        ObservableList<OrderdateilTm > tmList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM orderdetail";



        try {
            Statement stm = DBConnection.getInstance().getConnection().createStatement();
            ResultSet result = stm.executeQuery(sql);

            while (result.next()){


                OrderdateilTm tm = new OrderdateilTm(
                        result.getString(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getDouble(4)


                );

                tmList.add(tm);



            }

            TreeItem<OrderdateilTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
            OrderTable.setRoot(treeItem);
            OrderTable.setShowRoot(false);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



    public void backButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage)backButton.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void reportButtonOnAction(ActionEvent actionEvent) {

        try {
            JasperDesign design = JRXmlLoader.load("src/main/resources/Reports/OrderDetals1.jrxml");
            //
            //
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
