import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Загрузка драйвера SQLite
            Class.forName("org.sqlite.JDBC");

            // Создание подключения к базе данных SQLite
            String dbUrl = "jdbc:sqlite:Hospital.db";
            connection = DriverManager.getConnection(dbUrl);

            if (connection != null) {
                System.out.println("Успешное подключение к базе данных SQLite.");
                DatabaseManager dbManager = new DatabaseManager();

        dbManager.addDepartment("Отделение 1");
        dbManager.addDepartment("Отделение 2");

        dbManager.addPatient(1, "Стешковой Иван", 30, "Мужской");
        dbManager.addPatient(1, "Романенко", 25, "Мужской");
        dbManager.addPatient(2, "Агатов", 35, "Женский");

        dbManager.listDepartments();
        dbManager.listPatients();

        dbManager.editDepartment(1, "Измененное отделение 1");
        dbManager.editPatient(1, "Новое имя", 40, "Мужской");

        dbManager.removeDepartment(2);
        dbManager.removePatient(2);

        dbManager.listDepartments();
        dbManager.listPatients();

        connection.close();
            } else {
                System.out.println("Не удалось подключиться к базе данных SQLite.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер SQLite не найден.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к базе данных SQLite.");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии подключения.");
                e.printStackTrace();
            }
        }
    }
}
