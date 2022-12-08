import components.SpringUtilities;

import javax.swing.*;


public class JFraming {
            public static void createAndShowGUI() {
            //Create and populate the panel.
            JPanel p = new JPanel(new SpringLayout());
            JLabel l = new JLabel("Size (Recommend between 10 - 30): ", JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            p.add(textField);
            JButton button1 = new JButton("Beginner");
            JButton button2 = new JButton("Intermediate");
            JButton button3 = new JButton("Expert");
            p.add(new JLabel());
            p.add(button1);
            p.add(button2);
            p.add(button3);
            //Lay out the panel.

            //Create and set up the window.
            JFrame frame = new JFrame("Pre-Game Details");
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                SpringUtilities.makeCompactGrid(p,
                        2, 3, //rows, cols
                        7, 7,        //initX, initY
                        7, 7);       //xPad, yPad

                button1.addActionListener(e -> {

                    //Execute when button is pressed
                    try {
                        if (Integer.parseInt(textField.getText()) > 0) {
                            Main.size = Integer.parseInt(textField.getText());
                            Main.diff = 0;
                        }
                        else {
                            throw new IllegalArgumentException();
                        }
                        frame.dispose();
                    } catch (Exception exception){
                        System.out.println("Please provide valid inputs");
                    }
                });
                button2.addActionListener(e -> {

                    //Execute when button is pressed
                    try {
                        if (Integer.parseInt(textField.getText()) > 0) {
                            Main.size = Integer.parseInt(textField.getText());
                            Main.diff = 1;
                        }
                        else {
                            throw new IllegalArgumentException();
                        }
                        frame.dispose();
                    } catch (Exception exception){
                        System.out.println("Please provide valid inputs");
                    }
                });
                button3.addActionListener(e -> {

                    //Execute when button is pressed
                    try {
                        if (Integer.parseInt(textField.getText()) > 0) {
                            Main.size = Integer.parseInt(textField.getText());
                            Main.diff = 2;
                        }
                        else {
                            throw new IllegalArgumentException();
                        }
                        frame.dispose();
                    } catch (Exception exception){
                        System.out.println("Please provide valid inputs");
                    }
                });

            //Set up the content pane.
            p.setOpaque(true);  //content panes must be opaque
            frame.setContentPane(p);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        }


}
