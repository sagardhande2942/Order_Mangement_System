/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import static dbconnection.db.*;
import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author dhand
 */



public class Dashboard extends javax.swing.JFrame {
    public static Integer transidreal = 0;
    
    public static void updatetransid(Connection c){
        Statement s = null;
        ResultSet rs = null;
        String sql = "select id from trans";
        Integer newt = 0;
        try{
            s = c.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next())
            {
                newt = rs.getInt("id");
            }
            transidreal = newt + 1;
        }catch(Exception e){System.out.println("Error in updatetransid");}
    }
    
    public static void initTrack(Connection c, Integer id)
    {
        ResultSet rs = null;
        Statement s = null;
        String sql = "select * from trans";
        Integer ii = 0;
        String name = "";
        Integer quan = 0;
        Integer price = 0;
        Integer del = 0;
        String real = "";
        //sql += id.toString();
        try{
        s = c.createStatement();
        rs = s.executeQuery(sql);
        while(rs.next())
        {
            ii = rs.getInt("id");
            name = rs.getNString("name1");
            quan = rs.getInt("quan");
            price = rs.getInt("price");
            del = rs.getInt("delivery");
            String temp = ii + "\t" + name + "\t" + quan + "\t" + price + "\t" + del + " Days\n";
            real += temp; 
            transidreal = ii;
        }
        tracktext.setText(real);
        }catch(Exception e){System.out.println("Error in Dashboard line : 31 ");};
    }
    

    
    public static void updateTrack(Connection c,Integer id, String name, Integer stock, Integer price, Integer del)
    {
        Statement s = null;
        ResultSet rs = null;
        String sql = "insert into trans (name1, quan, price, delivery) values(";
        sql += "\'" + name + "\', " + stock.toString() + " ," + price.toString() + ", " + del.toString() + " );";
        System.out.println("update track : " + sql + " C : " + c);
        try{
            s = c.createStatement();
            s.executeUpdate(sql);
        }catch(Exception e){System.out.println("Hey");}
        }
    
    
    
