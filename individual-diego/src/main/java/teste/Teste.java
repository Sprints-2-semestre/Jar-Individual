package teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import dao.DadosComponentesDao;
import dao.MaquinaDao;
import dao.MaquinaTipoComponeneteDao;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Scanner sc = new Scanner(System.in);
        Scanner log = new Scanner(System.in);

        System.out.println("Digite seu Email:");
        String email = log.nextLine();
       System.out.println("Digite sua Senha:");
        String senha = log.nextLine();
                    Integer opcao;
                    do {
                        System.out.println("""
                                ------------------------------
                                  %s
                                |     Escolha uma opição:    |
                                | 1 - Memoria                |
                                | 2 - Processador            |
                                | 3 - Disco                  |
                                | 4 - Rede                   |
                                | 5 - Sair                   |
                                ------------------------------
                                """.formatted(email));
                         opcao = sc.nextInt();
                         switch (opcao) {
                            case 1 -> {
                                MaquinaDao maquinaDao = new MaquinaDao();
                                Sistema maquina = looca.getSistema();

                                maquinaDao.salvar(maquina);
                                System.out.println(maquinaDao.listar());

                                MaquinaTipoComponeneteDao maqTipoCompDao = new MaquinaTipoComponeneteDao();
                                Memoria memoria = looca.getMemoria();

                                maqTipoCompDao.salvar(memoria);
                                System.out.println(maqTipoCompDao.listar());

                                DadosComponentesDao dadosComponentesDao = new DadosComponentesDao();

                                dadosComponentesDao.salvar(memoria);
                                System.out.println(dadosComponentesDao.listar());
                            }
                            case 2 -> {
                                MaquinaDao maquinaDao = new MaquinaDao();
                                Sistema maquina = looca.getSistema();

                                maquinaDao.salvar(maquina);
                                System.out.println(maquinaDao.listar());

                                MaquinaTipoComponeneteDao maqTipoCompDao = new MaquinaTipoComponeneteDao();
                                Processador processador = looca.getProcessador();

                                maqTipoCompDao.salvar(processador);
                                System.out.println(maqTipoCompDao.listar());

                                DadosComponentesDao dadosComponentesDao = new DadosComponentesDao();

                                dadosComponentesDao.salvar(processador);
                                System.out.println(dadosComponentesDao.listar());
                            }
                            case 3 -> {
                                MaquinaDao maquinaDao = new MaquinaDao();
//                    Sistema maquina = looca.getSistema();
//
//        maquinaDao.salvar(maquina);
                                System.out.println(maquinaDao.listar());

                                MaquinaTipoComponeneteDao maqTipoCompDao = new MaquinaTipoComponeneteDao();
                                ;
                                Disco disco = looca.getGrupoDeDiscos().getDiscos().get(0);


                                maqTipoCompDao.salvar(disco);
                                System.out.println(maqTipoCompDao.listar());

                                DadosComponentesDao dadosComponentesDao = new DadosComponentesDao();

                                dadosComponentesDao.salvar(disco);
                                System.out.println(dadosComponentesDao.listar());

//                }
//                case 4 -> {
//                    Rede rede = looca.getRede();
//                    List<RedeInterface> redes = rede.getGrupoDeInterfaces().getInterfaces();
//                    for (RedeInterface redeInterface : redes) {
//                        System.out.println(redeInterface);
//                    }
//                }
                            }
                            case 5 -> {
                                System.out.println("Saindo...");
                                System.exit(0);

                            }
                            default -> System.out.println("Opção inválida");
                        }
                    } while (opcao != 5);
//        
                }

            }
