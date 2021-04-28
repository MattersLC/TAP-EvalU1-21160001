package examen;

// Orlando Lucero Camacho
// 21160001

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class TAPEvalU121160001 extends JFrame implements ActionListener {

    // Primer panel
    private JLabel nombre;
    private JLabel apellidos;
    private JLabel sexo;
    private JTextField tApellidos;
    private JTextField tNombre;
    private JRadioButton hombre;
    private JRadioButton mujer;
    // Segundo panel
    private JLabel calle;
    private JLabel colonia;
    private JLabel numero;
    private JLabel ciudad;
    private JTextField tCalle;
    private JTextField tColonia;
    private JTextField tNumero;
    private JTextField tCiudad;
    private JLabel departamento;
    private JLabel puesto;
    private JLabel fechaIngreso;
    private JComboBox cbDepartamento;
    private JComboBox cbPuesto;
    private JSpinner fecha;
    // Tercer panel
    private JButton añadir;
    private JButton editar;
    private JButton buscar;
    private JButton eliminar;

    public TAPEvalU121160001() {
        super("Registro de personal");
        Container base = getContentPane();
        base.setLayout(new BorderLayout());

        base.add(panelRegistro(), BorderLayout.NORTH);
        base.add(panelesEnMedio(), BorderLayout.CENTER);
        base.add(panelBtn(), BorderLayout.SOUTH);

        base.setBackground(Color.WHITE);
        this.setVisible(true);
        this.setSize(650, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ImageIcon imagenPerfil() {
        String ruta = "/img/fotoPerfil.png";
        URL url = getClass().getResource(ruta);
        ImageIcon img = new ImageIcon(url);

        return img;
    }

    public JPanel panelRegistro() {
        JPanel registro = new JPanel();
        registro.setLayout(new BorderLayout());
        registro.setBackground(Color.WHITE);

        JLabel foto = new JLabel(imagenPerfil());
        apellidos = new JLabel("Apellidos:");
        tApellidos = new JTextField("", 20);
        nombre = new JLabel("Nombre:");
        tNombre = new JTextField("", 20);
        sexo = new JLabel("Sexo:");
        hombre = new JRadioButton("Hombre");
        mujer = new JRadioButton("Mujer");
        ButtonGroup sexo_opc = new ButtonGroup();
        sexo_opc.add(hombre);
        sexo_opc.add(mujer);
        hombre.setBackground(Color.WHITE);
        mujer.setBackground(Color.WHITE);
        hombre.setSelected(true);

        JPanel panelFoto = new JPanel();
        panelFoto.setLayout(new BorderLayout());
        panelFoto.setBackground(Color.WHITE);
        panelFoto.add(foto);

        JPanel ingresaDatos = new JPanel();
        ingresaDatos.setLayout(new GridLayout(4,1));
            JPanel pCerrar = new JPanel();
            pCerrar.setLayout(new BorderLayout());
            pCerrar.setBackground(Color.WHITE);
            JLabel cerrar = new JLabel("Cerrar sesión");
            pCerrar.add(cerrar, BorderLayout.EAST);
        ingresaDatos.add(pCerrar);
            JPanel pApellidos = new JPanel();
            pApellidos.setBackground(Color.WHITE);
            pApellidos.add(apellidos, BorderLayout.WEST);
            pApellidos.add(tApellidos, BorderLayout.CENTER);
        ingresaDatos.add(pApellidos);
            JPanel pNombre = new JPanel();
            pNombre.setBackground(Color.WHITE);
            pNombre.add(nombre, BorderLayout.WEST);
            pNombre.add(tNombre, BorderLayout.CENTER);
        ingresaDatos.add(pNombre);
            JPanel pSexo = new JPanel();
            pSexo.setBackground(Color.WHITE);
            pSexo.add(sexo);
            pSexo.add(hombre);
            pSexo.add(mujer);
        ingresaDatos.add(pSexo);

        registro.add(panelFoto, BorderLayout.WEST);
        registro.add(ingresaDatos, BorderLayout.CENTER);

        return registro;
    }

    public JPanel panelesEnMedio() {
        JPanel datosDirAds = new JPanel();
        datosDirAds.setLayout(new GridLayout(2,0));
        datosDirAds.add(panelDireccion(), BorderLayout.NORTH);
        datosDirAds.add(panelAdscripcion(), BorderLayout.SOUTH);
        return  datosDirAds;
    }

    public JPanel panelDireccion() {
        JPanel direccion = new JPanel();
        direccion.setBackground(Color.WHITE);

        calle = new JLabel("Calle: ");
        tCalle = new JTextField("", 20);
        numero = new JLabel("Número: ");
        tNumero = new JTextField("", 20);
        colonia = new JLabel("Colonia: ");
        tColonia = new JTextField("", 20);
        ciudad = new JLabel("Ciudad: ");
        tCiudad = new JTextField("", 20);

        JPanel datosDireccion = new JPanel();
        datosDireccion.setLayout(new BorderLayout());
            JPanel calleNumero = new JPanel();
            calleNumero.setLayout(new GridBagLayout());
            calleNumero.setBackground(Color.WHITE);
            calleNumero.add(calle);
            calleNumero.add(tCalle);
            calleNumero.add(new JLabel("         "));
            calleNumero.add(numero);
            calleNumero.add(tNumero);
        datosDireccion.add(calleNumero, BorderLayout.NORTH);
            JPanel vacio = new JPanel();
            vacio.setLayout(new BorderLayout());
            vacio.setBackground(Color.WHITE);
            vacio.add(new JLabel("   "));
        datosDireccion.add(vacio, BorderLayout.CENTER);
            JPanel coloniaCiudad = new JPanel();
            coloniaCiudad.setLayout(new GridBagLayout());
            coloniaCiudad.setBackground(Color.WHITE);
            coloniaCiudad.add(colonia);
            coloniaCiudad.add(tColonia);
            coloniaCiudad.add(new JLabel("         "));
            coloniaCiudad.add(ciudad);
            coloniaCiudad.add(tCiudad);
        datosDireccion.add(coloniaCiudad, BorderLayout.SOUTH);

        direccion.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Dirección"),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                )
        );

        direccion.add(datosDireccion);

        return direccion;
    }

    public JPanel panelAdscripcion() {
        JPanel adscripcion = new JPanel();
        adscripcion.setBackground(Color.WHITE);

        departamento = new JLabel("Departamento: ");
        puesto = new JLabel("Puesto: ");
        fechaIngreso = new JLabel(" Fecha de ingreso: ");
        cbDepartamento = new JComboBox();
            cbDepartamento.addItem("uno");
            cbDepartamento.addItem("dos");
            cbDepartamento.addItem("tres");
        cbPuesto = new JComboBox();
            cbPuesto.addItem("uno");
            cbPuesto.addItem("dos");
            cbPuesto.addItem("tres");
        SpinnerDateModel dma = new SpinnerDateModel();
        fecha = new JSpinner(dma);
        JSpinner.DateEditor fdma = new JSpinner.DateEditor(fecha, "dd/MM/yyyy");
        fecha.setEditor(fdma);

        JPanel datosAdscripcion = new JPanel();
        datosAdscripcion.setLayout(new BorderLayout());
            JPanel dptoFecha = new JPanel();
            dptoFecha.setLayout(new GridLayout(1,5));
            dptoFecha.setBackground(Color.WHITE);
            dptoFecha.add(departamento);
            dptoFecha.add(cbDepartamento);
            dptoFecha.add(new JLabel("     "));
            dptoFecha.add(fechaIngreso);
            dptoFecha.add(fecha);
        datosAdscripcion.add(dptoFecha, BorderLayout.NORTH);
            JPanel vacio = new JPanel();
            vacio.setLayout(new BorderLayout());
            vacio.setBackground(Color.WHITE);
            vacio.add(new JLabel("   "));
        datosAdscripcion.add(vacio, BorderLayout.CENTER);
            JPanel pPuesto = new JPanel();
            pPuesto.setLayout(new GridLayout(1,5));
            pPuesto.setBackground(Color.WHITE);
            pPuesto.add(puesto);
            pPuesto.add(cbPuesto);
            pPuesto.add(new JLabel("   "));
            pPuesto.add(new JLabel("   "));
            pPuesto.add(new JLabel("   "));
        datosAdscripcion.add(pPuesto, BorderLayout.SOUTH);

        adscripcion.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Adscripción"),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                )
        );

        adscripcion.add(datosAdscripcion);

        return adscripcion;
    }

    public JPanel panelBtn() {
        JPanel pBotones = new JPanel();
        pBotones.setLayout(new BorderLayout());
        pBotones.setBackground(Color.WHITE);

        añadir = new JButton("Añadir");
        editar = new JButton("Editar");
        buscar = new JButton("Buscar");
        eliminar = new JButton("Eliminar");

        JPanel btns = new JPanel();
        btns.setLayout(new BorderLayout());
            JPanel vacio = new JPanel();
            vacio.setLayout(new BorderLayout());
            vacio.setBackground(Color.WHITE);
            vacio.add(new JLabel("   "));
        btns.add(vacio, BorderLayout.NORTH);
            JPanel btns2 = new JPanel();
            btns2.setLayout(new GridBagLayout());
            btns2.setBackground(Color.WHITE);
            btns2.add(añadir);
            btns2.add(editar);
            btns2.add(buscar);
            btns2.add(eliminar);
        btns.add(btns2, BorderLayout.CENTER);
            JPanel vacio2 = new JPanel();
            vacio2.setLayout(new BorderLayout());
            vacio2.setBackground(Color.WHITE);
            vacio2.add(new JLabel("   "));
        btns.add(vacio2, BorderLayout.SOUTH);

        añadir.setActionCommand("Añadir");
        añadir.addActionListener(this);
        editar.setActionCommand("Editar");
        editar.addActionListener(this);
        buscar.setActionCommand("Buscar");
        buscar.addActionListener(this);
        eliminar.setActionCommand("Eliminar");
        eliminar.addActionListener(this);

        pBotones.add(btns, BorderLayout.EAST);

        return pBotones;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Añadir":
                JOptionPane.showMessageDialog(null, "Botón 'añadir' presionado");
                break;
            case "Editar":
                JOptionPane.showMessageDialog(null, "Botón 'editar' presionado");
                break;
            case "Buscar":
                JOptionPane.showMessageDialog(null, "Botón 'buscar' presionado");
                break;
            case "Eliminar":
                JOptionPane.showMessageDialog(null, "Botón 'eliminar' presionado");
                break;
        }
    }

    public static void main(String[] args) {
        new TAPEvalU121160001();
    }
}
