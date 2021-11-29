package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectaticas;
    private JPanel panelBotones, panelDatos;
    private Titulos titulo;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Escucha escucha;
    private Escucha2 escucha2;
    private Escucha3 escucha3;

    //metodos
    public GUI_Presentacion(){
        initGUI();

        //configuracion base de la ventana
        this.setTitle("Mi Presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir continer y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();
        escucha2 = new Escucha2();
        escucha3 = new Escucha3();
        //Configurar JComponents
        titulo = new Titulos("Hola soy Luisa, oprime los botones...", Color.BLACK);
        this.add(titulo,BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"un poco mas de mi...",
                             TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                             new Font("Calibri",Font.BOLD,20), Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        miFoto = new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Este es mi hobby");
        miHobby.addActionListener(escucha);
        misExpectaticas = new JButton("Creo que...");
        misExpectaticas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectaticas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(10,12);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha implements ActionListener {
        private ImageIcon image;

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null,"Oprimiste boton");
            panelDatos.removeAll();
            if(e.getSource()==miFoto){
                image = new ImageIcon(getClass().getResource("/recursos/lu.jpg"));
                Icon icono = new ImageIcon(image.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
                labelImagen.setIcon(image);
                labelImagen.setIcon(icono);
                panelDatos.add(labelImagen);
            }else{
                if(e.getSource()==miHobby){
                    image = new ImageIcon(getClass().getResource("/recursos/valorant.png"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }else{
                    textoExpectativas.setText("No se de Java y casi no se programar.\n" +
                                              "Quiero aprender a tener una buena logica de programacion.");
                    textoExpectativas.setFont(new Font("Calibri",Font.PLAIN,20));
                    textoExpectativas.setBackground(null);
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }
    }

    private class Escucha2 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }
    }

    private class Escucha3 implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}