package by.epamtr.veloshop.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.bean.entity.ReportLine;
import by.epamtr.veloshop.dao.VeloDao;
import by.epamtr.veloshop.dao.exception.DaoException;

public class DBVeloDao implements VeloDao {

	private final String INSERT_INTO_PRODUCT = "INSERT INTO `cycling_products`.`product` (product_name, product_price, product_category)"
			+ "VALUES"
			+ "(?,?,?);";
	private final static String DELETE_FROM_PRODUCT = " DELETE FROM `product`"
			+ "WHERE `product`.`product_id` = ? ;";
	
	private final static String SELECT_FROM_PRODUCT = "SELECT `product`.`product_id`,"
			+ "`product`.`product_name`,"
			+ "`product`.`product_price`,"
			+ "`product`.`product_category`"
			+ "FROM `cycling_products`.`product`"
			+ "WHERE `cycling_products`.`product`.product_category LIKE ?;";
	
	private final static String UPDATE_PRODUCT_BY_ID = "UPDATE `cycling_products`.`product`"
			+ "SET"
			+ "`product_name` = ?,"
			+ "`product_price` = ?,"
			+ "`product_category` = ?"
			+ "WHERE `product_id` = ?;";
	
	private final static String GENERATE_REPORT = "SELECT  `product`.`product_category`, COUNT(*), MIN(`product`.product_price),  MAX(`product`.product_price)"
			+ "FROM `cycling_products`.`product`"
			+ "GROUP BY `product`.product_category;";
	
	
	@Override
	public void addProduct(String name, int price, String categoryName) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName("org.gjt.mm.mysql.Driver");// ну и зачем мы при вызове каждого метода грузим драйвер
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycling_products?useSSL=false", "root",
					"3946833Andrey");
			ps = con.prepareStatement(INSERT_INTO_PRODUCT);
			Product p = new Product (name,price,categoryName);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getPrice());
			ps.setString(3, p.getCategory());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new DaoException("No driver found.", e);
		} catch (SQLException e) {
			throw new DaoException("Database access error.", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();// если этот оператор сгенерирует исключение, соединенеие не закроется вовсе
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Database access error.", e);
			}

		}

	}

	@Override
	public void deleteProductById(int id) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycling_products?useSSL=false", "root",
					"3946833Andrey");
			ps = con.prepareStatement(DELETE_FROM_PRODUCT);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new DaoException("No driver found.", e);
		} catch (SQLException e) {
			throw new DaoException("Database access error.", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Database access error.", e);
			}

		}

	}

	@Override
	public List<Product> showProductByCategory(String categoryName) throws DaoException {
    
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> productList = new ArrayList<>();

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycling_products?useSSL=false", "root",
					"3946833Andrey");
			ps = con.prepareStatement(SELECT_FROM_PRODUCT);
			ps.setString(1, categoryName);
			rs = ps.executeQuery();
			while(rs.next()){
				Product product = new Product(rs.getString(2),rs.getInt(3),rs.getString(4));
				productList.add(product);
			}
		} catch (ClassNotFoundException e) {
			throw new DaoException("No driver found.", e);
		} catch (SQLException e) {
			throw new DaoException("Database access error.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Database access error.", e);
			}

		}
		return productList;
	}

	@Override
	public void updateProductById(Product product) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycling_products?useSSL=false", "root",
					"3946833Andrey");
			ps = con.prepareStatement(UPDATE_PRODUCT_BY_ID);
			ps.setString(1, product.getName());
			ps.setInt(2, product.getPrice());
			ps.setString(3, product.getCategory());
			ps.setInt(4, product.getId());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new DaoException("No driver found.", e);
		} catch (SQLException e) {
			throw new DaoException("Database access error.", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Database access error.", e);
			}

		}
	}

	@Override
	public List<ReportLine> showReport() throws DaoException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<ReportLine> reportList = new ArrayList<>();

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cycling_products?useSSL=false", "root",
					"3946833Andrey");
			st = con.createStatement();
			rs = st.executeQuery(GENERATE_REPORT);
			while(rs.next()){
				ReportLine reportLine = new ReportLine();
				reportLine.setProductCategory(rs.getString(1));
				reportLine.setProductAmount(rs.getInt(2));
				reportLine.setMinPrice(rs.getInt(3));
				reportLine.setMaxPrice(rs.getInt(4));
				reportList.add(reportLine);
			}
		} catch (ClassNotFoundException e) {
			throw new DaoException("No driver found.", e);
		} catch (SQLException e) {
			throw new DaoException("Database access error.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DaoException("Database access error.", e);
			}

		}
		return reportList;
	}

}
