package TP02;
import java.util.UUID;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

//Gabriel Coutinho dos Santos e Leonardo Pinto Teixeira

class Aluno {
    private String nome;
    private String endereco;
    private int idade;
    private UUID uuid;

    public Aluno(String nome, int idade, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.uuid = UUID.randomUUID();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public UUID getUuid() {
        return uuid;
    }

}

public class Ex01{

    public Ex01() {

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        JFrame frame = new JFrame();
        BorderLayout layout = new BorderLayout(10, 10);
        GridLayout conteudoSup = new GridLayout(3, 2, 10, 10);
        GridLayout conteudoInf = new GridLayout(1, 4, 10, 10);

        JPanel painel = new JPanel(layout);
        JPanel painelSuperior = new JPanel(conteudoSup);
        JPanel painelInferior = new JPanel(conteudoInf);

        painel.add(painelSuperior, BorderLayout.NORTH);
        painel.add(painelInferior, BorderLayout.SOUTH);
        frame.getContentPane().add(painel);

        TextField nome = new TextField();
        TextField idade = new TextField();
        TextField endereco = new TextField();

        painelSuperior.add(new JLabel("Nome:"));
        painelSuperior.add(nome);
        painelSuperior.add(new JLabel("Idade:"));
        painelSuperior.add(idade);
        painelSuperior.add(new JLabel("Endereco:"));
        painelSuperior.add(endereco);

        JButton ok = new JButton("Ok");
        JButton limpar = new JButton("Limpar");
        JButton mostrar = new JButton("Mostrar");
        JButton sair = new JButton("Sair");

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                nome.setText(null);
                idade.setText(null);
                endereco.setText(null);
            }
        });

        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String mensagem = "";
                for(Aluno aluno : alunos){
                    mensagem += "Id: " + aluno.getUuid() + " Nome: " + aluno.getNome() + "\n";
                }
                JOptionPane.showMessageDialog(frame, mensagem);
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Aluno a1 = new Aluno(nome.getText(), Integer.parseInt(idade.getText()), endereco.getText());
                alunos.add(a1);
                nome.setText(null);
                idade.setText(null);
                endereco.setText(null);
            }
        });

        painelInferior.add(ok);
        painelInferior.add(limpar);
        painelInferior.add(mostrar);
        painelInferior.add(sair);

        frame.setTitle("TP02");
        frame.setSize(400, 180);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        Ex01 app = new Ex01();
    }
}