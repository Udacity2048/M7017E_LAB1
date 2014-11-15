package gui;

import coreApplication.Constants;
import coreApplication.Controller;
import coreApplication.EventListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.Timer;

/**
 * This is one GUI implemented by our team using our application. This GUI is
 * juste an example of easy-to-use interface but it is up to you develop your
 * own GUI with your own ideas by using our API documentation.
 *
 * @author Fisayo
 * @reviewer Baptiste
 */
public final class GUI extends javax.swing.JFrame {

    //Variable to store the argument c to access Controller methods.
    private final Controller controller;

    //Variables flags defining different states.
    boolean recording = false;
    boolean playing = false;

    //Variable to broswe the local computer folders.
    final JFileChooser fc = new JFileChooser();

    //Variable defining the time format used for the recording duration.
    private final SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss:SSS");

    //Variables to manage the recording timing.
    private long startTime;
    private final ClockListener clock = new ClockListener();
    private final Timer timer = new Timer(53, (ActionListener) clock);

    //Varuables to playlists contain.
    Hashtable<String, String> listPView = new Hashtable<String, String>();
    Hashtable<String, String> listMView = new Hashtable<String, String>();

    /**
     * Constructor for GUI linked with a Controller argument.
     *
     * @param c is the Controller
     */
    public GUI(Controller c) {

        //Create the GUI
        initComponents();

        //Store the Controller variable
        controller = c;

        //Instantiate a listener to listen potential msg from the SoundPlayer.
        EventListener guiListener = new EventListener() {
            @Override
            public void fireEvent(EventObject e) {
                /*
                 Here, we simply check if the event is a PlayEnd event and we simply, update the 
                 Play button from Pause Icon to Play Icon and set the status label to finsihed
                 */
                //If message code 1 (PlayEnd) is listen.
                if (e.getSource().equals(1)) {

                    //Stop the player.
                    controller.playerStop();

                    //Change Icon buttons.
                    playButton.setPressedIcon(new ImageIcon(getClass().getResource("/Icons/001d.png")));
                    playButton.setIcon(new ImageIcon(getClass().getResource("/Icons/001.png")));
                    playButton.setRolloverIcon(new ImageIcon(getClass().getResource("/Icons/001g.png")));

                    //Set information label status.
                    lblDuration.setText("Finished");
                }
            }
        };

        //Define guiListener as the listener for the SoundPlayer events.
        controller.setPlayerListener(guiListener);

        //Automatically show in the GUI the previously created playlist.
        refreshItemList(".pp", playlistArea, controller.getPlaylistFolderPath());
    }

    //**************************************************************************
    //AUTO CREATED CODE FROM NETBEANS DESIGN FEATURE.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        forwardButton = new javax.swing.JButton();
        forwardButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        forwardButton.setBackground(Color.BLACK);
        forwardButton.setContentAreaFilled(false);
        forwardButton.setFocusPainted(false);
        playButton = new javax.swing.JButton();
        playButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        playButton.setBackground(Color.BLACK);
        playButton.setContentAreaFilled(false);
        playButton.setFocusPainted(false);
        stopButton = new javax.swing.JButton();
        stopButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        stopButton.setBackground(Color.BLACK);
        stopButton.setContentAreaFilled(false);
        stopButton.setFocusPainted(false);
        jsVolume = new javax.swing.JSlider();
        //HashTable is used to label the volume controller (Jslider) at particular positions 0 and 100
        Hashtable labelVolume = new Hashtable();
        labelVolume.put(0, new JLabel("Min"));
        labelVolume.put(100, new JLabel("Max"));
        jsVolume.setLabelTable(labelVolume);
        jsVolume.setPaintLabels(true);
        pbVol = new javax.swing.JProgressBar();
        backwardButton = new javax.swing.JButton();
        backwardButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        backwardButton.setBackground(Color.BLACK);
        backwardButton.setContentAreaFilled(false);
        backwardButton.setFocusPainted(false);
        psPlay = new javax.swing.JProgressBar();
        lblDuration = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        recordButton = new javax.swing.JButton();
        recordButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        recordButton.setBackground(Color.BLACK);
        recordButton.setContentAreaFilled(false);
        recordButton.setFocusPainted(false);
        listenButton = new javax.swing.JButton();
        listenButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listenButton.setBackground(Color.BLACK);
        listenButton.setContentAreaFilled(false);
        listenButton.setFocusPainted(false);
        listenButton.setEnabled(false);
        saveButton = new javax.swing.JButton();
        saveButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        saveButton.setBackground(Color.BLACK);
        saveButton.setContentAreaFilled(false);
        saveButton.setFocusPainted(false);
        saveButton.setEnabled(false);
        saveAsButton = new javax.swing.JButton();
        saveAsButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        saveAsButton.setBackground(Color.BLACK);
        saveAsButton.setContentAreaFilled(false);
        saveAsButton.setFocusPainted(false);
        saveAsButton.setEnabled(false);
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playlistArea = new javax.swing.JList();
        createPlaylistButton = new javax.swing.JButton();
        deletePlaylistButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        musicsArea = new javax.swing.JList();
        cmdLSongs = new javax.swing.JButton();
        addPlaylistButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mp3 Voice Recorder and Player");
        setResizable(false);

        forwardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/002.png"))); // NOI18N
        forwardButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/002g.png"))); // NOI18N
        forwardButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/002d.png"))); // NOI18N
        forwardButton.setVerifyInputWhenFocusTarget(false);
        forwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardButtonActionPerformed(evt);
            }
        });

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/001.png"))); // NOI18N
        playButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/001g.png"))); // NOI18N
        playButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/001d.png"))); // NOI18N
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icstop.png"))); // NOI18N
        stopButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icstopg.png"))); // NOI18N
        stopButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icstopd.png"))); // NOI18N
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        jsVolume.setValue(100);
        jsVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsVolumeStateChanged(evt);
            }
        });

        pbVol.setForeground(new java.awt.Color(0, 255, 51));
        pbVol.setValue(100);

        backwardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/003.png"))); // NOI18N
        backwardButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/003g.png"))); // NOI18N
        backwardButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/003d.png"))); // NOI18N
        backwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backwardButtonActionPerformed(evt);
            }
        });

        lblDuration.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        lblDuration.setText("Welcome!");
        lblDuration.setBorder(null);
        lblDuration.setCaretColor(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(backwardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forwardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jsVolume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(pbVol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(psPlay, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addComponent(lblDuration))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(psPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(pbVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backwardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(forwardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("00:00:00:000");

        recordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icMic.png"))); // NOI18N
        recordButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icMicg.png"))); // NOI18N
        recordButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icMicd.png"))); // NOI18N
        recordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordButtonActionPerformed(evt);
            }
        });

        listenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icListen.png"))); // NOI18N
        listenButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icListeng.png"))); // NOI18N
        listenButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icListend.png"))); // NOI18N
        listenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenButtonActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save.png"))); // NOI18N
        saveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save2.png"))); // NOI18N
        saveButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save3.png"))); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        saveAsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/saveas.png"))); // NOI18N
        saveAsButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/saveas2.png"))); // NOI18N
        saveAsButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/saveas.png"))); // NOI18N
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(recordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveAsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveAsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        playlistArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Playlist"));
        playlistArea.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        playlistArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        playlistArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistAreaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(playlistArea);
        playlistArea.getAccessibleContext().setAccessibleParent(this);

        createPlaylistButton.setText("Create");
        createPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlaylistButtonActionPerformed(evt);
            }
        });

        deletePlaylistButton.setText("Delete");
        deletePlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePlaylistButtonActionPerformed(evt);
            }
        });

        musicsArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Musics"));
        musicsArea.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        musicsArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musicsAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(musicsArea);
        musicsArea.getAccessibleContext().setAccessibleParent(this);

        cmdLSongs.setText("Load Songs");
        cmdLSongs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLSongsActionPerformed(evt);
            }
        });

        addPlaylistButton.setText("Add to Playlist");
        addPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlaylistButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(deletePlaylistButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createPlaylistButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cmdLSongs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPlaylistButton)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addPlaylistButton)
                        .addComponent(cmdLSongs))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createPlaylistButton)
                        .addComponent(deletePlaylistButton)))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Load Music Folder");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Playlist");

        jMenuItem4.setText("Create");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //**************************************************************************

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        //Stop the Player
        controller.playerStop();

        //Change icones
        playButton.setPressedIcon(new ImageIcon(getClass().getResource("/Icons/001d.png")));
        playButton.setIcon(new ImageIcon(getClass().getResource("/Icons/001.png")));
        playButton.setRolloverIcon(new ImageIcon(getClass().getResource("/Icons/001g.png")));

        //Change information label
        lblDuration.setText("Stopped");
    }//GEN-LAST:event_stopButtonActionPerformed

    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed
        if (!musicsArea.isSelectionEmpty() && controller.playerIsPlaying()) {

            //Select the next element
            int index = musicsArea.getSelectedIndex();
            index++;

            //Manage end of list situation
            if (musicsArea.getModel().getSize() <= index) {
                musicsArea.setSelectedIndex(0);
            } else {
                musicsArea.setSelectedIndex(index);
            }

            //Get the path of the corresponding file and play it.
            String path = listMView.get(musicsArea.getSelectedValue().toString());
            controller.playerPlayFile(path);
        } else {
            //Change information label
            lblDuration.setText("Select a File and play it");
        }
    }//GEN-LAST:event_forwardButtonActionPerformed

    private void recordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordButtonActionPerformed
        if (recording == false) {
            recording = true;
            controller.playerStop();
            playButton.setPressedIcon(new ImageIcon(getClass().getResource("/Icons/001d.png")));
            playButton.setIcon(new ImageIcon(getClass().getResource("/Icons/001.png")));
            playButton.setRolloverIcon(new ImageIcon(getClass().getResource("/Icons/001g.png")));
            controller.captureStart(100);
            listenButton.setEnabled(false);
            saveButton.setEnabled(false);
            saveAsButton.setEnabled(false);
            startTime = System.currentTimeMillis();
            timer.start();
            lblDuration.setText("Recording");
        } else {
            controller.captureStop();
            recording = false;
            listenButton.setEnabled(true);
            saveButton.setEnabled(true);
            saveAsButton.setEnabled(true);
            timer.stop();
            lblDuration.setText("Please Listen and Save File");
        }
    }//GEN-LAST:event_recordButtonActionPerformed

    private void listenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listenButtonActionPerformed
        if (controller.playerIsPlaying()) {
            controller.playerStop();
        } else {
            controller.playerPlayCaptured();
        }
    }//GEN-LAST:event_listenButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            controller.saveCapture();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Change labels
        lblDuration.setText("File Saved");
        jTextField1.setText("00:00:00:000");

        //Disable buttons
        listenButton.setEnabled(false);
        saveButton.setEnabled(false);
        saveAsButton.setEnabled(false);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void musicsAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicsAreaMouseClicked
        if (controller.playerIsPaused()) {
            controller.playerStop();
        }

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            if (controller.playerIsPlaying()) {
                controller.playerStop();
            }
            String path = listMView.get(musicsArea.getSelectedValue().toString());
            controller.playerPlayFile(path);

            //Console output for confirmation
            System.out.println(musicsArea.getSelectedValue().toString());

            //Change icones
            playButton.setPressedIcon(new ImageIcon(getClass().getResource("/Icons/icPaused.png")));
            playButton.setIcon(new ImageIcon(getClass().getResource("/Icons/icPause.png")));
            playButton.setRolloverIcon(new ImageIcon(getClass().getResource("/Icons/icPauseg.png")));

            //Progressing bar player animation
            startPoll();

            //Change information label
            lblDuration.setText("Playing");
        }
    }//GEN-LAST:event_musicsAreaMouseClicked

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        playMusic();
    }//GEN-LAST:event_playButtonActionPerformed

    private void backwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backwardButtonActionPerformed
        if (!musicsArea.isSelectionEmpty() && controller.playerIsPlaying()) {

            //Select the previous element
            int index = musicsArea.getSelectedIndex();
            index--;

            //Manage top of list situation
            if (index >= 0) {
                musicsArea.setSelectedIndex(index);
            } else {
                musicsArea.setSelectedIndex(musicsArea.getModel().getSize() - 1);
            }

            //Get the path of the corresponding file and play it.
            String path = listMView.get(musicsArea.getSelectedValue().toString());
            controller.playerPlayFile(path);
        } else {

            //Change information label
            lblDuration.setText("Select a File and play it");
        }
    }//GEN-LAST:event_backwardButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        openFolder();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        createPlaylist();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jsVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsVolumeStateChanged
        JSlider source = (JSlider) evt.getSource();
        if (!source.getValueIsAdjusting()) {
            int vol = (int) source.getValue();
            controller.playerSetVolume(vol);
            pbVol.setModel(source.getModel());
        }
    }//GEN-LAST:event_jsVolumeStateChanged

    private void addPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlaylistButtonActionPerformed
        if (!musicsArea.isSelectionEmpty() && !playlistArea.isSelectionEmpty()) {
            String pathP = listPView.get(playlistArea.getSelectedValue().toString());
            String pathM = listMView.get(musicsArea.getSelectedValue().toString());

            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(pathP, true)))) {
                out.println(pathM);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            String infoMessage = "Music successfully added!";
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String infoMessage = "Select Both Playlist and Song";
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_addPlaylistButtonActionPerformed

    private void createPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlaylistButtonActionPerformed
        createPlaylist();
    }//GEN-LAST:event_createPlaylistButtonActionPerformed

    private void cmdLSongsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLSongsActionPerformed
        openFolder();
    }//GEN-LAST:event_cmdLSongsActionPerformed

    private void playlistAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistAreaMouseClicked
        if (!playlistArea.isSelectionEmpty()) {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                evt.consume();
                showPlaylist();
            }
        }
    }//GEN-LAST:event_playlistAreaMouseClicked

    private void deletePlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePlaylistButtonActionPerformed
        if (!playlistArea.isSelectionEmpty()) {
            String path = listPView.get(playlistArea.getSelectedValue().toString());
            File f = new File(path);
            boolean success = f.delete();
            if (success) {
                refreshItemList(".pp", playlistArea, Constants.PLAYL_PATH);
            } else {
                throw new IllegalArgumentException("Delettion failed: check your rights for the target file/folder");
            }
        }
    }//GEN-LAST:event_deletePlaylistButtonActionPerformed

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
        int check = fc.showSaveDialog(this);
        if (check == JFileChooser.APPROVE_OPTION) {
            try {
                controller.saveAsCapture(fc.getSelectedFile().getPath());
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Change label
            lblDuration.setText("File Saved");
            jTextField1.setText("00:00:00:000");

            //Disable buttons
            listenButton.setEnabled(false);
            saveButton.setEnabled(false);
            saveAsButton.setEnabled(false);
        }
    }//GEN-LAST:event_saveAsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlaylistButton;
    private javax.swing.JButton backwardButton;
    private javax.swing.JButton cmdLSongs;
    private javax.swing.JButton createPlaylistButton;
    private javax.swing.JButton deletePlaylistButton;
    private javax.swing.JButton forwardButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JSlider jsVolume;
    private javax.swing.JTextField lblDuration;
    private javax.swing.JButton listenButton;
    private javax.swing.JList musicsArea;
    private javax.swing.JProgressBar pbVol;
    private javax.swing.JButton playButton;
    public javax.swing.JList playlistArea;
    private javax.swing.JProgressBar psPlay;
    private javax.swing.JButton recordButton;
    private javax.swing.JButton saveAsButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

    //**************************************************************************
    private class ClockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateClock();
        }
    }

    private void updateClock() {
        Date elapsed = new Date(System.currentTimeMillis() - startTime - 3600000);
        jTextField1.setText(date.format(elapsed));
    }

    //**************************************************************************
    /**
     * Manage the player progressing bar animation
     */
    private void startPoll() {
        Thread task = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        long position = controller.playerGetPosition();
                        long duration = controller.playerGetDuration();
                        psPlay.setValue((int) ((position * 100) / duration));
                    } catch (Exception e) {
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        };
        task.start();
    }

    //**************************************************************************
    private void openFolder() {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int response = fc.showSaveDialog(this);
        if (response == JFileChooser.APPROVE_OPTION) {
            controller.setMusicFolderPath(fc.getSelectedFile().getPath());
            refreshItemList(".mp3", musicsArea, controller.getMusicFolderPath());
        }
    }

    //**************************************************************************
    private void playMusic() {
        if (!musicsArea.isSelectionEmpty()) {
            if (controller.playerIsPlaying()) {
                controller.playerPause();
                playButton.setPressedIcon(new ImageIcon(getClass().getResource("/Icons/001d.png")));
                playButton.setIcon(new ImageIcon(getClass().getResource("/Icons/001.png")));
                playButton.setRolloverIcon(new ImageIcon(getClass().getResource("/Icons/001g.png")));
                lblDuration.setText("Paused");
            } else if (controller.playerIsPaused()) {
                controller.playerPlay();
                playButton.setPressedIcon(new ImageIcon(getClass().getResource("/Icons/icPaused.png")));
                playButton.setIcon(new ImageIcon(getClass().getResource("/Icons/icPause.png")));
                playButton.setRolloverIcon(new ImageIcon(getClass().getResource("/Icons/icPauseg.png")));
                lblDuration.setText("Playing");
            } else {
                String path = listMView.get(musicsArea.getSelectedValue().toString());
                controller.playerPlayFile(path);
                playButton.setPressedIcon(new ImageIcon(getClass().getResource("/Icons/icPaused.png")));
                playButton.setIcon(new ImageIcon(getClass().getResource("/Icons/icPause.png")));
                playButton.setRolloverIcon(new ImageIcon(getClass().getResource("/Icons/icPauseg.png")));
                startPoll();
                lblDuration.setText("Playing");
            }
        } else {
            lblDuration.setText("Select a File");
        }
    }

    //**************************************************************************

    /**
     * Create a new playlist in the default folder defined in Constants.
     */
        public void createPlaylist() {
        //Ask the user for a playlist name.
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        String playlistName = JOptionPane.showInputDialog(this, "Give your playlist a name", "Create a playlist", messageType);
        //Create the new playlist
        if (playlistName != null) {
            if (playlistName.isEmpty()) {
                String infoMessage = "No playlist name defined";
                JOptionPane.showMessageDialog(null, infoMessage, "InfoBox", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    controller.createPlaylist(playlistName);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            //Refresh the playlists displayed in the GUI.
            refreshItemList(".pp", playlistArea, this.controller.getPlaylistFolderPath());
        }
    }

    private void showPlaylist() {
        if (playlistArea.getModel().getSize() > 0) {
            ArrayList<String> list = new ArrayList<>();
            Scanner s;
            int i = 0;

            try {
                String path = listPView.get(playlistArea.getSelectedValue().toString());
                s = new Scanner(new File(path));
                while (s.hasNextLine()) {
                    list.add(s.nextLine());
                    i++;
                }
                s.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshItemList(list);
        }
    }

    //**************************************************************************

    /**
     * Refresh the music list area.
     * 
     * @param s is array list of music files paths.
     */
        public void refreshItemList(ArrayList<String> s) {

        DefaultListModel models = new DefaultListModel();
        File[] listOfFiles = new File[s.size()];
        for (int i = 0; i < s.size(); i++) {
            listOfFiles[i] = new File(s.get(i));
            if (listOfFiles[i].isFile()) {
                models.add(i, listOfFiles[i].getAbsolutePath());
            }
        }

        DefaultListModel mModels = new DefaultListModel();
        for (int i = 0; i < models.getSize(); i++) {
            String key = new File(models.get(i).toString()).getName();
            String Value = new File(models.get(i).toString()).getAbsolutePath();

            listMView.put(key, Value);
            mModels.add(i, new File(models.get(i).toString()).getName());
        }

        //Update the GUI
        musicsArea.setModel(mModels);
    }

    /**
     * Refresh the music list area
     * 
     * @param ext is the extention of the files
     * @param list is the Jlist element
     * @param path is the path of the folder
     */
    public void refreshItemList(final String ext, JList list, String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(ext);
            }
        });
        DefaultListModel model = new DefaultListModel();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                model.add(i, listOfFiles[i].getAbsolutePath());
                if (ext == ".mp3") {
                }
            }
        }
        DefaultListModel mModels = new DefaultListModel();
        DefaultListModel pModels = new DefaultListModel();
        for (int i = 0; i < model.getSize(); i++) {
            String key = new File(model.get(i).toString()).getName();
            String Value = new File(model.get(i).toString()).getAbsolutePath();
            if (".pp".equals(ext)) {
                listPView.put(key, Value);
                pModels.add(i, new File(model.get(i).toString()).getName());

            } else {
                listMView.put(key, Value);
                mModels.add(i, new File(model.get(i).toString()).getName());
            }
        }
        if (".pp".equals(ext)) {
            list.setModel(pModels);

        } else {
            list.setModel(mModels);
        }
    }

    //**************************************************************************  
}
