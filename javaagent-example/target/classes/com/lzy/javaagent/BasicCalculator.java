package com.lzy.javaagent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//implementing ActionListener interface
public class BasicCalculator implements ActionListener {
    //Creating variables for our calculations
    double number, answer;
    int BitwiseNumber;
    int BitwiseResult;
    int calculation;

    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();

    JRadioButton Binary = new JRadioButton("Binary");
    JRadioButton HexaDecimal = new JRadioButton("Hexadecimal");
    JRadioButton Decimal = new JRadioButton("Decimal");

    JButton buttonZero = new JButton("0");

    JButton buttonOne = new JButton("1");
    JButton buttonTwo = new JButton("2");
    JButton buttonThree = new JButton("3");
    JButton buttonFour = new JButton("4");
    JButton buttonFive = new JButton("5");
    JButton buttonSix = new JButton("6");
    JButton buttonSeven = new JButton("7");
    JButton buttonEight = new JButton("8");
    JButton buttonNine = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("C");
    JButton buttonDelete = new JButton("DEL");
    JButton buttonEqual = new JButton("=");
    JButton buttonMul = new JButton("x");
    JButton buttonDiv = new JButton("/");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonSquare = new JButton("x²");
    JButton buttonReciprocal = new JButton("1/x");
    JButton buttonSqrt = new JButton("√");


    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");
    JButton buttonC = new JButton("C");
    JButton buttonD= new JButton("D");
    JButton buttonE = new JButton("E");
    JButton buttonF = new JButton("F");
    JButton buttonAnd = new JButton("&");
    JButton buttonOr = new JButton(" | ");
    JButton buttonXor = new JButton("^");
    JButton buttonNot = new JButton("~");
    JButton buttonShiftLeft = new JButton("<<");
    JButton buttonShiftRigth = new JButton(">>");

    BasicCalculator() {

        prepareGUI();
        addComponents();
        addActionEvent();
        enableBinary();
    }

    public void prepareGUI() {

        frame = new JFrame();
        frame.setTitle("Basic Calculator");
        frame.setSize(600, 560);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponents() {
        label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.white);
        frame.add(label);


        textField.setBounds(10, 40, 565,40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);



        Binary.setBounds(10, 95, 100, 20);
        Binary.setSelected(true);
        Binary.setFont(new Font("Arial", Font.BOLD, 14));
        Binary.setBackground(Color.GRAY);
        Binary.setForeground(Color.white);
        frame.add(Binary);

        HexaDecimal.setBounds(10, 120, 150, 20);
        HexaDecimal.setSelected(false);
        HexaDecimal.setFont(new Font("Arial", Font.BOLD, 14));
        HexaDecimal.setBackground(Color.GRAY);
        HexaDecimal.setForeground(Color.white);
        frame.add(HexaDecimal);

        Decimal.setBounds(10, 145, 100, 20);
        Decimal.setSelected(false);
        Decimal.setFont(new Font("Arial", Font.BOLD, 14));
        Decimal.setBackground(Color.GRAY);
        Decimal.setForeground(Color.white);
        frame.add(Decimal);


        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(Binary);
        buttonGroup.add(HexaDecimal);
        buttonGroup.add(Decimal);


        buttonAnd.setBounds(430, 180, 60, 40);
        buttonAnd.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonAnd);


