package com.oracle.java.advance.t10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ChatClient extends  JFrame{
    private Socket client;
    private BufferedWriter  writer;
    private BufferedReader reader;
    private JScrollPane editPanel,messagePanel;
    private JTextArea edit,message;
    private JButton  send,close;
    public ChatClient(){
        setSize(300,600);
        this.setLocationRelativeTo(null);
        this.setTitle("聊天软件");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        try {
            client=new Socket("172.19.22.141",9988);
            reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            new Thread(){
                @Override
                public void run() {
                    while(true){
                        try {
                            String message= reader.readLine();
                            edit.append(new Date().toLocaleString()+"   "+message+"\r\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }.start();;
        } catch (IOException e) {
            e.printStackTrace();
        }
    initComponents();
    this.paintAll(this.getGraphics());
    }
    public void initComponents(){
        edit=new JTextArea();
        edit.setEnabled(false);
        message=new JTextArea();

        editPanel=new     JScrollPane
                (edit);
        messagePanel=new     JScrollPane
                (message);
        editPanel.setBounds(10,10,280,300);
        this.add(editPanel);
        messagePanel.setBounds(10,320,280,200);
        this.add(messagePanel);
        send=new JButton("Send");
        close=new JButton("close");
        send.setBounds(150,530,60,20);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String willSend=message.getText().toString();
                try {
                    writer.write(willSend+"\r\n");
                    writer.flush();
                    message.setText("");
                    edit.append(new Date().toLocaleString()+"   "+willSend+"\r\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        close.setBounds(220,530,60,20);
        this.add(send);
        this.add(close);
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}
