package project.DAO;

import project.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements IDAO<Customer> {
	private String jdbcURL = "jdbc:mysql://localhost:3306/customers";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	@Override
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		String sql = "SELECT * FROM customer";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				Customer customer = new Customer(id, name, email, address);
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return customers;
	}

	@Override
	public boolean add(Customer object) {
		return false;
	}

	@Override
	public Customer findById(int id) {
		Customer customer = null;
		String sql = "SELECT * FROM customer WHERE id = ?";
		try (
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				customer = new Customer(id, name, email, address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return customer;
	}

	@Override
	public boolean update(Customer object) {
		return false;
	}

	@Override
	public boolean remove(int id) {
		return false;
	}
}
