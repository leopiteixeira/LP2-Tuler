package TPFinal.TPFinal.src;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

class Aluno {

    private String nome;
    private int idade;
    private float peso;
    private float altura;
    private String objetivo;

    public float getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public float getPeso() {
        return peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }


}

public class App {

    public App(){
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        JFrame frame = new JFrame();
        BorderLayout layout = new BorderLayout(10, 10);
        GridLayout conteudoSup = new GridLayout(5, 2, 10, 10);
        GridLayout conteudoInf = new GridLayout(1, 4, 10, 10);

        JPanel painel = new JPanel(layout);
        JPanel painelSuperior = new JPanel(conteudoSup);
        JPanel painelInferior = new JPanel(conteudoInf);

        painel.add(painelSuperior, BorderLayout.NORTH);
        painel.add(painelInferior, BorderLayout.SOUTH);
        frame.getContentPane().add(painel);

        TextField nome = new TextField();
        TextField idade = new TextField();
        TextField peso = new TextField();
        TextField altura = new TextField();
        TextField obj = new TextField();

        painelSuperior.add(new JLabel("Nome:"));
        painelSuperior.add(nome);
        painelSuperior.add(new JLabel("Idade:"));
        painelSuperior.add(idade);
        painelSuperior.add(new JLabel("Peso:"));
        painelSuperior.add(peso);
        painelSuperior.add(new JLabel("Altura:"));
        painelSuperior.add(altura);
        painelSuperior.add(new JLabel("Objetivo:"));
        painelSuperior.add(obj);


        JButton incluir = new JButton("Incluir");
        JButton limpar = new JButton("Limpar");
        JButton apresenta = new JButton("Mostrar");
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
                peso.setText(null);
                altura.setText(null);
                obj.setText(null);
            }
        });

        incluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                Connection conn = new Conexao().conectaDB();
                PreparedStatement pstm;


                Aluno a1 = new Aluno();
                a1.setNome(nome.getText());
                a1.setIdade(Integer.parseInt(idade.getText()));
                a1.setPeso(Float.parseFloat(peso.getText()));
                a1.setAltura(Float.parseFloat(altura.getText()));
                a1.setObjetivo(obj.getText());

                String sql = "insert into alunos (nome, idade, peso, altura, objetivo) values (?, ?, ?, ?, ?)";

                try {
                    pstm = conn.prepareStatement(sql);

                    pstm.setString(1, a1.getNome());
                    pstm.setInt(2, a1.getIdade());
                    pstm.setFloat(3, a1.getPeso());
                    pstm.setFloat(4, a1.getAltura());
                    pstm.setString(5, a1.getObjetivo());

                    pstm.execute();
                    pstm.close();
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Incluir: " + erro.getMessage());
                }

                
                nome.setText(null);
                idade.setText(null);
                peso.setText(null);
                altura.setText(null);
                obj.setText(null);
            }
        });

        apresenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Connection conn = new Conexao().conectaDB();
                PreparedStatement pstm;
                ResultSet rs;
                String result = "";

                String sql = "select * from alunos";

                try {
                    pstm = conn.prepareStatement(sql);
                    rs = pstm.executeQuery();

                    while(rs.next()){
                        result += String.format("Nome: %s, Idade: %d, Peso: %.2f, Altura: %.2f, Objetivo: %s\n\n",
                                                rs.getString("nome"),
                                                rs.getInt("idade"),
                                                rs.getFloat("peso"),
                                                rs.getFloat("altura"),
                                                rs.getString("objetivo"));
                    }
                    JOptionPane.showMessageDialog(null, result);
                    pstm.close();
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Incluir: " + erro.getMessage());
                }
            }
        });

        painelInferior.add(incluir);
        painelInferior.add(limpar);
        painelInferior.add(apresenta);
        painelInferior.add(sair);

        
        frame.setTitle("TP02");
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App();
    }

}
