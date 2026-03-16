   import java.util.ArrayList;
import java.util.Scanner;

public class Tarefa {

    String nomeTarefa;
    String descricao;
    boolean concluida = false;

    void nomeTarefa(Scanner sc) {
        System.out.println("Qual o nome da sua Tarefa?");
        nomeTarefa = sc.nextLine();
    }

    void detalhes(Scanner sc) {
        System.out.println("Descreva sua Tarefa:");
        descricao = sc.nextLine();
    }

    void terminado(Scanner sc){
        System.out.println("Sua tarefa está concluida? (Sim/Não)");
        String resp = sc.nextLine();
        concluida = resp.equalsIgnoreCase("sim");
    }

    void suaTarefa() {
        System.out.println("Nome da tarefa: " + nomeTarefa);
        System.out.println("Descrição da tarefa: " + descricao);
        System.out.println("Status: " + (concluida ? "Concluida" : "Não concluida"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n------ MENU ------");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

         
            String input = sc.nextLine();
            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite 1, 2 ou 3.");
                continue; 
            }

            switch (opcao) {
                case 1:
                    Tarefa tarefa = new Tarefa();
                    tarefa.nomeTarefa(sc);
                    tarefa.detalhes(sc);
                    tarefa.terminado(sc);
                    tarefas.add(tarefa);
                    System.out.println("Tarefa criada com sucesso!");
                    break;

                case 2:
                    System.out.println("\n------ LISTA DE TAREFAS ------");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println("\nTarefa " + (i + 1));
                            tarefas.get(i).suaTarefa();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Digite 1, 2 ou 3.");
            }
        }

        sc.close();
    }
}
