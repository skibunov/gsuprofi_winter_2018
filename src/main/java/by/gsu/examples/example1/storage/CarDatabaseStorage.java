package by.gsu.examples.example1.storage;

import by.gsu.examples.example1.Storage;
import by.gsu.examples.example1.auto.Car;
import by.gsu.examples.example1.auto.Taxi;
import by.gsu.examples.example1.auto.Truck;
import by.gsu.examples.example1.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDatabaseStorage implements Storage<Car> {

    public CarDatabaseStorage() {
        DBUtils.init();
    }

    @Override
    public void add(Car car) {

        try {
            int passengers = 0;
            boolean isElectric = false;
            String type;

            if (car instanceof Taxi) {
                passengers = ((Taxi) car).getPassengers();
                type = "taxi";
            } else {
                isElectric = ((Truck) car).isElectric();
                type = "truck";
            }

            Connection cn = DBUtils.getConnection();

            PreparedStatement ps = cn.prepareStatement(
                    "insert into car " +
                            "(mark, passengers, is_electric, type) " +
                            "values(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, car.getMark());
            ps.setInt(2, passengers);
            ps.setBoolean(3, isElectric);
            ps.setString(4, type);
            ps.execute();
//    todo implement
//            ResultSet keys = ps.getGeneratedKeys();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public List<Car> getAll() {

        try {
            String sql = "select * from car";

            Connection cn = DBUtils.getConnection();
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                int id  = rs.getInt("id");
                String mark = rs.getString("mark");
                int passengers = rs.getInt("passengers");
                boolean isElectric = rs.getBoolean("is_electric");
                String type = rs.getString("type");

                Car car;
                if ("taxi".equalsIgnoreCase(type)) {
                    Taxi taxi = new Taxi();
                    taxi.setPassengers(passengers);
                    car = taxi;

                } else {
                    Truck truck = new Truck();
                    truck.setElectric(isElectric);
                    car = truck;
                }
                car.setMark(mark);
                car.setId(id);
                cars.add(car);

            }

            rs.close();
            st.close();

            return cars;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
