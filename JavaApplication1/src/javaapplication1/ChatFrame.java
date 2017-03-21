package javaapplication1;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import jserver.History;
import jserver.Message;
import jserver.SocketClient;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;
import jserver.SocketServer;

public class ChatFrame extends javax.swing.JFrame {

    public SocketClient client;
    public String username, password;
    public Thread clientThread;
    public DefaultListModel model;
    public File file;
    public String historyFile = "D:/History.xml";
    public HistoryFrame historyFrame;
    public History hist;
    
    ////server stuff below
    public SocketServer server;
    public Thread serverThread;
    public String filePath = "C:/Users/Owner/Desktop/Article_src/Data.xml";
    public JFileChooser fileChooser;
    public ChatFrame() {
        initComponents();
        this.setTitle("Chitter Chat");
        this.setSize( 1000,600 );
        
        
        DefaultCaret caret = (DefaultCaret)chatText.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        
        
        model.addElement("All");
        userList.setSelectedIndex(0);

        
        
        //server = new SocketServer(this);

        boolean serverFound= false;

            try{
                client = new SocketClient(this);
                clientThread = new Thread(client);
                clientThread.start();
                client.send(new Message("test", "testUser", "testContent", "SERVER"));
                serverFound = true;
            }
            catch(Exception ex){
                //chatText.append("[Application > Me] : Server not found\n");
                serverFound = false;
            }
            if(!serverFound){
                server = new SocketServer(this);
            }
            try{
                client = new SocketClient(this);
                clientThread = new Thread(client);
                clientThread.start();
                client.send(new Message("test", "testUser", "testContent", "SERVER"));
                serverFound = true;
            }
            catch(Exception ex){
                //chatText.append("[Application > Me] : Server not found\n");
                serverFound = false;
            }
        messageText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
              
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                  String msg = messageText.getText();
                  String target = userList.getSelectedValue().toString();
        
                  if(!msg.isEmpty() && !target.isEmpty()){
                     messageText.setText("");
                     client.send(new Message("message", username, msg, target));
                  }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        this.addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) { try{ client.send(new Message("message", username, ".bye", "SERVER")); clientThread.stop();  }catch(Exception ex){} }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
        
