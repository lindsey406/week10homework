package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Trail;

public class TrailDao {

	private Connection connection;
	private final String GET_ALL_TRAILS_QUERY = "SELECT id, name, mt_county, miles FROM trails";
	private final String GET_TRAIL_BY_ID_QUERY = "SELECT name, mt_county, miles FROM trails WHERE id = ?";
	private final String ADD_NEW_TRAIL_QUERY = "INSERT into trails(name, mt_county, miles) values(?, ?, ?)";
	private final String UPDATE_TRAIL_MILEAGE_BY_ID_QUERY = "UPDATE trails SET miles = ? WHERE id = ?";
	private final String DELETE_TRAIL_BY_ID_QUERY = "DELETE FROM trails WHERE id = ?";

	public TrailDao() {
		connection = DBConnection.getConnection();
	}

	public List<Trail> getAllTrails() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ALL_TRAILS_QUERY).executeQuery();
		List<Trail> trails = new ArrayList<Trail>();

		while (rs.next()) {
			trails.add(populateTrail(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		}
		return trails;
	}

	public Trail getTrailById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_TRAIL_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateTrail(id, rs.getString(1), rs.getString(2), rs.getDouble(3));
	}

	public void addNewTrail(String name, String mt_county, double miles) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_NEW_TRAIL_QUERY);
		ps.setString(1, name);
		ps.setString(2, mt_county);
		ps.setDouble(3, miles);
		ps.executeUpdate();
	}
	
	public void updateTrailMileage(int id, double miles) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_TRAIL_MILEAGE_BY_ID_QUERY);
		ps.setDouble(1, miles);
		ps.setInt(2, id);
		ps.executeUpdate();
}

	public void deleteTrail(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TRAIL_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	private Trail populateTrail(int id, String name, String mtCounty, double miles) {
		return new Trail(id, name, mtCounty, miles);
	}

}
