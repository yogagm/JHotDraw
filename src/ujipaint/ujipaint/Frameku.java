/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package painty;

import java.lang.reflect.InvocationTargetException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import org.jhotdraw.draw.AttributeKey;
import static org.jhotdraw.draw.AttributeKeys.FILL_COLOR;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DiamondFigure;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.EllipseFigure;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.draw.RectangleFigure;
import org.jhotdraw.draw.RoundRectangleFigure;
import org.jhotdraw.draw.TextAreaFigure;
import org.jhotdraw.draw.TextFigure;
import org.jhotdraw.draw.TriangleFigure;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.draw.io.OutputFormat;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.gui.Worker;
import org.jhotdraw.gui.filechooser.ExtensionFileFilter;
import org.jhotdraw.util.ResourceBundleUtil;
import java.net.URI;
import javax.swing.SwingUtilities;
/**
 *
 * @author Yogayustiawan
 */
public class Frameku extends javax.swing.JFrame{
    DrawingView view = new DefaultDrawingView();
    
    private JFileChooser openChooser;
    /** Holds the file chooser for saving a file. */
    private JFileChooser saveChooser;
    /** Maps file filters to input formats, so that we can
     * determine the input format that the user selected for
     * opening a drawing.
     */
    private HashMap<javax.swing.filechooser.FileFilter, InputFormat> fileFilterInputFormatMap;
    /** Maps file filters to output formats, so that we can
     * determine the output format that the user selected for
     * opening a drawing.
     */
    private HashMap<javax.swing.filechooser.FileFilter, OutputFormat> fileFilterOutputFormatMap;
    /** Holds the currently opened file. */
    private File file;
    DefaultDrawing drawing = new DefaultDrawing();
    
