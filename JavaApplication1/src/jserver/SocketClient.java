package jserver;

import javaapplication1.ChatFrame;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SocketClient implements Runnable{
    
    public int port;
    public String serverAddr;
    public Socket socket;
    public ChatFrame ui;
    public ObjectInputStream In;
    public ObjectOutputStream Out;
    public History hist;
    
    public SocketClient(ChatFrame frame) throws IOException{
        ui = frame;
       /* socket = new Socket(InetAddress.getByName(serverAddr), port);
            
        Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
        */
        hist = ui.hist;
    }

    public void reconnect(DatagramPacket receivePacket){
        try {
            socket = new Socket( receivePacket.getAddress(),receivePacket.getPort());
            Out = new ObjectOutputStream(socket.getOutputStream());
            Out.flush();
            In = new ObjectInputStream(socket.getInputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    
    
    
    @Override
    public void run() {
        boolean keepRunning = true;
        boolean connecting = true;
        
        while(connecting){
        // Find the server using UDP broadcast

try {

    //Open a random port to send the package
    DatagramSocket c = new DatagramSocket();

    c.setBroadcast(true);

  byte[] sendData = "CONNECT_REQUEST".getBytes();

  //Try the 255.255.255.255 first

  try {

    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("255.255.255.255"), 13000);

    c.send(sendPacket);

    System.out.println(getClass().getName() + ">>> Request packet sent to: 255.255.255.255 (DEFAULT)");

  } catch (Exception e) {

  }

 

  // Broadcast the message over all the network interfaces

  Enumeration interfaces = NetworkInterface.getNetworkInterfaces();

  while (interfaces.hasMoreElements()) {

    NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();

    if (networkInterface.isLoopback() || !networkInterface.isUp()) {

      continue; // Don't want to broadcast to the loopback interface

    }

    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {

      InetAddress broadcast = interfaceAddress.getBroadcast();

      if (broadcast == null) {

        continue;

      }

      // Send the broadcast package!

      try {

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, broadcast, 13000);

        c.send(sendPacket);

      } catch (Exception e) {

      }

 

      System.out.println(getClass().getName() + ">>> Request packet sent to: " + broadcast.getHostAddress() + "; Interface: " + networkInterface.getDisplayName());

    }

  }

 

  System.out.println(getClass().getName() + ">>> Done looping over all network interfaces. Now waiting for a reply!");

  //Wait for a response

  byte[] recvBuf = new byte[15000];

  DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);

  c.receive(receivePacket);

 

  //We have a response

  System.out.println(getClass().getName() + ">>> Broadcast response from server: " + receivePacket.getAddress().getHostAddress());

 

  //Check if the message is correct
  String message = new String(receivePacket.getData()).trim();

  if (message.equals("ALLOW_CONNECTION")) {

    //DO SOMETHING WITH THE SERVER'S IP (for example, store it in your controller)
    connecting = false;
    reconnect(receivePacket);

  }

 

  //Close the port!

  c.close();

} catch (IOException ex) {

 // Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);

}
           
}
        
        while(keepRunning){
            try {
                Message msg = (Message) In.readObject();
                System.out.println("Incoming : "+msg.toString());
                
                if(msg.type.equals("message")){
                    if(msg.recipient.equals(ui.username)){
                        ui.chatText.append("["+msg.sender +" > Me] : " + msg.content + "\n");
                    }
                    else{
                        ui.chatText.append("["+ msg.sender +" > "+ msg.recipient +"] : " + msg.content + "\n");
                    }
                                            
                    if(!msg.content.equals(".bye") && !msg.sender.equals(ui.username)){
                        String msgTime = (new Date()).toString();
                        
                        try{
                            hist.addMessage(msg, msgTime);
                            DefaultTableModel table = (DefaultTableModel) ui.historyFrame.jTable1.getModel();
                            table.addRow(new Object[]{msg.sender, msg.content, "Me", msgTime});
                        }
                        catch(Exception ex){}  
                    }
                }
                else if(msg.type.equals("login")){
                    if(msg.content.equals("TRUE")){
                        ui.loginButton.setEnabled(false); ui.signUpButton.setEnabled(false);                        
                        ui.chatText.append("\n[SERVER > Me] : Login Successful\n*\n*\n*\n*\n*\nBegin Chatting:\n");
                        ui.usernameText.setEnabled(false); ui.passwordText.setEnabled(false);
                        
                    
                    ui.chatText.setEnabled(true); ui.messageText.setEnabled(true);
                    ui.userList.setEnabled(true); ui.sendMessageButton.setEnabled(true);
                    ui.filePathText.setEnabled(true); ui.filePathButton.setEnabled(true);
                    ui.sendFileButton.setEnabled(true);
                    
                    ui.chatText.setEditable(false);
                    }
                    else{
                        ui.chatText.append("\n[SERVER > Me] : Login Failed\n");
                    }
                }
                else if(msg.type.equals("test")){
                    //ui.jButton1.setEnabled(false);
                    ui.loginButton.setEnabled(true); ui.signUpButton.setEnabled(true);
                    ui.usernameText.setEnabled(true); ui.passwordText.setEnabled(true);
                    
                    ui.chatText.setEnabled(false); ui.messageText.setEnabled(false);
                    ui.userList.setEnabled(false); ui.sendMessageButton.setEnabled(false);
                    ui.filePathText.setEnabled(false); ui.filePathButton.setEnabled(false);
                    ui.sendFileButton.setEnabled(false);
                    
                }
                else if(msg.type.equals("newuser")){
                    if(!msg.content.equals(ui.username)){
                        boolean exists = false;
                        for(int i = 0; i < ui.model.getSize(); i++){
                            if(ui.model.getElementAt(i).equals(msg.content)){
                                exists = true; break;
                            }
                        }
                        if(!exists){ ui.model.addElement(msg.content); }
                    }
                }
                else if(msg.type.equals("signup")){
                    if(msg.content.equals("TRUE")){
                        ui.loginButton.setEnabled(false); ui.signUpButton.setEnabled(false);
                        ui.sendMessageButton.setEnabled(true); ui.filePathButton.setEnabled(true);
                        ui.chatText.append("[SERVER > Me] : Signup Successful\n");
                    }
                    else{
                        ui.chatText.append("[SERVER > Me] : Signup Failed\n");
                    }
                }
                else if(msg.type.equals("signout")){
                    if(msg.content.equals(ui.username)){
                        ui.chatText.append("["+ msg.sender +" > Me] : Bye\n");
                        //ui.jButton1.setEnabled(true); ui.jButton4.setEnabled(false); 
                        //ui.jTextField1.setEditable(true); ui.jTextField2.setEditable(true);
                        
                        for(int i = 1; i < ui.model.size(); i++){
                            ui.model.removeElementAt(i);
                        }
                        
                        ui.clientThread.stop();
                    }
                    else{
                        ui.model.removeElement(msg.content);
                        ui.chatText.append("["+ msg.sender +" > All] : "+ msg.content +" has signed out\n");
                    }
                }
                else if(msg.type.equals("upload_req")){
                    
                    if(JOptionPane.showConfirmDialog(ui, ("Accept '"+msg.content+"' from "+msg.sender+" ?")) == 0){
                        
                        JFileChooser jf = new JFileChooser();
                        jf.setSelectedFile(new File(msg.content));
                        int returnVal = jf.showSaveDialog(ui);
                       
                        String saveTo = jf.getSelectedFile().getPath();
                        if(saveTo != null && returnVal == JFileChooser.APPROVE_OPTION){
                            Download dwn = new Download(saveTo, ui);
                            Thread t = new Thread(dwn);
                            t.start();
                            //send(new Message("upload_res", (""+InetAddress.getLocalHost().getHostAddress()), (""+dwn.port), msg.sender));
                            send(new Message("upload_res", ui.username, (""+dwn.port), msg.sender));
                        }
                        else{
                            send(new Message("upload_res", ui.username, "NO", msg.sender));
                        }
                    }
                    else{
                        send(new Message("upload_res", ui.username, "NO", msg.sender));
                    }
                }
                else if(msg.type.equals("upload_res")){
                    if(!msg.content.equals("NO")){
                        int port  = Integer.parseInt(msg.content);
                        String addr = msg.sender;
                        
                        ui.filePathButton.setEnabled(false); ui.sendFileButton.setEnabled(false);
                        Upload upl = new Upload(addr, port, ui.file, ui);
                        Thread t = new Thread(upl);
                        t.start();
                    }
                    else{
                        ui.chatText.append("[SERVER > Me] : "+msg.sender+" rejected file request\n");
                    }
                }
                else{
                    ui.chatText.append("[SERVER > Me] : Unknown message type\n");
                }
            }
            catch(Exception ex) {
                keepRunning = false;
                ui.chatText.append("[Application > Me] : Connection Failure\n");
                //ui.jButton1.setEnabled(true); ui.jTextField1.setEditable(true); ui.jTextField2.setEditable(true);
                ui.sendMessageButton.setEnabled(false); ui.filePathButton.setEnabled(false); ui.filePathButton.setEnabled(false);
                
                for(int i = 1; i < ui.model.size(); i++){
                    ui.model.removeElementAt(i);
                }
                
                ui.clientThread.stop();
                
                System.out.println("Exception SocketClient run()");
                ex.printStackTrace();
            }
        }
    }
    
    public void send(Message msg){
        try {
            Out.writeObject(msg);
            Out.flush();
            System.out.println("Outgoing : "+msg.toString());
            
            if(msg.type.equals("message") && !msg.content.equals(".bye")){
                String msgTime = (new Date()).toString();
                try{
                    hist.addMessage(msg, msgTime);               
                    DefaultTableModel table = (DefaultTableModel) ui.historyFrame.jTable1.getModel();
                    table.addRow(new Object[]{"Me", msg.content, msg.recipient, msgTime});
                }
                catch(Exception ex){}
            }
        } 
        catch (IOException ex) {
            System.out.println("Exception SocketClient send()");
        }
    }
    
    public void closeThread(Thread t){
        t = null;
    }
}
