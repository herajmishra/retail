package com.splus.learn.rest.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Product;
import com.splus.learn.rest.dao.ProductDao;
import com.splus.learn.rest.enums.Status;

/**
 * This is the class for Product Service
 * 
 * @author Nazish.Khatoon
 *
 */
public class ProductService {

	/**
	 * This method returns the status and description based on the passed Product
	 * Code
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse productByCode(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		product = productDao.productByCode(product, con);
		ApiResponse response = new ApiResponse();
		if (product.getProductCode() != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.commitAndCloseConnection();
		response.setResult(product);
		return response;
	}

	/**
	 * This method returns the status and description for all the fields of the
	 * table in the database.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse productShow(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		List<Product> products = productDao.productShow(product, con);
		ApiResponse response = new ApiResponse();
		if (products != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.closeConnection();
		response.setResult(products);
		return response;
	}

	/**
	 * This method returns the status and description whether the product is
	 * successfully inserted or not.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */

	public ApiResponse save(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		int i = productDao.save(product, con);
		ApiResponse response = new ApiResponse();
		if (i == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.commitAndCloseConnection();
		response.setResult(product);
		return response;
	}

	/**
	 * This method returns the status and description for the product whether the
	 * record_status is changed to 0 or not.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse delete(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		int i = productDao.delete(product, con);
		ApiResponse response = new ApiResponse();
		if (i == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.commitAndCloseConnection();
		response.setResult(product);
		return response;
	}

	/**
	 * This method returns the status and description whether the existing product
	 * is successfully updated or not.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	public ApiResponse update(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		int i = productDao.update(product, con);
		ApiResponse response = new ApiResponse();
		if (i == 1) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.commitAndCloseConnection();
		response.setResult(product);
		return response;
	}

	/**
	 * This methods Exports the product database into a excel sheet
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 * @throws IOException
	 */
	public ApiResponse export(Product product) throws SQLException, IOException {
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		List<Product> products = productDao.productShow(product, con);
		ApiResponse response = new ApiResponse();
		if (products != null) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		createExcel(products);
		productDao.closeConnection();
		response.setResult(products);
		return response;
	}

	/**
	 * This method creates an excel file
	 * 
	 * @param products
	 * @throws IOException
	 */
	private void createExcel(List<Product> products) throws IOException {
		final String FILE_NAME = "C:\\Users\\rishabh.goel\\Desktop\\Product.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Products");

		System.out.println("Creating excel");

		createHeader(sheet, workbook);
		createExcelData(sheet, products);

		FileOutputStream outputStream = new FileOutputStream(new File(FILE_NAME));
		workbook.write(outputStream);
		workbook.close();

		System.out.println("Done");

	}

	/**
	 * This method creates the heading of the excel sheet
	 * 
	 * @param sheet
	 * @param workbook
	 */
	private void createHeader(XSSFSheet sheet, XSSFWorkbook workbook) {
		Row row = sheet.createRow(0);
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		int colNum = 0;
		Cell cell = row.createCell(colNum++);
		cell.setCellValue("Product Code");
		cell.setCellStyle(style);
		Cell cell1 = row.createCell(colNum++);
		cell1.setCellValue("Product Name");
		cell1.setCellStyle(style);
		Cell cell2 = row.createCell(colNum++);
		cell2.setCellValue("Product Line");
		cell2.setCellStyle(style);
		Cell cell3 = row.createCell(colNum++);
		cell3.setCellValue("Product Scale");
		cell3.setCellStyle(style);
		Cell cell4 = row.createCell(colNum++);
		cell4.setCellValue("Product Vendor");
		cell4.setCellStyle(style);
		Cell cell5 = row.createCell(colNum++);
		cell5.setCellValue("Product Description");
		cell5.setCellStyle(style);
		Cell cell6 = row.createCell(colNum++);
		cell6.setCellValue("Quantity in Stock");
		cell6.setCellStyle(style);
		Cell cell7 = row.createCell(colNum++);
		cell7.setCellValue("Buy Price");
		cell7.setCellStyle(style);
		Cell cell8 = row.createCell(colNum++);
		cell8.setCellValue("MSRP");
		cell8.setCellStyle(style);

	}

	/**
	 * This method inputs the data into excel sheet
	 * 
	 * @param sheet
	 * @param products
	 */
	private void createExcelData(XSSFSheet sheet, List<Product> products) {
		int rowNum = 1;
		for (Product product : products) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			Cell cell = row.createCell(colNum++);
			cell.setCellValue((String) product.getProductCode());
			Cell cell1 = row.createCell(colNum++);
			cell1.setCellValue((String) product.getProductName());
			Cell cell2 = row.createCell(colNum++);
			cell2.setCellValue((String) product.getProductLine());
			Cell cell3 = row.createCell(colNum++);
			cell3.setCellValue((String) product.getProductScale());
			Cell cell4 = row.createCell(colNum++);
			cell4.setCellValue((String) product.getProductVendor());
			Cell cell5 = row.createCell(colNum++);
			cell5.setCellValue((String) product.getProductDescription());
			Cell cell6 = row.createCell(colNum++);
			cell6.setCellValue((Integer) product.getQuantityInStock());
			Cell cell7 = row.createCell(colNum++);
			cell7.setCellValue((Double) product.getBuyPrice());
			Cell cell8 = row.createCell(colNum++);
			cell8.setCellValue((Double) product.getMsrp());
		}

	}

	/**
	 * This method loads the data from excel sheet into mysql database
	 * 
	 * @param product1
	 * @return response
	 * @throws IOException
	 * @throws SQLException
	 */
	public ApiResponse load(Product product1) throws IOException, SQLException {
		final String FILE_NAME = "C:\\Users\\rishabh.goel\\Desktop\\Product2.xlsx";
		ProductDao productDao = new ProductDao();
		Connection con = productDao.connect();
		FileInputStream file = new FileInputStream(new File(FILE_NAME));
		List<Product> products = new ArrayList<Product>();
		ApiResponse response = new ApiResponse();
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Product product = new Product();
			row = (Row) sheet.getRow(i);
			product.setProductCode(row.getCell(0).toString());
			product.setProductName(row.getCell(1).toString());
			product.setProductLine(row.getCell(2).toString());
			product.setProductScale(row.getCell(3).toString());
			product.setProductVendor(row.getCell(4).toString());
			product.setProductDescription(row.getCell(5).toString());
			product.setQuantityInStock((int) row.getCell(6).getNumericCellValue());
			product.setBuyPrice(row.getCell(7).getNumericCellValue());
			product.setMsrp(row.getCell(8).getNumericCellValue());
			products.add(product);

		}

		int i = productDao.load(products, con);
		if (i != 0) {
			response.setCode(Status.SUCCESS.status());
			response.setMessage(Status.SUCCESS.description());
		} else {
			response.setCode(Status.FAILED.status());
			response.setMessage(Status.FAILED.description());
		}
		productDao.commitAndCloseConnection();
		response.setResult(products);
		file.close();
		return response;
	}

}
