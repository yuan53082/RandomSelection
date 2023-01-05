
import dao.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * @avthor ${Yuan}
 * @Date ${2023/01/05}
 */
public class Main extends JFrame {
    private Container container;
    private JTextArea output;
    private JTextArea input;
    private JButton submit;
    private JButton copy;
    private JButton clean;
    private JScrollPane inputScrollPane;
    private JScrollPane outputScrollPane;
    public Main(){
        init();
    }
    private void init(){

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        container = this.getContentPane();
        container.setLayout(null);
        this.setTitle("名單抽選器");
        this.setSize(375,500);
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //輸入抽選名單
        input = new JTextArea();
        input.setBounds(20,20,200,200);
        inputScrollPane  = new JScrollPane(input);
        inputScrollPane.setBounds(20,20,200,200);
        inputScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        container.add(inputScrollPane);

        //輸出抽選後結果
        output = new JTextArea();
        output.setBounds(20,240,200,200);
        output.setEnabled(false);
        outputScrollPane = new JScrollPane(output);
        outputScrollPane.setBounds(20,240,200,200);
        outputScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        container.add(outputScrollPane);

        //執行抽選
        submit = new JButton("抽選");
        submit.setBounds(240,20,100,30);
        container.add(submit);

        //複製抽選結果文字
        copy = new JButton("複製結果");
        copy.setBounds(240,240,100,30);
        container.add(copy);

        clean = new JButton("全部清除");
        clean.setBounds(240,410,100,30);
        container.add(clean);

        submit.addActionListener(e -> {
            output.setText(Random.random(input.getText().split("\n")));
        });

        copy.addActionListener(e -> {
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection strSel = new StringSelection(output.getText());
            cb.setContents(strSel,null);
            JFrame checkWindow = new JFrame();

            JOptionPane.showMessageDialog(checkWindow,"複製成功");
        });

        clean.addActionListener(e -> {
            input.setText("");
            output.setText("");
        });
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(()->new Main().setVisible(true));
    }
}