package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.TrailDao;
import entity.Trail;

public class Menu {

	private TrailDao trailDao = new TrailDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display All Trails", "Display Information for a Trail", "Add a Trail",
			"Update a Trail's Mileage", "Delete a Trail");

	public void start() throws SQLException {
		String selection = "";

		do {
			printMenu();
			selection = scanner.nextLine();

			try {
				if (selection.equals("1")) {
					displayTrails();
				} else if (selection.equals("2")) {
					displayTrail();
				} else if (selection.equals("3")) {
					addNewTrail();
				} else if (selection.equals("4")) {
					updateTrailMileage();
				} else if (selection.equals("5")) {
					deleteTrail();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
			System.out.println("Press enter for main menu...");
			scanner.nextLine();

		} while (!selection.equals("-1"));

	}

	private void printMenu() {
		System.out.println("Select an option and press enter:");

		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + " - " + options.get(i));
		}
	}

	private void displayTrails() throws SQLException {
		List<Trail> trails = trailDao.getAllTrails();
		System.out.println("All trails:");
		for (Trail trail : trails) {
			System.out.println("#" + trail.getId() + ": " + trail.getName());
		}
	}

	private void displayTrail() throws SQLException {
		System.out.println("Enter trail id:");
		int id = Integer.parseInt(scanner.nextLine());
		Trail trail = trailDao.getTrailById(id);
		System.out.println(trail.getId() + ") " + trail.getName() + ", " + trail.getMtCounty() + "County, "
				+ trail.getMiles() + " miles");
	}

	private void addNewTrail() throws SQLException {
		System.out.println("Enter trail name to add:");
		String name = scanner.nextLine();
		System.out.println("Enter county name.");
		String mtCounty = scanner.nextLine();
		System.out.println("Enter number of miles:");
		Double miles = scanner.nextDouble();
		trailDao.addNewTrail(name, mtCounty, miles);

	}

	private void updateTrailMileage() throws SQLException {
		System.out.println("Enter trail ID# before updating mileage.");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter updated number of miles for the trail.");
		double miles = Double.parseDouble(scanner.nextLine());
		trailDao.updateTrailMileage(id, miles);

	}

	private void deleteTrail() throws SQLException {
		System.out.print("Enter trail ID to delete:\n");
		int id = Integer.parseInt(scanner.nextLine());
		trailDao.deleteTrail(id);
	}

}
