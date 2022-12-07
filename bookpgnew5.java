






import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;
import java.sql.*;
import java.applet.*;



class bookpgnew5 extends Frame implements ActionListener,ItemListener
{
    Font fontKristen = new Font("Kristen ITC", Font.BOLD, 29);
    Font labelFont = new Font("Arial", Font.BOLD, 23);
    Font bookedLabel = new Font("Arial", Font.BOLD, 22);

    JLabel headerLabel, nameLabel, selectMovieLabel, selectTimeLabel, chooseSeatLabel, selectSofaLabel, footer;
    JTextField nameTextField;
    ImageIcon image;

  
  JComboBox<String> selectMovieOptions, selectTimeOptions, selectSofaOptions;
    ArrayList<JButton> seats = new ArrayList<>();
    String[] movie = {"Select movie", "The Conjuning","The Conjuning 2","1920 London","IT","Darr @ The Mall","Crawl","Raaz","The Unholy","Darr @ The Mall 2","Cinderella","Lupt","Lake Placid"};

    String[] time = {"Select time", "09:00AM - 11:00AM", "12:00PM - 02:00PM", "02.30PM - 04.30PM", "5PM - 7PM", "07.30PM - 09.30PM", "CLOSED"};
    String[] sofa = {"Select sofa", "Royal Sofa  -- Rs.220","Gold Sofa   -- Rs.170", "Silver Sofa  -- Rs.130"};


    JButton confirm, reset;

    public bookpgnew5() {
       
        setSize(1500, 1200);
        setVisible(true);
    setLocationRelativeTo(null);

        setLayout(null);
        int totalSeats = 31;
        int bookedSeatsTotal = 10;

        ArrayList<Integer> bookedSeats = generateRandomArray(bookedSeatsTotal, totalSeats);

        headerLabel = new JLabel("Book Your Seat Here !");
        headerLabel.setBounds(600, 27, 400, 100);
        add(headerLabel);
        headerLabel.setForeground(Color.red);
        headerLabel.setFont(fontKristen);


        //NAME
        nameLabel = new JLabel("Enter Your Name ");
        nameLabel.setBounds(100, 150, 200, 100);
        add(nameLabel);
        nameLabel.setFont(labelFont);

nameTextField = new JTextField();
        nameTextField.setBounds(350, 180, 300, 40);
        add(nameTextField);
        nameTextField.setFont(new Font("Arial", Font.BOLD, 17));

        //SELECT MOVIE
        selectMovieLabel = new JLabel("Select Movie ");
        selectMovieLabel.setBounds(100, 240, 200, 100);
        add(selectMovieLabel);
        selectMovieLabel.setFont(labelFont);

        selectMovieOptions = new JComboBox<>(movie);
        selectMovieOptions.setBounds(350, 270, 300, 30);
        add(selectMovieOptions);
        selectMovieOptions.setBackground(Color.white);
        selectMovieOptions.setFont(new Font("Arial", Font.BOLD, 17));

       selectMovieOptions.addItemListener(this);
        //SELECT TIME
        selectTimeLabel = new JLabel("Select Time ");
        selectTimeLabel.setBounds(740, 240, 200, 100);
        add(selectTimeLabel);
        selectTimeLabel.setFont(labelFont);


        selectTimeOptions = new JComboBox<>(time);
        selectTimeOptions.setBounds(950, 275, 300, 30);
        add(selectTimeOptions);
        selectTimeOptions.setBackground(Color.white);
        selectTimeOptions.setFont(new Font("Arial", Font.BOLD, 17));
        selectTimeOptions.addItemListener(this);


//BOOK SEATS
        chooseSeatLabel = new JLabel("Choose seat no ");
        chooseSeatLabel.setBounds(100, 380, 200, 100);
        add(chooseSeatLabel);
        chooseSeatLabel.setFont(labelFont);

        createSeats(totalSeats);
        setSeatBounds(7, 5);

        for (JButton seat : seats) {
            seat.setBackground(Color.white);
            seat.setForeground(Color.black);
            add(seat);
        }
        
        for(int bookedSeat: bookedSeats) {
            ImageIcon icon = new ImageIcon("seatBooked.png");
            icon.setImage(icon.getImage().getScaledInstance(50, 28, Image.SCALE_SMOOTH));
            seats.get(bookedSeat).setIcon(icon);
            seats.get(bookedSeat).setBackground(Color.white);
            seats.get(bookedSeat).setBorderPainted(false);
        }
//SOFA TYPE
        selectSofaLabel = new JLabel("Select Sofa ");
        selectSofaLabel.setBounds(100, 520, 200, 100);
        add(selectSofaLabel);
        selectSofaLabel.setFont(labelFont);

        selectSofaOptions = new JComboBox<>(sofa);
        selectSofaOptions.setBounds(350, 560, 300, 30);
        add(selectSofaOptions);
        selectSofaOptions.setBackground(Color.white);
        selectSofaOptions.setFont(new Font("Arial", Font.BOLD, 17));
        selectSofaOptions.addItemListener(this);

        image=new ImageIcon("sign.jpg");
        footer=new JLabel(image);
        footer.setBounds(0,800,1500,200);
        add(footer);

//confirm
        confirm = new JButton("Confirm");
        confirm.setBounds(430, 670, 250, 40);
        confirm.setFont(bookedLabel);
        add(confirm);
        confirm.setBackground(Color.white);
        confirm.setForeground(Color.black);

        confirm.addActionListener(this);


//reset
        reset = new JButton("Reset");
        reset.setBounds(700, 670, 250, 40);
        reset.setFont(bookedLabel);
        add(reset);
        reset.setBackground(Color.white);
        reset.setForeground(Color.black);
        reset.addActionListener(this);
    }


