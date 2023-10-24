package teste;

import IntegracaoSlack.ConexaoSlack;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import dao.DadosComponentesDao;
import dao.MaquinaDao;
import dao.MaquinaTipoComponeneteDao;

public class Teste {
    public static void main(String[] args) {
        Looca looca = new Looca();
        ConexaoSlack conexaoSlack = new ConexaoSlack();

        MaquinaDao maquinaDao = new MaquinaDao();
        Sistema maquina = looca.getSistema();

        maquinaDao.salvar(maquina);
        System.out.println(maquinaDao.listar());

        MaquinaTipoComponeneteDao maqTipoCompDao = new MaquinaTipoComponeneteDao();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        Disco disco = looca.getGrupoDeDiscos().getDiscos().get(0);
       // Rede rede = looca.getRede();


        maqTipoCompDao.salvar(processador, memoria, disco);//rede);
        System.out.println(maqTipoCompDao.listar());

        DadosComponentesDao dadosComponentesDao = new DadosComponentesDao();

        dadosComponentesDao.salvar(processador, memoria,disco);//rede);
        System.out.println(dadosComponentesDao.listar());

        conexaoSlack.enviarMensagem("Será que voltou???");
    }
}