package teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import dao.DadosComponentesDao;
import dao.MaquinaDao;
import dao.MaquinaTipoComponenteDao;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Looca looca = new Looca();

        MaquinaDao maquinaDao = new MaquinaDao();
        Sistema maquina = looca.getSistema();

        maquinaDao.salvar(maquina);


        MaquinaTipoComponenteDao maqTipoCompDao = new MaquinaTipoComponenteDao();
        Memoria memoria = looca.getMemoria();
        Processador processador = looca.getProcessador();
        Disco disco = looca.getGrupoDeDiscos().getDiscos().get(0);
        // Rede rede = looca.getRede();

        DadosComponentesDao dadosComponentesDao = new DadosComponentesDao();

        Scanner leitor = new Scanner(System.in);

        Integer opcaoEscolhida;
        do{
            System.out.println("""
                    -----------------------------------------------
                    |        Bem vindo ao sistema Fármacos        |
                    -----------------------------------------------
                    | Digite a opção desejada de monitoramento:   |
                    |                                             |
                    | 1) Todos os componentes                     |
                    | 2) CPU                                      |
                    | 3) Memória                                  |
                    | 4) Disco                                    |
                    | 5) Sair                                     |
                    -----------------------------------------------
                    """);
            opcaoEscolhida = leitor.nextInt();

            switch (opcaoEscolhida){
                case 1:
                    System.out.println(maquinaDao.listar());

                    maqTipoCompDao.salvarComponentes(processador, memoria, disco);//rede);
                    System.out.println(maqTipoCompDao.listar());

                    dadosComponentesDao.salvarComponentes(processador, memoria,disco);//rede);
                    System.out.println(dadosComponentesDao.listar());

                    dadosComponentesDao.truncarDados();
                    maqTipoCompDao.truncarDados();
                    break;
                case 2:
                    System.out.println(maquinaDao.listar());

                    maqTipoCompDao.salvarCpu(processador);
                    System.out.println(maqTipoCompDao.listar());

                    dadosComponentesDao.salvarCpu(processador);
                    System.out.println(dadosComponentesDao.listar());

                    dadosComponentesDao.truncarDados();
                    maqTipoCompDao.truncarDados();
                    break;
                case 3:
                    System.out.println(maquinaDao.listar());

                    maqTipoCompDao.salvarMemoria(memoria);
                    System.out.println(maqTipoCompDao.listar());

                    dadosComponentesDao.salvarMemoria(memoria);
                    System.out.println(dadosComponentesDao.listar());

                    dadosComponentesDao.truncarDados();
                    maqTipoCompDao.truncarDados();
                    break;
                case 4:
                    System.out.println(maquinaDao.listar());

                    maqTipoCompDao.salvarDisco(disco);
                    System.out.println(maqTipoCompDao.listar());

                    dadosComponentesDao.salvarDisco(disco);
                    System.out.println(dadosComponentesDao.listar());

                    dadosComponentesDao.truncarDados();
                    maqTipoCompDao.truncarDados();
                    break;
                case 5:
                    System.out.println("Encerrando programa...");
                    System.exit(5);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcaoEscolhida != 5);

        leitor.close();
    }
}
