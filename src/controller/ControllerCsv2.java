package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;
import model.ModelCsv2;
import view.ViewCsv2;

public class ControllerCsv2 {

    ModelCsv2 modelo;
    ViewCsv2 view;
    private int contador = 0;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.jb_guardar) {
                abrirArchivo();
            } else if (e.getSource() == view.jb_primero) {
                primerArchivo();
            } else if (e.getSource() == view.jb_ultimo) {
                ultimoArchivo();
            } else if (e.getSource() == view.jb_anterior) {
                anteriorArchivo();
            } else if (e.getSource() == view.jb_siguiente) {
                siguienteArchivo();
            } else if (e.getSource() == view.jb_limpiar) {
                limpiar();
            }
        }
    };

    public ControllerCsv2(ModelCsv2 modelo, ViewCsv2 view) {
        this.modelo = modelo;
        this.view = view;
        InitComponets();
        this.view.jb_guardar.addActionListener(actionListener);
        this.view.jb_limpiar.addActionListener(actionListener);
        this.view.jb_primero.addActionListener(actionListener);
        this.view.jb_ultimo.addActionListener(actionListener);
        this.view.jb_anterior.addActionListener(actionListener);
        this.view.jb_siguiente.addActionListener(actionListener);
    }

    public void primerArchivo() {
        try {
            String row;
            StringBuilder contenido = new StringBuilder();
            try (FileReader file = new FileReader(modelo.getPath())) {
                BufferedReader bufferedReader = new BufferedReader(file);
                int i = 0;
                while ((row = bufferedReader.readLine()) != null) {
                    contenido.append(row);
                    contenido.append("\n");
                }
                modelo.primerRegistro(String.valueOf(contenido));

                view.jtf_nombre.setText(modelo.getNombre());
                view.jtf_correo.setText(modelo.getCorreo());
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.err.println("File" + ex.getMessage());
            }
        } catch (IOException ex) {
            System.err.println("Error  " + ex.getMessage());
        }
    }

    public void ultimoArchivo() {
        try {
            String row;
            StringBuilder contenido = new StringBuilder();
            try (FileReader file = new FileReader(modelo.getPath())) {
                BufferedReader bufferedReader = new BufferedReader(file);
                while ((row = bufferedReader.readLine()) != null) {
                    contenido.append(row);
                    contenido.append("\n");
                }
                modelo.ultimoRegistro(String.valueOf(contenido));

                view.jtf_nombre.setText(modelo.getNombre());
                view.jtf_correo.setText(modelo.getCorreo());
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.err.println("File" + ex.getMessage());
            }
        } catch (IOException ex) {
            System.err.println("Error  " + ex.getMessage());
        }
    }

    public void anteriorArchivo() {
        try {
            String row;
            StringBuilder contenido = new StringBuilder();
            try (FileReader file = new FileReader(modelo.getPath())) {
                BufferedReader bufferedReader = new BufferedReader(file);
                //int contador=0;
                while ((row = bufferedReader.readLine()) != null) {
                    contenido.append(row);
                    contenido.append("\n");
                }
                System.out.println(contador);

                contador += modelo.getContador() - 1;

                modelo.sigultRegistro(String.valueOf(contenido), contador);

                view.jtf_nombre.setText(modelo.getNombre());
                view.jtf_correo.setText(modelo.getCorreo());
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.err.println("File" + ex.getMessage());
            }
        } catch (IOException ex) {
            System.err.println("Error  " + ex.getMessage());
        }
    }

    public void siguienteArchivo() {
        try {
            String row;
            StringBuilder contenido = new StringBuilder();
            try (FileReader file = new FileReader(modelo.getPath())) {
                BufferedReader bufferedReader = new BufferedReader(file);

                while ((row = bufferedReader.readLine()) != null) {
                    contenido.append(row);
                    contenido.append("\n");
                }
                System.out.println(contador);
                contador += modelo.getContador() + 1;
                modelo.sigultRegistro(String.valueOf(contenido), contador);
                view.jtf_nombre.setText(modelo.getNombre());
                view.jtf_correo.setText(modelo.getCorreo());
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.err.println("File" + ex.getMessage());
            }
        } catch (IOException ex) {
            System.err.println("Error  " + ex.getMessage());
        }
    }

    public void abrirArchivo() {
        try {
            File file = new File(modelo.getPath());
            FileWriter fileWriter = new FileWriter(file, true);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(modelo.separarCadena(view.jtf_nombre.getText(), view.jtf_correo.getText()));
                JOptionPane.showMessageDialog(null, "Archivo Almacenado");
                printWriter.close();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File" + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error  " + ex.getMessage());
        }
    }

    public void limpiar() {
        view.jtf_nombre.setText("");
        view.jtf_correo.setText("");
    }

    public void InitComponets() {
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        primerArchivo();
    }
}
