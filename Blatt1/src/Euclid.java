import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Calculates the greatest common divisor of two integers in two different ways.
 * 1. by subtraction and 2. by division (mod)
 *
 * @author Michael Mardaus
 *
 */
class Euclid {

    /**
     * The main function.
     *
     * @param args
     *            command line arguments
     */
    public static void main(final String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EuclidWindow eu = new EuclidWindow();
            }
        });
    }

    /**
     * The Window for my little Program.
     *
     * @author Michael Mardaus
     */
    public static class EuclidWindow extends JFrame {
        private static final long serialVersionUID = 1L;
        JTextField textfieldA;
        JTextField textfieldB;
        JTextField textfieldMod;
        JTextField textfieldMin;
        JTextField textfieldModSteps;
        JTextField textfieldMinSteps;
        JTextField textfieldModTime;
        JTextField textfieldMinTime;
        JButton modButton;
        JButton minButton;
        JButton bothButton;

        public static int modCounter = 0;
        public static int minCounter = 0;

        /**
         * Calculate the gcd of two ints by division.
         *
         * @param p
         *            first int
         * @param q
         *            second int
         * @return the gcd of p and q
         * @throws Exception
         *             if q or p is negative
         */
        public int modulo(final int p, final int q) throws Exception {
            modCounter++;
            System.out.println("\np = " + p + ", q = " + q);
            if (p < 0 || q < 0) {
                throw new Exception("numbers must be non-negative");
            }

            if (q == 0) {
                return p;
            } else if (p == 0) {
                return q;
            } else if (p > q) {
                return modulo(q, p % q);
            } else {
                return modulo(p, q % p);
            }
            // also works like this
            // if (q == 0) {
            // return p;
            // }
            // return modulo(q, p % q);
        }

        /**
         * Calculate the gcd of two ints by subtraction.
         *
         * @param p
         *            first int
         * @param q
         *            second int
         * @return the gcd of p and q
         * @throws Exception
         *             if q or p is negative
         */
        public int minus(final int p, final int q) throws Exception {
            minCounter++;
            System.out.println("\np = " + p + ", q = " + q);
            if (p < 0 || q < 0) {
                throw new Exception("numbers must be non-negative");
            }

            if (q == 0) {
                return p;
            } else if (p == 0) {
                return q;
            } else if (p == q) {
                return p;
            } else if (p > q) {
                return minus(p - q, q);
            } else {
                return minus(q - p, p);
            }
        }

        public EuclidWindow() {

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setLayout(new GridLayout(10, 2));
            setBounds(300, 300, 500, 400);

            JLabel aLabel = new JLabel("A =");
            getContentPane().add(aLabel);
            textfieldA = new JTextField();
            getContentPane().add(textfieldA);
            textfieldA.setText("832040");

            JLabel bLabel = new JLabel("B =");
            getContentPane().add(bLabel);

            textfieldB = new JTextField();
            getContentPane().add(textfieldB);
            textfieldB.setText("514229");

            modButton = new JButton("GCD mod");
            getContentPane().add(modButton);
            modButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        long modTime = System.nanoTime();
                        modCounter = 0;
                        textfieldMod.setText(Integer.toString(modulo(
                                Integer.parseInt(textfieldA.getText()),
                                Integer.parseInt(textfieldB.getText()))));
                        textfieldModSteps.setText(Integer.toString(modCounter));
                        textfieldModTime.setText(Long.toString(System
                                .nanoTime() - modTime));
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null,
                                "Input is not an Integer", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.err.println("Error: Input is not an Integer");
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter non-negative numbers", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.err.println("Please enter non-negative numbers");
                        e1.printStackTrace();
                    }
                }
            });

            minButton = new JButton("GCD min");
            getContentPane().add(minButton);
            minButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        long minTime = System.nanoTime();
                        minCounter = 0;
                        textfieldMin.setText(Integer.toString(minus(
                                Integer.parseInt(textfieldA.getText()),
                                Integer.parseInt(textfieldB.getText()))));
                        textfieldMinSteps.setText(Integer.toString(minCounter));
                        textfieldMinTime.setText(Long.toString(System
                                .nanoTime() - minTime));
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null,
                                "Input is not an Integer", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.err.println("Error: Input is not an Integer");
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter non-negative numbers", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.err.println("Please enter non-negative numbers");
                        e1.printStackTrace();
                    }
                }
            });

            bothButton = new JButton("GCD both");
            getContentPane().add(bothButton);
            bothButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        long modTime = System.nanoTime();
                        modCounter = 0;
                        textfieldMod.setText(Integer.toString(modulo(
                                Integer.parseInt(textfieldA.getText()),
                                Integer.parseInt(textfieldB.getText()))));
                        textfieldModSteps.setText(Integer.toString(modCounter));
                        textfieldModTime.setText(Long.toString(System
                                .nanoTime() - modTime));

                        long minTime = System.nanoTime();
                        minCounter = 0;
                        textfieldMin.setText(Integer.toString(minus(
                                Integer.parseInt(textfieldA.getText()),
                                Integer.parseInt(textfieldB.getText()))));
                        textfieldMinSteps.setText(Integer.toString(minCounter));
                        textfieldMinTime.setText(Long.toString(System
                                .nanoTime() - minTime));
                    } catch (NumberFormatException e2) {
                        JOptionPane.showMessageDialog(null,
                                "Input is not an Integer", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.err.println("Error: Input is not an Integer");
                        e2.printStackTrace();
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter non-negative numbers", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        System.err.println("Please enter non-negative numbers");
                        e2.printStackTrace();
                    }
                }
            });

            JLabel spacer = new JLabel("");
            getContentPane().add(spacer);

            JLabel modLabel = new JLabel("gcd with division");
            getContentPane().add(modLabel);
            JLabel minLabel = new JLabel("gcd with subtraction");
            getContentPane().add(minLabel);

            textfieldMod = new JTextField();
            textfieldMod.setEditable(false);
            getContentPane().add(textfieldMod);

            textfieldMin = new JTextField();
            textfieldMin.setEditable(false);
            getContentPane().add(textfieldMin);

            JLabel modStepsLabel = new JLabel("mod steps");
            getContentPane().add(modStepsLabel);
            JLabel minStepsLabel = new JLabel("min steps");
            getContentPane().add(minStepsLabel);

            textfieldModSteps = new JTextField();
            textfieldModSteps.setEditable(false);
            getContentPane().add(textfieldModSteps);

            textfieldMinSteps = new JTextField();
            textfieldMinSteps.setEditable(false);
            getContentPane().add(textfieldMinSteps);

            JLabel modTimeLabel = new JLabel("mod time");
            getContentPane().add(modTimeLabel);
            JLabel minTimeLabel = new JLabel("Min time");
            getContentPane().add(minTimeLabel);

            textfieldModTime = new JTextField();
            textfieldModTime.setEditable(false);
            getContentPane().add(textfieldModTime);

            textfieldMinTime = new JTextField();
            textfieldMinTime.setEditable(false);
            getContentPane().add(textfieldMinTime);

            // pack();
            setVisible(true);
        }
    }
}