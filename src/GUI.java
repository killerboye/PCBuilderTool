/**
 * Created by students UA:FTI-EI De Laet Jan & Yigit Yunus Emre.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI
{
    //Main Pane
    public JPanel mainPanel;
    public JTextField loginText;
    public JProgressBar progressBar;
    public JLabel UCLIcon;
    //catalogue Tab
    public JTextArea detailsTextArea;
    public JLabel componentIcon;
    public JList<String> specificComponentList;
    public JList<String> userCfgList;
    public JButton addCompare;
    public JTabbedPane mainTabbedPanel;
    public JTextField searchText;
    //Watt Usage Tab
    public JTextArea wattInfo;
    public JTextArea wattResults;
    public JButton calculateButton;
    //Compare Tab
    public JTextArea compareArea1;
    public JTextArea compareArea2;
    public JLabel compareIcon1;
    public JLabel compareIcon2;
    //Compatibility Check Tab
    public JTextArea compatibilityInfo;
    public JTextArea compatibilityResults;
    public JTextArea exportResults;
    //Frame
    JFrame frame;
    private JLabel PCBuilderIcon;
    private JPanel catalogueTab;
    private JPanel compareTab;
    private JPanel wattTab;
    private JPanel compatibilityTab;
    private JPanel exportTab;
    private JTextArea welcomeTitle;
    private JTextArea userCfgTitle;
    private JButton sortZA;
    private JButton sortAZ;
    private JTextArea detailsTitleTextArea;
    private JTextArea specificComponentTitle;
    private JScrollPane specificComponentScrollPane;
    private JButton motherboardButton;
    private JButton CPUButton;
    private JButton RAMButton;
    private JButton GPUButton;
    private JButton PSUButton;
    private JButton drivesButton;
    private JButton addComponent;
    private JButton saveUserCfg;
    private JButton removeComponentButton1;
    private JButton removeComponentButton2;
    private JButton compatibilityButton;

    //Export (offer file) Tab
    private JTextArea exportInfo;
    private JButton exportButton;


    GUI()
    {
        frame = new JFrame("PCBuilder Tool");
        $$$setupUI$$$();
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }

    void setLoginActionListener(ActionListener al)
    {
        loginText.addActionListener(al);
    }

    void setCalculateWattButtonActionListener(ActionListener al)
    {
        calculateButton.addActionListener(al);
    }

    void setCompatibilityCheckActionListener(ActionListener al)
    {
        compatibilityButton.addActionListener(al);
    }

    void setExportButtonActionListener(ActionListener al)
    {
        exportButton.addActionListener(al);
    }

    void setSelectMotherboardActionListener(ActionListener al)
    {
        motherboardButton.addActionListener(al);
    }

    void setSelectCPUActionListener(ActionListener al)
    {
        CPUButton.addActionListener(al);
    }

    void setSelectRAMActionListener(ActionListener al)
    {
        RAMButton.addActionListener(al);
    }

    void setSelectGPUActionListener(ActionListener al)
    {
        GPUButton.addActionListener(al);
    }

    void setSelectPSUActionListener(ActionListener al)
    {
        PSUButton.addActionListener(al);
    }

    void setSelectDriveActionListener(ActionListener al)
    {
        drivesButton.addActionListener(al);
    }

    void setSearchActionListener(ActionListener al)
    {
        searchText.addActionListener(al);
    }

    void setSortAZActionListener(ActionListener al)
    {
        sortAZ.addActionListener(al);
    }

    void setSortZAActionListener(ActionListener al)
    {
        sortZA.addActionListener(al);
    }

    void setAddComponentActionListener(ActionListener al)
    {
        addComponent.addActionListener(al);
    }

    void setAddToCompareActionListener(ActionListener al)
    {
        addCompare.addActionListener(al);
    }

    void setSaveUserCfgActionListener(ActionListener al)
    {
        saveUserCfg.addActionListener(al);
    }

    void setRemoveCompare1ActionListener(ActionListener al)
    {
        removeComponentButton1.addActionListener(al);
    }

    void setRemoveCompare2ActionListener(ActionListener al)
    {
        removeComponentButton2.addActionListener(al);
    }

    void setErrorPanel(String error)
    {
        JOptionPane.showMessageDialog(new JPanel(), error, "ERROR!", JOptionPane.ERROR_MESSAGE);
    }

    void setProgressBar()
    {
        switch (PCBuilder.PCBE.myPc.userCfg.size())
        {
            case 1:
                progressBar.setValue(20);
                break;
            case 2:
                progressBar.setValue(40);
                break;
            case 3:
                progressBar.setValue(60);
                break;
            case 4:
                progressBar.setValue(80);
                break;
            case 5:
                progressBar.setValue(100);
                break;
            case 6:
                progressBar.setValue(120);
                break;
        }
    }

    boolean setVerification(String message)
    {
        int result = JOptionPane.showConfirmDialog(null, message, null, JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }

    void updateWattTab()
    {
        String textComponent = "Your configuration:\n";
        for (Component component : PCBuilder.PCBE.myPc.userCfg)
        {
            textComponent += "\n" + component.getGroupComponent() + ": " + component.getBrandComponent() + " " + component.getNameComponent() + "\n";
            if (!component.getGroupComponent().equals("PSU"))
            {
                textComponent += "Individual Watt Usage: " + component.getWattUsage() + " Watt\n";
            }
        }
        wattInfo.setText(textComponent);
    }

    void updateCheckCompatibilityTab()
    {
        String textComponent = "Your configuration:\n";
        for (Component component : PCBuilder.PCBE.myPc.userCfg)
        {
            textComponent += "\n" + component.getGroupComponent() + ": " + component.getBrandComponent() + " " + component.getNameComponent() + "\n";
        }
        compatibilityInfo.setText(textComponent);
    }

    void updateExportTab()
    {
        String textComponent = "Your configuration:\n";
        for (Component component : PCBuilder.PCBE.myPc.userCfg)
        {
            textComponent += "\n" + component.getGroupComponent() + ": " + component.getBrandComponent() + " " + component.getNameComponent() + "\n";
        }
        exportInfo.setText(textComponent);
    }

    void updateSpecificComponentList()
    {
        ArrayList<Component> tempList = new ArrayList<>();

        for (int i = 0; i < PCBuilder.componentNameList.size(); i++)
        {
            for (Component component : PCBuilder.PCBE.catalogue.searchList)
            {
                if ((component.getBrandComponent() + " " + component.getNameComponent()).equals(PCBuilder.componentNameList.get(i)))
                {
                    tempList.add(component);
                }
            }
        }

        PCBuilder.PCBE.catalogue.searchList.clear();

        for (Component component : tempList)
        {
            PCBuilder.PCBE.catalogue.searchList.add(component);
        }

        PCBuilder.DLM.clear();

        for (Component component : PCBuilder.PCBE.catalogue.searchList)
        {
            PCBuilder.DLM.addElement(component.getBrandComponent() + " " + component.getNameComponent());
        }
        specificComponentList.setModel(PCBuilder.DLM);

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(-1513240));
        mainPanel.setEnabled(true);
        mainPanel.setMinimumSize(new Dimension(900, 600));
        mainPanel.setPreferredSize(new Dimension(900, 600));
        loginText = new JTextField();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 200;
        mainPanel.add(loginText, gbc);
        userCfgTitle = new JTextArea();
        userCfgTitle.setEditable(false);
        userCfgTitle.setFont(new Font("Segoe UI", Font.BOLD, userCfgTitle.getFont().getSize()));
        userCfgTitle.setOpaque(false);
        userCfgTitle.setSelectedTextColor(new Color(-16645630));
        userCfgTitle.setSelectionColor(new Color(-1513240));
        userCfgTitle.setText("Current PC configuration:");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 20.0;
        gbc.anchor = GridBagConstraints.NORTH;
        mainPanel.add(userCfgTitle, gbc);
        mainTabbedPanel = new JTabbedPane();
        mainTabbedPanel.setBackground(new Color(-1513240));
        mainTabbedPanel.setEnabled(true);
        mainTabbedPanel.setFont(new Font("Segoe UI", mainTabbedPanel.getFont().getStyle(), mainTabbedPanel.getFont().getSize()));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 6;
        gbc.weightx = 100.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(mainTabbedPanel, gbc);
        catalogueTab = new JPanel();
        catalogueTab.setLayout(new GridBagLayout());
        catalogueTab.setAlignmentY(0.0f);
        catalogueTab.setBackground(new Color(-3613198));
        catalogueTab.setPreferredSize(new Dimension(800, 500));
        mainTabbedPanel.addTab("Component Catalogue", catalogueTab);
        detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);
        detailsTextArea.setFocusCycleRoot(false);
        detailsTextArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
        detailsTextArea.setMargin(new Insets(0, 10, 0, 0));
        detailsTextArea.setMinimumSize(new Dimension(0, 10));
        detailsTextArea.setOpaque(true);
        detailsTextArea.setPreferredSize(new Dimension(0, 10));
        detailsTextArea.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        catalogueTab.add(detailsTextArea, gbc);
        detailsTitleTextArea = new JTextArea();
        detailsTitleTextArea.setAlignmentX(0.5f);
        detailsTitleTextArea.setAlignmentY(0.5f);
        detailsTitleTextArea.setBackground(new Color(-1710619));
        detailsTitleTextArea.setEditable(false);
        detailsTitleTextArea.setFont(new Font("Segoe UI", Font.BOLD, detailsTitleTextArea.getFont().getSize()));
        detailsTitleTextArea.setMargin(new Insets(8, 0, 0, 0));
        detailsTitleTextArea.setMaximumSize(new Dimension(250, 32));
        detailsTitleTextArea.setMinimumSize(new Dimension(238, 32));
        detailsTitleTextArea.setOpaque(false);
        detailsTitleTextArea.setPreferredSize(new Dimension(238, 32));
        detailsTitleTextArea.setSelectedTextColor(new Color(-16645630));
        detailsTitleTextArea.setSelectionColor(new Color(-3613198));
        detailsTitleTextArea.setText("Details of the selected component:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        catalogueTab.add(detailsTitleTextArea, gbc);
        motherboardButton = new JButton();
        motherboardButton.setFont(new Font("Segoe UI", motherboardButton.getFont().getStyle(), motherboardButton.getFont().getSize()));
        motherboardButton.setText("Motherboard");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(motherboardButton, gbc);
        CPUButton = new JButton();
        CPUButton.setFont(new Font("Segoe UI", CPUButton.getFont().getStyle(), CPUButton.getFont().getSize()));
        CPUButton.setText("Processor (CPU)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(CPUButton, gbc);
        RAMButton = new JButton();
        RAMButton.setFont(new Font("Segoe UI", RAMButton.getFont().getStyle(), RAMButton.getFont().getSize()));
        RAMButton.setText("Memory (RAM)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(RAMButton, gbc);
        GPUButton = new JButton();
        GPUButton.setFont(new Font("Segoe UI", GPUButton.getFont().getStyle(), GPUButton.getFont().getSize()));
        GPUButton.setText("Graphics Card (GPU)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(GPUButton, gbc);
        PSUButton = new JButton();
        PSUButton.setFont(new Font("Segoe UI", PSUButton.getFont().getStyle(), PSUButton.getFont().getSize()));
        PSUButton.setText("Power Supply (PSU)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(PSUButton, gbc);
        drivesButton = new JButton();
        drivesButton.setFont(new Font("Segoe UI", drivesButton.getFont().getStyle(), drivesButton.getFont().getSize()));
        drivesButton.setText("Drives");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(drivesButton, gbc);
        specificComponentScrollPane = new JScrollPane();
        specificComponentScrollPane.setBackground(new Color(-1));
        specificComponentScrollPane.setOpaque(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.gridheight = 6;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        catalogueTab.add(specificComponentScrollPane, gbc);
        specificComponentList = new JList();
        specificComponentList.setAlignmentX(1.0f);
        specificComponentList.setBackground(new Color(-1));
        specificComponentList.setDoubleBuffered(false);
        specificComponentList.setDragEnabled(false);
        specificComponentList.setEnabled(true);
        specificComponentList.setFont(new Font("Segoe UI", Font.BOLD, specificComponentList.getFont().getSize()));
        specificComponentList.setOpaque(true);
        specificComponentList.setSelectionBackground(new Color(-1));
        specificComponentScrollPane.setViewportView(specificComponentList);
        specificComponentTitle = new JTextArea();
        specificComponentTitle.setAlignmentX(1.0f);
        specificComponentTitle.setEditable(false);
        specificComponentTitle.setFont(new Font("Segoe UI", Font.BOLD, specificComponentTitle.getFont().getSize()));
        specificComponentTitle.setMargin(new Insets(0, 0, 0, 5));
        specificComponentTitle.setOpaque(false);
        specificComponentTitle.setSelectedTextColor(new Color(-16645630));
        specificComponentTitle.setSelectionColor(new Color(-3613198));
        specificComponentTitle.setText("Search:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.EAST;
        catalogueTab.add(specificComponentTitle, gbc);
        sortZA = new JButton();
        sortZA.setAlignmentY(0.5f);
        sortZA.setHorizontalAlignment(0);
        sortZA.setMargin(new Insets(2, 14, 2, 14));
        sortZA.setMaximumSize(new Dimension(64, 24));
        sortZA.setMinimumSize(new Dimension(64, 24));
        sortZA.setPreferredSize(new Dimension(64, 24));
        sortZA.setText("Z>A");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(sortZA, gbc);
        addComponent = new JButton();
        addComponent.setFont(new Font("Segoe UI", addComponent.getFont().getStyle(), addComponent.getFont().getSize()));
        addComponent.setMaximumSize(new Dimension(111, 24));
        addComponent.setMinimumSize(new Dimension(111, 24));
        addComponent.setPreferredSize(new Dimension(125, 24));
        addComponent.setText("Add to your PC");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(addComponent, gbc);
        addCompare = new JButton();
        addCompare.setFont(new Font("Segoe UI", addCompare.getFont().getStyle(), addCompare.getFont().getSize()));
        addCompare.setMargin(new Insets(2, 5, 2, 5));
        addCompare.setMaximumSize(new Dimension(116, 24));
        addCompare.setMinimumSize(new Dimension(116, 24));
        addCompare.setPreferredSize(new Dimension(125, 24));
        addCompare.setText("Add to compare");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(addCompare, gbc);
        searchText = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(searchText, gbc);
        sortAZ = new JButton();
        sortAZ.setAlignmentX(0.0f);
        sortAZ.setAlignmentY(0.5f);
        sortAZ.setFont(new Font("Segoe UI", sortAZ.getFont().getStyle(), sortAZ.getFont().getSize()));
        sortAZ.setMargin(new Insets(2, 14, 2, 14));
        sortAZ.setMaximumSize(new Dimension(53, 24));
        sortAZ.setMinimumSize(new Dimension(53, 24));
        sortAZ.setPreferredSize(new Dimension(64, 24));
        sortAZ.setText("A>Z");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        catalogueTab.add(sortAZ, gbc);
        componentIcon = new JLabel();
        componentIcon.setBackground(new Color(-1));
        componentIcon.setHorizontalAlignment(0);
        componentIcon.setOpaque(true);
        componentIcon.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        catalogueTab.add(componentIcon, gbc);
        compareTab = new JPanel();
        compareTab.setLayout(new GridBagLayout());
        compareTab.setBackground(new Color(-3613198));
        mainTabbedPanel.addTab("Compare", compareTab);
        compareArea1 = new JTextArea();
        compareArea1.setEditable(false);
        compareArea1.setFont(new Font("Segoe UI", Font.BOLD, compareArea1.getFont().getSize()));
        compareArea1.setMargin(new Insets(0, 10, 0, 0));
        compareArea1.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 50.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 5);
        compareTab.add(compareArea1, gbc);
        compareArea2 = new JTextArea();
        compareArea2.setEditable(false);
        compareArea2.setFont(new Font("Segoe UI", Font.BOLD, compareArea2.getFont().getSize()));
        compareArea2.setMargin(new Insets(0, 10, 0, 0));
        compareArea2.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 50.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 5, 0, 0);
        compareTab.add(compareArea2, gbc);
        compareIcon1 = new JLabel();
        compareIcon1.setBackground(new Color(-1));
        compareIcon1.setHorizontalAlignment(2);
        compareIcon1.setOpaque(true);
        compareIcon1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 50.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 0, 0, 5);
        compareTab.add(compareIcon1, gbc);
        compareIcon2 = new JLabel();
        compareIcon2.setBackground(new Color(-1));
        compareIcon2.setHorizontalAlignment(2);
        compareIcon2.setOpaque(true);
        compareIcon2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 50.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 5, 0, 0);
        compareTab.add(compareIcon2, gbc);
        removeComponentButton2 = new JButton();
        removeComponentButton2.setText("Remove component");
        removeComponentButton2.setVerticalAlignment(1);
        removeComponentButton2.setVerticalTextPosition(1);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        compareTab.add(removeComponentButton2, gbc);
        removeComponentButton1 = new JButton();
        removeComponentButton1.setText("Remove component");
        removeComponentButton1.setVerticalAlignment(1);
        removeComponentButton1.setVerticalTextPosition(1);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0.05;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        compareTab.add(removeComponentButton1, gbc);
        wattTab = new JPanel();
        wattTab.setLayout(new GridBagLayout());
        wattTab.setBackground(new Color(-3613198));
        mainTabbedPanel.addTab("Watt Usage", wattTab);
        wattInfo = new JTextArea();
        wattInfo.setEditable(false);
        wattInfo.setFont(new Font("Segoe UI", Font.BOLD, wattInfo.getFont().getSize()));
        wattInfo.setMargin(new Insets(10, 10, 0, 0));
        wattInfo.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 0, 30, 0);
        wattTab.add(wattInfo, gbc);
        calculateButton = new JButton();
        calculateButton.setFont(new Font("Segoe UI", calculateButton.getFont().getStyle(), calculateButton.getFont().getSize()));
        calculateButton.setText("Calculate Watt Usage");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        wattTab.add(calculateButton, gbc);
        wattResults = new JTextArea();
        wattResults.setEditable(false);
        wattResults.setFont(new Font("Segoe UI", Font.BOLD, wattResults.getFont().getSize()));
        wattResults.setMargin(new Insets(10, 10, 0, 0));
        wattResults.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.4;
        gbc.fill = GridBagConstraints.BOTH;
        wattTab.add(wattResults, gbc);
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-1));
        label1.setHorizontalAlignment(0);
        label1.setIcon(new ImageIcon(getClass().getResource("/resources/wattUsageIcon.png")));
        label1.setOpaque(true);
        label1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 0, 30, 0);
        wattTab.add(label1, gbc);
        compatibilityTab = new JPanel();
        compatibilityTab.setLayout(new GridBagLayout());
        compatibilityTab.setBackground(new Color(-3613198));
        mainTabbedPanel.addTab("Compatibility Check", compatibilityTab);
        compatibilityInfo = new JTextArea();
        compatibilityInfo.setEditable(false);
        compatibilityInfo.setFont(new Font("Segoe UI", Font.BOLD, compatibilityInfo.getFont().getSize()));
        compatibilityInfo.setMargin(new Insets(10, 10, 0, 0));
        compatibilityInfo.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 0, 30, 0);
        compatibilityTab.add(compatibilityInfo, gbc);
        compatibilityButton = new JButton();
        compatibilityButton.setFont(new Font("Segoe UI", compatibilityButton.getFont().getStyle(), compatibilityButton.getFont().getSize()));
        compatibilityButton.setText("Check for compatibility");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        compatibilityTab.add(compatibilityButton, gbc);
        compatibilityResults = new JTextArea();
        compatibilityResults.setEditable(false);
        compatibilityResults.setFont(new Font("Segoe UI", Font.BOLD, compatibilityResults.getFont().getSize()));
        compatibilityResults.setMargin(new Insets(10, 10, 0, 0));
        compatibilityResults.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.4;
        gbc.fill = GridBagConstraints.BOTH;
        compatibilityTab.add(compatibilityResults, gbc);
        final JLabel label2 = new JLabel();
        label2.setBackground(new Color(-1));
        label2.setHorizontalAlignment(0);
        label2.setIcon(new ImageIcon(getClass().getResource("/resources/compatibilityCheckIcon.png")));
        label2.setOpaque(true);
        label2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 0, 30, 0);
        compatibilityTab.add(label2, gbc);
        exportTab = new JPanel();
        exportTab.setLayout(new GridBagLayout());
        exportTab.setBackground(new Color(-3613198));
        mainTabbedPanel.addTab("Export Configuration", exportTab);
        exportButton = new JButton();
        exportButton.setFont(new Font("Segoe UI", exportButton.getFont().getStyle(), exportButton.getFont().getSize()));
        exportButton.setText("Export to text file");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        exportTab.add(exportButton, gbc);
        exportResults = new JTextArea();
        exportResults.setEditable(false);
        exportResults.setFont(new Font("Segoe UI", Font.BOLD, exportResults.getFont().getSize()));
        exportResults.setMargin(new Insets(10, 10, 0, 0));
        exportResults.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.4;
        gbc.fill = GridBagConstraints.BOTH;
        exportTab.add(exportResults, gbc);
        final JLabel label3 = new JLabel();
        label3.setBackground(new Color(-1));
        label3.setHorizontalAlignment(0);
        label3.setIcon(new ImageIcon(getClass().getResource("/resources/exportIcon.jpg")));
        label3.setOpaque(true);
        label3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 0, 30, 0);
        exportTab.add(label3, gbc);
        exportInfo = new JTextArea();
        exportInfo.setEditable(false);
        exportInfo.setFont(new Font("Segoe UI", Font.BOLD, exportInfo.getFont().getSize()));
        exportInfo.setMargin(new Insets(10, 10, 0, 0));
        exportInfo.setSelectionColor(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(30, 0, 30, 0);
        exportTab.add(exportInfo, gbc);
        userCfgList = new JList();
        userCfgList.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userCfgList.setMaximumSize(new Dimension(250, 175));
        userCfgList.setMinimumSize(new Dimension(250, 175));
        userCfgList.setOpaque(true);
        userCfgList.setPreferredSize(new Dimension(250, 175));
        userCfgList.setRequestFocusEnabled(true);
        userCfgList.setSelectionBackground(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(userCfgList, gbc);
        progressBar = new JProgressBar();
        progressBar.setForeground(new Color(-16655360));
        progressBar.setMaximum(120);
        progressBar.setValue(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(progressBar, gbc);
        welcomeTitle = new JTextArea();
        welcomeTitle.setEditable(false);
        welcomeTitle.setEnabled(true);
        welcomeTitle.setFont(new Font("Segoe UI", Font.BOLD, welcomeTitle.getFont().getSize()));
        welcomeTitle.setMargin(new Insets(0, 0, 0, 10));
        welcomeTitle.setOpaque(false);
        welcomeTitle.setSelectedTextColor(new Color(-16645630));
        welcomeTitle.setSelectionColor(new Color(-1513240));
        welcomeTitle.setText("Please enter your name here:");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(welcomeTitle, gbc);
        final JTextArea textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setEnabled(true);
        textArea1.setFont(new Font("Segoe UI", Font.BOLD, textArea1.getFont().getSize()));
        textArea1.setMargin(new Insets(0, 10, 0, 0));
        textArea1.setOpaque(false);
        textArea1.setRequestFocusEnabled(true);
        textArea1.setSelectedTextColor(new Color(-16645630));
        textArea1.setSelectionColor(new Color(-1513240));
        textArea1.setText("Welcome to the PCBuilder Tool!");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(textArea1, gbc);
        PCBuilderIcon = new JLabel();
        PCBuilderIcon.setAlignmentX(0.0f);
        PCBuilderIcon.setDoubleBuffered(false);
        PCBuilderIcon.setHorizontalAlignment(4);
        PCBuilderIcon.setIcon(new ImageIcon(getClass().getResource("/resources/PCBuilderIcon.png")));
        PCBuilderIcon.setOpaque(false);
        PCBuilderIcon.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(PCBuilderIcon, gbc);
        UCLIcon = new JLabel();
        UCLIcon.setBackground(new Color(-1));
        UCLIcon.setHorizontalAlignment(0);
        UCLIcon.setIcon(new ImageIcon(getClass().getResource("/resources/gamingPc2.jpg")));
        UCLIcon.setOpaque(true);
        UCLIcon.setText("");
        UCLIcon.setVerticalAlignment(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.weighty = 0.15;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(UCLIcon, gbc);
        saveUserCfg = new JButton();
        saveUserCfg.setFont(new Font("Segoe UI", saveUserCfg.getFont().getStyle(), 18));
        saveUserCfg.setText("Save your user configuration");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(saveUserCfg, gbc);
        final JTextArea textArea2 = new JTextArea();
        textArea2.setEditable(false);
        textArea2.setEnabled(true);
        textArea2.setFont(new Font("Segoe UI", Font.BOLD, textArea2.getFont().getSize()));
        textArea2.setMargin(new Insets(0, 0, 0, 0));
        textArea2.setOpaque(false);
        textArea2.setSelectedTextColor(new Color(-16645630));
        textArea2.setSelectionColor(new Color(-1513240));
        textArea2.setText("Tip: Double-click to remove a component");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 3, 0, 0);
        mainPanel.add(textArea2, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return mainPanel;
    }
}
