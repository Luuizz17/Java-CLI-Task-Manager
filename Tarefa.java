    import java.util.ArrayList;
    import java.util.Scanner;
    public class Tarefa {

        String nomeTarefa;
        String descricao;
        boolean concluida = false;


        void nomeTarefa(Scanner sc) {
            System.out.println("Qual o nome da sua Tarefa ? ");
            nomeTarefa = sc.nextLine();
        }

        void detalhes(Scanner sc) {
            System.out.println("Descreva sua Tarefa : ");
            descricao = sc.nextLine();
        }

        void terminado(Scanner sc) {
            System.out.println("Sua tarefa está concluida ? (Sim = true ; Não = false)");
            concluida = sc.nextBoolean();
            sc.nextLine();
        }

        void suaTarefa() {
            System.out.println("Nome da tarefa : " + nomeTarefa);
            System.out.println("Descrição da tarefa : " + descricao);

            if (!concluida) {
                System.out.println("Sua tarefa não foi concluida");
            } else {
                System.out.println("Sua tarefa foi concluida");
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int opcao = 0;
            ArrayList<Tarefa> tarefas = new ArrayList<>();
            while (opcao != 3) {
                System.out.println("\n------ MENU ------");
                System.out.println("1 - Criar tarefa");
                System.out.println("2 - Listar tarefas");
                System.out.println("3 - Sair");

                opcao = sc.nextInt();
                sc.nextLine();

                System.out.println("Quer criar uma tarefa? (1-Sim ; 2-Não");
                int criar = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {

                    Tarefa tarefa = new Tarefa();

                    tarefa.nomeTarefa(sc);
                    tarefa.detalhes(sc);
                    tarefa.terminado(sc);

                    tarefas.add(tarefa);

                } else if (opcao == 2) {

                    System.out.println("\n------ LISTA DE TAREFAS ------");

                    for (int i = 0; i < tarefas.size(); i++) {

                        System.out.println("\nTarefa " + (i + 1));

                        Tarefa t = tarefas.get(i);
                        t.suaTarefa();
                    }

                    System.out.println("Quer criar outra tarefa ? ");
                    opcao = sc.nextInt();
                    sc.nextLine();
                }

                sc.close();
            }

        }
    }
