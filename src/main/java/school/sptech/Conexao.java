package school.sptech;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

public class Conexao {

    private DataSource conexao;

    public Conexao(){
        Dotenv dotenv = Dotenv.load();
        DriverManagerDataSource driver = new DriverManagerDataSource();

        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPass = dotenv.get("DB_PASSWORD");

        if (dbUrl == null) {
            dbUrl = "jdbc:mysql://container-banco-vigilante:3306/DataWings";
        }
        if (dbUser == null) {
            dbUser = "root";
        }
        if (dbPass == null) {
            dbPass = "urubu100";
        }

        driver.setUrl(dbUrl);
        driver.setUsername(dbUser);
        driver.setPassword(dbPass);
        driver.setDriverClassName("com.mysql.cj.jdbc.Driver");

        this.conexao = driver;
    }

    public DataSource getConexao(){
        return conexao;
    }

}