package Assembly;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *$ javax.swing.JFormattedTextField 1.4
 *      JFormattedTextField(Format format);
 *###  使用给定格式构造一个文本域
 *
 *      JFormattedTextField(JFormattedTextField.AbstractFormatter formatter)
 *###  使用给定的格式器构造文本域。DefaultFormatter和International是JFormattedTextField.AbstractFormatter的子类
 *
 *      Object getValue();
 *###  返回文本域的当前有效值。他可能和正在编辑的字符串可能不一致
 *
 *      void setValue(Object value);
 *###  设置给定对象的值。如果格式器不能将对象转换成字符串，则操作失败。
 *
 *      void commitEdit();
 *###  用正在编辑的字符串设置文本域的有效值。如果格式器无法转换该字符串，操作可能失败。
 *
 *      boolean isEdit();
 *###  检测正在编辑的字符串是否代表了一个有效值。
 *
 *      void setFocusLostBehavior(int behavior);
 *      int getFocusLostBehavior();
 *###  设置或得到“失去焦点”的行为，。behavior的合法值可以是JFormattedTextField类的常量COMMIT_OR_REVERT、REVERT、COMMIT、PERSIST。
 */

/**
 * $  java.text.DateFormat 1.1
 *      static DateFormat getDateInstance();
 *      static DateFormat getDateInstance(int dateStyle);
 *      static DateFormat getTimeInstance();
 *      static DateFormat getTimeInstance(int dateStyle);
 *      static DateFormat getDateTimeInstance();
 *      static DateFormate getDateTimeInstance(int dateStyle);
 *、###  返回date对象产生的日期、时间、日期与时间。dateStyle与timeStyle的合法值是DateFormat类的常量SHORT、MEDIUM、LONG、FULL、DEFAULT。
 */

/**
 * $ javax.swing.JFormattedTextField.AbstractFormatter 1.4
 *      abstract String valueToString(Object value);
 *###  将一个值转换为可编辑字符串。如果value不适合这个格式器将抛出ParseException异常。
 *
 *      abstract Object stringToValue(String string);
 *###  将一个字符串转换为值。如果string不适合这个格式将抛出ParseException异常。
 *
 *      DocumentFilter getDocumentFilter();
 *###  覆盖该方法以提供一个文档过滤器，用来限制对文本域的输入。返回值为null代表不需要过滤器。
 */

/**
 * $  javax.swing.text.DefaultFormatter 1.3
 *      void setOverwriteMode(boolean mode);
 *      boolean getOverwriteMode();
 *###  设置或得到覆写的方式。如果mode为true，编辑文本时用新的字符覆盖已有字符。
 */

/**
 * $  javax.swing.text.DucumentFilter 1.4
 *      void insertString(DocumentFilter.FilterBypass bypass,int offset,String text,AttributeSet attrib);
 *###  字符串插入文档前调用这一方法。可以覆盖该方法并修改字符串。也可以不调用super.insertString禁止插入，或调用bypass方法修改文档而不使用过滤器。
 *      bypass:一个对象，允许执行屏蔽过滤器的编辑命令
 *      offset:插入文本处的偏移。
 *      text:将要插入的字符
 *      attrib:插入字符的格式属性
 *
 *      void replace(DocumnetFilter.FilterBypass bypass,int offset,int length,String text,AttributeSet attrib);
 *###  该方法在使用新字符串替换部分文档之前调用。可以覆盖该方法并修改字符串，也可以调用super.replace禁止替换，或调用bypass方法修改文档而不使用过滤器。
 *      bypass:一个对象，允许你执行一个屏蔽过滤器的编辑命令
 *      offset:插入文本处的偏移
 *      length:将要插入的长度
 *      attrib:插入文本的属性
 *
 *      void remove(DocumentFilter.FilterBpass bypass,int offset,int length);
 *###  在文档的一部分被删除之前被调用。如果需要分析删除的结果，调用bypass.getDocument()获得文档。
 *      bypass:一个对象，允许你执行一个屏蔽过滤器的编辑命令
 *      offset:被删除的偏移
 *      length:被删除部分的长度
 */

