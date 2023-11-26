package conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoAws {

    JdbcTemplate conexaoDoBanco;
    public ConexaoAws() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://54.197.240.46:1433;database=MedGuard;trustServerCertificate=true");
        dataSource.setUsername("sa");
        dataSource.setPassword("farmacos");
    }
    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }
}