    public Frameku() {
        initComponents();
        setSize(new Dimension(600, 400));
    }
    public Frameku(String title){
        super(title);
        initComponents();
    }
    private void initComponents() {

//        svgPanel = new org.jhotdraw.samples.svg.SVGDrawingPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  //      getContentPane().add(svgPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        openMenuItem.setText("Open...");
        openMenuItem.addActionListener(formListener);
        fileMenu.add(openMenuItem);

        saveAsMenuItem.setText("Save As...");
        saveAsMenuItem.addActionListener(formListener);
        fileMenu.add(saveAsMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
        
        //
        //
        //
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        
                DefaultDrawing drawing = new DefaultDrawing();
                view.setDrawing(drawing);

                // Create a common drawing editor for the views
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view);

                // Create a tool bar
                JToolBar tb = new JToolBar();

                // Add a selection tool to the toolbar.
                ButtonFactory.addSelectionToolTo(tb, editor);

                // Add a creation tool for blue rectangles to the toolbar.
                HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(a, Color.BLUE);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RectangleFigure(), a),
                        "edit.createRectangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                 // Add a creation tool for green ellipse to the toolbar.
                HashMap<AttributeKey, Object> b = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.GREEN);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new EllipseFigure(), b),
                        "edit.createEllipse",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for black straight line to the toolbar.
                HashMap<AttributeKey, Object> c = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.BLACK);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new LineFigure(), c),
                        "edit.createLine",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for text area to the toolbar.
                HashMap<AttributeKey, Object> d = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.BLACK);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TextAreaFigure(), d),
                        "edit.createTextArea",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for black diamond to the toolbar.
                HashMap<AttributeKey, Object> e = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.BLACK);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new DiamondFigure(), e),
                        "edit.createDiamond",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for black round rectangle to the toolbar.
                HashMap<AttributeKey, Object> g = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.BLACK);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RoundRectangleFigure(), g),
                        "edit.createRoundRectangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                // Add a creation tool for black triangle to the toolbar.
                HashMap<AttributeKey, Object> h = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.BLACK);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TriangleFigure(), h),
                        "edit.createTriangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                 // Add a creation tool for black triangle to the toolbar.
                HashMap<AttributeKey, Object> i = new HashMap<AttributeKey, Object>();
                FILL_COLOR.put(b, Color.BLACK);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TextFigure(), i),
                        "edit.createText",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                this.getContentPane().add(tb, BorderLayout.WEST);
                JScrollPane sp = new JScrollPane(view.getComponent());
                sp.setPreferredSize(new Dimension(200, 200));
                this.getContentPane().add(sp, BorderLayout.CENTER);


    }
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    //private org.jhotdraw.samples.svg.SVGDrawingPanel svgPanel;
   
    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == openMenuItem) {
                Frameku.this.open(evt);
            }
            else if (evt.getSource() == saveAsMenuItem) {
                Frameku.this.saveAs(evt);
            }
        }
    }
    private void open(java.awt.event.ActionEvent evt) {                      
        JFileChooser fc = getOpenChooser();
        if (file != null) {
            fc.setSelectedFile(file);
        }

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
    //        svgPanel.setEnabled(false);
            final File selectedFile = fc.getSelectedFile();
            final InputFormat selectedFormat = fileFilterInputFormatMap.get(fc.getFileFilter());
            new Worker() {

                @Override
                protected Object construct() throws IOException {
                    read(selectedFile.toURI(), selectedFormat);
                    
                    return null;
                }

                @Override
                protected void done(Object value) {
                    file = selectedFile;
                    setTitle(file.getName());
                }

                @Override
                protected void failed(Throwable error) {
                    JOptionPane.showMessageDialog(Frameku.this,
                            "<html><b>Couldn't open file \"" + selectedFile.getName() + "\"<br>" +
                            error.toString(), "Open File", JOptionPane.ERROR_MESSAGE);
                }

                @Override
                protected void finished() {
          //          svgPanel.setEnabled(true);
                }
            }.start();
        }
    }
    private void saveAs(java.awt.event.ActionEvent evt) {                        
        JFileChooser fc = getSaveChooser();
        if (file != null) {
            fc.setSelectedFile(file);
        }

        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//            svgPanel.setEnabled(false);
            final File selectedFile;
            if (fc.getFileFilter() instanceof ExtensionFileFilter) {
                selectedFile = ((ExtensionFileFilter) fc.getFileFilter()).makeAcceptable(fc.getSelectedFile());
            } else {
                selectedFile = fc.getSelectedFile();
            }
            final OutputFormat selectedFormat = fileFilterOutputFormatMap.get(fc.getFileFilter());
            new Worker() {

                @Override
                protected Object construct() throws IOException {
  //                  svgPanel.write(selectedFile.toURI(), selectedFormat);
                    return null;
                }

                @Override
                protected void done(Object value) {
                    file = selectedFile;
                    setTitle(file.getName());
                }

                @Override
                protected void failed(Throwable error) {
                    
                    JOptionPane.showMessageDialog(Frameku.this,
                            "<html><b>Couldn't save to file \"" + selectedFile.getName() + "\"<br>" +
                            error.toString(), "Save As File", JOptionPane.ERROR_MESSAGE);
                }

                @Override
                protected void finished() {
    //                svgPanel.setEnabled(true);
                }
            }.start();
        }
    }
    private JFileChooser getOpenChooser() {
        if (openChooser == null) {
            openChooser = new JFileChooser();
            Drawing d = drawing;
            fileFilterInputFormatMap = new HashMap<>();
            javax.swing.filechooser.FileFilter firstFF = null;
            for (InputFormat format : d.getInputFormats()) {
                javax.swing.filechooser.FileFilter ff = format.getFileFilter();
                if (firstFF == null) {
                    firstFF = ff;
                }
                fileFilterInputFormatMap.put(ff, format);
                openChooser.addChoosableFileFilter(ff);
            }
            openChooser.setFileFilter(firstFF);
            openChooser.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equals("fileFilterChanged")) {
                        InputFormat inputFormat = fileFilterInputFormatMap.get(evt.getNewValue());
                        openChooser.setAccessory((inputFormat == null) ? null : inputFormat.getInputFormatAccessory());
                    }
                }
            });
        }
        return openChooser;
    }
    private JFileChooser getSaveChooser() {
        if (saveChooser == null) {
            saveChooser = new JFileChooser();
            Drawing d = this.drawing;
            fileFilterOutputFormatMap = new HashMap<javax.swing.filechooser.FileFilter, OutputFormat>();
            javax.swing.filechooser.FileFilter firstFF = null;
            for (OutputFormat format : d.getOutputFormats()) {
                javax.swing.filechooser.FileFilter ff = format.getFileFilter();
                if (firstFF == null) {
                    firstFF = ff;
                }
                fileFilterOutputFormatMap.put(ff, format);
                saveChooser.addChoosableFileFilter(ff);
            }
            saveChooser.setFileFilter(firstFF);
            saveChooser.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equals("fileFilterChanged")) {
                        OutputFormat outputFormat = fileFilterOutputFormatMap.get(evt.getNewValue());
                        saveChooser.setAccessory((outputFormat == null) ? null : outputFormat.getOutputFormatAccessory());
                    }
                }
            });
        }
        return saveChooser;
    }
    public void read(URI f) throws IOException {
        // Create a new drawing object
        final DefaultDrawing newDrawing = new DefaultDrawing();
        if (newDrawing.getInputFormats().size() == 0) {
            throw new InternalError("Drawing object has no input formats.");
        }

        // Try out all input formats until we succeed
        IOException firstIOException = null;
        for (InputFormat format : newDrawing.getInputFormats()) {
            try {
                format.read(f, newDrawing);
                final Drawing loadedDrawing = newDrawing;
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        // Set the drawing on the Event Dispatcher Thread
                        view.setDrawing(newDrawing);
                    }
                };
                if (SwingUtilities.isEventDispatchThread()) {
                    r.run();
                } else {
                    try {
                        SwingUtilities.invokeAndWait(r);
                    } catch (InterruptedException ex) {
                        // suppress silently
                    } catch (InvocationTargetException ex) {
                        InternalError ie = new InternalError("Error setting drawing.");
                        ie.initCause(ex);
                        throw ie;
                    }
                }
                // We get here if reading was successful.
                // We can return since we are done.
                return;
                //
            } catch (IOException e) {
                // We get here if reading failed.
                // We only preserve the exception of the first input format,
                // because that's the one which is best suited for this drawing.
                if (firstIOException == null) {
                    firstIOException = e;
                }
            }
        }
        throw firstIOException;
    }
    public void read(URI f, InputFormat format) throws IOException {
        if (format == null) {
            read(f);
            return;
        }

        // Create a new drawing object
        final DefaultDrawing newDrawing = new DefaultDrawing();
        if (newDrawing.getInputFormats().size() == 0) {
            throw new InternalError("Drawing object has no input formats.");
        }

        format.read(f, newDrawing);
        final Drawing loadedDrawing = newDrawing;
        Runnable r;
        r = new Runnable() {
            
            @Override
            public void run() {
                // Set the drawing on the Event Dispatcher Thread
                //setDrawing(loadedDrawing);
                view.setDrawing(newDrawing);
            }
        };
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            try {
                SwingUtilities.invokeAndWait(r);
            } catch (InterruptedException ex) {
                // suppress silently
            } catch (InvocationTargetException ex) {
                InternalError ie = new InternalError("Error setting drawing.");
                ie.initCause(ex);
                throw ie;
            }
        }
    }

}
