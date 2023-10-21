package dao;

import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import conexao.Conexao;
import modelo.MaquinaTipoComponente;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MaquinaTipoComponenteDao {
    public void salvarComponentes(Processador processador, Memoria memoria, Disco disco){//, Rede rede) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("INSERT INTO maquinaTipoComponente (fkMaquina, fkTipoComp, idProcessador, num_ProcesLogicos, num_ProcesFisicos) VALUES (?,?,?,?,?)", 1, 1, processador.getId(), processador.getNumeroCpusLogicas(), processador.getNumeroCpusFisicas());

        con.update("INSERT INTO maquinaTipoComponente (fkMaquina, fkTipoComp, tamanhoTotal) VALUES (?,?,?)", 1, 2, memoria.getTotal());

        con.update("INSERT INTO maquinaTipoComponente (fkMaquina, fkTipoComp, tamanhoTotal, numSerial) VALUES (?,?,?,?)", 1, 3, disco.getTamanho(), disco.getSerial());

        //  con.update("INSERT INTO maquinaTipoComponente (fkMaquina, fkTipoComp, enderecoMac, ipv4) VALUES (?,?,?,?)", 1, 4, rede.getGrupoDeInterfaces().getInterfaces().get(1).getEnderecoMac(), rede.getGrupoDeInterfaces().getInterfaces().get(1).getEnderecoIpv4());
    }

    public void salvarCpu(Processador processador){
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("INSERT INTO maquinaTipoComponente (fkMaquina, fkTipoComp, idProcessador, num_ProcesLogicos, num_ProcesFisicos) VALUES (?,?,?,?,?)", 1, 1, processador.getId(), processador.getNumeroCpusLogicas(), processador.getNumeroCpusFisicas());
    }

    public void salvarMemoria(Memoria memoria){
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("INSERT INTO maquinaTipoComponente (fkMaquina, fkTipoComp, tamanhoTotal) VALUES (?,?,?)", 1, 2, memoria.getTotal());
    }

    public void salvarDisco(Disco disco){
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("INSERT INTO maquinaTipoComponente (fkMaquina, fkTipoComp, tamanhoTotal, numSerial) VALUES (?,?,?,?)", 1, 3, disco.getTamanho(), disco.getSerial());
    }

    public List<MaquinaTipoComponente> listar() {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        return con.query("SELECT * FROM maquinaTipoComponente",
                new BeanPropertyRowMapper<>(MaquinaTipoComponente.class));
    }

    public void truncarDados(){
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();

        con.update("ALTER TABLE dadosComponente DROP CONSTRAINT Dados_FK_MaqTipoComp;");
        con.update("truncate table maquinaTipoComponente;");
        con.update("ALTER TABLE dadosComponente ADD CONSTRAINT Dados_FK_MaqTipoComp FOREIGN KEY (fkMaquinaTipoComponente) REFERENCES maquinaTipoComponente(idMaqTipoComp)");
    }
}
