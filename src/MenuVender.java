import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuVender extends JFrame{
    private JList list1;
    private JPanel painelvender;

    public MenuVender(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painelvender);
        this.pack();
        this.setVisible(true);

        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday"};
        List<String> semana = Arrays.asList(week);

        DefaultListModel listModel;
        listModel = new DefaultListModel();

        listModel.addElement("item1");

        listModel.addElement("item 2");
        JList list1 = new JList(listModel);

        //painelvender.add(list2);


    }

    public static void main(String[] args) {

        MenuVender m = new MenuVender();
      //  this.list1 = new JList<>();
    }
}
