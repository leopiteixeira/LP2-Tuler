package TP03;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JComboBox;

class Pessoa{

    private static int kp;
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa(){
        kp = 0;
        this.nome = " ";
        this.sexo = 'F';
        this.idade = -1;

    }

    public Pessoa(String nome, char sexo, int idade){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public static void setKp(int kp) {
        Pessoa.kp = kp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public static int getKp() {
        return kp;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

}

public class Ex02V2 {

    private Pessoa umaPessoa = new Pessoa();

    public Ex02V2() {

        

        JFrame frame = new JFrame();
        BorderLayout layout = new BorderLayout(10, 10);
        GridLayout conteudoSup = new GridLayout(4, 4, 10, 10);
        GridLayout conteudoInf = new GridLayout(1, 4, 10, 10);

        JPanel painel = new JPanel(layout);
        JPanel painelSuperior = new JPanel(conteudoSup);
        JPanel painelInferior = new JPanel(conteudoInf);

        painel.add(painelSuperior, BorderLayout.NORTH);
        painel.add(painelInferior, BorderLayout.SOUTH);
        frame.getContentPane().add(painel);

        String[] c1 = {"f", "m"};

        TextField numero = new TextField(null);
        TextField nome = new TextField(null);
        JComboBox<String> sexo = new JComboBox<String>(c1);
        TextField idade = new TextField(null);


        
        painelSuperior.add(new JLabel("Numero:"));
        painelSuperior.add(numero);
        painelSuperior.add(new JLabel("Nome:"));
        painelSuperior.add(nome);
        painelSuperior.add(new JLabel("Sexo:"));
        painelSuperior.add(sexo);
        painelSuperior.add(new JLabel("Idade:"));
        painelSuperior.add(idade);

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
                numero.setText(null);
                idade.setText(null);
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(nome.getText().isEmpty() || idade.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Componentes obrigatorios faltando!!");
                }
                else if(sexo.getSelectedItem() != "f" && sexo.getSelectedItem() != "m"){
                    JOptionPane.showMessageDialog(frame, "Valor colocado como sexo diferente de 'm' e 'f'");
                } 
                else if(sexo.getSelectedItem().toString().length() > 1){
                    JOptionPane.showMessageDialog(frame, "Valor colocado como sexo diferente de 'm' e 'f'");
                }
                else{
                    umaPessoa = new Pessoa(nome.getText(), sexo.getSelectedItem().toString().toCharArray()[0], Integer.parseInt(idade.getText()));
                    nome.setText(null);
                    idade.setText(null);
                    numero.setText(null);
                }
                
            }
        });

        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, String.format("Nome: %s\nIdade: %d\nSexo: %s\nKp: %d", umaPessoa.getNome(), umaPessoa.getIdade(), umaPessoa.getSexo(), Pessoa.getKp()));
            }
        });

        painelInferior.add(ok);
        painelInferior.add(limpar);
        painelInferior.add(mostrar);
        painelInferior.add(sair);

        frame.setTitle("TP02");
        frame.setSize(400, 200);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        Ex02V2 app = new Ex02V2();
    }
}