public static Connection c = null;
public static  ResultSet rs = null;
public static Statement s1 = null;
    /**
     * Creates new form Dashboard
     */
    public static void Buyvalues(Connection c,Integer id, javax.swing.JLabel stock)
    {
        ResultSet rs = null;
            try{
        s1 = c.createStatement();
        }catch(Exception e){System.out.println("Error in c or s1");}
            
        String sq = "Select stock from buy where id = ";
        sq += id.toString();
        try{
        rs = s1.executeQuery(sq);
        rs.next();
        Integer i = rs.getInt("stock");
        System.out.println("Integer : " + i);
        stock.setText(i.toString());
        }catch(Exception e){System.out.println("Error in rs");}
    }
    
        public static void Buyprice(Connection c,Integer id, javax.swing.JLabel price)
    {
//        Connection c = null;
        ResultSet rs = null;
//        Statement s1 = null;
        try{
                    s1 = c.createStatement();

            try{
//        c = DriverManager.getConnection("jdbc:mysql://instance-1.cnruxcy14rpo.us-east-1.rds.amazonaws.com/test",dbconnection.db.USER,dbconnection.db. PASS);
//        s1 = c.createStatement();
         rs = null;
        String sq = "Select price from buy where id = ";
        sq += id.toString();
        rs = s1.executeQuery(sq);
        }catch(Exception e){System.out.println("Error in c or s1");}
        rs.next();
        Integer i = rs.getInt("price");
        System.out.println("Integer : " + i);
        price.setText(i.toString());
        }catch(Exception e){System.out.println("Error in setStock");}
    }
  
    public Dashboard() {
        initComponents();
       
        
        
        //JOptionPane.showMessageDialog(null, "LOW BALANCE", "TITLE", JOptionPane.WARNING_MESSAGE);
        home.setVisible(true);
        trackPage.setVisible(false);
        panelBalance.setVisible(false);
        BuyPage.setVisible(false);
        //Connection c = null;
        //Statement s1 = null;
        String s = "";
//        ResultSet rs1 = null, rs2 = null;
        try{
        c = DriverManager.getConnection("jdbc:mysql://instance-1.cnruxcy14rpo.us-east-1.rds.amazonaws.com/test",dbconnection.db.USER,dbconnection.db. PASS);
        s1 = c.createStatement();
        String sq = "Select * from balance";
        rs = s1.executeQuery(sq);
        rs.next();
        }catch(Exception e){System.out.println("Error in c1,s1,rs1,sq");}
        Integer i =0 ;
        try{
        i = rs.getInt("bal");
        }catch(Exception e){System.out.println("Error in i to string");}
        String bala = i.toString();
        balance.setText(bala);
        balanceCancel.setText(bala);
        
        
         Buyvalues(c,1,stock1);Buyvalues(c,2,stock2);Buyvalues(c,3,stock3);Buyvalues(c,4,stock4);Buyvalues(c,5,stock5);Buyvalues(c,6,stock6);
        Buyprice(c,1,price1);Buyprice(c,2,price2);Buyprice(c,3,price3);Buyprice(c,4,price4);Buyprice(c,5,price5);Buyprice(c,6,price6);
        //String sz = "select * from trans where "
        initTrack(c, 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField1 = new javax.swing.JTextField();
        BuyPage = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        price1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        quan1 = new javax.swing.JSpinner();
        buy1but = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jeans = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        stock1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Tshirt = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        stock2 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        price2 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        quan2 = new javax.swing.JSpinner();
        buy2but = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        quan3 = new javax.swing.JSpinner();
        buy3but = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        stock3 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        price3 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        stock4 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        price4 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        quan4 = new javax.swing.JSpinner();
        buy4but = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        quan5 = new javax.swing.JSpinner();
        buy5but = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        stock5 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        price5 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        stock6 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        price6 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        quan6 = new javax.swing.JSpinner();
        buy6but = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        SellBut = new javax.swing.JButton();
        BuyBut = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        TrackBut = new javax.swing.JButton();
        BalBut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelBalance = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IncrBalance = new javax.swing.JSpinner();
        AddBalance = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        home = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        trackPage = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tracktext = new javax.swing.JTextArea();
        RefreshTrack = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        clearTrack1 = new javax.swing.JButton();
        CancelTransaction = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cancelID = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        balanceCancel = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setText("jLabel5");

        jLabel17.setText("jLabel17");

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BuyPage.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        BuyPage.setMaximumSize(new java.awt.Dimension(693, 391));
        BuyPage.setOpaque(false);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 102, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rsz_screenshot_2020-11-03_222718.png"))); // NOI18N
        jLabel10.setText("ITEM");
        jLabel10.setToolTipText("");
        jLabel10.setOpaque(true);
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 10, 174, 181));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Price :");
        jLabel2.setOpaque(true);
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 287, 74, 28));

        price1.setBackground(new java.awt.Color(204, 204, 204));
        price1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        price1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price1.setText("$$$");
        price1.setOpaque(true);
        jPanel6.add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 80, 27));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Quantity : ");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 321, 85, 28));

        quan1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel6.add(quan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 321, 79, 28));

        buy1but.setBackground(new java.awt.Color(204, 0, 153));
        buy1but.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buy1but.setForeground(new java.awt.Color(153, 255, 255));
        buy1but.setText("Buy");
        buy1but.setContentAreaFilled(false);
        buy1but.setOpaque(true);
        buy1but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy1butActionPerformed(evt);
            }
        });
        jPanel6.add(buy1but, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 367, 92, 41));

        jLabel12.setBackground(new java.awt.Color(255, 102, 102));
        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tshirt1.png"))); // NOI18N
        jLabel12.setText("ITEM");
        jLabel12.setToolTipText("");
        jLabel12.setOpaque(true);
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 172, 181));

        jLabel16.setBackground(new java.awt.Color(255, 102, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shirt1.png"))); // NOI18N
        jLabel16.setText("ITEM");
        jLabel16.setToolTipText("");
        jLabel16.setOpaque(true);
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 10, 172, 180));

        jLabel21.setBackground(new java.awt.Color(255, 102, 102));
        jLabel21.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/jacket1.png"))); // NOI18N
        jLabel21.setText("ITEM");
        jLabel21.setToolTipText("");
        jLabel21.setOpaque(true);
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 172, 180));

        jLabel30.setBackground(new java.awt.Color(204, 204, 204));
        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Name :  ");
        jLabel30.setOpaque(true);
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 209, 74, 28));

        jeans.setBackground(new java.awt.Color(204, 204, 204));
        jeans.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jeans.setForeground(new java.awt.Color(0, 0, 255));
        jeans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jeans.setText("Jeans");
        jeans.setOpaque(true);
        jPanel6.add(jeans, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 80, 27));

        jLabel32.setBackground(new java.awt.Color(204, 204, 204));
        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Stock :");
        jLabel32.setOpaque(true);
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 247, 74, 28));

        stock1.setBackground(new java.awt.Color(204, 204, 204));
        stock1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stock1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stock1.setText("0");
        stock1.setOpaque(true);
        jPanel6.add(stock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 80, 27));

        jLabel34.setBackground(new java.awt.Color(204, 204, 204));
        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Name :  ");
        jLabel34.setOpaque(true);
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 74, 28));

        Tshirt.setBackground(new java.awt.Color(204, 204, 204));
        Tshirt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Tshirt.setForeground(new java.awt.Color(0, 0, 255));
        Tshirt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tshirt.setText("Tshirt");
        Tshirt.setOpaque(true);
        jPanel6.add(Tshirt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 80, 27));

        jLabel36.setBackground(new java.awt.Color(204, 204, 204));
        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Stock :");
        jLabel36.setOpaque(true);
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 74, 28));

        stock2.setBackground(new java.awt.Color(204, 204, 204));
        stock2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stock2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stock2.setText("0");
        stock2.setOpaque(true);
        jPanel6.add(stock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 80, 27));

        jLabel38.setBackground(new java.awt.Color(204, 204, 204));
        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Price :");
        jLabel38.setOpaque(true);
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 74, 28));

        price2.setBackground(new java.awt.Color(204, 204, 204));
        price2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        price2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price2.setText("$$$");
        price2.setOpaque(true);
        jPanel6.add(price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 290, 80, 27));

        jLabel40.setBackground(new java.awt.Color(204, 204, 204));
        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Quantity : ");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 85, 28));

        quan2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel6.add(quan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 79, 28));

        buy2but.setBackground(new java.awt.Color(204, 0, 153));
        buy2but.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buy2but.setForeground(new java.awt.Color(153, 255, 255));
        buy2but.setText("Buy");
        buy2but.setContentAreaFilled(false);
        buy2but.setOpaque(true);
        buy2but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy2butActionPerformed(evt);
            }
        });
        jPanel6.add(buy2but, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 92, 41));

        jLabel47.setBackground(new java.awt.Color(204, 204, 204));
        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Quantity : ");
        jPanel6.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 85, 28));

        quan3.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel6.add(quan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 79, 28));

        buy3but.setBackground(new java.awt.Color(204, 0, 153));
        buy3but.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buy3but.setForeground(new java.awt.Color(153, 255, 255));
        buy3but.setText("Buy");
        buy3but.setContentAreaFilled(false);
        buy3but.setOpaque(true);
        buy3but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy3butActionPerformed(evt);
            }
        });
        jPanel6.add(buy3but, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 92, 41));

        jLabel48.setBackground(new java.awt.Color(204, 204, 204));
        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Name :  ");
        jLabel48.setOpaque(true);
        jPanel6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 74, 28));

        jLabel49.setBackground(new java.awt.Color(204, 204, 204));
        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Shirt");
        jLabel49.setOpaque(true);
        jPanel6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 80, 27));

        jLabel50.setBackground(new java.awt.Color(204, 204, 204));
        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Stock :");
        jLabel50.setOpaque(true);
        jPanel6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 74, 28));

        stock3.setBackground(new java.awt.Color(204, 204, 204));
        stock3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stock3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stock3.setText("0");
        stock3.setOpaque(true);
        jPanel6.add(stock3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 80, 27));

        jLabel52.setBackground(new java.awt.Color(204, 204, 204));
        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Price :");
        jLabel52.setOpaque(true);
        jPanel6.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 74, 28));

        price3.setBackground(new java.awt.Color(204, 204, 204));
        price3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        price3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price3.setText("$$$");
        price3.setOpaque(true);
        jPanel6.add(price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 290, 80, 27));

        jLabel54.setBackground(new java.awt.Color(204, 204, 204));
        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Quantity : ");
        jPanel6.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 85, 28));

        jButton10.setBackground(new java.awt.Color(204, 0, 153));
        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(153, 255, 255));
        jButton10.setText("Buy");
        jButton10.setContentAreaFilled(false);
        jButton10.setOpaque(true);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 92, 41));

        jLabel55.setBackground(new java.awt.Color(204, 204, 204));
        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Name :  ");
        jLabel55.setOpaque(true);
        jPanel6.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 74, 28));

        jLabel56.setBackground(new java.awt.Color(204, 204, 204));
        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 51, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Jacket");
        jLabel56.setOpaque(true);
        jPanel6.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 80, 27));

        jLabel57.setBackground(new java.awt.Color(204, 204, 204));
        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Stock :");
        jLabel57.setOpaque(true);
        jPanel6.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 74, 28));

        stock4.setBackground(new java.awt.Color(204, 204, 204));
        stock4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stock4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stock4.setText("0");
        stock4.setOpaque(true);
        jPanel6.add(stock4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, 80, 27));

        jLabel59.setBackground(new java.awt.Color(204, 204, 204));
        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Price :");
        jLabel59.setOpaque(true);
        jPanel6.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 74, 28));

        price4.setBackground(new java.awt.Color(204, 204, 204));
        price4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        price4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price4.setText("$$$");
        price4.setOpaque(true);
        jPanel6.add(price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 80, 27));

        jLabel61.setBackground(new java.awt.Color(204, 204, 204));
        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Quantity : ");
        jPanel6.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 85, 28));

        quan4.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel6.add(quan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 70, 28));

        buy4but.setBackground(new java.awt.Color(204, 0, 153));
        buy4but.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buy4but.setForeground(new java.awt.Color(153, 255, 255));
        buy4but.setText("Buy");
        buy4but.setContentAreaFilled(false);
        buy4but.setOpaque(true);
        buy4but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy4butActionPerformed(evt);
            }
        });
        jPanel6.add(buy4but, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 92, 41));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 0));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 40, 350));

        jSeparator5.setBackground(new java.awt.Color(153, 153, 0));
        jSeparator5.setForeground(new java.awt.Color(51, 51, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 40, 350));

        jSeparator6.setBackground(new java.awt.Color(153, 153, 0));
        jSeparator6.setForeground(new java.awt.Color(51, 51, 0));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 40, 350));

        jLabel18.setBackground(new java.awt.Color(255, 102, 102));
        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hoodie1.png"))); // NOI18N
        jLabel18.setText("ITEM");
        jLabel18.setToolTipText("");
        jLabel18.setOpaque(true);
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 172, 180));

        jLabel62.setBackground(new java.awt.Color(255, 102, 102));
        jLabel62.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sweater1.png"))); // NOI18N
        jLabel62.setText("ITEM");
        jLabel62.setToolTipText("");
        jLabel62.setOpaque(true);
        jPanel6.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 172, 180));

        jLabel63.setBackground(new java.awt.Color(204, 204, 204));
        jLabel63.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Quantity : ");
        jPanel6.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 85, 28));

        quan5.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel6.add(quan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, 79, 28));

        buy5but.setBackground(new java.awt.Color(204, 0, 153));
        buy5but.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buy5but.setForeground(new java.awt.Color(153, 255, 255));
        buy5but.setText("Buy");
        buy5but.setContentAreaFilled(false);
        buy5but.setOpaque(true);
        buy5but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy5butActionPerformed(evt);
            }
        });
        jPanel6.add(buy5but, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 92, 41));

        jLabel64.setBackground(new java.awt.Color(204, 204, 204));
        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Name :  ");
        jLabel64.setOpaque(true);
        jPanel6.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, 74, 28));

        jLabel65.setBackground(new java.awt.Color(204, 204, 204));
        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 255));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Hoodie");
        jLabel65.setOpaque(true);
        jPanel6.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 80, 27));

        jLabel66.setBackground(new java.awt.Color(204, 204, 204));
        jLabel66.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Stock :");
        jLabel66.setOpaque(true);
        jPanel6.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 74, 28));

        stock5.setBackground(new java.awt.Color(204, 204, 204));
        stock5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stock5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stock5.setText("0");
        stock5.setOpaque(true);
        jPanel6.add(stock5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 80, 27));

        jLabel68.setBackground(new java.awt.Color(204, 204, 204));
        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Price :");
        jLabel68.setOpaque(true);
        jPanel6.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 74, 28));

        price5.setBackground(new java.awt.Color(204, 204, 204));
        price5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        price5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price5.setText("$$$");
        price5.setOpaque(true);
        jPanel6.add(price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 80, 27));

        jLabel70.setBackground(new java.awt.Color(204, 204, 204));
        jLabel70.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Quantity : ");
        jPanel6.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 85, 28));

        jButton13.setBackground(new java.awt.Color(204, 0, 153));
        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(153, 255, 255));
        jButton13.setText("Buy");
        jButton13.setContentAreaFilled(false);
        jButton13.setOpaque(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 92, 41));

        jLabel71.setBackground(new java.awt.Color(204, 204, 204));
        jLabel71.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Name :  ");
        jLabel71.setOpaque(true);
        jPanel6.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 210, 74, 28));

        jLabel72.setBackground(new java.awt.Color(204, 204, 204));
        jLabel72.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Sweater");
        jLabel72.setOpaque(true);
        jPanel6.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 210, 90, 27));

        jLabel73.setBackground(new java.awt.Color(204, 204, 204));
        jLabel73.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Stock :");
        jLabel73.setOpaque(true);
        jPanel6.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 250, 74, 28));

        stock6.setBackground(new java.awt.Color(204, 204, 204));
        stock6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stock6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stock6.setText("0");
        stock6.setOpaque(true);
        jPanel6.add(stock6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 250, 90, 27));

        jLabel75.setBackground(new java.awt.Color(204, 204, 204));
        jLabel75.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Price :");
        jLabel75.setOpaque(true);
        jPanel6.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, 74, 28));

        price6.setBackground(new java.awt.Color(204, 204, 204));
        price6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        price6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price6.setText("$$$");
        price6.setOpaque(true);
        jPanel6.add(price6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 290, 88, 27));

        jLabel77.setBackground(new java.awt.Color(204, 204, 204));
        jLabel77.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("Quantity : ");
        jPanel6.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 85, 28));

        quan6.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel6.add(quan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 320, 79, 28));

        buy6but.setBackground(new java.awt.Color(204, 0, 153));
        buy6but.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        buy6but.setForeground(new java.awt.Color(153, 255, 255));
        buy6but.setText("Buy");
        buy6but.setContentAreaFilled(false);
        buy6but.setOpaque(true);
        buy6but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy6butActionPerformed(evt);
            }
        });
        jPanel6.add(buy6but, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 370, 92, 41));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 0));
        jSeparator7.setForeground(new java.awt.Color(51, 51, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 40, 350));

        jSeparator8.setBackground(new java.awt.Color(153, 153, 0));
        jSeparator8.setForeground(new java.awt.Color(51, 51, 0));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 40, 350));

        BuyPage.setViewportView(jPanel6);

        getContentPane().add(BuyPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 780, 450));

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));

        SellBut.setBackground(new java.awt.Color(204, 153, 0));
        SellBut.setText("<html><h2 ><b> Cancel Order </b></h2></html>");
        SellBut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SellBut.setContentAreaFilled(false);
        SellBut.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        SellBut.setOpaque(true);
        SellBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellButActionPerformed(evt);
            }
        });

        BuyBut.setBackground(new java.awt.Color(204, 153, 0));
        BuyBut.setText("<html><h2 ><b> Buy </b></h2></html>");
        BuyBut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BuyBut.setContentAreaFilled(false);
        BuyBut.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BuyBut.setOpaque(true);
        BuyBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyButActionPerformed(evt);
            }
        });

        TrackBut.setBackground(new java.awt.Color(204, 153, 0));
        TrackBut.setText("<html><h2 ><b> Track </b></h2></html>");
        TrackBut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TrackBut.setContentAreaFilled(false);
        TrackBut.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        TrackBut.setOpaque(true);
        TrackBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrackButActionPerformed(evt);
            }
        });

        BalBut.setBackground(new java.awt.Color(204, 153, 0));
        BalBut.setText("<html><h2 ><b> Check Balance </b></h2></html>");
        BalBut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BalBut.setContentAreaFilled(false);
        BalBut.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BalBut.setOpaque(true);
        BalBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BalButActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/LOGO.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuyBut)
                    .addComponent(SellBut, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TrackBut)
                    .addComponent(BalBut, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BalBut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BuyBut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TrackBut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SellBut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 180, 580));

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));

        jLabel4.setBackground(new java.awt.Color(51, 204, 255));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage and Buy products anytime,  anywhere");
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 0, 790, 120));

        panelBalance.setBackground(new java.awt.Color(204, 204, 204));
        panelBalance.setMinimumSize(new java.awt.Dimension(420, 433));
        panelBalance.setPreferredSize(new java.awt.Dimension(720, 718));
        panelBalance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("<html><h1><b> Wallet    </b></h1></html>");
        panelBalance.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 121, 71));

        balance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balance.setText("0");
        balance.setOpaque(true);
        panelBalance.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 160, 49));

        jLabel3.setText("<html><h1><b> Add Money </b></h1></html>");
        panelBalance.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 121, 60));

        IncrBalance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        IncrBalance.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 100));
        IncrBalance.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelBalance.add(IncrBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 169, 53));

        AddBalance.setBackground(new java.awt.Color(51, 102, 255));
        AddBalance.setForeground(new java.awt.Color(255, 255, 255));
        AddBalance.setText("<html><b>Add</h1></html>");
        AddBalance.setContentAreaFilled(false);
        AddBalance.setOpaque(true);
        AddBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBalanceActionPerformed(evt);
            }
        });
        panelBalance.add(AddBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 80, 40));
        panelBalance.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 720, 17));
        panelBalance.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 423, 685, 10));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Screenshot 2020-11-03 222242.png"))); // NOI18N
        panelBalance.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 120));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Screenshot 2020-11-03 222027.png"))); // NOI18N
        panelBalance.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 180, 130));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("Rs");
        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        panelBalance.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 40, 40));

        getContentPane().add(panelBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 790, 460));

        home.setLayout(null);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 153, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("  Buy and Track your orders \n     anywhere, anytime.\n\nGet started by adding balance\nto your account from the Check\nbalance option.");
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jTextArea1);

        home.add(jScrollPane3);
        jScrollPane3.setBounds(170, 80, 440, 270);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/backgroundhome.jpg"))); // NOI18N
        jLabel6.setText("jb");
        home.add(jLabel6);
        jLabel6.setBounds(0, 0, 790, 460);

        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 790, 460));

        trackPage.setBackground(new java.awt.Color(153, 153, 153));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/track.png"))); // NOI18N

        tracktext.setBackground(new java.awt.Color(204, 204, 204));
        tracktext.setColumns(20);
        tracktext.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tracktext.setForeground(new java.awt.Color(0, 0, 204));
        tracktext.setRows(5);
        jScrollPane1.setViewportView(tracktext);

        RefreshTrack.setBackground(new java.awt.Color(0, 51, 255));
        RefreshTrack.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        RefreshTrack.setForeground(new java.awt.Color(255, 255, 255));
        RefreshTrack.setText("Refresh Track");
        RefreshTrack.setContentAreaFilled(false);
        RefreshTrack.setOpaque(true);
        RefreshTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshTrackActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 0, 51));
        jTextField2.setText("Trans_ID\tName\tQuantity\tPrice\tDelivery ");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        clearTrack1.setBackground(new java.awt.Color(0, 51, 255));
        clearTrack1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        clearTrack1.setForeground(new java.awt.Color(255, 255, 255));
        clearTrack1.setText("Clear Track");
        clearTrack1.setContentAreaFilled(false);
        clearTrack1.setOpaque(true);
        clearTrack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTrack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout trackPageLayout = new javax.swing.GroupLayout(trackPage);
        trackPage.setLayout(trackPageLayout);
        trackPageLayout.setHorizontalGroup(
            trackPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trackPageLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(trackPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(trackPageLayout.createSequentialGroup()
                        .addGroup(trackPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(40, 40, 40))
                    .addGroup(trackPageLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(29, 29, 29)
                        .addComponent(RefreshTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addGroup(trackPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trackPageLayout.createSequentialGroup()
                    .addContainerGap(660, Short.MAX_VALUE)
                    .addComponent(clearTrack1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)))
        );
        trackPageLayout.setVerticalGroup(
            trackPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackPageLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(trackPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trackPageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trackPageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RefreshTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
            .addGroup(trackPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trackPageLayout.createSequentialGroup()
                    .addContainerGap(259, Short.MAX_VALUE)
                    .addComponent(clearTrack1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(158, 158, 158)))
        );

        getContentPane().add(trackPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 790, 460));

        CancelTransaction.setBackground(new java.awt.Color(153, 153, 255));
        CancelTransaction.setLayout(null);

        jLabel13.setBackground(new java.awt.Color(255, 204, 51));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelogo.png"))); // NOI18N
        jLabel13.setText("jLabel13");
        CancelTransaction.add(jLabel13);
        jLabel13.setBounds(30, 30, 204, 161);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        cancelID.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jButton2.setBackground(new java.awt.Color(255, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(0, 255, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("  Enter the Transaction ID to \n       \t    Cancel.");
        jScrollPane4.setViewportView(jTextArea3);

        jTextField3.setBackground(new java.awt.Color(51, 153, 255));
        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("ID : ");
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cancelID, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(32, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(278, Short.MAX_VALUE)))
        );

        CancelTransaction.add(jPanel1);
        jPanel1.setBounds(270, 30, 491, 390);

        jTextField4.setBackground(new java.awt.Color(204, 204, 255));
        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jTextField4.setText("Cancel Order Easily And Get Refund Immediatly");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        CancelTransaction.add(jTextField4);
        jTextField4.setBounds(0, 209, 270, 50);

        jTextField5.setBackground(new java.awt.Color(204, 204, 255));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Current Balance");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        CancelTransaction.add(jTextField5);
        jTextField5.setBounds(70, 390, 120, 50);

        balanceCancel.setEditable(false);
        balanceCancel.setBackground(new java.awt.Color(204, 204, 255));
        balanceCancel.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        balanceCancel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        balanceCancel.setText("0");
        balanceCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceCancelActionPerformed(evt);
            }
        });
        CancelTransaction.add(balanceCancel);
        balanceCancel.setBounds(60, 280, 140, 90);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(153, 153, 255));
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("Rs ");
        jTextField7.setBorder(null);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        CancelTransaction.add(jTextField7);
        jTextField7.setBounds(20, 310, 40, 40);

        getContentPane().add(CancelTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 780, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuyButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyButActionPerformed
        // TODO add your handling code here:
        trackPage.setVisible(false);
        panelBalance.setVisible(false);
        CancelTransaction.setVisible(false);
        home.setVisible(false);
        BuyPage.setVisible(true);
        BuyBut.setText("<html><h2 style = \"color : red;\" ><b> Buy </b></h2></html>");
        TrackBut.setText("<html><h2 style = \"color : black;\" ><b> Track </b></h2></html>");
        SellBut.setText("<html><h2 style = \"color : black;\" ><b> Sell </b></h2></html>");
                BalBut.setText("<html><h2 style = \"color : black;\" ><b> Check Balance </b></h2></html>");

    }//GEN-LAST:event_BuyButActionPerformed

    private void TrackButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrackButActionPerformed
        // TODO add your handling code here:
        home.setVisible(false);
        CancelTransaction.setVisible(false);
        BuyPage.setVisible(false);
        panelBalance.setVisible(false);
        trackPage.setVisible(true);
         BuyBut.setText("<html><h2 style = \"color : black;\" ><b> Buy </b></h2></html>");
        TrackBut.setText("<html><h2 style = \"color : red;\" ><b> Track </b></h2></html>");
        SellBut.setText("<html><h2 style = \"color : black;\" ><b> Sell </b></h2></html>");
                BalBut.setText("<html><h2 style = \"color : black;\" ><b> Check Balance </b></h2></html>");

    }//GEN-LAST:event_TrackButActionPerformed

    private void BalButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BalButActionPerformed
        // TODO add your handling code here:
        trackPage.setVisible(false);
        CancelTransaction.setVisible(false);
        home.setVisible(false);
        
        BuyPage.setVisible(false);
        panelBalance.setVisible(true);
        
           BuyBut.setText("<html><h2 style = \"color : black;\" ><b> Buy </b></h2></html>");
        TrackBut.setText("<html><h2 style = \"color : black;\" ><b> Track </b></h2></html>");
        SellBut.setText("<html><h2 style = \"color : black;\" ><b> Sell </b></h2></html>");
        BalBut.setText("<html><h2 style = \"color : red;\" ><b> Check Balance </b></h2></html>");

    }//GEN-LAST:event_BalButActionPerformed

    private void AddBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBalanceActionPerformed
        // TODO add your handling code here:\