        buttonOr.setBounds(430, 230, 60, 40);
        buttonOr.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonOr);

        buttonXor.setBounds(430, 280, 60, 40);
        buttonXor.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonXor);

        buttonNot.setBounds(500, 180, 60, 40);
        buttonNot.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonNot);

        buttonShiftLeft.setBounds(500, 230, 60, 40);
        buttonShiftLeft.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonShiftLeft);

        buttonShiftRigth.setBounds(500, 280, 60, 40);
        buttonShiftRigth.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonShiftRigth);

        buttonA.setBounds(290, 180, 60, 40);
        buttonA.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonA);

        buttonB.setBounds(290, 230, 60, 40);
        buttonB.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonB);

        buttonC.setBounds(290, 280, 60, 40);
        buttonC.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonC);

        buttonD.setBounds(360, 180, 60, 40);
        buttonD.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonD);

        buttonE.setBounds(360, 230, 60, 40);
        buttonE.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonE);

        buttonF.setBounds(360, 280, 60, 40);
        buttonF.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonF);



        buttonSeven.setBounds(10, 280, 60, 40);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSeven);

        buttonEight.setBounds(80, 280, 60, 40);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonEight);

        buttonNine.setBounds(150, 280, 60, 40);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonNine);

        buttonFour.setBounds(10, 330, 60, 40);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFour);

        buttonFive.setBounds(80, 330, 60, 40);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonFive);

        buttonSix.setBounds(150, 330, 60, 40);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSix);

        buttonOne.setBounds(10, 380, 60, 40);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonOne);


        buttonTwo.setBounds(80, 380, 60, 40);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonTwo);

        buttonThree.setBounds(150, 380, 60, 40);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonThree);

        buttonDot.setBounds(150, 430, 60, 40);
        buttonDot.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonDot);

        buttonZero.setBounds(10, 430, 130, 40);
        buttonZero.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonZero);

        buttonEqual.setBounds(220, 380, 60, 90);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEqual.setBackground(new Color(239, 188, 2));
        frame.add(buttonEqual);

        buttonDiv.setBounds(220, 180, 60, 40);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDiv.setBackground(new Color(239, 188, 2));
        frame.add(buttonDiv);

        buttonSqrt.setBounds(10, 230, 60, 40);
        buttonSqrt.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(buttonSqrt);

        buttonMul.setBounds(220, 280, 60, 40);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMul.setBackground(new Color(239, 188, 2));
        frame.add(buttonMul);

        buttonMinus.setBounds(220, 230, 60, 40);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMinus.setBackground(new Color(239, 188, 2));
        frame.add(buttonMinus);

        buttonPlus.setBounds(220, 330, 60, 40);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPlus.setBackground(new Color(239, 188, 2));
        frame.add(buttonPlus);

        buttonSquare.setBounds(80, 230, 60, 40);
        buttonSquare.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(buttonSquare);

        buttonReciprocal.setBounds(150, 230, 60, 40);
        buttonReciprocal.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(buttonReciprocal);

        buttonDelete.setBounds(150, 180, 60, 40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 12));
        buttonDelete.setBackground(Color.red);
        buttonDelete.setForeground(Color.white);
        frame.add(buttonDelete);

        buttonClear.setBounds(80, 180, 60, 40);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 12));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        frame.add(buttonClear);
        buttonA.setName("melih");

    }

    public void addActionEvent() {
        //Registering ActionListener to buttons
        Binary.addActionListener(this);
        HexaDecimal.addActionListener(this);
        Decimal.addActionListener(this);

        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonSqrt.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonZero.addActionListener(this);
        buttonDot.addActionListener(this);

        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        buttonD.addActionListener(this);
        buttonE.addActionListener(this);
        buttonE.addActionListener(this);
        buttonF.addActionListener(this);
        buttonAnd.addActionListener(this);
        buttonOr.addActionListener(this);
        buttonXor.addActionListener(this);
        buttonShiftLeft.addActionListener(this);
        buttonShiftRigth.addActionListener(this);


    }
    //Overriding actionPerformed() method
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==HexaDecimal) {
            enableHexadecimal();//Calling enable() function
        } else if (source==Decimal) {
            enableDecimal();//Calling disable function

        } else if(source==Binary) {
            enableBinary();

        } else if (source == buttonClear) {
            //Clearing texts of label and text field
            label.setText("");
            textField.setText("");
        } else if (source == buttonDelete) {
            //Setting functionality for delete button(backspace)
            int length = textField.getText().length();
            int number = length - 1;


            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());

            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }
        } else if (source == buttonZero) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == buttonOne) {
            textField.setText(textField.getText() + "1");
        } else if (source == buttonTwo) {
            textField.setText(textField.getText() + "2");
        } else if (source == buttonThree) {
            textField.setText(textField.getText() + "3");
        } else if (source == buttonFour) {
            textField.setText(textField.getText() + "4");
        } else if (source == buttonFive) {
            textField.setText(textField.getText() + "5");
        } else if (source == buttonSix) {
            textField.setText(textField.getText() + "6");
        } else if (source == buttonSeven) {
            textField.setText(textField.getText() + "7");
        } else if (source == buttonEight) {
            textField.setText(textField.getText() + "8");
        } else if (source == buttonNine) {
            textField.setText(textField.getText() + "9");
        }else if (source == buttonA) {
            textField.setText(textField.getText() + "A");
        }else if (source == buttonB) {
            textField.setText(textField.getText() + "B");
        }else if (source == buttonC) {
            textField.setText(textField.getText() + "C");
        }else if (source == buttonD) {
            textField.setText(textField.getText() + "D");
        }else if (source == buttonE) {
            textField.setText(textField.getText() + "E");
        }else if (source == buttonF) {
            textField.setText(textField.getText() + "F");
        }

        else if (source == buttonDot) {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }

        }
        else if (source == buttonPlus) {
            String str = textField.getText();

            if(Binary.isSelected()) {
                number = Integer.parseInt(textField.getText(),2);

            }
            else if (HexaDecimal.isSelected()) {
                number=Integer.parseInt(textField.getText(),16);
            }
            else {
                number = Double.parseDouble(textField.getText());
            }

            textField.setText("");
            label.setText(str + "+");
            calculation = 1;

        }
        else if (source == buttonMinus) {
            String str = textField.getText();

            if(Binary.isSelected()) {

                number = Integer.parseInt(textField.getText(),2);

            }
            else if (HexaDecimal.isSelected()) {
                number= Integer.parseInt(textField.getText(),16);
            }
            else {
                number = Double.parseDouble(textField.getText());
            }
            textField.setText("");
            label.setText(str + "-");
            calculation = 2;
        }
        else if (source == buttonMul) {
            String str = textField.getText();

            if(Binary.isSelected()) {
                number =  Integer.parseInt(textField.getText(),2);

            }
            else if (HexaDecimal.isSelected()) {
                number= Integer.parseInt(textField.getText(),16);
            }
            else {
                number = Double.parseDouble(textField.getText());
            }
            textField.setText("");
            label.setText(str + "X");
            calculation = 3;
        }
        else if (source == buttonDiv) {
            String str = textField.getText();

            if(Binary.isSelected()) {
                number = Integer.parseInt(textField.getText(),2);

            }
            else if (HexaDecimal.isSelected()) {
                number= Integer.parseInt(textField.getText(),16);
            }
            else {
                number = Double.parseDouble(textField.getText());
            }
            textField.setText("");
            label.setText(str + "/");
            calculation = 4;
        } else if(source==buttonAnd) {

            String str = textField.getText();

            BitwiseNumber = Integer.parseInt(textField.getText(),2);

            textField.setText("");
            label.setText(str + "&");
            calculation=5;
        } else if(source == buttonOr) {
            String str = textField.getText();

            BitwiseNumber= Integer.parseInt(textField.getText(),2);

            textField.setText("");
            label.setText(str + "|");
            calculation=6;

        } else if (source == buttonXor) {

            String str = textField.getText();

            BitwiseNumber= Integer.parseInt(textField.getText(),2);

            textField.setText("");
            label.setText(str + "^");
            calculation=7;
        } else if ( source == buttonNot) {
            String str = textField.getText();

            BitwiseNumber= Integer.parseInt(textField.getText(),2);

            textField.setText("");
            label.setText(str + "~");
            calculation=8;
        } else if ( source == buttonShiftLeft) {
            String str = textField.getText();

            BitwiseNumber= Integer.parseInt(textField.getText(),2);

            textField.setText("");
            label.setText(str + "<<");
            calculation=9;
        } else if (source == buttonShiftRigth) {
            String str = textField.getText();

            BitwiseNumber= Integer.parseInt(textField.getText(),2);

            textField.setText("");
            label.setText(str + ">>");
            calculation=10;
        }
        else if (source == buttonSqrt) {
            number = Double.parseDouble(textField.getText());
            double sqrt = Math.sqrt(number);
            textField.setText(Double.toString(sqrt));

        } else if (source == buttonSquare) {
            String str = textField.getText();
            number = Double.parseDouble(textField.getText());
            double square = Math.pow(number, 2);
            String string = Double.toString(square);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
            label.setText("(sqr)" + str);
        } else if (source == buttonReciprocal) {
            number = Double.parseDouble(textField.getText());
            double reciprocal = 1 / number;
            String string = Double.toString(reciprocal);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
        } else if (source == buttonEqual) {
            //Setting functionality for equal(=) button
            switch (calculation) {
                case 1:
                    if(Binary.isSelected()) {
                        answer=number + Integer.parseInt(textField.getText(),2);
                        textField.setText(Integer.toBinaryString((int)answer));
                    }
                    else if (HexaDecimal.isSelected()) {
                        answer = number + Integer.parseInt(textField.getText(),16);
                        textField.setText(Integer.toHexString((int)answer));
                    }
                    else {
                        answer = number + Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                    }

                    label.setText("");
                    break;
                case 2:
                    if(Binary.isSelected()) {
                        answer=number - Integer.parseInt(textField.getText(),2);
                        textField.setText(Integer.toBinaryString((int)answer));
                    }
                    else if (HexaDecimal.isSelected()) {
                        answer = number - Integer.parseInt(textField.getText(),16);
                        textField.setText(Integer.toHexString((int)answer));
                    }
                    else {
                        answer = number - Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                    }

                    label.setText("");
                    break;
                case 3:
                    if (Binary.isSelected()) {
                        answer= number * Integer.parseInt(textField.getText(),2);
                        textField.setText(Integer.toBinaryString((int)answer));
                    }
                    else if ( HexaDecimal.isSelected()) {
                        answer = number * Integer.parseInt(textField.getText(),16);
                        textField.setText(Integer.toHexString((int)answer));
                    }
                    else {
                        answer = number * Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                    }

                    label.setText("");
                    break;
                case 4:
                    if ( Binary.isSelected()) {
                        answer= number / Integer.parseInt(textField.getText(),2);
                        textField.setText(Integer.toBinaryString((int)answer));
                    }
                    else if (HexaDecimal.isSelected()) {
                        answer=  number / Integer.parseInt(textField.getText(),16);
                        textField.setText(Integer.toHexString((int)answer));
                    }
                    else {
                        answer = number / Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                    }

                    label.setText("");
                    break;
                case 5 :

                    BitwiseResult = BitwiseNumber & Integer.parseInt(textField.getText(),2);
                    textField.setText(Integer.toBinaryString(BitwiseResult));

                    label.setText("");
                    break ;

                case 6 :

                    BitwiseResult = BitwiseNumber | Integer.parseInt(textField.getText(),2);
                    textField.setText(Integer.toBinaryString(BitwiseResult));

                    label.setText("");
                    break ;

                case 7 :

                    BitwiseResult = BitwiseNumber ^ Integer.parseInt(textField.getText(),2);
                    textField.setText(Integer.toBinaryString(BitwiseResult));

                    label.setText("");
                    break ;

                case 8 :

                    BitwiseResult =  ~ BitwiseNumber ;
                    textField.setText(Integer.toBinaryString(BitwiseResult));

                    label.setText("");
                    break ;

                case 9 :

                    BitwiseResult = BitwiseNumber << 1;
                    textField.setText(Integer.toBinaryString(BitwiseResult));

                    label.setText("");
                    break ;

                case 10 :

                    BitwiseResult = BitwiseNumber >> 1 ;
                    textField.setText(Integer.toBinaryString(BitwiseResult));

                    label.setText("");
                    break ;









            }
        }


    }

    public void enableDecimal() {

        Decimal.setEnabled(false);
        HexaDecimal.setEnabled(true);
        Binary.setEnabled(true);

        textField.setEnabled(true);
        label.setEnabled(true);

        buttonClear.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonSqrt.setEnabled(true);
        buttonSquare.setEnabled(true);
        buttonReciprocal.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonE.setEnabled(false);
        buttonF.setEnabled(false);

        buttonAnd.setEnabled(false);
        buttonOr.setEnabled(false);
        buttonXor.setEnabled(false);
        buttonNot.setEnabled(false);
        buttonShiftLeft.setEnabled(false);
        buttonShiftRigth.setEnabled(false);

    }

    public void enableHexadecimal() {

        Binary.setEnabled(true);
        Decimal.setEnabled(true);
        HexaDecimal.setEnabled(false);

        label.setEnabled(true);
        textField.setEnabled(true);

        buttonClear.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonSqrt.setEnabled(true);
        buttonSquare.setEnabled(true);
        buttonReciprocal.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);


        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        buttonE.setEnabled(true);
        buttonF.setEnabled(true);

        buttonAnd.setEnabled(false);
        buttonOr.setEnabled(false);
        buttonXor.setEnabled(false);
        buttonNot.setEnabled(false);
        buttonShiftLeft.setEnabled(false);
        buttonShiftRigth.setEnabled(false);
    }

    public void enableBinary() {

        Binary.setEnabled(false);
        Decimal.setEnabled(true);
        HexaDecimal.setEnabled(true);

        label.setEnabled(true);
        textField.setEnabled(true);

        buttonClear.setEnabled(true);
        buttonDelete.setEnabled(true);

        buttonDiv.setEnabled(true);
        buttonSqrt.setEnabled(true);
        buttonSquare.setEnabled(true);
        buttonReciprocal.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(false);
        buttonEight.setEnabled(false);
        buttonNine.setEnabled(false);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(false);
        buttonFive.setEnabled(false);
        buttonSix.setEnabled(false);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(false);
        buttonThree.setEnabled(false);

        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);


        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonE.setEnabled(false);
        buttonF.setEnabled(false);

        buttonAnd.setEnabled(true);
        buttonOr.setEnabled(true);
        buttonXor.setEnabled(true);
        buttonNot.setEnabled(true);
        buttonShiftLeft.setEnabled(true);
        buttonShiftRigth.setEnabled(true);
    }
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator(); // Hesap makinesi arayüzünü başlat

    }






}
