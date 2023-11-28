package TP05;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Gabriel Coutinho dos Santos e Leonardo Pinto Teixeira

class App{

    public App() {

        JFrame frame = new JFrame();
        BorderLayout layout = new BorderLayout(10, 10);
        BorderLayout conteudoSup = new BorderLayout(10, 10);
        GridLayout supEsq = new GridLayout(3, 2, 10, 10);
        GridLayout conteudoCentro = new GridLayout(2, 2, 10, 10);


        JPanel painel = new JPanel(layout);
        JPanel painelSuperior = new JPanel(conteudoSup);
        JPanel painelSupEsq = new JPanel(supEsq);
        JPanel painelCentro = new JPanel(conteudoCentro);

        JTextField maximo = new JTextField();
        JTextField prio1 = new JTextField();
        JTextField prio2 = new JTextField();

        painelSupEsq.add(new JLabel("Máximo:"));
        painelSupEsq.add(maximo);
        painelSupEsq.add(new JLabel("Prioridade 1:"));
        painelSupEsq.add(prio1);
        painelSupEsq.add(new JLabel("Prioridade 2:"));
        painelSupEsq.add(prio2);

        JButton iniciar = new JButton("Iniciar");
        JButton limpar = new JButton("Limpar");

        painelSuperior.add(painelSupEsq, BorderLayout.WEST);
        painelSuperior.add(iniciar, BorderLayout.SOUTH);


        painel.add(painelSuperior, BorderLayout.NORTH);
        painel.add(painelCentro, BorderLayout.CENTER);
        painel.add(limpar, BorderLayout.SOUTH);
        frame.getContentPane().add(painel);

        TextArea fim1 = new TextArea();
        TextArea fim2 = new TextArea();
        JLabel final1 = new JLabel("Final");
        JLabel final2 = new JLabel("Final");
        Ex01 runnable1 = new Ex01("Thread 1", fim1, final1);
        Ex01 runnable2 = new Ex01("Thread 2", fim2, final2);
        final1.setVisible(false);
        final2.setVisible(false);

        painelCentro.add(fim1);
        painelCentro.add(fim2);
        painelCentro.add(final1);
        painelCentro.add(final2);

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                final1.setVisible(false);
                final2.setVisible(false);

                runnable1.setMax(Integer.parseInt(maximo.getText()));
                runnable2.setMax(Integer.parseInt(maximo.getText()));

                Thread t1 = new Thread(runnable1);
                Thread t2 = new Thread(runnable2);

                t1.setPriority(Integer.parseInt(prio1.getText()));
                t2.setPriority(Integer.parseInt(prio2.getText()));

                t1.start();
                t2.start();
            }
        });

        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                final1.setVisible(false);
                final2.setVisible(false);

                fim1.setText("");
                fim2.setText("");
                maximo.setText("");
                prio1.setText("");
                prio2.setText("");
            }
        });

        frame.setTitle("TP05");
        frame.setSize(400, 400);
        frame.setVisible(true);

    }
}

public class Ex01 implements Runnable{

    private String nome;
    private int max;
    private TextArea text;
    private JLabel label;

    public Ex01(String nome, TextArea text, JLabel label){
        this.nome = nome;
        this.text = text;
        this.label = label;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public void run(){

        String ret = "";

        for(int i = 0; i < max; i++){
            ret += i + "\n";
            text.setText(ret);          
        }
        label.setVisible(true);
    }

    public static void main(String[] args){
        App app = new App();
    }
}

