package chat_client1;

import java.net.*;
import java.io.*;
import java.util.*;

public class Frame_clientside extends javax.swing.JFrame {

    String Clientname, address = "localhost";
    ArrayList<String> clients = new ArrayList();
    int port_number = 1111;
    Boolean isConnected = false;
    
    Socket S;
    BufferedReader reader;
    PrintWriter writer;
    
    //XXXXXXXXXXXXXXXXXXXXXXXXX//
    
    public void ListenThread()
    {
       Thread IncomingReader = new Thread(new IncomingReader());
       IncomingReader.start();
    }
    
    //XXXXXXXXXXXXXXXXXXXXXXXX//
    
    public void clientAdd(String data){
        clients.add(data);
    }
    
    //XXXXXXXXXXXXXXXXXXXXXXX//
    
    public void clientRemove(String data)
    {
        ta_chat.append(data + "is not online");
    }
    //XXXXXXXXXXXXXXXXXXXXXXXX//
    
    public void writeclients(){
        String[] temperoryList = new String[(clients.size())];
        clients.toArray(temperoryList);
        for (String token: temperoryList)
        {
         //clients.append(token + "\n");   
        }
    }
    //XXXXXXXXXXXXXXXXXXXXXXX//
    
    public void send_Disconnect(){
        String bye = (Clientname + ": :Disconnect");
        {
            try{
                writer.println(bye);
                writer.flush();
               }catch(Exception ex)
               {
                ta_chat.append("Cloud has not sent disconnect message. \n");
               }
    }
        
        //XXXXXXXXXXXXXXXXXXXXXXXX//
    
    /**
     *
     */
    }
    public void Disconnect()
    {
        try
        {
            ta_chat.append("Client is Disconnected. \n");
            S.close();
        }catch(Exception e)
        {
            ta_chat.append("Failed to disconnect the client. \n");
        }
        isConnected = false;
        tz_clientname.setEditable(true);
        }
   
public Frame_clientside() {
        initComponents();
    }
//XXXXXXXXXXXXXXXXXXXXXXXXXXX//