//        try{
//            conn = DriverManager.getConnection(dbconnection.db.DB_URL,dbconnection.db.USER,dbconnection.db. PASS);
//            stmt = conn.createStatement();
//
//        }catch(Exception e)
//        {
//            System.out.print("Conn or Stmt Null");
//        }
        String sql = "update  balance set bal = ";
        bal = Integer.parseInt(balance.getText());
        System.out.print(balance.getText());
        Integer it = (Integer)IncrBalance.getValue();
        if(it < 0)
        {
            JOptionPane.showMessageDialog(null, "LOW BALANCE", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
        it += bal;
        sql += it.toString() + " where id = 1";
        try{
            s1.executeUpdate(sql);}catch(Exception e){System.out.println("Update fail");}
        String s = it.toString();
        balance.setText(s);
        }
    }//GEN-LAST:event_AddBalanceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        trackPage.setVisible(false);
        CancelTransaction.setVisible(false);
        panelBalance.setVisible(false);
        BuyPage.setVisible(false);
        home.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    Integer but1 = 0;
    Integer transid = 0;
    private void buy1butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy1butActionPerformed
        // TODO add your handling code here: 
        ResultSet rs = null;
        System.out.println("C : HERE : " + c);
        Integer b = Integer.parseInt(price1.getText());
        System.out.println("Price1 : " + b);
        String aa = balance.getText();
        Integer bb = Integer.parseInt(aa);
        Integer ac = bb - b;
         System.out.println("ac : " + ac);

        if(bb - b < 0)
        {
            JOptionPane.showMessageDialog(null, "LOW BALANCE", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            String sql1 = "update balance set bal = ";
            try{
                sql1 += ac.toString() + " where id = 1;";
                System.out.println(sql1);
                s1.executeUpdate(sql1);
            }catch(Exception e){System.out.println("error in buy but 1 hehre");}
        
        String s = stock1.getText();
        Integer i1 = Integer.parseInt(s);
        Integer i2 = (Integer)quan1.getValue();
        Integer i3 = i1 - i2;
        if(i3 < 0 || i1 < 0)
        {
            JOptionPane.showMessageDialog(null, "Not enough Stock available", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            updatetransid(c);
            
            stock1.setText(i3.toString());
            try{
            String sql = "update buy set stock = ";
            sql += i3.toString() + " where id = 1";
             s1.executeUpdate(sql);
            }catch(Exception e){System.out.println("Error in connection");}
            
            String ss = tracktext.getText();
            but1 = (Integer)quan1.getValue();
            Integer ran = generateRandom();
            String sg = ss +  transidreal.toString() + "\tJeans " + "\t" + but1.toString() + "\t" + Integer.parseInt(price1.getText()) * but1 + "\t" + ran + " Days\n";
            tracktext.setText(sg);
            updateTrack(c, transidreal,"Jeans", i2 , b * i2, ran);
             initTrack(c, 1);          

            
        }
        }
        String sq = "Select * from balance";
        try{
        rs = s1.executeQuery(sq);
        rs.next();
        }catch(Exception e){System.out.println("Error in c1,s1,rs1,sq");}
        Integer i =0 ;
        try{
        i = rs.getInt("bal");
        }catch(Exception e){System.out.println("Error in i to string");}
        String bala = i.toString();
        balance.setText(bala);
        
        
        
    }//GEN-LAST:event_buy1butActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    Integer but2 = 0;
    private void buy2butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy2butActionPerformed
        // TODO add your handling code here:
        
            ResultSet rs = null;
        Integer b = Integer.parseInt(price2.getText());
        System.out.println("Price2 : " + b);
        String aa = balance.getText();
        Integer bb = Integer.parseInt(aa);
        Integer ac = bb - b;
         System.out.println("ac : " + ac);

        if(bb - b < 0)
        {
            JOptionPane.showMessageDialog(null, "LOW BALANCE", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            String sql1 = "update balance set bal = ";
            try{
                sql1 += ac.toString() + " where id = 1;";
                System.out.println(sql1);
                s1.executeUpdate(sql1);
            }catch(Exception e){System.out.println("error in buy but 1 hehre");}
        
        
         String s = stock2.getText();
        Integer i1 = Integer.parseInt(s);
        Integer i2 = (Integer)quan2.getValue();
        Integer i3 = i1 - i2;
        if(i3 < 0 || i1 < 0)
        {
            JOptionPane.showMessageDialog(null, "Not enough Stock available", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            transidreal++;
            stock2.setText(i3.toString());
            try{
            String sql = "update buy set stock = ";
            sql += i3.toString() + " where id = 2";
             s1.executeUpdate(sql);
            }catch(Exception e){System.out.println("Error in connection");}
            
              String ss = tracktext.getText();
            but2 = (Integer)quan2.getValue();
            Integer ran = generateRandom();
            String sg = ss +  transidreal + "\tTshirt " + "\t" + but2.toString() + "\t" + Integer.parseInt(price2.getText()) * but2 + "\t" + ran + " Days\n";
            tracktext.setText(sg);
            updateTrack(c, transidreal,"Tshirt", i2, b * i2, ran);
            initTrack(c, 1);  
        }
        }
             String sq = "Select * from balance";
        try{
        rs = s1.executeQuery(sq);
        rs.next();
        }catch(Exception e){System.out.println("Error in c1,s1,rs1,sq");}
        Integer i =0 ;
        try{
        i = rs.getInt("bal");
        }catch(Exception e){System.out.println("Error in i to string");}
        String bala = i.toString();
        balance.setText(bala);
        
    }//GEN-LAST:event_buy2butActionPerformed

    Integer but3 = 0;
    private void buy3butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy3butActionPerformed
        
            ResultSet rs = null;
        Integer b = Integer.parseInt(price3.getText());
        System.out.println("Price3 : " + b);
        String aa = balance.getText();
        Integer bb = Integer.parseInt(aa);
        Integer ac = bb - b;
         System.out.println("ac : " + ac);

        if(bb - b < 0)
        {
            JOptionPane.showMessageDialog(null, "LOW BALANCE", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            String sql1 = "update balance set bal = ";
            try{
                sql1 += ac.toString() + " where id = 1;";
                System.out.println(sql1);
                s1.executeUpdate(sql1);
            }catch(Exception e){System.out.println("error in buy but 1 hehre");}
        
        
         String s = stock3.getText();
        Integer i1 = Integer.parseInt(s);
        Integer i2 = (Integer)quan3.getValue();
        Integer i3 = i1 - i2;
        if(i3 < 0 || i1 < 0)
        {
            JOptionPane.showMessageDialog(null, "Not enough Stock available", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            transidreal++;
            stock3.setText(i3.toString());
            try{
            String sql = "update buy set stock = ";
            sql += i3.toString() + " where id = 3";
             s1.executeUpdate(sql);
            }catch(Exception e){System.out.println("Error in connection");}
            
              String ss = tracktext.getText();
            but3 = (Integer)quan3.getValue();
            Integer ran = generateRandom();
            String sg = ss + transidreal + "\tShirt " + "\t" + but3.toString() + "\t" + Integer.parseInt(price3.getText()) * but3 + "\t" + ran+ " Days\n";
            tracktext.setText(sg);
            updateTrack(c, transidreal,"Shirt", i2, b * i2, ran);
            initTrack(c, 1);  

        }
        }
        
             String sq = "Select * from balance";
        try{
        rs = s1.executeQuery(sq);
        rs.next();
        }catch(Exception e){System.out.println("Error in c1,s1,rs1,sq");}
        Integer i =0 ;
        try{
        i = rs.getInt("bal");
        }catch(Exception e){System.out.println("Error in i to string");}
        String bala = i.toString();
        balance.setText(bala);
    }//GEN-LAST:event_buy3butActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    Integer but4 = 0;
    private void buy4butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy4butActionPerformed
        // TODO add your handling code here:
        
            ResultSet rs = null;
        Integer b = Integer.parseInt(price4.getText());
        System.out.println("Price4 : " + b);
        String aa = balance.getText();
        Integer bb = Integer.parseInt(aa);
        Integer ac = bb - b;
         System.out.println("ac : " + ac);

        if(bb - b < 0)
        {
            JOptionPane.showMessageDialog(null, "LOW BALANCE", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            String sql1 = "update balance set bal = ";
            try{
                sql1 += ac.toString() + " where id = 1;";
                System.out.println(sql1);
                s1.executeUpdate(sql1);
            }catch(Exception e){System.out.println("error in buy but 1 hehre");}
        
        
         String s = stock4.getText();
        Integer i1 = Integer.parseInt(s);
        Integer i2 = (Integer)quan4.getValue();
        Integer i3 = i1 - i2;
        if(i3 < 0 || i1 < 0)
        {
            JOptionPane.showMessageDialog(null, "Not enough Stock available", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            transidreal++;
            stock4.setText(i3.toString());
            try{
            String sql = "update buy set stock = ";
            sql += i3.toString() + " where id = 4";
             s1.executeUpdate(sql);
            }catch(Exception e){System.out.println("Error in connection");}
            
              String ss = tracktext.getText();
            but4 = (Integer)quan4.getValue();
            Integer ran = generateRandom();
            String sg = ss +  transidreal + "\tJacket " + "\t" + but4.toString() + "\t" + Integer.parseInt(price4.getText()) * but4 + "\t" + ran + " Days\n";
            tracktext.setText(sg);
            updateTrack(c, transidreal,"Jacket", i2, b * i2, ran);
            initTrack(c, 1);  

        }
        }
        
             String sq = "Select * from balance";
        try{
        rs = s1.executeQuery(sq);
        rs.next();
        }catch(Exception e){System.out.println("Error in c1,s1,rs1,sq");}
        Integer i =0 ;
        try{
        i = rs.getInt("bal");
        }catch(Exception e){System.out.println("Error in i to string");}
        String bala = i.toString();
        balance.setText(bala);
    }//GEN-LAST:event_buy4butActionPerformed

    Integer but5 = 0;
    private void buy5butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy5butActionPerformed
        // TODO add your handling code here:
        
            ResultSet rs = null;
        Integer b = Integer.parseInt(price5.getText());
        System.out.println("Price5 : " + b);
        String aa = balance.getText();
        Integer bb = Integer.parseInt(aa);
        Integer ac = bb - b;
         System.out.println("ac : " + ac);

        if(bb - b < 0)
        {
            JOptionPane.showMessageDialog(null, "LOW BALANCE", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            String sql1 = "update balance set bal = ";
            try{
                sql1 += ac.toString() + " where id = 1;";
                System.out.println(sql1);
                s1.executeUpdate(sql1);
            }catch(Exception e){System.out.println("error in buy but 1 hehre");}
        
        
         String s = stock5.getText();
        Integer i1 = Integer.parseInt(s);
        Integer i2 = (Integer)quan5.getValue();
        Integer i3 = i1 - i2;
        if(i3 < 0 || i1 < 0)
        {
            JOptionPane.showMessageDialog(null, "Not enough Stock available", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            transidreal++;
            stock5.setText(i3.toString());
            try{
            String sql = "update buy set stock = ";
            sql += i3.toString() + " where id = 5";
             s1.executeUpdate(sql);
            }catch(Exception e){System.out.println("Error in connection");}
            
              String ss = tracktext.getText();
            but5 = (Integer)quan5.getValue();
            Integer ran = generateRandom();
            String sg = ss + transidreal + "\tHoodie " + "\t" + but5.toString() + "\t" + Integer.parseInt(price5.getText()) * but5 + "\t" + ran + " Days\n";
            tracktext.setText(sg);
            updateTrack(c, transidreal,"Hoodie", i2, b * i2, ran);
            initTrack(c, 1);  

            
        }
        }
             String sq = "Select * from balance";
        try{
        rs = s1.executeQuery(sq);
        rs.next();
        }catch(Exception e){System.out.println("Error in c1,s1,rs1,sq");}
        Integer i =0 ;
        try{
        i = rs.getInt("bal");
        }catch(Exception e){System.out.println("Error in i to string");}
        String bala = i.toString();
        balance.setText(bala);
    }//GEN-LAST:event_buy5butActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    Integer but6 = 0;
    private void buy6butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy6butActionPerformed
        // TODO add your handling code here:
        
            ResultSet rs = null;
        Integer b = Integer.parseInt(price6.getText());
        System.out.println("Price6 : " + b);
        String aa = balance.getText();
        Integer bb = Integer.parseInt(aa);
        Integer ac = bb - b;
         System.out.println("ac : " + ac);

        if(bb - b < 0)
        {
            JOptionPane.showMessageDialog(null, "LOW BALANCE", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            String sql1 = "update balance set bal = ";
            try{
                sql1 += ac.toString() + " where id = 1;";
                System.out.println(sql1);
                s1.executeUpdate(sql1);
            }catch(Exception e){System.out.println("error in buy but 1 hehre");}
        
        
         String s = stock6.getText();
        Integer i1 = Integer.parseInt(s);
        Integer i2 = (Integer)quan6.getValue();
        Integer i3 = i1 - i2;
        if(i3 < 0 || i1 < 0)
        {
            JOptionPane.showMessageDialog(null, "Not enough Stock available", "TITLE", JOptionPane.WARNING_MESSAGE);
        }else{
            transidreal++;
            stock6.setText(i3.toString());
            try{
            String sql = "update buy set stock = ";
            sql += i3.toString() + " where id = 6";
             s1.executeUpdate(sql);
            }catch(Exception e){System.out.println("Error in connection");}
            
              String ss = tracktext.getText();
            but6 = (Integer)quan6.getValue();
            Integer ran = generateRandom();
            String sg = ss  +transidreal + "\tSweater " + "\t" + but6.toString() + "\t" + Integer.parseInt(price6.getText()) * but6 + "\t" + ran+ " Days\n";
            tracktext.setText(sg);
            updateTrack(c, transidreal,"Sweater", i2, b * i2, ran);
            initTrack(c, 1);  
            

        }
        }
        
             String sq = "Select * from balance";
        try{
        rs = s1.executeQuery(sq);
        rs.next();
        }catch(Exception e){System.out.println("Error in c1,s1,rs1,sq");}
        Integer i =0 ;
        try{
        i = rs.getInt("bal");
        }catch(Exception e){System.out.println("Error in i to string");}
        String bala = i.toString();
        balance.setText(bala);
    }//GEN-LAST:event_buy6butActionPerformed

    private void RefreshTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshTrackActionPerformed
        // TODO add your handling code here:
        tracktext.setText("");
        initTrack(c, 1);
        
    }//GEN-LAST:event_RefreshTrackActionPerformed

    private void SellButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellButActionPerformed
        // TODO add your handling code here:
        // jTextField1.setText("Hiiii");
        trackPage.setVisible(false);
        panelBalance.setVisible(false);
        home.setVisible(false);
        BuyPage.setVisible(false);
        CancelTransaction.setVisible(true);
        BuyBut.setText("<html><h2 style = \"color : black;\" ><b> Buy </b></h2></html>");
        TrackBut.setText("<html><h2 style = \"color : black;\" ><b> Track </b></h2></html>");
        SellBut.setText("<html><h2 style = \"color : red;\" ><b> Sell </b></h2></html>");
        BalBut.setText("<html><h2 style = \"color : black;\" ><b> Check Balance </b></h2></html>");
    }//GEN-LAST:event_SellButActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String s1 = "select price from trans where id =";
        String sql = "Delete from trans where id = ";
        Integer a = (Integer)cancelID.getValue();
        sql += a.toString();
        s1 += a.toString();
        Statement s = null;
        ResultSet rs = null;
        try{
            s = c.createStatement();
            
            rs = s.executeQuery(s1);
            rs.next();
            String gg = balance.getText();
            Integer ss = Integer.parseInt(gg) + rs.getInt("price");
            balance.setText(ss.toString());
        }catch(Exception e){System.out.println("Error in setting balance cancel trans");}
        try{
            s = c.createStatement();
            s.executeUpdate(sql);
        }catch(Exception e){System.out.println("Cancel button not working");}
        
        balanceCancel.setText(balance.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void balanceCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceCancelActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void clearTrack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTrack1ActionPerformed
        // TODO add your handling code here:
        tracktext.setText("");
    }//GEN-LAST:event_clearTrack1ActionPerformed
    private static Integer bal = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBalance;
    private javax.swing.JButton BalBut;
    private javax.swing.JButton BuyBut;
    private javax.swing.JScrollPane BuyPage;
    private javax.swing.JPanel CancelTransaction;
    private javax.swing.JSpinner IncrBalance;
    private javax.swing.JButton RefreshTrack;
    private javax.swing.JButton SellBut;
    private javax.swing.JButton TrackBut;
    private javax.swing.JLabel Tshirt;
    private javax.swing.JLabel balance;
    private javax.swing.JTextField balanceCancel;
    private javax.swing.JButton buy1but;
    private javax.swing.JButton buy2but;
    private javax.swing.JButton buy3but;
    private javax.swing.JButton buy4but;
    private javax.swing.JButton buy5but;
    private javax.swing.JButton buy6but;
    private javax.swing.JSpinner cancelID;
    private javax.swing.JButton clearTrack1;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel jeans;
    private javax.swing.JPanel panelBalance;
    private javax.swing.JLabel price1;
    private javax.swing.JLabel price2;
    private javax.swing.JLabel price3;
    private javax.swing.JLabel price4;
    private javax.swing.JLabel price5;
    private javax.swing.JLabel price6;
    private javax.swing.JSpinner quan1;
    private javax.swing.JSpinner quan2;
    private javax.swing.JSpinner quan3;
    private javax.swing.JSpinner quan4;
    private javax.swing.JSpinner quan5;
    private javax.swing.JSpinner quan6;
    private javax.swing.JLabel stock1;
    private javax.swing.JLabel stock2;
    private javax.swing.JLabel stock3;
    private javax.swing.JLabel stock4;
    private javax.swing.JLabel stock5;
    private javax.swing.JLabel stock6;
    private javax.swing.JPanel trackPage;
    private static javax.swing.JTextArea tracktext;
    // End of variables declaration//GEN-END:variables

    public static int generateRandom() { 
  

        // create instance of Random class 
        Random rand = new Random(); 
  
        // Generate random integers in range 0 to 999 
        int rand_int2 = 0;
        do{
            rand_int2 = rand.nextInt(10);
        }while(rand_int2 == 0);
        
        return rand_int2;
        // Print random doubles 
//        System.out.println("Random Doubles: "+rand_dub1); 
//        System.out.println("Random Doubles: "+rand_dub2); 
    }

        
    

}
