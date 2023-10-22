package teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.sistema.Sistema;
import dao.DadosComponentesDao;
import dao.MaquinaDao;
import dao.MaquinaTipoComponeneteDao;
import modelo.Maquina;
import modelo.Separacao;
import org.checkerframework.checker.units.qual.A;
import oshi.SystemInfo;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        Looca looca = new Looca();

        List<RedeInterface>ConfigRede = looca.getRede().getGrupoDeInterfaces().getInterfaces();
        RedeInterface Adaptadores = null;
        long MaiorByteRecebido = 0;
        for (RedeInterface listaConfigRede: ConfigRede) {
            long bitesRecebidos = listaConfigRede.getBytesRecebidos();
            if (bitesRecebidos > MaiorByteRecebido){
                Adaptadores = listaConfigRede;
            }
        }
        System.out.println("DADOS DE REDE");
        System.out.println(Adaptadores);

        Separacao separar = new Separacao();
        System.out.println(separar.espacamento());

        System.out.println("DADOS SISTEMA OPERACIONAL\n");
        MaquinaDao maquinaDao = new MaquinaDao();
        Sistema maquina = looca.getSistema();

        maquinaDao.salvar(maquina);
        System.out.println(maquinaDao.listar());

        System.out.println("DADOS TIPOS COMPONENTES\n");
        MaquinaTipoComponeneteDao maqTipoCompDao = new MaquinaTipoComponeneteDao();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        Disco disco = looca.getGrupoDeDiscos().getDiscos().get(0);
       // Rede rede = looca.getRede();

        maqTipoCompDao.salvar(processador, memoria, disco);//rede);
        System.out.println(maqTipoCompDao.listar());


        System.out.println("DADOS COMPONENTES\n");
        DadosComponentesDao dadosComponentesDao = new DadosComponentesDao();

        dadosComponentesDao.salvar(processador, memoria,disco);//rede);
        System.out.println(dadosComponentesDao.listar());
    }

}
