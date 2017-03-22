package javaapplication1;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.BOTTOM;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultCaret;
import javax.swing.text.TableView.TableCell;
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jMenu1 = new javax.swing.JMenu();
        create = new javax.swing.JDialog();
        input = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        task = new javax.swing.JCheckBox();
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
        ListHeader = new javax.swing.JPanel();
        TeamLabel1 = new javax.swing.JLabel();
        TasksLabel = new javax.swing.JLabel();
        taskAdd = new javax.swing.JButton();
        ResourcesLabel = new javax.swing.JLabel();
        resourceAdd = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jCheckBox1 = new javax.swing.JCheckBox();
        ConflictLabel = new javax.swing.JLabel();
        conflictAdd = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        taskList = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        Events = new javax.swing.JPanel();
        meetings = new javax.swing.JLabel();
        presentations = new javax.swing.JLabel();
        keystone = new javax.swing.JLabel();
        ListHeader1 = new javax.swing.JPanel();
        TeamLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Availability = new javax.swing.JPanel();
        ListHeader2 = new javax.swing.JPanel();
        TeamLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jMenu1.setText("jMenu1");

        create.setTitle("Add Task");
        create.setAlwaysOnTop(true);
        create.setForeground(java.awt.Color.lightGray);
        create.setLocation(new java.awt.Point(150, 150));
        create.setLocationByPlatform(true);
        create.setResizable(false);
        create.setSize(new java.awt.Dimension(400, 200));
        create.setType(java.awt.Window.Type.POPUP);

        input.setText("jTextField1");
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createLayout = new javax.swing.GroupLayout(create.getContentPane());
        create.getContentPane().setLayout(createLayout);
        createLayout.setHorizontalGroup(
            createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(20, 20, 20))
        );
        createLayout.setVerticalGroup(
            createLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        task.setText("jCheckBox3");
        task.setOpaque(true);
        task.getAccessibleContext().setAccessibleParent(taskList);

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
        Lists.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ListsStateChanged(evt);
            }
        });

        ToDo.setBackground(new java.awt.Color(234, 247, 250));
        ToDo.setAutoscrolls(true);

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
                .addContainerGap(120, Short.MAX_VALUE))
        );
        ListHeaderLayout.setVerticalGroup(
            ListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ListHeaderLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(TeamLabel1)
                .addContainerGap())
        );

        TasksLabel.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        TasksLabel.setForeground(new java.awt.Color(3, 92, 141));
        TasksLabel.setText("Tasks");

        taskAdd.setText("+");
        taskAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskAddActionPerformed(evt);
            }
        });

        ResourcesLabel.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        ResourcesLabel.setForeground(new java.awt.Color(3, 92, 141));
        ResourcesLabel.setText("Resources");

        resourceAdd.setText("+");
        resourceAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resourceAddActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(234, 247, 250));
        jCheckBox1.setFont(new java.awt.Font("Gadugi", 0, 13)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(3, 92, 141));
        jCheckBox1.setText("task to complete...");
        jCheckBox1.setAutoscrolls(true);
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jScrollPane4.setViewportView(jCheckBox1);

        ConflictLabel.setFont(new java.awt.Font("Gadugi", 0, 18)); // NOI18N
        ConflictLabel.setForeground(new java.awt.Color(3, 92, 141));
        ConflictLabel.setText("Conflicts");

        conflictAdd.setText("+");

        taskList.setAutoscrolls(true);
        taskList.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                taskListComponentAdded(evt);
            }
        });

        jCheckBox2.setText("jCheckBox2");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout taskListLayout = new javax.swing.GroupLayout(taskList);
        taskList.setLayout(taskListLayout);
        taskListLayout.setHorizontalGroup(
            taskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        taskListLayout.setVerticalGroup(
            taskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox2)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ToDoLayout = new javax.swing.GroupLayout(ToDo);
        ToDo.setLayout(ToDoLayout);
        ToDoLayout.setHorizontalGroup(
            ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ToDoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ToDoLayout.createSequentialGroup()
                        .addComponent(ConflictLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conflictAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ToDoLayout.createSequentialGroup()
                        .addComponent(TasksLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(taskAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ToDoLayout.createSequentialGroup()
                        .addComponent(ResourcesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resourceAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ToDoLayout.setVerticalGroup(
            ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToDoLayout.createSequentialGroup()
                .addComponent(ListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TasksLabel)
                    .addComponent(taskAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(taskList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResourcesLabel)
                    .addComponent(resourceAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ToDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConflictLabel)
                    .addComponent(conflictAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        Lists.addTab("ToDo", ToDo);

        Events.setBackground(new java.awt.Color(234, 247, 250));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListHeader1Layout.setVerticalGroup(
            ListHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TeamLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Meeting 1 @ 3/30, 1930 in CSE 119");

        jLabel2.setText("Meeting 2 @ 4/01, 1500 in Dungeon");

        jLabel3.setText("Meeting 3 @ 4/04, 1230 in Marston Newton");

        javax.swing.GroupLayout EventsLayout = new javax.swing.GroupLayout(Events);
        Events.setLayout(EventsLayout);
        EventsLayout.setHorizontalGroup(
            EventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EventsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(presentations, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meetings, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keystone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        EventsLayout.setVerticalGroup(
            EventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EventsLayout.createSequentialGroup()
                .addComponent(ListHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meetings)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addComponent(presentations)
                .addGap(18, 18, 18)
                .addComponent(keystone)
                .addContainerGap(288, Short.MAX_VALUE))
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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1200", "0", "0", "0", "0", "0", "0", "0"},
                {"1230", "0", "0", "0", "0", "0", "0", "0"},
                {"1300", "0", "0", "0", "0", "0", "0", "0"},
                {"1330", "0", "0", "0", "0", "0", "0", "0"},
                {"1400", "0", "0", "0", "0", "0", "0", "0"},
                {"1430", "0", "0", "0", "0", "0", "0", "0"},
                {"1500", "0", "0", "0", "0", "0", "0", "0"},
                {"1530", "0", "0", "0", "0", "0", "0", "0"},
                {"1600", "0", "0", "0", "0", "0", "0", "0"},
                {"1630", "0", "0", "0", "0", "0", "0", "0"},
                {"1700", "0", "0", "0", "0", "0", "0", "0"},
                {"1730", "0", "0", "0", "0", "0", "0", "0"},
                {"1800", "0", "0", "0", "0", "0", "0", "0"},
                {"1830", "0", "0", "0", "0", "0", "0", "0"},
                {"1900", "0", "0", "0", "0", "0", "0", "0"},
                {"1930", "0", "0", "0", "0", "0", "0", "0"},
                {"2000", "0", "0", "0", "0", "0", "0", "0"},
                {"2030", "0", "0", "0", "0", "0", "0", "0"},
                {"2100", "0", "0", "0", "0", "0", "0", "0"},
                {"2130", "0", "0", "0", "0", "0", "0", "0"}
            },
            new String [] {
                "Time", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun"
            }
        ));
        jTable2.setCellSelectionEnabled(true);
        jTable2.setDragEnabled(true);
        jTable2.setGridColor(new java.awt.Color(51, 51, 51));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable2.setShowGrid(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable2, org.jdesktop.beansbinding.ELProperty.create("${selectedElement}"), jTable2, org.jdesktop.beansbinding.BeanProperty.create("selectedElements"));
        bindingGroup.addBinding(binding);

        jTable2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTable2MouseDragged(evt);
            }
        });
        jTable2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable2FocusGained(evt);
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable2InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jTable2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable2PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout AvailabilityLayout = new javax.swing.GroupLayout(Availability);
        Availability.setLayout(AvailabilityLayout);
        AvailabilityLayout.setHorizontalGroup(
            AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ListHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AvailabilityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AvailabilityLayout.setVerticalGroup(
            AvailabilityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvailabilityLayout.createSequentialGroup()
                .addComponent(ListHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
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

        bindingGroup.bind();

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

    private void jTable2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2PropertyChange

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseDragged

    private void jTable2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable2InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2InputMethodTextChanged

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        for(int i = 1; i < jTable2.getRowCount(); i++){
            for(int j = 0; j < jTable2.getColumnCount(); j++){
                if(jTable2.isCellSelected(i, j)){
                    Object val = jTable2.getValueAt(i, j);
                    if( val.equals(1)){
                        val = 0;
                    }
                    else{
                        val = 1;
                    }
                    jTable2.setValueAt(val, i, j);
                }
            }
        }
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2FocusGained

    private void resourceAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resourceAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resourceAddActionPerformed

    private void taskAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskAddActionPerformed
        // TODO add your handling code here:
        create.setVisible(true);
    }//GEN-LAST:event_taskAddActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed
        JCheckBox task2= new JCheckBox();
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        task = new JCheckBox();
        task.setText(input.getText()); 
        create.setVisible(false);
        //task.setVisible(true);
        taskList.add(task);
    }//GEN-LAST:event_submitActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void taskListComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_taskListComponentAdded
        // TODO add your handling code here:
       // taskList.isAncestorOf(task);
       // taskList.add(task);
    }//GEN-LAST:event_taskListComponentAdded

    private void ListsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ListsStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ListsStateChanged
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
    private javax.swing.JButton conflictAdd;
    private javax.swing.JDialog create;
    public javax.swing.JButton filePathButton;
    public javax.swing.JTextField filePathText;
    private javax.swing.JTextField input;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel keystone;
    public javax.swing.JButton loginButton;
    private javax.swing.JLabel meetings;
    public javax.swing.JTextField messageText;
    private javax.swing.JLabel passwordLabel;
    public javax.swing.JPasswordField passwordText;
    private javax.swing.JLabel presentations;
    private javax.swing.JButton resourceAdd;
    public javax.swing.JButton sendFileButton;
    public javax.swing.JButton sendMessageButton;
    public javax.swing.JButton signUpButton;
    private javax.swing.JButton submit;
    private javax.swing.JCheckBox task;
    private javax.swing.JButton taskAdd;
    private javax.swing.JPanel taskList;
    public javax.swing.JList userList;
    private javax.swing.JLabel usernameLabel;
    public javax.swing.JTextField usernameText;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