    public class IncomingReader implements Runnable
    {
       @Override
       public void run()
       {
        String[] dataset;
        String stream, done ="Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";
        
        try
        {
            while((stream = reader.readLine()) != null)
            {
                dataset = stream.split(":");
                if (dataset[2].equals(chat))
                {
                   ta_chat.append(dataset[0] + ":" +dataset[1] + "\n");
                   ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
                }
                else if (dataset[2].equals(connect))
                {
                    ta_chat.removeAll();
                    clientAdd(dataset[0]);
                }
                else if (dataset[2].equals(disconnect))
                {
                    clientRemove(dataset[0]);
                }
                    //clients.setText("");
                    writeclients();
                    clients.clear();
                }
                
            }catch(Exception e) {}
    
        }
    }
    //XXXXXXXXXXXXXXXXXXXXXXXX//
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connect_client = new javax.swing.JButton();
        client_port = new javax.swing.JLabel();
        disconnect_client = new javax.swing.JButton();
        tz_portnumber = new javax.swing.JTextField();
        client_name = new javax.swing.JLabel();
        client_address = new javax.swing.JLabel();
        tz_chat = new javax.swing.JTextField();
        annonymous_client = new javax.swing.JButton();
        message_send = new javax.swing.JButton();
        tz_password = new javax.swing.JTextField();
        tz_clientname = new javax.swing.JTextField();
        client_password = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();
        tz_address = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        connect_client.setBackground(new java.awt.Color(0, 255, 255));
        connect_client.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        connect_client.setForeground(new java.awt.Color(204, 0, 0));
        connect_client.setText("Connect");
        connect_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connect_clientActionPerformed(evt);
            }
        });

        client_port.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        client_port.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        client_port.setText("Port number");

        disconnect_client.setBackground(new java.awt.Color(0, 255, 255));
        disconnect_client.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        disconnect_client.setForeground(new java.awt.Color(204, 0, 51));
        disconnect_client.setText("Disconnect");
        disconnect_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnect_clientActionPerformed(evt);
            }
        });

        tz_portnumber.setText("1111");
        tz_portnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tz_portnumberActionPerformed(evt);
            }
        });

        client_name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        client_name.setText("Clientname");

        client_address.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        client_address.setText("Address");

        tz_chat.setBackground(new java.awt.Color(102, 255, 255));

        annonymous_client.setBackground(new java.awt.Color(0, 255, 255));
        annonymous_client.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        annonymous_client.setForeground(new java.awt.Color(204, 0, 0));
        annonymous_client.setText("Anonymous login");
        annonymous_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annonymous_clientActionPerformed(evt);
            }
        });

        message_send.setBackground(new java.awt.Color(0, 255, 255));
        message_send.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        message_send.setForeground(new java.awt.Color(204, 0, 51));
        message_send.setText("Send");
        message_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message_sendActionPerformed(evt);
            }
        });

        tz_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tz_passwordActionPerformed(evt);
            }
        });

        tz_clientname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tz_clientnameActionPerformed(evt);
            }
        });

        client_password.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        client_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        client_password.setText("Password");

        ta_chat.setBackground(new java.awt.Color(102, 255, 255));
        ta_chat.setColumns(20);
        ta_chat.setRows(5);
        jScrollPane1.setViewportView(ta_chat);

        tz_address.setText("localhost");

        jTextField1.setBackground(new java.awt.Color(0, 255, 255));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("CLIENT");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tz_chat)
                        .addGap(18, 18, 18)
                        .addComponent(message_send, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(annonymous_client, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(client_address)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tz_address, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(client_name)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(tz_clientname, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(client_port)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tz_portnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(connect_client, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(disconnect_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addComponent(client_password)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tz_password, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(client_password, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tz_address, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(client_address)
                        .addComponent(client_name)
                        .addComponent(tz_clientname)
                        .addComponent(client_port)
                        .addComponent(tz_portnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tz_password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connect_client)
                    .addComponent(disconnect_client)
                    .addComponent(annonymous_client))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tz_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(message_send, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connect_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connect_clientActionPerformed
        if(isConnected == false)
        {
            Clientname = tz_clientname.getText();
            tz_clientname.setEditable(false);
            
            try
            {
                    S = new Socket(address, port_number);
                    InputStreamReader streamreader = new InputStreamReader(S.getInputStream());
                    reader = new BufferedReader(streamreader);
                    writer = new PrintWriter(S.getOutputStream());
                    writer.println(Clientname + ":the client is connected: client");
                    writer.flush();
                    isConnected = true;
            }
             catch(Exception e)
             {
                 ta_chat.append("Cannot connect to the server at this moment! Please try again later!! \n");
                 tz_clientname.setEditable(true);
             }
            ListenThread();
            
        } else if (isConnected == true)
        {
                ta_chat.append("You are already connected to the server. \n");
        }
    }//GEN-LAST:event_connect_clientActionPerformed

    private void disconnect_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnect_clientActionPerformed
        send_Disconnect();
        Disconnect();
    }//GEN-LAST:event_disconnect_clientActionPerformed

    private void tz_portnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tz_portnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tz_portnumberActionPerformed

    private void annonymous_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annonymous_clientActionPerformed
        tz_clientname.setText("");
        if(isConnected == false)
        {
            String anon="anon";
            Random generator = new Random();
            int j = generator.nextInt(1000) +1;
            String is=String.valueOf(j);
            anon=anon.concat(is);
            Clientname = anon;
            
            tz_clientname.setText(anon);
            tz_clientname.setEditable(false);
            
            try
            {
                S = new Socket(address, port_number);
                InputStreamReader streamreader = new InputStreamReader(S.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(S.getOutputStream());
                writer.println(anon + "the client is conected to the server: connect");
                writer.flush();
                isConnected = true;
            } catch(Exception e)
            {
                ta_chat.append("Cannot connect to the server. Try again later!! \n");
                tz_clientname.setEditable(true);
            }
            ListenThread();    
        } else if (isConnected == true)
        {
          ta_chat.append("You are alreday connected to the server. \n");
        }
    }//GEN-LAST:event_annonymous_clientActionPerformed

    private void message_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message_sendActionPerformed
       String nothing_Found = "";
       if((tz_chat.getText()).equals(nothing_Found)){
           tz_chat.setText("");
           tz_chat.requestFocus();
       }
       else{
           try
           {
               writer.println(Clientname + ":" + tz_chat.getText() + ":" + "Chat");
               writer.flush(); // this command will flush the buffer.
           } catch(Exception e){
               ta_chat.append("Failed to send the message! \n");
           }
           tz_chat.setText("");
           tz_chat.requestFocus();
    }
        tz_chat.setText("");
        tz_chat.requestFocus();
       
    }//GEN-LAST:event_message_sendActionPerformed

    private void tz_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tz_passwordActionPerformed
       
    }//GEN-LAST:event_tz_passwordActionPerformed

    private void tz_clientnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tz_clientnameActionPerformed
        
    }//GEN-LAST:event_tz_clientnameActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new Frame_clientside().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annonymous_client;
    private javax.swing.JLabel client_address;
    private javax.swing.JLabel client_name;
    private javax.swing.JLabel client_password;
    private javax.swing.JLabel client_port;
    private javax.swing.JButton connect_client;
    private javax.swing.JButton disconnect_client;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton message_send;
    private javax.swing.JTextArea ta_chat;
    private javax.swing.JTextField tz_address;
    private javax.swing.JTextField tz_chat;
    private javax.swing.JTextField tz_clientname;
    private javax.swing.JTextField tz_password;
    private javax.swing.JTextField tz_portnumber;
    // End of variables declaration//GEN-END:variables
}
