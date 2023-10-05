import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JFrame {
    private JPanel panel;
    private JTextField t1;
    private JComboBox comboBox2;
    private JComboBox comboBox1;
    private JButton convertButton;
    private JLabel resultLbl;

    private double input;


    public void initComponents(){
        panel = new JPanel();
        panel.setLayout(null);

        t1.setBounds(10,10,410,40);
        panel.add(t1);

        DefaultComboBoxModel<String> comboBox1Model = new DefaultComboBoxModel<>();
        comboBox1Model.addElement("m");
        comboBox1Model.addElement("cm");
        comboBox1Model.addElement("km");

        comboBox1 = new JComboBox<>(comboBox1Model);
        comboBox1.setBounds(10, 60, 200, 40);
        panel.add(comboBox1);

        DefaultComboBoxModel<String> comboBox2Model = new DefaultComboBoxModel<>();
        comboBox2Model.addElement("m");
        comboBox2Model.addElement("cm");
        comboBox2Model.addElement("km");

        comboBox2 = new JComboBox<>(comboBox2Model);
        comboBox2.setBounds(220, 60, 200, 40);
        panel.add(comboBox2);

        convertButton.setBounds(15,120, 400,40);
        panel.add(convertButton);

        resultLbl.setBounds(30, 180, 300, 40);
        panel.add(resultLbl);

//        t1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                input = Double.parseDouble(t1.getText());
//            }
//        });

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = Double.parseDouble(t1.getText());
                String fromUnit = comboBox1Model.getSelectedItem().toString();
                String toUnit = comboBox2Model.getSelectedItem().toString();
                resultLbl.setText("Result is "+ (input*1000));
                if (fromUnit.equals("m")){
                    switch (toUnit) {
                        case "m" -> resultLbl.setText("Result is " + input+"m");
                        case "cm" -> resultLbl.setText("Result is " + (input * 100) +"cm");
                        case "km" -> resultLbl.setText("Result is " + (input * 1000)+"km");
                        default -> {
                        }
                    }
                    ;
                }
                else if (fromUnit.equals("cm")){
                    switch (toUnit) {
                        case "m" -> resultLbl.setText("Result is " + (input/100)+"m");
                        case "cm" -> resultLbl.setText("Result is " + (input)+"cm");
                        case "km" -> resultLbl.setText("Result is " + (input/100000)+"km");
                        default -> {
                        }
                    }
                    ;
                }
                else {
                    switch (toUnit) {
                        case "m" -> resultLbl.setText("Result is " + (input*1000)+"m");
                        case "cm" -> resultLbl.setText("Result is " + (input*100000)+"cm");
                        case "km" -> resultLbl.setText("Result is " + (input)+"km");
                        default -> {
                        }
                    }
                    ;
                }

            }
        });


    }
    public UnitConverter(){
        //frame = new JFrame("Unit Convertor");
        initComponents();
        setContentPane(panel);
        setSize(450,300);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        UnitConverter uc1 = new UnitConverter();
    }

}


