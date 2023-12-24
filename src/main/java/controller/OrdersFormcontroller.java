package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import db.DBConnection;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.*;

public class OrdersFormcontroller {
    public AnchorPane pane;

    public JFXButton BackButton;
    public ImageView backButton;
    public TreeTableColumn IDCol;
    public TreeTableColumn DateCol;
    public TreeTableColumn CustomerCol;
    public JFXTreeTableView<OrdersTm> treeTable;
    public JFXButton RefrechButton;
    public JFXButton ReportButton;

    public void initialize(){
        IDCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
       DateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("Date"));
        CustomerCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("CustomerID"));
        loadOrdersTable();


    }


    public void BackButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) BackButton.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void RefrechButtonOnAction(ActionEvent actionEvent) {
     loadOrdersTable();
    }

    private void clearFields() {
    treeTable.refresh();

    }

    private void loadOrdersTable() {
        ObservableList<OrdersTm> tmList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM orders";

        try {
            Statement stm = DBConnection.getInstance().getConnection().createStatement();
            ResultSet result = stm.executeQuery(sql);

            while (result.next()){
                JFXButton btn = new JFXButton("Delete");

                OrdersTm tm = new OrdersTm(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3)


                );

              tmList.add(tm);
              tmList.add(tm);


            }

            TreeItem<OrdersTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
            treeTable.setRoot(treeItem);
            treeTable.setShowRoot(false);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void ReportButtonOnAction(ActionEvent actionEvent) {
        try {
            JasperDesign design = JRXmlLoader.load("F:\\mvc-maven-pos-master  2\\src\\main\\resources\\Reports\\orderDetails.jrxml");
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
