package TP03;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex01 {
    private boolean reset = true;
    private boolean pontuado = false;
    private double mem;
    private char op;

    public Ex01() {
        
        JFrame frame = new JFrame();
        BorderLayout layout = new BorderLayout(10, 10);
        FlowLayout telaSup = new FlowLayout(FlowLayout.RIGHT);
        FlowLayout tecladoInf = new FlowLayout(FlowLayout.LEFT);

        JPanel painel = new JPanel(layout);
        JPanel painelSuperior = new JPanel(telaSup);
        JPanel painelInferior = new JPanel(tecladoInf);

        painel.add(painelSuperior, BorderLayout.NORTH);
        painel.add(painelInferior, BorderLayout.CENTER);
        frame.getContentPane().add(painel);

        JLabel tela = new JLabel("0");

        painelSuperior.add(tela);

        JButton botao1 = new JButton("1");
        JButton botao2 = new JButton("2");
        JButton botao3 = new JButton("3");
        JButton botao4 = new JButton("4");
        JButton botao5 = new JButton("5");
        JButton botao6 = new JButton("6");
        JButton botao7 = new JButton("7");
        JButton botao8 = new JButton("8");
        JButton botao9 = new JButton("9");
        JButton botao0 = new JButton("0");
        JButton botaoDiv = new JButton("/");
        JButton botaoMul = new JButton("*");
        JButton botaoSoma = new JButton("+");
        JButton botaoSub = new JButton("-");
        JButton botaoResul = new JButton("=");
        JButton botaoPonto = new JButton(".");
        JButton botaoc = new JButton("C");

        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("1");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "1");
                }
            }
        });

        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("2");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "2");
                }
            }
        });

        botao3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("3");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "3");
                }
            }
        });

        botao4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("4");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "4");
                }
            }
        });

        botao5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("5");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "5");
                }
            }
        });

        botao6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("6");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "6");
                }
            }
        });

        botao7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("7");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "7");
                }
            }
        });

        botao8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("8");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "8");
                }
            }
        });

        botao9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("9");
                    reset = false;
                }else{
                    tela.setText(tela.getText() + "9");
                }
            }
        });

        botao0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("0");
                }else{
                    tela.setText(tela.getText() + "0");
                }
            }
        });

        botaoPonto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(reset){
                    tela.setText("0.");
                    reset = false;
                    pontuado = true;
                }else if(!pontuado){
                    tela.setText(tela.getText() + ".");
                    pontuado = true;
                }
            }
        });

        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tela.setText("0");
                reset = true;
                pontuado = false;
                mem = 0;
            }
        });

        botaoDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                reset = true;
                pontuado = false;
                mem = Double.parseDouble(tela.getText());
                op = 'd';
            }
        });

        botaoMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                reset = true;
                pontuado = false;
                mem = Double.parseDouble(tela.getText());
                op = 'm';
            }
        });

        botaoSoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                reset = true;
                pontuado = false;
                mem = Double.parseDouble(tela.getText());
                op = 'a';
            }
        });

        botaoSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                reset = true;
                pontuado = false;
                mem = Double.parseDouble(tela.getText());
                op = 's';
            }
        });

        botaoResul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                reset = true;
                pontuado = false;
                switch(op){
                    case 'a':
                        mem = mem + Double.parseDouble(tela.getText());
                        tela.setText(String.valueOf(mem));
                        break;
                    
                    case 's':
                        mem = mem - Double.parseDouble(tela.getText());
                        tela.setText(String.valueOf(mem));
                        break;
                    
                    case 'd':
                        mem = mem / Double.parseDouble(tela.getText());
                        tela.setText(String.valueOf(mem));
                        break;

                    case 'm':
                        mem = mem * Double.parseDouble(tela.getText());
                        tela.setText(String.valueOf(mem));
                        break;
                }
            }
        });

        painelInferior.add(botao7);
        painelInferior.add(botao8);
        painelInferior.add(botao9);
        painelInferior.add(botaoDiv);
        painelInferior.add(botao4);
        painelInferior.add(botao5);
        painelInferior.add(botao6);
        painelInferior.add(botaoMul);
        painelInferior.add(botao1);
        painelInferior.add(botao2);
        painelInferior.add(botao3);
        painelInferior.add(botaoSub);
        painelInferior.add(botao0);
        painelInferior.add(botaoPonto);
        painelInferior.add(botaoResul);
        painelInferior.add(botaoSoma);
        painelInferior.add(botaoc);

        frame.setTitle("TP03");
        frame.setSize(200, 230);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Ex01 app = new Ex01();
    }
}
