package server_chat1;

/**
 *
 * @author Bhagyashree Gawade
 */
import java.io.*;
import java.net.*;
import java.util.*;
//import javax.swing.*;

public class Frame_server extends javax.swing.JFrame {

   
        ArrayList clientOutputStreams;
        ArrayList<String> users;   
        
    public class ClientHandler implements Runnable
        {
            BufferedReader reader;
            Socket S;
            PrintWriter client;
            
        public ClientHandler(Socket clientSocket, PrintWriter user)
        {
            client = user;
            try
            {
                S = clientSocket;
                InputStreamReader isReader = new InputStreamReader(S.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch(Exception e)
            {
                ta_chat.append("Unexpected error. . . \n");
            }
        }  
    
    /**
     * Creates new form Frame_server
     */
    @Override
        public void run()
        {
           String message, chat = "Chat", connect = "Connect", disconnect = "Disconnect";
           String[] dataset;
           
           try
           {
               while ((message = reader.readLine()) != null)
               {
                   ta_chat.append("recieved: " + message + "\n");
                   dataset = message.split(":");
                   
                   for(String token:dataset)
                   {
                       ta_chat.append(token + "\n");
                   }      
                   if (dataset[2].equals(connect))
                   {
                       tellEveryone((dataset[0] + ":" + dataset[1] +":" + chat));
                   }
                   else if (dataset[2].equals(disconnect))
                   {
                       tellEveryone((dataset[0] + ":is disconnected" + ":" + chat));
                       clientRemove(dataset[0]);
                   }   
                   else if (dataset[2].equals(chat))
                   {
                       tellEveryone(message);
                   }
                   else
                   {
                       ta_chat.append("the conditions are not met. \n");
                   }
               }
           }
           catch(Exception e)
           {
               ta_chat.append("Lost a connection! \n");
               e.printStackTrace();
               clientOutputStreams.remove(client);
           }
        }
    }
        
    public Frame_server() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();
        server_start = new javax.swing.JButton();
        server_stop = new javax.swing.JButton();
        server_client = new javax.swing.JButton();
        server_clear = new javax.swing.JButton();
        CLIENT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));

        ta_chat.setBackground(new java.awt.Color(204, 255, 255));
        ta_chat.setColumns(20);
        ta_chat.setForeground(new java.awt.Color(153, 255, 255));
        ta_chat.setRows(5);
        ta_chat.setSelectionColor(new java.awt.Color(51, 255, 255));
        jScrollPane1.setViewportView(ta_chat);

        server_start.setBackground(new java.awt.Color(0, 255, 255));
        server_start.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        server_start.setForeground(new java.awt.Color(204, 0, 102));
        server_start.setText("Start");
        server_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_startActionPerformed(evt);
            }
        });

        server_stop.setBackground(new java.awt.Color(51, 255, 255));
        server_stop.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        server_stop.setForeground(new java.awt.Color(204, 0, 102));
        server_stop.setText("Stop");
        server_stop.setOpaque(false);
        server_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_stopActionPerformed(evt);
            }
        });

        server_client.setBackground(new java.awt.Color(0, 255, 255));
        server_client.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        server_client.setForeground(new java.awt.Color(204, 0, 102));
        server_client.setText("Online Clients");
        server_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_clientActionPerformed(evt);
            }
        });

        server_clear.setBackground(new java.awt.Color(0, 255, 255));
        server_clear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        server_clear.setForeground(new java.awt.Color(204, 0, 102));
        server_clear.setText("Clear");
        server_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_clearActionPerformed(evt);
            }
        });

        CLIENT.setBackground(new java.awt.Color(0, 255, 255));
        CLIENT.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CLIENT.setText("SERVER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(198, 198, 198)
                                    .addComponent(CLIENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(server_start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(115, 115, 115)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(server_client, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(server_stop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(server_clear, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CLIENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(server_start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(server_stop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(server_client)
                            .addComponent(server_clear))
                        .addGap(21, 21, 21)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void server_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_clientActionPerformed
       ta_chat.append("\n Online clients: \n");
       for (String current_user : users)
       {
           ta_chat.append(current_user);
           ta_chat.append("\n");
       }
    }//GEN-LAST:event_server_clientActionPerformed

    private void server_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_stopActionPerformed
       try
       {
           Thread.sleep(5000);    //5000 milliseconds is five second.
       }
       catch(InterruptedException e) { Thread.currentThread().interrupt();}
       
       tellEveryone("Server: All users will be disconnected because the server is stopping. \n");
       ta_chat.append("Server stopping . . .  \n");
       
       ta_chat.setText("");
    
    }//GEN-LAST:event_server_stopActionPerformed

    private void server_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_clearActionPerformed
       ta_chat.setText("");
    }//GEN-LAST:event_server_clearActionPerformed

    private void server_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_startActionPerformed
        Thread starter = new Thread(new ServerStart());
        starter.start();
        
        ta_chat.append("Server has started!! \n");
    }//GEN-LAST:event_server_startActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new Frame_server().setVisible(true);
            }
        });
    }
    
    public class ServerStart implements Runnable
    {
        @Override
        public void run()
        {
            clientOutputStreams = new ArrayList();
            users = new ArrayList();
            
            try
            {
                ServerSocket serverS = new ServerSocket(1111);
                
                while (true)
                {
                                 Socket clientS = serverS.accept();
                                 PrintWriter writer = new PrintWriter(clientS.getOutputStream());
                                 clientOutputStreams.add(writer);
                                 
                                 Thread listener = new Thread(new ClientHandler(clientS, writer));
                                 listener.start();
                                 ta_chat.append("Got a connection. \n");
                }
            } catch(Exception e)
            {
                ta_chat.append("There is an error in creating a connection.\n");
            }      
        }
    }
    
    public void clientAdd (String dataset)
           
    {
        String message, add = ": :Connect", done = "Server: :Done", name= dataset;
        ta_chat.append("Before " + name + "added. \n");
        users.add(name);
        ta_chat.append("After " + name + " added. \n");
        String[] temperoryList = new String[(users.size())];
        users.toArray(temperoryList);
        
        
        for(String token: temperoryList)
        {
            message =(token +add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    
    public void clientRemove(String dataset)
    {
        String message, add =" : :Connect", done = "Server: :Done",name =dataset;
        users.remove(name);
        String[] temperoryList = new String[(users.size())];
        users.toArray(temperoryList);
        for(String token: temperoryList)
                {
                    message = (token + add);
                    tellEveryone(message);
                }
                tellEveryone(done);
            }
        
    public void tellEveryone(String message)
    {
        Iterator it = clientOutputStreams.iterator();
        
        while(it.hasNext())
        {
            try
            {
                PrintWriter writer =(PrintWriter) it.next();
                writer.println(message);
                ta_chat.append("Sending message to the client: " + message + "\n");
                writer.flush();
                ta_chat.setCaretPosition(ta_chat.getDocument().getLength());            
        } 
        catch (Exception e)
                {
                ta_chat.append("Error!! \n");
                }
            }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CLIENT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton server_clear;
    private javax.swing.JButton server_client;
    private javax.swing.JButton server_start;
    private javax.swing.JButton server_stop;
    private javax.swing.JTextArea ta_chat;
    // End of variables declaration//GEN-END:variables
}