    private void createSeats(int totalSeats) {
        for (int i = 1; i <= totalSeats; i++) {
            ImageIcon icon = new ImageIcon("seat.png");
            icon.setImage(icon.getImage().getScaledInstance(50, 28, Image.SCALE_SMOOTH));
            JButton seatButton = new JButton(icon);
            seatButton.setBorderPainted(false);
            seats.add(seatButton);
        }
    }

    private void setSeatBounds(int leftSeatsSize, int rightSeatSize) {
        int seatWidth = 60;
        int seatHeight = 30;
        int startX = 355;
        int x = startX;
        int y = 366;
        int seatSideSpace = 73;
        int middleDifference = 107;
        int seatFrontSpace = 56;



        int rowSeatCount = 0;
        for (JButton seat : this.seats) {
            seat.setBounds(x, y, seatWidth, seatHeight);

            rowSeatCount += 1;
            if (rowSeatCount == leftSeatsSize) {
                x = x + middleDifference;
            } else {
                x = x + seatSideSpace;
            }
            if (rowSeatCount == leftSeatsSize + rightSeatSize) {
                x = startX;
                y = y + seatFrontSpace;
                rowSeatCount = 0;
            }
        }
    }
    public void itemStateChanged(ItemEvent ie)
    {
          
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s1=ae.getActionCommand();
        if(s1.equals("Confirm"))
        {
            try
            {
                            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                            JOptionPane.showMessageDialog(this,"Driver Registered");

                            Connection co=DriverManager.getConnection("jdbc:odbc:book1");
                            JOptionPane.showMessageDialog(this,"Connection Created");

                            String a1=nameTextField.getText();
                            String a2=selectMovieOptions.getSelectedItem().toString();
                            String a3=selectTimeOptions.getSelectedItem().toString();
                            String a4= selectSofaOptions.getSelectedItem().toString();
                            
                            PreparedStatement ps1=co.prepareStatement("insert into Ticket values(?,?,?,?)");
                            ps1.setString(1,a1);
                            ps1.setString(2,a2);
                            ps1.setString(3,a3);
                            ps1.setString(4,a4);
                            
                            ps1.executeUpdate();
                            JOptionPane.showMessageDialog(this,"Ticket Booked Successfully...");
                              
                            co.close();
                    }catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this,""+e);
                    }
        }
        
        if(s1.equals("Reset"))
        {
                   nameTextField.setText("");
                   selectMovieOptions.setSelectedIndex(0);
                   selectTimeOptions.setSelectedIndex(0);
                    selectSofaOptions.setSelectedIndex(0);
        }
       
    }


    public static ArrayList<Integer> generateRandomArray(int bookedTotal, int bound) {
        ArrayList<Integer> list = new ArrayList<>(bookedTotal);
        Random random = new Random();
        for (int i = 0; i < bookedTotal; i++) {
            list.add(random.nextInt(bound));
        }
        return list;
    }
    public static void main(String[] args)
    {
        new bookpgnew5();
    }
}





 
