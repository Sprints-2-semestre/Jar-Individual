package dao;

import conexao.Conexao;
import conexao.ConexaoAws;
import modelo.ValidacaoParametro;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ValidacaoEmail extends ValidacaoParametro {

    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoDoBanco();

    ConexaoAws conexaoAws = new ConexaoAws();
    JdbcTemplate conAws = conexaoAws.getConexaoDoBanco();

    public ValidacaoEmail() {
    }

    @Override
    public Boolean verificarParametro(String parametro) {
        List<String> emailsExistentes;

        try {
            emailsExistentes = conAws.queryForList("SELECT email FROM usuario", String.class);
        for(int i = 0; i < emailsExistentes.size(); i++){
            if(emailsExistentes.get(i).equals(parametro)){
                return true;
            }
        }
        }catch(Exception erroEmail) {
            System.err.println(erroEmail.getMessage());
        }
        return false;


    }
}