/**
 * $ javax.swing.text.MaskFormatter 1.4
 *      MaskFormatter(String mask);
 *###  用给定掩码构造掩码格式器。
 *
 *      void setValidCharacters(String characters);
 *      String getValidCharacters();
 *###  设置或得到有效的编辑字符。只有给定字符串中的字符才能作为掩码的可变部分
 *
 *      void setInvalidCharacters(String characters);
 *      String getInvalidCharacters(String charaters);
 *###  设置或得到无效的编辑字符。任何给定字符串中的字符都不能输入。
 *
 *      void setPlaceholderCharacter(char text);
 *      char getPlaceholderCharacter();
 *###  设置或的到占位符，在用户没有提供时该占位符作为掩码的可变字符使用。默认的占位符为空格。
 *
 *      void setPlaceholder(String text);
 *      char getPlaceholder();
 *###  设置或得到占位符字符串。如果用户没有提供掩码中所有的可变字符则使用其尾部。如果是null或比掩码短，用占位符填充剩余输入
 *
 *      void setValueContainsLiteralCharacters(boolean b);
 *      boolean getValueContainsLiteralCharacters();
 *###  设置或得到“包含直接量字符的值”标志。如果该标志为true，文本域中的值包含掩码的直接量（非可变）部分。如果为false，直接量字符将被移除。默认值为true。
 */
