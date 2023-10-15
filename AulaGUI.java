import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AulaGUI {
    private ABB arbolAulas = new ABB();

    public AulaGUI() {
        JFrame frame = new JFrame("Gestión de Aulas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JButton btnAsignar = new JButton("Asignar Aula");
        JButton btnCrear = new JButton("Crear Aula");

        btnAsignar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                asignarAula();
            }
        });

        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearAula();
            }
        });

        frame.add(btnAsignar);
        frame.add(btnCrear);
        frame.setVisible(true);
    }
    public void asignarAula() {
        JFrame frame = new JFrame("Asignar Aula");
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblCapacidad = new JLabel("Capacidad de estudiantes:");
        JTextField txtCapacidad = new JTextField(10);

        JCheckBox chkPc = new JCheckBox("Requiere PC");
        JCheckBox chkProyector = new JCheckBox("Requiere Proyector");
        JCheckBox chkPizarron = new JCheckBox("Requiere Pizarrón");

        JButton btnBuscar = new JButton("Buscar Aula");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int capacidad = Integer.parseInt(txtCapacidad.getText());
                int pc = chkPc.isSelected() ? 1 : 0;
                int proyector = chkProyector.isSelected() ? 1 : 0;
                int pizarron = chkPizarron.isSelected() ? 1 : 0;
                String aulaAsignada = arbolAulas.assignAula(capacidad, pc, proyector, pizarron);
                if (aulaAsignada != null) {
                    JOptionPane.showMessageDialog(frame, "Aula asignada: " + aulaAsignada);
                } else {
                    JOptionPane.showMessageDialog(frame, "No se encontró aula con los requisitos especificados.");
                }
                frame.dispose();
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblCapacidad);
        panel.add(txtCapacidad);
        panel.add(chkPc);
        panel.add(chkProyector);
        panel.add(chkPizarron);
        panel.add(btnBuscar);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void crearAula() {
        JFrame frame = new JFrame("Crear Aula");
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblCapacidad = new JLabel("Capacidad:");
        JTextField txtCapacidad = new JTextField(10);

        JLabel lblDescripcion = new JLabel("Detalles:");
        JTextField txtDescripcion = new JTextField(20);

        JLabel lblEdificio = new JLabel("Edificio:");
        JTextField txtEdificio = new JTextField(10);

        JLabel lblSalon = new JLabel("Número de Aula:");
        JTextField txtSalon = new JTextField(10);

        JCheckBox chkPc = new JCheckBox("Tiene PC");
        JCheckBox chkProyector = new JCheckBox("Tiene Proyector");
        JCheckBox chkPizarron = new JCheckBox("Tiene Pizarrón");

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int capacidad = Integer.parseInt(txtCapacidad.getText());
                String descripcion = txtDescripcion.getText();
                String edificio = txtEdificio.getText();
                int salon = Integer.parseInt(txtSalon.getText());
                int pc = chkPc.isSelected() ? 1 : 0;
                int proyector = chkProyector.isSelected() ? 1 : 0;
                int pizarron = chkPizarron.isSelected() ? 1 : 0;
                arbolAulas.insert(capacidad, edificio, salon, descripcion, pc, proyector, pizarron);
                JOptionPane.showMessageDialog(frame, "Aula creada con éxito!");
                frame.dispose();
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblCapacidad);
        panel.add(txtCapacidad);
        panel.add(lblDescripcion);
        panel.add(txtDescripcion);
        panel.add(lblEdificio);
        panel.add(txtEdificio);
        panel.add(lblSalon);
        panel.add(txtSalon);
        panel.add(chkPc);
        panel.add(chkProyector);
        panel.add(chkPizarron);
        panel.add(btnGuardar);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AulaGUI());
    }
}