        hist = new History(historyFile);
    }
    
    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        usernameText = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        passwordText = new javax.swing.JPasswordField();
        chatScroll = new javax.swing.JScrollPane();
        chatText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        messageText = new javax.swing.JTextField();
        sendMessageButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        filePathText = new javax.swing.JTextField();
        filePathButton = new javax.swing.JButton();
        sendFileButton = new javax.swing.JButton();
        TeamHeader = new javax.swing.JPanel();
        TeamLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TeamLabel2 = new javax.swing.JLabel();
        Lists = new javax.swing.JTabbedPane();
        ToDo = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        TasksLabel = new javax.swing.JLabel();
        ResourcesLabel = new javax.swing.JLabel();
        ConflictLabel = new javax.swing.JLabel();
        ListHeader = new javax.swing.JPanel();
        TeamLabel1 = new javax.swing.JLabel();
        Events = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        meetings = new javax.swing.JLabel();
        presentations = new javax.swing.JLabel();
        keystone = new javax.swing.JLabel();
        ListHeader1 = new javax.swing.JPanel();
        TeamLabel3 = new javax.swing.JLabel();
        Availability = new javax.swing.JPanel();
        ListHeader2 = new javax.swing.JPanel();
        TeamLabel4 = new javax.swing.JLabel();
        table = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(64, 174, 208));
        setForeground(java.awt.Color.cyan);

        usernameText.setText("Nathan");
        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });

        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password :");

        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText(" Username :");

        signUpButton.setBackground(new java.awt.Color(3, 92, 141));
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("SignUp");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        passwordText.setText("boyzboyzboyz");
        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });

        chatText.setEditable(false);
        chatText.setColumns(20);
        chatText.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        chatText.setRows(5);
        chatText.setEnabled(false);
        chatScroll.setViewportView(chatText);

        userList.setModel((model = new DefaultListModel()));
        jScrollPane2.setViewportView(userList);

        messageText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        messageText.setEnabled(false);

        sendMessageButton.setBackground(new java.awt.Color(3, 92, 141));
        sendMessageButton.setForeground(new java.awt.Color(255, 255, 255));
        sendMessageButton.setText("Send Message");
        sendMessageButton.setEnabled(false);
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(3, 92, 141));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        filePathButton.setBackground(new java.awt.Color(3, 92, 141));
        filePathButton.setForeground(new java.awt.Color(255, 255, 255));
        filePathButton.setText("File Path...");
        filePathButton.setEnabled(false);
        filePathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathButtonActionPerformed(evt);
            }
        });

        sendFileButton.setBackground(new java.awt.Color(3, 92, 141));
        sendFileButton.setForeground(new java.awt.Color(255, 255, 255));
        sendFileButton.setText("Send File");
        sendFileButton.setEnabled(false);
        sendFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFileButtonActionPerformed(evt);
            }
        });

        TeamHeader.setBackground(new java.awt.Color(3, 92, 141));

        TeamLabel.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        TeamLabel.setForeground(new java.awt.Color(255, 255, 255));
        TeamLabel.setText("Team");

        javax.swing.GroupLayout TeamHeaderLayout = new javax.swing.GroupLayout(TeamHeader);
        TeamHeader.setLayout(TeamHeaderLayout);
        TeamHeaderLayout.setHorizontalGroup(
            TeamHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeamHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TeamLabel)
                .addGap(55, 55, 55))
        );
        TeamHeaderLayout.setVerticalGroup(
            TeamHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeamHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TeamLabel)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(24, 182, 210));

        TeamLabel2.setFont(new java.awt.Font("Gadugi", 0, 48)); // NOI18N
        TeamLabel2.setForeground(new java.awt.Color(255, 255, 255));
        TeamLabel2.setText("ChitterChat");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TeamLabel2)
                .addGap(362, 362, 362))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(TeamLabel2)
                .addGap(25, 25, 25))
        );

        Lists.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        ToDo.setBackground(new java.awt.Color(234, 247, 250));

        jCheckBox1.setBackground(new java.awt.Color(234, 247, 250));
        jCheckBox1.setFont(new java.awt.Font("Gadugi", 0, 13)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(3, 92, 141));
        jCheckBox1.setText("task to complete...");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(234, 247, 250));
        jCheckBox3.setFont(new java.awt.Font("Gadugi", 0, 13)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(3, 92, 141));
        jCheckBox3.setText("task to complete...");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(234, 247, 250));
        jCheckBox4.setFont(new java.awt.Font("Gadugi", 0, 13)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(3, 92, 141));
        jCheckBox4.setText("task to complete...");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        TasksLabel.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        TasksLabel.setForeground(new java.awt.Color(3, 92, 141));
        TasksLabel.setText("Tasks");

        ResourcesLabel.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        ResourcesLabel.setForeground(new java.awt.Color(3, 92, 141));
        ResourcesLabel.setText("Resources");

        ConflictLabel.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        ConflictLabel.setForeground(new java.awt.Color(3, 92, 141));
        ConflictLabel.setText("Conflicts");

        ListHeader.setBackground(new java.awt.Color(3, 92, 141));

        TeamLabel1.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        TeamLabel1.setForeground(new java.awt.Color(255, 255, 255));
        TeamLabel1.setText("To Do:");

        javax.swing.GroupLayout ListHeaderLayout = new javax.swing.GroupLayout(ListHeader);
        ListHeader.setLayout(ListHeaderLayout);
        ListHeaderLayout.setHorizontalGroup(
            ListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListHeaderLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(TeamLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListHeaderLayout.setVerticalGroup(
            ListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ListHeaderLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(TeamLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout ToDoLayout = new javax.swing.GroupLayout(ToDo);
        ToDo.setLayout(ToDoLayout);
        ToDoLayout.setHorizontalGroup(
            ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ToDoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ResourcesLabel)
                    .addComponent(TasksLabel)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConflictLabel))
                .addContainerGap())
        );
        ToDoLayout.setVerticalGroup(
            ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToDoLayout.createSequentialGroup()
                .addComponent(ListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TasksLabel)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox4)
                .addGap(18, 18, 18)
                .addComponent(ResourcesLabel)
                .addGap(18, 18, 18)
                .addComponent(ConflictLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Lists.addTab("ToDo", ToDo);

        Events.setBackground(new java.awt.Color(234, 247, 250));

        jCheckBox2.setBackground(new java.awt.Color(234, 247, 250));
        jCheckBox2.setFont(new java.awt.Font("Gadugi", 0, 13)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(3, 92, 141));
        jCheckBox2.setText("task to complete...");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox5.setBackground(new java.awt.Color(234, 247, 250));
        jCheckBox5.setFont(new java.awt.Font("Gadugi", 0, 13)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(3, 92, 141));
        jCheckBox5.setText("task to complete...");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setBackground(new java.awt.Color(234, 247, 250));
        jCheckBox6.setFont(new java.awt.Font("Gadugi", 0, 13)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(3, 92, 141));
        jCheckBox6.setText("task to complete...");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        meetings.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        meetings.setForeground(new java.awt.Color(3, 92, 141));
        meetings.setText("Meetings");

        presentations.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        presentations.setForeground(new java.awt.Color(3, 92, 141));
        presentations.setText("Presentations");

        keystone.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        keystone.setForeground(new java.awt.Color(3, 92, 141));
        keystone.setText("Keystone Dates");

        ListHeader1.setBackground(new java.awt.Color(3, 92, 141));

        TeamLabel3.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        TeamLabel3.setForeground(new java.awt.Color(255, 255, 255));
        TeamLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TeamLabel3.setText("Meetings&Events:");

        javax.swing.GroupLayout ListHeader1Layout = new javax.swing.GroupLayout(ListHeader1);
        ListHeader1.setLayout(ListHeader1Layout);
        ListHeader1Layout.setHorizontalGroup(
            ListHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListHeader1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(TeamLabel3)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        ListHeader1Layout.setVerticalGroup(
            ListHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TeamLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TeamLabel3.getAccessibleContext().setAccessibleName("Meetings&Events:");

        javax.swing.GroupLayout EventsLayout = new javax.swing.GroupLayout(Events);
        Events.setLayout(EventsLayout);
        EventsLayout.setHorizontalGroup(
            EventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EventsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presentations)
                    .addComponent(meetings)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keystone))
                .addContainerGap())
        );
        EventsLayout.setVerticalGroup(
            EventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventsLayout.createSequentialGroup()
                .addComponent(ListHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meetings)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox5)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox6)
                .addGap(18, 18, 18)
                .addComponent(presentations)
                .addGap(18, 18, 18)
                .addComponent(keystone)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        Lists.addTab("Events", Events);

        Availability.setBackground(new java.awt.Color(234, 247, 250));

        ListHeader2.setBackground(new java.awt.Color(3, 92, 141));

        TeamLabel4.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        TeamLabel4.setForeground(new java.awt.Color(255, 255, 255));
        TeamLabel4.setText("Availability");

        javax.swing.GroupLayout ListHeader2Layout = new javax.swing.GroupLayout(ListHeader2);
        ListHeader2.setLayout(ListHeader2Layout);
        ListHeader2Layout.setHorizontalGroup(
            ListHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListHeader2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(TeamLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListHeader2Layout.setVerticalGroup(
            ListHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ListHeader2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(TeamLabel4)
                .addContainerGap())
        );

        jTable1.setAutoCreateColumnsFromModel(false);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setViewportView(jTable1);

        javax.swing.GroupLayout AvailabilityLayout = new javax.swing.GroupLayout(Availability);
        Availability.setLayout(AvailabilityLayout);
        AvailabilityLayout.setHorizontalGroup(
            AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AvailabilityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AvailabilityLayout.setVerticalGroup(
            AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvailabilityLayout.createSequentialGroup()
                .addComponent(ListHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Lists.addTab("Availability", Availability);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Lists, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chatScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(messageText, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(filePathText, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filePathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sendMessageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sendFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(TeamHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addComponent(passwordText)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(messageText, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(sendMessageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filePathText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filePathButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sendFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TeamHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Lists))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        username = usernameText.getText();
        password = passwordText.getText();
        
        if(!username.isEmpty() && !password.isEmpty()){
            client.send(new Message("login", username, password, "SERVER"));
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageButtonActionPerformed
        String msg = messageText.getText();
        String target = userList.getSelectedValue().toString();
        
        if(!msg.isEmpty() && !target.isEmpty()){
            messageText.setText("");
            client.send(new Message("message", username, msg, target));

        }
    }//GEN-LAST:event_sendMessageButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        username = usernameText.getText();
        password = passwordText.getText();
        
        if(!username.isEmpty() && !password.isEmpty()){
            client.send(new Message("signup", username, password, "SERVER"));
        }
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void filePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Select File");
        file = fileChooser.getSelectedFile();
        
        if(file != null){
            if(!file.getName().isEmpty()){
                sendFileButton.setEnabled(true); String str;
                
                if(filePathText.getText().length() > 30){
                    String t = file.getPath();
                    str = t.substring(0, 20) + " [...] " + t.substring(t.length() - 20, t.length());
                }
                else{
                    str = file.getPath();
                }
                filePathText.setText(str);
            }
        }
    }//GEN-LAST:event_filePathButtonActionPerformed

    private void sendFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFileButtonActionPerformed
            long size = file.length();
            if(size < 120 * 1024 * 1024){
                client.send(new Message("upload_req", username, file.getName(), userList.getSelectedValue().toString()));
            }
            else{
                chatText.append("[Application > Me] : File is size too large\n");
            }
    }//GEN-LAST:event_sendFileButtonActionPerformed

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextActionPerformed

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed
    public void RetryStart(int port){
        if(server != null){ server.stop(); }
        //server = new SocketServer(this, port);
    }
    
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception ex){
            System.out.println("Look & Feel exception");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Availability;
    private javax.swing.JLabel ConflictLabel;
    private javax.swing.JPanel Events;
    private javax.swing.JPanel ListHeader;
    private javax.swing.JPanel ListHeader1;
    private javax.swing.JPanel ListHeader2;
    private javax.swing.JTabbedPane Lists;
    private javax.swing.JLabel ResourcesLabel;
    private javax.swing.JLabel TasksLabel;
    private javax.swing.JPanel TeamHeader;
    private javax.swing.JLabel TeamLabel;
    private javax.swing.JLabel TeamLabel1;
    private javax.swing.JLabel TeamLabel2;
    private javax.swing.JLabel TeamLabel3;
    private javax.swing.JLabel TeamLabel4;
    private javax.swing.JPanel ToDo;
    private javax.swing.JScrollPane chatScroll;
    public javax.swing.JTextArea chatText;
    public javax.swing.JButton filePathButton;
    public javax.swing.JTextField filePathText;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel keystone;
    public javax.swing.JButton loginButton;
    private javax.swing.JLabel meetings;
    public javax.swing.JTextField messageText;
    private javax.swing.JLabel passwordLabel;
    public javax.swing.JPasswordField passwordText;
    private javax.swing.JLabel presentations;
    public javax.swing.JButton sendFileButton;
    public javax.swing.JButton sendMessageButton;
    public javax.swing.JButton signUpButton;
    private javax.swing.JScrollPane table;
    public javax.swing.JList userList;
    private javax.swing.JLabel usernameLabel;
    public javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
