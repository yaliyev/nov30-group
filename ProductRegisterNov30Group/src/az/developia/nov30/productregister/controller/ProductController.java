package az.developia.nov30.productregister.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class ProductController {
	@FXML
	private CheckBox allSelectedCheckBox;

	@FXML
	private TableColumn<?, ?> arrivalDateCol;

	@FXML
	private TableColumn<?, ?> atStorageCol;

	@FXML
	private ToggleGroup atStorageRadioButtonToggler;

	@FXML
	private TableColumn<?, ?> categoryCol;

	@FXML
	private Button changeStatusButton;

	@FXML
	private Button deleteCategoryButton;

	@FXML
	private Button deleteProductButton;

	@FXML
	private TableColumn<?, ?> idCol;

	@FXML
	private Button insertCategoryButton;

	@FXML
	private Button insertProductButton;

	@FXML
	private TableColumn<?, ?> nameCol;

	@FXML
	private TableColumn<?, ?> priceCol;

	@FXML
	private ComboBox<?> productCategoryCB;

	@FXML
	private ImageView productImageView;

	@FXML
	private TextField productNameTF;

	@FXML
	private TextField productPriceTF;

	@FXML
	private TextField productQuantityTF;

	@FXML
	private DatePicker productStorageArrivingDP;

	@FXML
	private TableView<?> productsTableView;

	@FXML
	private TableColumn<?, ?> quantityCol;

	@FXML
	private Button resetFormButton;

	@FXML
	private TextField searchProductTF;

	@FXML
	private Button updateProductButton;

	@FXML
	private Button uploadImageButton;

	@FXML
	void changeStatusButtonClicked(ActionEvent event) {

	}

	@FXML
	void deleteCategoryButtonClicked(ActionEvent event) {

	}

	@FXML
	void deleteProductButtonClicked(ActionEvent event) {

	}

	@FXML
	void insertCategoryButtonClicked(ActionEvent event) {

	}

	@FXML
	void insertProductButtonClicked(ActionEvent event) {

	}

	@FXML
	void resetFormButtonClicked(ActionEvent event) {

	}

	@FXML
	void updateProductButtonClicked(ActionEvent event) {

	}

	@FXML
	void uploadImageButtonClicked(ActionEvent event) {

	}
}