public class FormatTest {
    public static void main(String[] args){
        FormatFrame frame=new FormatFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class FormatFrame extends JFrame {

    public static final int DEFAULT_WIDTH=500;
    public static final int DEFAULT_HEIGHT=250;
    private JButton okbutton;
    private JPanel mainPanel;

    public FormatFrame(){
        setTitle("FormatTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JPanel buttonPanel=new JPanel();
        okbutton=new JButton("OK");

        buttonPanel.add(okbutton);
        add(buttonPanel, BorderLayout.SOUTH);

        mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(0,3));
        add(mainPanel,BorderLayout.CENTER);

        JFormattedTextField intField=new JFormattedTextField(NumberFormat.getIntegerInstance());
        intField.setValue(100);
        addRow("Number:",intField);

        JFormattedTextField intField_two=new JFormattedTextField(NumberFormat.getIntegerInstance());
        intField_two.setValue(100);
        intField_two.setFocusLostBehavior(JFormattedTextField.COMMIT);
        addRow("Number(Commit behavior):",intField_two);

        JFormattedTextField intField_three=new JFormattedTextField(
                new InternationalFormatter(NumberFormat.getIntegerInstance()){
                    private DocumentFilter filter=new IntFilter();
            @Override
            protected DocumentFilter getDocumentFilter(){
                return filter;
            }
        });
        intField_three.setValue(100);
        addRow("Filtered Number:",intField_three);

        JFormattedTextField intField_four=new JFormattedTextField(NumberFormat.getIntegerInstance());
        intField_four.setValue(100);
        intField_four.setInputVerifier(new FormattedTextFieldVerifier());
        addRow("Verified Number:",intField_four);

        JFormattedTextField currencyField=new JFormattedTextField(NumberFormat.getCurrencyInstance());
        currencyField.setValue(new Double(10));
        addRow("Currency:",currencyField);

        JFormattedTextField dateField=new JFormattedTextField(DateFormat.getDateInstance());
        dateField.setValue(new Date());
        addRow("Date:",dateField);

        DateFormat format=DateFormat.getDateInstance(DateFormat.SHORT);
        format.setLenient(false);
        JFormattedTextField dateField_two=new JFormattedTextField(format);
        dateField_two.setValue(new Date());
        addRow("Date(short,no lenient):",dateField_two);

        try{
            DefaultFormatter formatter=new DefaultFormatter();
            formatter.setOverwriteMode(false);
            JFormattedTextField urlField=new JFormattedTextField(formatter);
            urlField.setValue(new URL("http://java.sun.com"));
            addRow("URL:",urlField);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

        try{
            MaskFormatter formatter=new MaskFormatter("###-###-###");
            formatter.setPlaceholderCharacter('0');
            JFormattedTextField ssnField=new JFormattedTextField(formatter);
            ssnField.setValue("183-767-123");
            addRow("SSN MASK:",ssnField);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JFormattedTextField ipField=new JFormattedTextField(new IPAddressFormatter());
        ipField.setValue(new byte[] {(byte) 192, (byte) 168,1,1});
        addRow("IP Address:",ipField);
    }

    public void addRow(String labelText,final JFormattedTextField field){
        mainPanel.add(new JLabel(labelText));
        mainPanel.add(field);
        final JLabel valueLabel=new JLabel();
        mainPanel.add(valueLabel);
        okbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                Object value=field.getValue();
                if(value.getClass().isArray()){
                    StringBuilder builder=new StringBuilder();
                    builder.append('{');
                    for(int i=0;i< Array.getLength(value);i++){
                        if(i>0) {
                            builder.append(',');
                        }
                        builder.append(Array.get(value,i).toString());
                    }
                    builder.append('}');
                    valueLabel.setText(builder.toString());
                }else{
                    valueLabel.setText(value.toString());
                }
            }
        });
    }
}

class IntFilter extends DocumentFilter{
    @Override
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet at) throws BadLocationException{
    {
            StringBuilder builder=new StringBuilder(str);
            for(int i=builder.length()-1;i>=0;i--){
                int sum=builder.codePointAt(i);
                if(!Character.isDigit(sum) && sum != '-') {
                    ;
                }
                {
                    builder.deleteCharAt(i);
                    if(Character.isSupplementaryCodePoint(sum)){
                        i--;
                        builder.deleteCharAt(i);
                    }
                }
            }
            super.insertString(fb, offset, builder.toString(), at);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet as) throws BadLocationException{
        if(str!=null){
            StringBuilder builder=new StringBuilder(str);
            for(int i=builder.length();i>=0;i--){
                int sum=builder.codePointAt(i);
                if(!Character.isDigit(sum) && sum !='-'){
                    builder.deleteCharAt(i);
                    if(Character.isSupplementaryCodePoint(sum)){
                        i--;
                        builder.deleteCharAt(i);
                    }
                }
            }
            str=builder.toString();
        }
        super.replace(fb,offset,length,str,as);
    }
}

class FormattedTextFieldVerifier extends InputVerifier{

    @Override
    public boolean verify(JComponent input) {
        JFormattedTextField field=(JFormattedTextField)input;
        return field.isEditValid();
    }
}

class IPAddressFormatter extends DefaultFormatter{
    @Override
    public String valueToString(Object value) throws ParseException{
        if(!(value instanceof byte[])) {
            throw new ParseException("Not a byte[]",0);
        }
        byte[] a=(byte[])value;
        if(a.length !=4) {
            throw new ParseException("more length",0);
        }
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<4;i++){
            int b=a[i];
            if(b<0) {
                b+=256;
            }
            builder.append(String.valueOf(b));
            if(i<3) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public Object stringTpValue(String text) throws ParseException{
        StringTokenizer tokenizer=new StringTokenizer(text,".");
        byte[] temp=new byte[4];
        for(int i=0;i<4;i++){
            int temp_two=0;
            if(!tokenizer.hasMoreTokens()) {
                throw new ParseException("Too few bytes",0);
            }
            try{
                temp_two=Integer.parseInt(tokenizer.nextToken());
            }catch (NumberFormatException e){
                e.printStackTrace();
                throw new ParseException("Not an integer",0);
            }
            if(temp_two<0 || temp_two>=256) {
                throw new ParseException("Byte out of range",0);
            }
            temp[i]=(byte)temp_two;
        }
        if(tokenizer.hasMoreTokens()) {
            throw new ParseException("Too many bytes",0);
        }
        return temp;
    }
}